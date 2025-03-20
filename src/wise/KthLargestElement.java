package wise;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2; // Meaning the 2nd largest element, or the 5th smallest from the front
    }

    /**
     * ✅ Approach 1: Sorting
     * - Sorts the array and directly accesses the kth largest element.
     *
     * ⏳ Time Complexity: O(N log N) (due to sorting)
     * 🛠 Space Complexity: O(1) (in-place sorting, unless Java's sort uses extra space)
     *
     * ✅ Pros:
     * - Simple and easy to implement.
     * - Works well for small arrays.
     *
     * ❌ Cons:
     * - Inefficient for large datasets.
     * - Sorting is unnecessary when we only need one element.
     */
    public int findKthLargestSortIndex(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums); // Sort in ascending order
        return nums[n - k]; // kth largest means (n-k)th index
    }

    /**
     * ✅ Approach 2: Min-Heap (Priority Queue)
     * - Uses a min-heap of size k to efficiently track the kth largest element.
     *
     * ⏳ Time Complexity: O(N log K) (insertion/removal in heap takes log K time)
     * 🛠 Space Complexity: O(K) (heap of size k)
     *
     * ✅ Pros:
     * - More efficient than sorting when k is small.
     * - Works well for streaming large data.
     *
     * ❌ Cons:
     * - Extra space required for heap.
     * - Not optimal for large k values (approaches O(N log N) in worst case).
     */
    public int findKthLargestPriorityQueue(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min-heap
        for (int val : nums) {
            pq.offer(val); // Add element to heap
            if (pq.size() > k) { // If heap size exceeds k, remove smallest element
                pq.poll();
            }
        }
        return pq.peek(); // The root (smallest in heap) is the kth largest element
    }

    /**
     * ✅ Approach 3: Quickselect (Partition-based Selection)
     * - Uses the partitioning logic of QuickSort to find the kth largest element efficiently.
     *
     * ⏳ Time Complexity:
     *    - Best/Average: O(N) (each partition step reduces problem size)
     *    - Worst: O(N^2) (rare case when pivoting is poor)
     * 🛠 Space Complexity: O(1) (in-place partitioning, no extra space)
     *
     * ✅ Pros:
     * - More efficient than sorting (O(N) vs. O(N log N)).
     * - Works well for large datasets.
     *
     * ❌ Cons:
     * - Worst-case can degrade to O(N^2) if the pivot selection is bad.
     * - Modifies the input array (not ideal if original order needs to be preserved).
     */
    public int findKthLargestPartitian(int[] nums, int k) {
        k = nums.length - k; // Convert kth largest to index in sorted order
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi); // Get partition index
            if (j < k) {
                lo = j + 1; // Move right (search larger elements)
            } else if (j > k) {
                hi = j - 1; // Move left (search smaller elements)
            } else {
                break; // Found kth largest
            }
        }
        return nums[k]; // Return the kth largest element
    }

    /**
     * ✅ Approach 4: Quickselect with Shuffle (Randomized Quickselect)
     * - First shuffles the array to ensure a better pivot selection, avoiding O(N^2) worst-case.
     * - Uses the same partitioning logic as Quickselect.
     *
     * ⏳ Time Complexity: O(N) on average, O(N^2) in worst case (though rare with shuffling)
     * 🛠 Space Complexity: O(1) (in-place)
     *
     * ✅ Pros:
     * - Reduces the likelihood of worst-case O(N^2).
     * - Still maintains O(N) expected runtime.
     *
     * ❌ Cons:
     * - Modifies input array.
     * - Extra overhead due to shuffling.
     */
    public int findKthLargestShuffle(int[] nums, int k) {
        shuffle(nums); // Shuffle to avoid worst-case scenario
        k = nums.length - k; // Convert kth largest to index
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if (j < k) {
                lo = j + 1; // Move right
            } else if (j > k) {
                hi = j - 1; // Move left
            } else {
                break; // Found kth largest
            }
        }
        return nums[k]; // Return the kth largest element
    }

    /**
     * 📌 Partition function for Quickselect.
     * - Uses the last element as pivot.
     * - Moves elements ≤ pivot to the left, and > pivot to the right.
     * - Returns the final pivot index.
     *
     * ⏳ Time Complexity: O(N) (single pass)
     */
    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[hi]; // Choose last element as pivot
        int i = lo;
        for (int j = lo; j < hi; j++) { // Traverse elements
            if (nums[j] <= pivot) { // If element ≤ pivot, swap to left partition
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, hi); // Swap pivot to its final position
        return i; // Return pivot index
    }

    /**
     * 📌 Swap function to exchange two elements in an array.
     */
    private void swap(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * 📌 Shuffle function (Fisher-Yates algorithm) to randomize the array order.
     * - Helps in avoiding Quickselect's worst-case O(N^2) runtime.
     *
     * ⏳ Time Complexity: O(N)
     */
    private void shuffle(int a[]) {
        final Random random = new Random();
        for (int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1); // Pick a random index (+1 for exclusive property of random e.g. X-1)
            swap(a, ind, r); // Swap current index with random index
        }
    }
}
