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

        System.out.println("Task 1 result: " + new Task1().findDistance(instructions));
        System.out.println("Task 2 result: " + new Task2().findDistance(instructions));
    }

    public static List<Instruction> readInstructions() throws IOException {
        List<Instruction> instructions = new ArrayList<>();

        URL url = Main.class.getResource("input");
        File file = new File(url.getPath());
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            instructions.add(new Instruction(
                    st.charAt(0),
                    Integer.parseInt(st.substring(1))
            ));
        }

        return instructions;
    }
}
