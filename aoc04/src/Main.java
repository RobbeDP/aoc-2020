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
        List<Map<String, String>> passwords = readPasswords();

        Task1 task1 = new Task1();
        System.out.println("Task 1 result: " + task1.countValidPassword(passwords));

        Task2 task2 = new Task2();
        System.out.println("Task 2 result: " + task2.countValidPassword(passwords));
    }

    public static List<Map<String, String>> readPasswords() throws IOException {
        List<Map<String, String>> passwords = new ArrayList<>();

        URL url = Main.class.getResource("input");
        File file = new File(url.getPath());
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        Map<String, String> password = new HashMap<>();
        while ((st = br.readLine()) != null) {
            if (st.equals("")) {
                passwords.add(password);
                password = new HashMap<>();
            } else {
                for (String part : st.split(" ")) {
                    String[] splitField = part.split(":");
                    password.put(splitField[0], splitField[1]);
                }
            }
        }
        passwords.add(password);

        return passwords;
    }
}
