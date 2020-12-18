import java.util.List;
import java.util.Map;

public class Notes {
    private Map<String, Range> fields;
    private List<Integer> myTicket;
    private List<List<Integer>> otherTickets;

    public Notes(Map<String, Range> fields, List<Integer> myTicket, List<List<Integer>> otherTickets) {
        this.fields = fields;
        this.myTicket = myTicket;
        this.otherTickets = otherTickets;
    }

    public Map<String, Range> getFields() {
        return fields;
    }

    public List<Integer> getMyTicket() {
        return myTicket;
    }

    public List<List<Integer>> getOtherTickets() {
        return otherTickets;
    }
}
