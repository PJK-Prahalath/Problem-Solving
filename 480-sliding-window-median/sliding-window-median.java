class Solution {

    TreeSet<E> lowerHalf = new TreeSet(Comparator.comparing(E::num).thenComparing(E::index));
    TreeSet<E> upperHalf = new TreeSet(Comparator.comparing(E::num).reversed().thenComparing(E::index));
    record E(long num, int index) {}

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] ans = new double[n-k+1];
        for (int i = 0; i < k; i++)
            lowerHalf.add(new E(nums[i], i));
        while (lowerHalf.size() > upperHalf.size())
            upperHalf.add(lowerHalf.pollFirst());
        ans[0] = median(0, k);
        for (int i = 1; i <= n - k; i++) {
            if (!lowerHalf.remove(new E(nums[i-1], i-1))) 
                upperHalf.remove(new E(nums[i-1], i-1));
            upperHalf.add(new E(nums[i+k-1], i+k-1));
            lowerHalf.add(upperHalf.pollFirst());
            if (lowerHalf.size() > upperHalf.size()) {
                upperHalf.add(lowerHalf.pollFirst());
            }
            ans[i] = median(i, i + k);
        }
        return ans;
    }

    double median(int start, int end) {
        if (upperHalf.size() > lowerHalf.size())
            return upperHalf.first().num;
        return (upperHalf.first().num + lowerHalf.first().num) / 2.0;
    }
}