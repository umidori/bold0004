import java.io.BufferedReader;
import java.io.InputStreamReader;

fun main() {
    val map=mutableMapOf<String,Int>();
    BufferedReader(InputStreamReader(System.`in`)).forEachLine {
        map[it]=map.getOrDefault(it,0)+1
    }
    for ((key,value) in map) {
        println("%d %s".format(value,key))
    }
}
