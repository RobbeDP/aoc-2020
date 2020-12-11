import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public int countSeats(List<List<Character>> seats) {
        List<List<Character>> seatsCopy = new ArrayList<>();
        for (List<Character> row: seats) {
            seatsCopy.add(new ArrayList<>(row));
        }

        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < seats.size(); i++) {
                for (int j = 0; j < seats.get(i).size(); j++) {
                    char seat = seats.get(i).get(j);
                    if (seat == 'L') {
                        if (countAdjacent(seats, i, j) == 0) {
                            seatsCopy.get(i).set(j, '#');
                            changed = true;
                        }
                    } else if (seat == '#') {
                        if (countAdjacent(seats, i, j) >= 4) {
                            seatsCopy.get(i).set(j, 'L');
                            changed = true;
                        }
                    }
                }
            }
            seats = seatsCopy;
            seatsCopy = new ArrayList<>();
            for (List<Character> row: seats) {
                seatsCopy.add(new ArrayList<>(row));
            }
        }

        return countOccupied(seats);
    }

    public int countAdjacent(List<List<Character>> seats, int row, int col) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        int count = 0;
        for (int[] dir: dirs) {
            int adjRow = row + dir[0];
            int adjCol = col + dir[1];
            if (adjRow >= 0 && adjRow < seats.size() && adjCol >= 0 && adjCol < seats.get(row).size()) {
                if (seats.get(adjRow).get(adjCol) == '#') count++;
            }
        }

        return count;
    }

    public int countOccupied(List<List<Character>> seats) {
        int count = 0;
        for (List<Character> row : seats) {
            for (Character seat : row) {
                if (seat == '#') count++;
            }
        }

        return count;
    }
}
