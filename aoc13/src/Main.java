import java.io.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        URL url = Main.class.getResource("input");
        File file = new File(url.getPath());
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st = br.readLine();
        int timestamp = Integer.parseInt(st);

        st = br.readLine();
        String[] busIDStrings = st.split(",");
        int[] busIDs = new int[busIDStrings.length];
        for (int i = 0; i < busIDs.length; i ++) {
            if (busIDStrings[i].equals("x")) {
                busIDs[i] = -1;
            } else {
                busIDs[i] = Integer.parseInt(busIDStrings[i]);
            }
        }

        System.out.println("Task 1 result: " + new Task1().findEarliestBus(timestamp, busIDs));
        System.out.println("Task 2 result: " + new Task2().findEarliestTimestamp(busIDs));
    }
}
