import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public long calculateErrorRate(Notes notes) {
        List<List<Integer>> allTickets = new ArrayList<>(notes.getOtherTickets());
        allTickets.add(notes.getMyTicket());

        long sum = 0;
        for (List<Integer> ticket: allTickets) {
            for (int value: ticket) {
                boolean valid = false;
                for (Range range: notes.getFields().values()) {
                    if ((value >= range.getLoBound1() && value <= range.getHiBound1()) ||
                            (value >= range.getLoBound2() && value <= range.getHiBound2())){
                        valid = true;
                        break;
                    }
                }
                if (! valid) sum += value;
            }
        }

        return sum;
    }
}
