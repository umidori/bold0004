import java.util.Scanner;
import java.io.File;

class ToWordList {
    public static void main(String[] args) throws Exception {
        try (var scan = new Scanner(new File("news.txt"))) {
            String line;
            while (scan.hasNextLine()) {
                line = scan.nextLine().toLowerCase()
                    .replaceAll("[.,!'()-]","");
                for (var word: line.split(" +")) {
                    System.out.println(word);
                }
            }
        }
    }
}
