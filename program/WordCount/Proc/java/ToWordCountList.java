import java.util.Scanner;
import java.util.HashMap;
import java.util.Map.Entry;

class ToWordCountList {
    public static void main(String[] args) throws Exception {
        var scan=new Scanner(System.in);
        var map=new HashMap<String,Integer>();
        String word;
        while (scan.hasNext()) {
            word=scan.next();
            if (!map.containsKey(word)) {
                map.put(word,0);
            }
            map.put(word,map.get(word)+1);
        }
        for (var entry: map.entrySet()) {
            System.out.printf("%d %s\n",entry.getValue(),entry.getKey());
        }
    }
}
