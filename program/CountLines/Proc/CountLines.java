import java.io.File;
import java.util.Scanner;

class CountLines {
    public static void main(String[] args) throws Exception {
        var scan = new Scanner(new File("news.txt"));
        int count;
        for (count = 0; scan.hasNextLine(); scan.nextLine()) {
            count++;
        }
        System.out.println(count);
    }
}
