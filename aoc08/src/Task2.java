import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task2 {
    public int executeInstructions(List<Instruction> instructions) {
        for (int i = 0; i < instructions.size(); i++) {
            if (instructions.get(i).operation.equals("nop") || instructions.get(i).operation.equals("jmp")) {
                Instruction originalInstruction = instructions.get(i);
                if (instructions.get(i).operation.equals("nop")) {
                    instructions.set(i, new Instruction("jmp", originalInstruction.argument));
                } else {
                    instructions.set(i, new Instruction("nop", originalInstruction.argument));
                }

                int acc = 0;
                int instructionPointer = 0;
                Set<Integer> seen = new HashSet<>();
                while (instructionPointer < instructions.size() && ! seen.contains(instructionPointer)) {
                    seen.add(instructionPointer);

                    Instruction currentInstruction = instructions.get(instructionPointer);
                    if (currentInstruction.operation.equals("jmp")) {
                        instructionPointer += currentInstruction.argument - 1;
                    } else if (currentInstruction.operation.equals("acc")) {
                        acc += currentInstruction.argument;
                    }
                    instructionPointer += 1;
                }

                if (instructionPointer >= instructions.size()) {
                    return acc;
                } else {
                    instructions.set(i, originalInstruction);
                }
            }
        }

        return 0;
    }
}
