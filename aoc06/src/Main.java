import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<List<String>> groupAnswers = readGroupAnswers();

        Task1 task1 = new Task1();
        System.out.println("Task 1 result: " + task1.countYesAnswers(groupAnswers));

        Task2 task2 = new Task2();
        System.out.println("Task 2 result: " + task2.countYesAnswers(groupAnswers));
    }

    public static List<List<String>> readGroupAnswers() throws IOException {
        List<List<String>> answers = new ArrayList<>();

        URL url = Main.class.getResource("input");
        File file = new File(url.getPath());
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        List<String> group = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            if (st.equals("")) {
                answers.add(group);
                group = new ArrayList<>();
            } else {
                group.add(st);
            }
        }
        answers.add(group);

        return answers;
    }
}
