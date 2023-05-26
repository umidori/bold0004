import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.stream.Stream;

class Top10WordList {
    public static void main(String[] args) throws Exception {
        getTop10WordList(getWordCountList(getWordList())).forEach(
            s->System.out.println(s)
        );
    }

    public static Stream<String> getWordList() throws Exception {
        var list = new ArrayList<String>();
        try (var scan = new Scanner(new File("news.txt"))) {
            String line;
            while (scan.hasNextLine()) {
                line = scan.nextLine().toLowerCase()
                    .replaceAll("[.,!'()-]","");
                for (var word: line.split(" +")) {
                    list.add(word);
                }
            }
        }
        return list.stream();
    }

    public static Stream<Entry<String,Integer>> getWordCountList(Stream<String> stream) {
        var map=new HashMap<String,Integer>();
        stream.forEach(word->{
            if (!map.containsKey(word)) {
                map.put(word,0);
            }
            map.put(word,map.get(word)+1);
        });
        return map.entrySet().stream();
    }

    public static Stream<String> getTop10WordList(Stream<Entry<String,Integer>> stream) {
        var list=new ArrayList<Entry<String,Integer>>(stream.toList());
        Collections.sort(list,new Comparator<Entry<String,Integer>>() {
            @Override
            public int compare(Entry<String,Integer> a,Entry<String,Integer> b) {
                int comp;
                return (comp=b.getValue().compareTo(a.getValue()))!=0?
                    comp:a.getKey().compareTo(b.getKey());
            }
        });
        var strList=new ArrayList<String>();
        for (var i=0;i<list.size() && i<10;i++) {
            strList.add(String.format("%d %s",list.get(i).getValue(),list.get(i).getKey()));
        }
        return strList.stream();
    }
}
