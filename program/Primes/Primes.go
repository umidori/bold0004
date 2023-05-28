package main

import (
	"fmt"
	"math"
	"sort"
)

type numCount struct {
	num   int
	count int
}

func main() {
	for i := range uniqNumber(groupNumber(multipleNumber(100))) {
		fmt.Println(i)
	}
}

func multipleNumber(n int) <-chan int {
	res := make(chan int)
	go func() {
		defer close(res)
		for i := 1; i <= int(math.Sqrt(float64(n))); i++ {
			for j := 2 * i; j <= n; j += i {
				res <- j
			}
		}
	}()
	return res
}

func groupNumber(ci <-chan int) <-chan numCount {
	res := make(chan numCount)
	m := make(map[int]int)
	a := make([]numCount, 0)
	go func() {
		defer close(res)
		for i := range ci {
			if _, ok := m[i]; !ok {
				m[i] = 0
			}
			m[i]++
		}
		for num, count := range m {
			a = append(a, numCount{num, count})
		}
		sort.Slice(a, func(i, j int) bool {
			if a[i].num < a[j].num {
				return true
			}
			return false
		})
		for _, nc := range a {
			res <- nc
		}
	}()
	return res
}

func uniqNumber(nc <-chan numCount) <-chan int {
	res := make(chan int)
	go func() {
		defer close(res)
		for n := range nc {
			if n.count == 1 {
				res <- n.num
			}
		}
	}()
	return res
}
