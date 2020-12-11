import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<List<Character>> seats = readSeats();

        System.out.println("Task 1 result: " + new Task1().countSeats(seats));
        System.out.println("Task 2 result: " + new Task2().countSeats(seats));
    }

    public static List<List<Character>> readSeats() throws IOException {
        List<List<Character>> seats = new ArrayList<>();

        URL url = Main.class.getResource("input");
        File file = new File(url.getPath());
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            List<Character> row = new ArrayList<>();
            for (int i = 0; i < st.length(); i++) {
                row.add(st.charAt(i));
            }
            seats.add(row);
        }

        return seats;
    }
}
