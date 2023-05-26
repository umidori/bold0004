File.open("news.txt"){|f|
  f.readlines()
    .map{|line|line.chomp.downcase.gsub(/[.,!'()-]/,"")}
    .flat_map{|line| line.split(/ +/)}
    .group_by{|word|word}
    .map{|k,v|[k,v.count]}
    .sort_by{|a|[-a[1],a[0]]}
    .take(10)
    .each{|a| puts "#{a[1]} #{a[0]}"}
}
