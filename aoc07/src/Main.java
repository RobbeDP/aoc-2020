import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, List<BagPair>> bags = readBags();

        Task1 task1 = new Task1();
        System.out.println("Task 1 result: " + task1.countBags(bags));

        Task2 task2 = new Task2();
        System.out.println("Task 2 result: " + task2.countBags(bags));
    }

    public static Map<String, List<BagPair>> readBags() throws IOException {
        Map<String, List<BagPair>> bags = new HashMap<>();

        URL url = Main.class.getResource("input");
        File file = new File(url.getPath());
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            String[] splitLine = st.split(" ");
            List<BagPair> contains = new ArrayList<>();
            for (int i = 4; i < splitLine.length; i += 4) {
                if (! splitLine[i].equals("no")) {
                    contains.add(new BagPair(
                            Integer.parseInt(splitLine[i]),
                            splitLine[i + 1] + " "  + splitLine[i + 2]
                    ));
                }

            }
            bags.put(splitLine[0] + " " + splitLine[1], contains);
        }

        return bags;
    }
}
