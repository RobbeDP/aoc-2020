import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static String[] eyeColors = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};

    public static boolean validateYear(String value, int loBound, int hiBound) {
        if (value.length() == 4) {
            try {
                int yearInt = Integer.parseInt(value);
                return yearInt >= loBound && yearInt <= hiBound;
            } catch (NumberFormatException ex) {
                return false;
            }
        }
        return false;
    }

    public static boolean validateHeight(String value) {
        if (value.length() >= 4 && (value.endsWith("cm") || value.endsWith("in"))) {
            try {
                int valueInt = Integer.parseInt(value.substring(0, value.length() - 2));
                if (value.endsWith("cm")) return valueInt >= 150 && valueInt <= 193;
                if (value.endsWith("in")) return valueInt >= 59 && valueInt <= 76;
            } catch (NumberFormatException ex) {
                return false;
            }
        }
        return false;
   }

   public static boolean validateColorCode(String value) {
       Pattern pattern = Pattern.compile("^#[a-f0-9]{6}$");
       Matcher matcher = pattern.matcher(value);
       return matcher.matches();
   }

   public static boolean validateEyeColor(String value) {
       for (String eyeColor: eyeColors) {
           if (value.equals(eyeColor)) return true;
       }
       return false;
   }

   public static boolean validatePassportID(String value) {
       if (value.length() == 9) {
           try {
               Integer.parseInt(value);
               return true;
           } catch (NumberFormatException ex) {
               return false;
           }
       }
       return false;
   }
}
