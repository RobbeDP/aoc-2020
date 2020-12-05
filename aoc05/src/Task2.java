import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2 {
    public int findSeatID(List<String> seatNumbers) {
        Task1 task1 = new Task1();

        List<Integer> seatIDs = new ArrayList<>();
        for (String seatNumber: seatNumbers) {
            String rowNumber = seatNumber.substring(0, 7).
                    replaceAll("F", "0").replaceAll("B", "1");
            String colNumber = seatNumber.substring(7, 10).
                    replaceAll("L", "0").replaceAll("R", "1");
            int row = task1.binarySearch(rowNumber, 0, 128);
            int col = task1.binarySearch(colNumber, 0, 8);
            seatIDs.add(row * 8 + col);
        }
        Collections.sort(seatIDs);

        int i = 1;
        while (seatIDs.get(i) == seatIDs.get(i + 1) - 1) {
            i++;
        }

        return seatIDs.get(i + 1) - 1;
    }
}
