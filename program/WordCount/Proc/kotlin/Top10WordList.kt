import java.io.BufferedReader;
import java.io.InputStreamReader;

fun main() {
    val list: MutableList<Pair<String,Int>> = mutableListOf();
    BufferedReader(InputStreamReader(System.`in`)).forEachLine {
        val (first,word)=it.split(" ")
        val count=first.toInt()
        list.add(word to count)
    }
    list.sortWith(Comparator{a,b->if(a.second!=b.second)b.second-a.second else a.first.compareTo(b.first)})
    for (i in 0..9) {
        if (i>=list.size) break
        println("%d %s".format(list[i].second,list[i].first))
    }
}



