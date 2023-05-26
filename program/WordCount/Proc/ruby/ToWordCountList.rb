hash=Hash.new(0)
$stdin.each_line {|word|
    hash[word]+=1
}
hash.each {|k,v|
    puts "#{v} #{k}"
}
