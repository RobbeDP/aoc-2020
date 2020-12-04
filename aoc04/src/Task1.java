import java.util.List;
import java.util.Map;

public class Task1 {
    public int countValidPassword(List<Map<String, String>> passwords) {
        String[] fields = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};

        int count = 0;
        for (Map<String, String> password: passwords) {
            boolean valid = true;
            for (String field: fields) {
                if (! password.containsKey(field)) {
                    valid = false;
                    break;
                }
            }
            if (valid) count++;
        }

        return count;
    }
}
