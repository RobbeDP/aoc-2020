import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> joltages = readJoltages();

        System.out.println("Task 1 result: " + new Task1().findDifferences(joltages));
        System.out.println("Task 2 result: " + new Task2().findArrangements(joltages));
    }

    public static List<Integer> readJoltages() throws IOException {
        List<Integer> numbers = new ArrayList<>();

        URL url = Main.class.getResource("input");
        File file = new File(url.getPath());
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            numbers.add(Integer.parseInt(st));
        }

        return numbers;
    }
}
