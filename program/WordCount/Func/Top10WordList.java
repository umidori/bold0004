import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Map.Entry;

class Top10WordList {
    public static void main(String[] args) throws Exception {
        Files.readAllLines(Paths.get("news.txt"))
        .stream()
        .map(line->line.toLowerCase().replaceAll("[.,!'()-]",""))
        .flatMap(line->Arrays.stream(line.split(" +")))
        .collect(Collectors.groupingBy(x->x,Collectors.counting()))
        .entrySet()
        .stream()
        .sorted(Comparator.comparing(Entry<String,Long>::getValue).reversed()
                .thenComparing(Entry<String,Long>::getKey))
        .limit(10)
        .forEach(x->System.out.printf("%d %s\n",x.getValue(),x.getKey()));
    }
}

