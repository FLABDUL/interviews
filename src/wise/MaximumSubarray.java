package wise;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println("result: " + maximumSubarray.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        //msf/meh
        //loop
            //max meh/now
            //max msf/meh
        //r msf
        int maxSoFar=nums[0];
        int maxEndingHere=nums[0];
        for(int i=0; i< nums.length; i++){
            maxEndingHere = Math.max(maxEndingHere+nums[i], nums[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }//can also be written as dp[i] = Math.max(A[i] + dp[i - 1] , A[i]) with i=1 start;
        return maxSoFar;
    }
}
/*
On time array once
O1 space ints only
pros constant simple, works for -ve
cons no edge case handling empty
kadane's algorithm max subarray
doesnt return subarray itself just max

Greedy = only info available, visit onces, no bracktrack
Dynamic Programming DP break down to subproblems, avoid memoization redundant cals
suboptimals sum = optimals
overlapping suboptimals
top-down memoization sovle recursively store subproblems cache avoid redundant cals
bottom-up tabulation iteratively starting subproblems
GREEDY simpler, in the moment, no worry future, faster, not optimla every problem
DP break down smaller, expensive, guarnteed optimal
 */
