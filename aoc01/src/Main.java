import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> numbers = readNumbers();

        Task1 task1 = new Task1();
        System.out.println("Result task 1: " + task1.findNumber(numbers));

        Task2 task2 = new Task2();
        System.out.println("Result task 1: " + task2.findNumber(numbers));
    }

    private static List<Integer> readNumbers() throws IOException {
        List<Integer> numbers = new ArrayList<>();

        URL url = Task1.class.getResource("input");
        File file = new File(url.getPath());
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            numbers.add(Integer.parseInt(st));
        }

        return numbers;
    }
}
