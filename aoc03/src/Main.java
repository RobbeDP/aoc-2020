import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> forest = readForest();

        Task1 task1 = new Task1();
        System.out.println("Result task 1: " + task1.countTrees(forest, 3, 1));

        Task2 task2 = new Task2();
        int[][] slopes = {{1, 1}, {3, 1}, {5, 1}, {7, 1}, {1, 2}};
        System.out.println("Result task 2: " + task2.countTrees(forest, slopes));
    }

    public static List<String> readForest() throws IOException {
        List<String> forest = new ArrayList<>();

        URL url = Main.class.getResource("input");
        File file = new File(url.getPath());
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            forest.add(st);
        }

        return forest;
    }
}
