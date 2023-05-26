import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;

class Top10WordList {
    public static void main(String[] args) throws Exception {
        var scan=new Scanner(System.in);
        String word;
        int count;
        var list=new ArrayList<Entry<String,Integer>>();
        while (scan.hasNext()) {
            count=scan.nextInt();
            word=scan.next();
            list.add(new SimpleEntry<String,Integer>(word,count));
        }
        Collections.sort(list,new Comparator<Entry<String,Integer>>() {
            @Override
            public int compare(Entry<String,Integer> a,Entry<String,Integer> b) {
                int comp;
                return (comp=b.getValue().compareTo(a.getValue()))!=0?
                    comp:a.getKey().compareTo(b.getKey());
            }
        });
        for (var i=0;i<list.size() && i<10;i++) {
            System.out.printf("%d %s\n",list.get(i).getValue(),list.get(i).getKey());
        }
    }
}
