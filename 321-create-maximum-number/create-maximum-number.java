class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] answer = new int[k];
        int start = Math.max(0, k - nums2.length);
        int end = Math.min(nums1.length, k);
        for(int i = start; i <= end; i++) {
            int[] merged = mergeArrays(generateArray(nums1, i), generateArray(nums2, k - i));
            if(maxArray(merged, answer, 0, 0)) answer = merged;
        }
        return answer;
    }

    private int[] generateArray(int[] nums, int k) {
        int[] answer = new int[k];
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            while(count > 0 && i - count < nums.length - k && answer[count - 1] < nums[i]) count--;
            if(count < k) answer[count++] = nums[i];
        }
        return answer;
    }

    private int[] mergeArrays(int[] nums1, int[] nums2) {
        int[] answer = new int[nums1.length + nums2.length];
        int index = 0;
        int indexA = 0;
        int indexB = 0;
        while(indexA < nums1.length && indexB < nums2.length) {
            if(maxArray(nums1, nums2, indexA, indexB)) answer[index++] = nums1[indexA++];
            else answer[index++] = nums2[indexB++];
        }
        while(indexA < nums1.length) answer[index++] = nums1[indexA++];
        while(indexB < nums2.length) answer[index++] = nums2[indexB++];
        return answer;
    }
    private boolean maxArray(int[] nums1, int[] nums2, int indexA, int indexB) {
        while(indexA < nums1.length && indexB < nums2.length && nums1[indexA] == nums2[indexB]) {
            indexA++;
            indexB++;
        }
        return indexB == nums2.length || (indexA < nums1.length && nums1[indexA] > nums2[indexB]);
    }
}