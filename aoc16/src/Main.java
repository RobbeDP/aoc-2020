import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Notes notes = readInput();

        System.out.println("Task 1 result: " + new Task1().calculateErrorRate(notes));
        System.out.println("Task 2 result: " + new Task2().calculateErrorRate(notes));
    }

    public static Notes readInput() throws IOException {
        URL url = Main.class.getResource("input");
        File file = new File(url.getPath());
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        Map<String, Range> fields = new HashMap<>();
        while (! (st = br.readLine()).equals("")) {
            Pattern pattern = Pattern.compile("([a-z ]+): ([0-9]+)-([0-9]+) or ([0-9]+)-([0-9]+)");
            Matcher matcher = pattern.matcher(st);
            if (matcher.find()) {
                fields.put(matcher.group(1), new Range(
                        Integer.parseInt(matcher.group(2)),
                        Integer.parseInt(matcher.group(3)),
                        Integer.parseInt(matcher.group(4)),
                        Integer.parseInt(matcher.group(5))
                ));
            }
        }

        // your ticket:
        br.readLine();
        List<Integer> yourTicket = Arrays.stream(br.readLine().split(","))
                .map(Integer::parseInt).collect(Collectors.toList());
        // empty line
        br.readLine();
        // nearby tickets:
        br.readLine();

        List<List<Integer>> otherTickets = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            List<Integer> ticket = Arrays.stream(st.split(","))
                    .map(Integer::parseInt).collect(Collectors.toList());
            otherTickets.add(ticket);
        }

        return new Notes(fields, yourTicket, otherTickets);
    }
}
