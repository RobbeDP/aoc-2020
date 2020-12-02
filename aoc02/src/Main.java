import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Password> passwords = readPasswords();

        Task1 task1 = new Task1();
        System.out.println("Result task 1: " + task1.countCorrectPasswords(passwords));

        Task2 task2 = new Task2();
        System.out.println("Result task 2: " + task2.countCorrectPasswords(passwords));
    }

    private static List<Password> readPasswords() throws IOException {
        List<Password> passwords = new ArrayList<>();

        URL url = Main.class.getResource("input");
        File file = new File(url.getPath());
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            String[] splitLine = st.split(" ");
            String[] bounds = splitLine[0].split("-");
            passwords.add(new Password(
                    Integer.parseInt(bounds[0]),
                    Integer.parseInt(bounds[1]),
                    splitLine[1].charAt(0),
                    splitLine[2]
                    )
            );
        }

        return passwords;
    }
}
