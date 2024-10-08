class Solution {
    public int[] intersection(int[] nums1, int[] nums2) 
    {
        int l1 = nums1.length;
        int l2 = nums2.length;
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0,k=0;
        while(i<l1 && j<l2)
        {
            if(nums1[i]<nums2[j])
            {
                i++;
            }
            else if(nums1[i]>nums2[j])
            {
                j++;
            }
            else
            {
                set.add(nums1[i]);
                i++;
                j++;
            }

        }
        int a[] = new int[set.size()];
        for(int b : set)
        {
            a[k++] = b;
        }
        return a;
    }
}