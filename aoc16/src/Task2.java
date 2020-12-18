import java.util.*;

public class Task2 {
    public long calculateErrorRate(Notes notes) {
        // Place all tickets in 1 list
        List<List<Integer>> allTickets = new ArrayList<>(notes.getOtherTickets());
        allTickets.add(notes.getMyTicket());
        List<List<Integer>> validTickets = getValidTickets(notes.getFields(), allTickets);
        Set<String> fieldTypes = new HashSet<>(notes.getFields().keySet());
        Set<Integer> done = new HashSet<>();

        // Loop over columns
        long result = 1;
        while(done.size() != notes.getFields().keySet().size()) {
            for (int i = 0; i < validTickets.get(0).size(); i++) {
                if (!done.contains(i)) {
                    Set<String> remainingTypes = new HashSet<>(fieldTypes);
                    for (List<Integer> validTicket : validTickets) {
                        Set<String> toRemove = new HashSet<>();
                        int value = validTicket.get(i);
                        for (String type : remainingTypes) {
                            Range range = notes.getFields().get(type);
                            boolean valid = (value >= range.getLoBound1() && value <= range.getHiBound1()) ||
                                    (value >= range.getLoBound2() && value <= range.getHiBound2());
                            if (!valid) {
                                toRemove.add(type);
                            }
                        }
                        for (String type : toRemove) {
                            remainingTypes.remove(type);
                        }
                    }
                    if (remainingTypes.size() == 1) {
                        String type = remainingTypes.stream().findAny().get();
                        if (type.startsWith("departure")) {
                            result *= notes.getMyTicket().get(i);
                        }
                        fieldTypes.remove(type);
                        done.add(i);
                    }
                }
            }
            if (fieldTypes.isEmpty()) break;
        }

        return result;
    }

    public List<List<Integer>> getValidTickets(Map<String, Range> fields, List<List<Integer>> tickets) {
        List<List<Integer>> validTickets = new ArrayList<>();

        for (List<Integer> ticket: tickets) {
            boolean valid = true;
            for (int value: ticket) {
                boolean validField = false;
                for (Range range: fields.values()) {
                    if ((value >= range.getLoBound1() && value <= range.getHiBound1()) ||
                            (value >= range.getLoBound2() && value <= range.getHiBound2())){
                        validField = true;
                        break;
                    }
                }
                if (! validField) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                validTickets.add(ticket);
            }
        }

        return validTickets;
    }
}
