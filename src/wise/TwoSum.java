package wise;//package wise;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
//public class TwoSum {
//    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;
//        TwoSum twoSum = new TwoSum();
//        System.out.println("brute force result: " + Arrays.toString(twoSum.twoSumBruteForce(nums, target)));
//    }
//
//    public int[] twoSumBruteForce(int[] nums, int target) {
//        //embedded loop On^2 complexity too slow
//        //use hashmaps with On
//        int n = nums.length;
//        for (int i=0; i< n-1/*last element j take care*/; i++){
//            for(int j=i+1/*0 already done*/; j<n; j++){
//                if(nums[i] + nums[j] == target){
//                    return new int[]{i+j};//return array of solution
//                }
//            }
//        }
//        //if cycled through all then no solution found
//        return new int[]{};
//    }
//    //no early exist after match
//    //sapce complexity O1 no extra space needed
//
//    public int[] twoSumTwoPassHash(int[] nums, int target) {
//        int n = nums.length;
//        Map<Integer, Integer> numMap = new HashMap<>();
//
//        //build hash
//        for (int i=0; i<n +; i++){
//            numMap.put(nums[i], i);//value and index
//        }
//
//        //find complement
//        for (int i=0; i<n; i++){
//            int complement = target-nums[i];
//            if(numMap.containsKey(complement) && numMap.get(complement) != i){//not that same number
//                return new int[]{i, numMap.get(complement)};//e,g, [3, 2, 4, 5] for 6
//            }
//        }
//
//        return new int[]{};
//    }//On one pass array time
//    //early exist possible
//
//    public int[] twoSumOnePassHash(int [] nums, int target){
//        Map<Integer, Integer> numMap = new HashMap<>();
//        int n=nums.length;
//        for(int i=0; i<n; i++){
//            int complement = target - nums[i];
//            if(numMap.containsKey(complement)){
//                return new int[]{numMap.get(complement), i};
//            }
//            numMap.put(nums[i], i);
//        }
//        return new int[]{};
//    }//On one for loop
//    //O1 space for get/containskeys
//    //On space for HM, fast lookups
//}
