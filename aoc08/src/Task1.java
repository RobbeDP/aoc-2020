import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task1 {
    public int executeInstructions(List<Instruction> instructions) {
        int acc = 0;
        int instructionPointer = 0;
        Set<Integer> seen = new HashSet<>();
        while (! seen.contains(instructionPointer)) {
            seen.add(instructionPointer);

            Instruction currentInstruction = instructions.get(instructionPointer);
            if (currentInstruction.operation.equals("jmp")) {
                instructionPointer += currentInstruction.argument - 1;
            } else if (currentInstruction.operation.equals("acc")) {
                acc += currentInstruction.argument;
            }
            instructionPointer += 1;
        }

        return acc;
    }
}
