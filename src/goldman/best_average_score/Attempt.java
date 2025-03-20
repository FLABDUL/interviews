package goldman.best_average_score;//package goldman;
//
///*Problem Name is &&& Best Average Grade &&& PLEAE DO NOT REMOVE THIS LINE. */
//
///*
//*   Instructions:
//*
//*   Given a list of student test scores, find the best average grade.
//*   Each student may have more than one test score in the list.
//*
//*   Complete the bestAverageGrade function in the editor below.
//*   It has one parameter, score, whcih is an array of student test scores.
//*   Each element in the array is two-element array of the form [student name, test score ]
//*   e.g. [ "Bobby", "87" ].
//*   Test scores may be positive or negative integers.
//*
//*   If you end up with an average grade that is not an integer, you should
//*   use a floor function to return the largest integer less than or equal to the average.
//*   Return 0 for an empty input.
//*
//*   Example:
//*
//*   Input:
//*   [["Bobby", "87"],
//*    ["Charles", "100"],
//*    ["Eric", "64"],
//*    ["Charles", "22"]].
//*
//*   Expected output: 87
//*   Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric,
//*   respectively. 87 is the highest.
//*/
//
//import java.util.*;
//
//public class Attempt {
//    /*
//    **  Find the best average grade.
//     */
//    public static int bestAverageGrade(String[][] scores){
//        //TODO: implement this function
//
//        //scores=[list of (student, score)][array of student[0], score[1]]
//        //average = sum scores same student / number of times student appears
//        //cycle through scores
//        //keep count of student appearance
//        //update sum of student
//        //store in another data structure with unique student, count student, cumulative score
//        //String unique student (key), (count appearance Integer, cumulative sumScore Integer) ACCESS 2ND ELEMENT
//        //New Object/Class or ArrayList<>() or int[]?
//        //cant use int[] primitive inside hashmap
//        //cycle through new hashmap
//        //find max value.sumScore
//        //return scoreitself
////        List<Integer> appearanceCumulative = new ArrayList<>();
//        Map<String, List<Integer>> uniqueScores = new HashMap<>();
//        for(String [] score : scores){
////            int appearance = 0;
////            int cumulative = 0;
//            String student = score[0];
//            int studentScore = Integer.parseInt(score[1]);
//            if(!uniqueScores.containsKey(student)){
//                uniqueScores.put(student, List.of(1, studentScore));
//            }else{
//                uniqueScores.put(student, List.of(uniqueScores.get(student).get(0) + 1, uniqueScores.get(student).get(1)+studentScore));
//            }
//
//        }
////        int maxCumulativeScore = uniqueScores.values().stream()
////                .map(list -> list.get(1)) // Extract the cumulative score (second element of the list)
////                .max(Comparator.naturalOrder()) // Find the maximum cumulative score
////                .orElse(Integer.MIN_VALUE);
////        System.out.println(maxCumulativeScore);
////        int averageMaxCumulativeScore =
////        Map.Entry<String, List<Integer>> maxEntry = uniqueScores.entrySet().stream()
////                .max(Comparator.comparing(entry -> entry.getValue().get(1))) // Compare by cumulativeScore (second element)
////                .orElse(null); // Return null if map is empty
////        int maxAverage = maxEntry.getValue().get(1)/maxEntry.getValue().get(0);
////        System.out.println(maxAverage);
////        return maxAverage;
//        uniqueScores.entrySet().stream().
//    }
//
//    /*
//    **  Returns true if the tests pass. Otherwise, returns false;
//     */
//    public static boolean doTestsPass() {
//        //TODO: implement more test cases
//        String[][] tc1 = {
//                {"Bobby", "87"},
//                {"Charles", "100"},
//                {"Eric", "64"},
//                {"Charles", "22"}
//        };
//
//        int bestAverageGrade = bestAverageGrade(tc1);
//        if(bestAverageGrade == 87){
//            System.out.println("Test passed!");
//            return true;
//        }else{
//            System.out.println("Test failed!");
//            return false;
//        }
//    }
//
//    public static void main(String[] args) {
//        doTestsPass();
//    }
//}
