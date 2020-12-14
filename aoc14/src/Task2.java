import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public long calculateMemorySum(String fileName) throws IOException {
        URL url = Main.class.getResource(fileName);
        File file = new File(url.getPath());
        BufferedReader br = new BufferedReader(new FileReader(file));
        Map<Long, Integer> memory = new HashMap<>();

        String st;
        String currentMask = "";
        Pattern pattern = Pattern.compile("mem\\[([0-9]+)] = ([0-9]+)");
        while ((st = br.readLine()) != null) {
            if (st.startsWith("mask")) {
                currentMask = st.substring(7);
            } else {
                Matcher matcher = pattern.matcher(st);
                if (matcher.find()) {
                    String address = String.format(
                            "%36s",
                            Integer.toBinaryString(Integer.parseInt(matcher.group(1)))
                    ).replace(' ', '0');


                    int value = Integer.parseInt(matcher.group(2));
                    String maskedAddress = applyMask(address, currentMask);
                    writeMemory(memory, maskedAddress, value);

                }
            }
        }

        return countMemory(memory);
    }

    public static String applyMask(String bitString, String mask) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < mask.length(); i++) {
            if (mask.charAt(i) == '0') {
                result.append(bitString.charAt(i));
            } else {
                result.append(mask.charAt(i));
            }
        }

        return result.toString();
    }

    public void writeMemory(Map<Long, Integer> memory, String bitString, int value) {
        recursiveWrite(memory, bitString, new ArrayList<>(), value);
    }

    public void recursiveWrite(Map<Long, Integer> memory, String bitString, List<String> currentBitString, int value) {
        if (currentBitString.size() == 36) {
            String addressBitString = String.join("", currentBitString);
            memory.put(Long.parseLong(addressBitString, 2), value);
        } else {
            if (bitString.charAt(currentBitString.size()) == 'X') {
                currentBitString.add("0");
                recursiveWrite(memory, bitString, currentBitString, value);
                currentBitString.set(currentBitString.size() - 1, "1");
            } else {
                currentBitString.add(Character.toString(bitString.charAt(currentBitString.size())));
            }
            recursiveWrite(memory, bitString, currentBitString, value);
            currentBitString.remove(currentBitString.size() - 1);
        }
    }

    public long countMemory(Map<Long, Integer> memory) {
        long sum = 0;
        for (long value: memory.values()) {
            sum += value;
        }

        return sum;
    }
}
