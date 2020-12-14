import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public long calculateMemorySum(String fileName) throws IOException {
        URL url = Main.class.getResource(fileName);
        File file = new File(url.getPath());
        BufferedReader br = new BufferedReader(new FileReader(file));
        Map<Integer, Long> memory = new HashMap<>();

        String st;
        String currentMask = "";
        Pattern pattern = Pattern.compile("mem\\[([0-9]+)] = ([0-9]+)");
        while ((st = br.readLine()) != null) {
            if (st.startsWith("mask")) {
                currentMask = st.substring(7);
            } else {
                Matcher matcher = pattern.matcher(st);
                if (matcher.find()) {
                    int address = Integer.parseInt(matcher.group(1));
                    String bitString = String.format(
                            "%36s",
                            Integer.toBinaryString(Integer.parseInt(matcher.group(2)))
                    ).replace(' ', '0');

                    String maskedBitstring = applyMask(bitString, currentMask);
                    memory.put(address, Long.parseLong(maskedBitstring, 2));
                }
            }
        }

        return countMemory(memory);
    }

    public static String applyMask(String bitString, String mask) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < mask.length(); i++) {
            if (mask.charAt(i) == 'X') {
                result.append(bitString.charAt(i));
            } else {
                result.append(mask.charAt(i));
            }
        }

        return result.toString();
    }

    public long countMemory(Map<Integer, Long> memory) {
        long sum = 0;
        for (long value: memory.values()) {
            sum += value;
        }

        return sum;
    }
}
