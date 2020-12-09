import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Long> numbers = readNumbers();

        System.out.println("Task 1 result: " + new Task1().findWeakness(numbers, 25));
        System.out.println("Task 2 result: " + new Task2().findWeakness(numbers, 25));
    }

    public static List<Long> readNumbers() throws IOException {
        List<Long> numbers = new ArrayList<>();

        URL url = Main.class.getResource("input");
        File file = new File(url.getPath());
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            numbers.add(Long.parseLong(st));
        }

        return numbers;
    }
}
