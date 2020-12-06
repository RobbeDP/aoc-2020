import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task1 {
    public int countYesAnswers(List<List<String>> groupAnswers) {
        int count = 0;
        for (List<String> group: groupAnswers) {
            Set<Character> answerSet = new HashSet<>();
            for (String answers: group) {
                for (int i = 0; i < answers.length(); i ++) {
                    answerSet.add(answers.charAt(i));
                }
            }
            count += answerSet.size();
        }

        return count;
    }
}
