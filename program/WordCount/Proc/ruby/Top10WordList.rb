arr=Array.new()
$stdin.each_line {|line|
    count,word=line.split(" ")
    arr.push [count.to_i,word]
}
arr.sort!{|a,b|(b[0]<=>a[0]).nonzero? || a[1]<=>b[1]}
(0..[10,arr.length-1].min-1).each {|i|
    puts "#{arr[i][0]} #{arr[i][1]}"
}
