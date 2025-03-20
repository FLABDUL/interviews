package goldman.best_average_score;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /*
     **  Find the best average grade.
     */
    public static int bestAverageGrade(String[][] scores) {
        if (scores == null || scores.length == 0) {
            return 0;
        }

        // Map to store student names and their scores
        Map<String, List<Integer>> studentScores = new HashMap<>();

        // Populate the map
        for (String[] entry : scores) {
            String name = entry[0];
            int score = Integer.parseInt(entry[1]);

            studentScores.putIfAbsent(name, new ArrayList<>());
            studentScores.get(name).add(score);
        }

        int bestAvg = Integer.MIN_VALUE;//assumes possible all negative scores

        // Compute best average
        for (Map.Entry<String, List<Integer>> entry : studentScores.entrySet()) {
            List<Integer> scoreList = entry.getValue();
            int sum = 0;
            for (int score : scoreList) {
                sum += score;
            }
            int avg = (int) Math.floor((double) sum / scoreList.size()); // Floor the average
            bestAvg = Math.max(bestAvg, avg);
        }
        System.out.println("result: " + bestAvg);
        return bestAvg;
    }

    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass() {
        String[][] tc1 = {
                {"Bobby", "87"},
                {"Charles", "100"},
                {"Eric", "64"},
                {"Charles", "22"}
        };

        assert bestAverageGrade(tc1) == 87 : "Test case 1 failed";
        assert bestAverageGrade(new String[][]{}) == 0 : "Empty input failed";
        assert bestAverageGrade(new String[][]{{"Alice", "75"}}) == 75 : "Single student single score failed";
        assert bestAverageGrade(new String[][]{{"Alice", "80"}, {"Alice", "85"}}) == 82 : "Single student multiple scores failed";
        assert bestAverageGrade(new String[][]{{"Alice", "90"}, {"Bob", "99"}, {"Charlie", "85"}}) == 99 : "Multiple students one score each failed";
        assert bestAverageGrade(new String[][]{{"Alice", "-20"}, {"Bob", "-10"}, {"Alice", "0"}}) == -10 : "Negative scores failed";
        assert bestAverageGrade(new String[][]{{"Alice", "2147483646"}, {"Alice", "2147483647"}}) == 2147483646 : "Large numbers failed";

        System.out.println("All tests passed!");
        return true;
    }


    public static void main(String[] args) {
        doTestsPass();
    }
}
