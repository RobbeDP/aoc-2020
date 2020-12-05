import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> seatNumbers = readSeatNumbers();

        Task1 task1 = new Task1();
        System.out.println("Task 1 result: " + task1.maxSeatID(seatNumbers));

        Task2 task2 = new Task2();
        System.out.println("Task 2 result: " + task2.findSeatID(seatNumbers));
    }

    private static List<String> readSeatNumbers() throws IOException {
        List<String> seatNumbers = new ArrayList<>();

        URL url = Main.class.getResource("input");
        File file = new File(url.getPath());
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            seatNumbers.add(st);
        }

        return seatNumbers;
    }
}
