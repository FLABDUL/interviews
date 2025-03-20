package goldman.best_average_score;

/*Problem Name is &&& Best Average Grade &&& PLEAE DO NOT REMOVE THIS LINE. */

/*
*   Instructions:
*
*   Given a list of student test scores, find the best average grade.
*   Each student may have more than one test score in the list.
*
*   Complete the bestAverageGrade function in the editor below.
*   It has one parameter, score, whcih is an array of student test scores.
*   Each element in the array is two-element array of the form [student name, test score ]
*   e.g. [ "Bobby", "87" ].
*   Test scores may be positive or negative integers.
*
*   If you end up with an average grade that is not an integer, you should
*   use a floor function to return the largest integer less than or equal to the average.
*   Return 0 for an empty input.
*
*   Example:
*
*   Input:
*   [["Bobby", "87"],
*    ["Charles", "100"],
*    ["Eric", "64"],
*    ["Charles", "22"]].
*
*   Expected output: 87
*   Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric,
*   respectively. 87 is the highest.
*/

public class Problem {
    /*
    **  Find the best average grade.
     */
    public static int bestAverageGrade(String[][] scores){
        //TODO: implement this function
        return 0;
    }

    /*
    **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass() {
        //TODO: implement more test cases
        String[][] tc1 = {
                {"Bobby", "87"},
                {"Charles", "100"},
                {"Eric", "64"},
                {"Charles", "22"}
        };

        int bestAverageGrade = bestAverageGrade(tc1);
        if(bestAverageGrade == 87){
            System.out.println("Test passed!");
            return true;
        }else{
            System.out.println("Test failed!");
            return false;
        }
    }

    public static void main(String[] args) {
        doTestsPass();
    }
}
