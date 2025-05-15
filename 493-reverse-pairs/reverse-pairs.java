class Solution {
    public  static int mergesort(int nums[],int st, int end){
        int count=0;
        if(st>=end){
            return 0;
        }
        int mid=st+(end-st)/2;
       count+=mergesort(nums,st,mid);
       count+=mergesort(nums,mid+1,end);
        count+=countpair(nums,st,end,mid);
        merge(nums,st,end,mid);
        return count;
    }

    public  static  void merge(int nums[],int st, int end, int mid){
        int temp[]=new int[end-st+1];
        int i=st;
        int j=mid+1;
        int k=0;

        while(i<=mid && j<=end){
          if(nums[i]<=nums[j]){
          temp[k++]=nums[i++];
        }else{
            temp[k++]=nums[j++];
        }
        }

        while(i<=mid){
             temp[k++]=nums[i++];
        }
        
        while(j<=end){
             temp[k++]=nums[j++];
        }

        for(int x=0,y=st;x<temp.length;x++,y++){
            nums[y]=temp[x];
        }
    }

    public static int countpair(int nums[],int st, int end , int mid){
        int right=mid+1;
        int pcount=0;
        for(int i=st;i<=mid;i++){
            while(right<=end && (long)nums[i]>2L*nums[right]){
                right++;
            }
            pcount+=(right-(mid+1));
        }
        return pcount;
    }
    public int reversePairs(int[] nums) {
        return mergesort(nums,0,nums.length-1);
    }   
}
