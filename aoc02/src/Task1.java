import java.util.List;

public class Task1 {
    public int countCorrectPasswords(List<Password> passwords) {
        int count = 0;

        for (Password pw: passwords) {
            int occurrences = 0;
            for (int i = 0; i < pw.password.length(); i++) {
                if (pw.password.charAt(i) == pw.character) {
                    occurrences++;
                }
            }

            if (occurrences >= pw.lower && occurrences <= pw.higher) {
                count++;
            }
        }

        return count;
    }
}
