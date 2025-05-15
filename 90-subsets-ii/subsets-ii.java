import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // First, sort the array to handle duplicates easily
        Arrays.sort(nums);

        // Using a set to avoid duplicates
        Set<List<Integer>> resultSet = new HashSet<>();
        resultSet.add(new ArrayList<>());

        for (int num : nums) {
            Set<List<Integer>> newSubsets = new HashSet<>();
            for (List<Integer> subset : resultSet) {
                List<Integer> newSub = new ArrayList<>(subset);
                newSub.add(num);
                newSubsets.add(newSub);
            }
            resultSet.addAll(newSubsets);
        }

        // Convert the set back to a list
        return new ArrayList<>(resultSet);
    }
}