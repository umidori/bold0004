import java.io.File;

fun main() {
    File("news.txt").forEachLine {
        var line=it.lowercase()
        line=line.replace(Regex("[.,!'()-]"),"")
        val words=line.split(Regex(" +"));
        for (word in words) {
            println(word);
        }
    }
}
