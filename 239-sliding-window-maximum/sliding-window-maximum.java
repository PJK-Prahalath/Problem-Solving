class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>(); // Monotonic deque to store indices
        int[] ans = new int[nums.length - k + 1]; // Result array to store max values
        int p = 0; // Pointer for the result array

        for (int i = 0; i < nums.length; i++) {
            // Remove indices from the front that are out of the current window
            while (!dq.isEmpty() && (i - dq.getFirst()) >= k) {
                dq.removeFirst();
            }

            // Maintain decreasing order by removing smaller values from the back
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[i]) {
                dq.removeLast();
            }

            // Add current index to the deque
            dq.addLast(i);

            // Start adding results to ans once we have a full window
            if (i >= k - 1) {
                ans[p++] = nums[dq.getFirst()];
            }
        }

        return ans;
    }
}