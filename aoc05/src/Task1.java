import java.util.List;

public class Task1 {
    public int maxSeatID(List<String> seatNumbers) {
        int maxSeatID = 0;

        for (String seatNumber: seatNumbers) {
            String rowNumber = seatNumber.substring(0, 7).
                    replaceAll("F", "0").replaceAll("B", "1");
            String colNumber = seatNumber.substring(7, 10).
                    replaceAll("L", "0").replaceAll("R", "1");
            int row = binarySearch(rowNumber, 0, 128);
            int col = binarySearch(colNumber, 0, 8);
            int seatID = row * 8 + col;
            if (seatID > maxSeatID) maxSeatID = seatID;
        }

        return maxSeatID;
    }

    public int binarySearch(String seatNumber, int loBound, int hiBound) {
        for (int i = 0; i < seatNumber.length(); i++) {
            int middle = loBound + (hiBound - loBound) / 2;

            if (seatNumber.charAt(i) == '1') {
                loBound = middle;
            } else {
                hiBound = middle;
            }
        }

        return loBound;
    }
}
