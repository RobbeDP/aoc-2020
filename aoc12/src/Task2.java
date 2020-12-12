import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {
    public int findDistance(List<Instruction> instructions) {
        List<Integer> waypoint = Arrays.asList(1, 10, 0, 0);
        List<Integer> ship = Arrays.asList(0, 0, 0, 0);

        for (Instruction instruction : instructions) {
            if (instruction.action == 'L') {
                waypoint = rotateCounterClockwise(waypoint, instruction.value / 90);
            } else if (instruction.action == 'R') {
                waypoint = rotateClockwise(waypoint, instruction.value / 90);
            } else if (instruction.action == 'F') {
                for (int i = 0; i < waypoint.size(); i++) {
                    ship.set(i, ship.get(i) + waypoint.get(i) * instruction.value);
                }
            } else {
                int index = directionToIndex(instruction.action);
                waypoint.set(index, waypoint.get(index) + instruction.value);
            }
        }

        return new Task1().manhattanDistance(ship.get(1), ship.get(3), ship.get(0), ship.get(2));
    }

    public int directionToIndex(char dir) {
        if (dir == 'N') return 0;
        else if (dir == 'E') return 1;
        else if (dir == 'S') return 2;
        else if (dir == 'W') return 3;

        return -1;
    }

    public List<Integer> rotateClockwise(List<Integer> waypoint, int times) {
        List<Integer> waypointCopy = new ArrayList<>(waypoint);

        for (int i = 0; i < times; i++) {
            int last = waypointCopy.remove(waypointCopy.size() - 1);
            waypointCopy.add(0, last);
        }

        return waypointCopy;
    }

    public List<Integer> rotateCounterClockwise(List<Integer> waypoint, int times) {
        List<Integer> waypointCopy = new ArrayList<>(waypoint);

        for (int i = 0; i < times; i++) {
            int first = waypointCopy.remove(0);
            waypointCopy.add(first);
        }

        return waypointCopy;
    }
}
