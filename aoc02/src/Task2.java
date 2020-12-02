import java.util.List;

public class Task2 {
    public int countCorrectPasswords(List<Password> passwords) {
        int count = 0;

        for (Password pw: passwords) {
            if ((pw.password.charAt(pw.lower - 1) == pw.character) != (pw.password.charAt(pw.higher - 1) == pw.character)) {
                count++;
            }
        }

        return count;
    }
}
