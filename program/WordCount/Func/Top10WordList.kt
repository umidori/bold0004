import java.io.File;

fun main() {
    File("news.txt").useLines {
        it
        .map{it.lowercase()
        .replace(Regex("[.,!'()-]"),"")}
        .flatMap{it.split(Regex(" +"))}
        .groupingBy{it}
        .eachCount()
        .toList()
        .sortedWith(compareByDescending<Pair<String,Int>>{it.second}.thenBy{it.first})
        .take(10)
        .map{"%d %s".format(it.second,it.first)}
        .forEach(::println)
    }
}
