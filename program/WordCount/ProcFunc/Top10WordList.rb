def getWordList
    arr=Array.new()
    File.foreach("news.txt") {|line|
        line.chomp.downcase.gsub(/[.,!'()-]/,"").split(/ +/).each {|word|
            arr.push word
        }
    }
    arr
end

def getWordCountList(arr)
    hash=Hash.new(0)
    arr.each {|word|
        hash[word]+=1
    }
    hash
end

def getTop10WordList(hash)
    arr=Array.new()
    strs=Array.new()
    hash.each {|k,v|
        arr.push [v, k]
    }
    arr.sort!{|a,b|(b[0]<=>a[0]).nonzero? || a[1]<=>b[1]}
    (0..[10,arr.length-1].min-1).each {|i|
        strs.push "#{arr[i][0]} #{arr[i][1]}"
    }
    strs
end

(getTop10WordList getWordCountList getWordList).each{|str|
    puts str
}
