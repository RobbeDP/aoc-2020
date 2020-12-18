import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        URL url = Main.class.getResource("input");
        File file = new File(url.getPath());
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st = br.readLine();
        List<Integer> numbers = new ArrayList<>();
        for (String num: st.split(",")) {
            numbers.add(Integer.parseInt(num));
        }

        System.out.println("Task 1 result: " + new Task1().findNumber(numbers, 2020));
        System.out.println("Task 2 result: " + new Task1().findNumber(numbers, 30000000));
    }
}
