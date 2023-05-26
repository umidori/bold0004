fun main() {
    listOf(100)
    .flatMap{n->(1..kotlin.math.sqrt(n.toDouble()).toInt())
        .flatMap{x->(2..n/x).map{y->x*y}}}
    .groupBy{it}
    .filter{it.value.count()==1}
    .map{it.key}
    .forEach(::println);
}
