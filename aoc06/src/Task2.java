import java.util.HashMap;
import java.util.List;

public class Task2 {
    public int countYesAnswers(List<List<String>> groupAnswers) {
        int count = 0;
        for (List<String> group: groupAnswers) {
            HashMap<Character, Integer> answerMap = new HashMap<>();
            for (String answers: group) {
                for (int i = 0; i < answers.length(); i ++) {
                    answerMap.put(
                            answers.charAt(i),
                            answerMap.getOrDefault(answers.charAt(i), 0) + 1
                    );
                }
            }

            for (int answerCount : answerMap.values()) {
                if (answerCount == group.size()) count++;
            }
        }

        return count;
    }
}
