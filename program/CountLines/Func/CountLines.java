import java.nio.file.Files;
import java.nio.file.Paths;

class CountLines {
    public static void main(String[] args) throws Exception {
        System.out.println(Files.readAllLines(Paths.get("news.txt")).size());
    }
}
