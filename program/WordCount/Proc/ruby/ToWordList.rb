File.foreach("news.txt") {|line|
    line.chomp.downcase.gsub(/[.,!'()-]/,"").split(/ +/).each {|word|
        puts word
    }
}
