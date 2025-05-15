/**
 * Recursive Backtracking using countMap.
 *
 * Time Complexity: O(N * N!). Number of permutations = P(N,N) = N!. Each
 * permutation takes O(N) to construct
 *
 * T(n) = n*T(n-1) + O(n)
 * T(n-1) = (n-1)*T(n-2) + O(n)
 * ...
 * T(2) = (2)*T(1) + O(n)
 * T(1) = O(n)
 *
 * Above equations can be added together to get:
 * T(n) = n (1 + n + n*(n-1) + ... + (n....2) + (n....1))
 *      = n (P(n,0) + P(n,1) + P(n,1) + ... + P(n,n-1) + P(n,n))
 *      = n * Floor(e*n!)
 *      = O(N * N!)
 *
 * Space Complexity: O(N). Recursion stack + countMap + tempList
 *
 * N = Length of input array.
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        permuteUniqueHelper(result, nums.length, countMap, new ArrayList<>());
        return result;
    }

    private void permuteUniqueHelper(List<List<Integer>> result, int inputLength, HashMap<Integer, Integer> countMap, List<Integer> tempList) {
        if (tempList.size() == inputLength) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int num : countMap.keySet()) {
            int count = countMap.get(num);
            if (count == 0) {
                continue;
            }
            countMap.put(num, count - 1);
            tempList.add(num);
            permuteUniqueHelper(result, inputLength, countMap, tempList);
            tempList.remove(tempList.size() - 1);
            countMap.put(num, count);
        }
    }
}