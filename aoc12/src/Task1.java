import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task1 {
    private final char[] directions = {'N', 'E', 'S', 'W'};

    public int findDistance(List<Instruction> instructions) {
        char currDir = 'E';
        Map<Character, Integer> positions = new HashMap<>();
        for (char dir: directions) positions.put(dir, 0);

        for (Instruction instruction: instructions) {
            if (instruction.action == 'L') {
                currDir = getDirectionByOffset(currDir, -(instruction.value / 90));
            } else if (instruction.action == 'R') {
                currDir = getDirectionByOffset(currDir, instruction.value / 90);
            } else if (instruction.action == 'F') {
                positions.put(
                        currDir,
                        positions.get(currDir) + instruction.value
                );
            } else {
                positions.put(
                        instruction.action,
                        positions.get(instruction.action) + instruction.value
                );
            }
        }

        return manhattanDistance(
                positions.get('E'),
                positions.get('W'),
                positions.get('N'),
                positions.get('S')
        );
    }

    public char getDirectionByOffset(char dir, int offset) {
        int index = getIndex(dir, directions);
        int mod = directions.length;
        return directions[((((index + offset) % mod) + mod) % mod)];
    }

    public int manhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public int getIndex(char el, char[] array) {
        for (int i = 0; i < array.length; i ++) {
            if (array[i] == el) return i;
        }

        return -1;
    }
}
