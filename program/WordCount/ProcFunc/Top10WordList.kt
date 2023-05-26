import java.io.File

fun main() {
    getTop10WordList(getWordCountList(getWordList()))
    .forEach(::println)
}

fun getWordList(): List<String> {
    var list=mutableListOf<String>()
    File("news.txt").forEachLine {
        var line=it.lowercase()
        line=line.replace(Regex("[.,!'()-]"),"")
        val words=line.split(Regex(" +"));
        for (word in words) {
            list+=word
        }
    }
    return list
}

fun getWordCountList(list: List<String>): List<Pair<String,Int>> {
    val map=mutableMapOf<String,Int>()
    for (word in list) {
        map[word]=map.getOrDefault(word,0)+1
    }
    return map.toList()
}

fun getTop10WordList(list: List<Pair<String,Int>>): List<String> {
    var mutList=list.toMutableList()
    var strList=mutableListOf<String>()
    mutList.sortWith(compareByDescending<Pair<String,Int>>{it.second}.thenBy{it.first})
    for (i in 0..10) {
        if (i>=list.size) break
        strList+="%d %s".format(mutList[i].second,mutList[i].first)
    }
    return strList
}
