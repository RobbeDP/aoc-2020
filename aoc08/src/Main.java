import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Instruction> instructions = readInstructions();

        Task1 task1 = new Task1();
        System.out.println("Task 1 result: " + task1.executeInstructions(instructions));

        Task2 task2 = new Task2();
        System.out.println("Task 2 result: " + task2.executeInstructions(instructions));
    }

    public static List<Instruction> readInstructions() throws IOException {
        List<Instruction> instructions = new ArrayList<>();

        URL url = Main.class.getResource("input");
        File file = new File(url.getPath());
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            String[] splitLine = st.split(" ");

            instructions.add(new Instruction(
               splitLine[0],
               Integer.parseInt(splitLine[1])
            ));
        }

        return instructions;
    }
}
