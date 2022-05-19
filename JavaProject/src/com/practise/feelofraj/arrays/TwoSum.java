
package com.practise.feelofraj.arrays;
class TwoSum {
public int[] twoSum(int[] nums, int target) {
        //ArrayList<Integer> ar=new ArrayList<Integer> (Arrays.asList(nums));
        int[] out=new int[2];
        for(int i=0; i<nums.length-1;i++){
           for(int j=i+1; j<nums.length;j++){
                if(nums[j]+nums[i]==target){
                    out[0]=j;
                    out[1]=i;
                    break;
                }
            }
                if(out[0]!=0) {
                    break;
                }        
        }
        return out;
}
public static void main(String[] args) {
    TwoSum t=new TwoSum();
    int[] out={3,2,4};
    t.twoSum(out, 6);
}
}