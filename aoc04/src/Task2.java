import java.util.List;
import java.util.Map;

public class Task2 {
    public int countValidPassword(List<Map<String, String>> passwords) {
        String[] fields = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};

        int count = 0;
        for (Map<String, String> password: passwords) {
            boolean valid = true;
            for (String field: fields) {
                if (! password.containsKey(field) || ! validateField(field, password.get(field))) {
                    valid = false;
                    break;
                }
            }
            if (valid) count++;
        }

        return count;
    }

    private boolean validateField(String field, String value) {
        return switch (field) {
            case "byr" -> Validator.validateYear(value, 1920, 2002);
            case "iyr" -> Validator.validateYear(value, 2010, 2020);
            case "eyr" -> Validator.validateYear(value, 2020, 2030);
            case "hgt" -> Validator.validateHeight(value);
            case "hcl" -> Validator.validateColorCode(value);
            case "ecl" -> Validator.validateEyeColor(value);
            case "pid" -> Validator.validatePassportID(value);
            default -> true;
        };
    }
}
