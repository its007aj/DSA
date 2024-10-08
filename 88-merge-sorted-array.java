/*
 https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0;
        int j = 0;
        int l = 0;

        int[] arr = new int[m];
        for(int k=0; k<m; k++){
            arr[k] = nums1[k];
        }

        while(i<m && j<n){
            if(arr[i]<=nums2[j]){
                nums1[l] = arr[i];
                i++;
                l++;
            }
            else{
                nums1[l] = nums2[j];
                j++;
                l++;
            }
        }

        while(j<n){
            nums1[l] = nums2[j];
            j++;
            l++;
        }

        while(i<m){
            nums1[l] = arr[i];
            i++;
            l++;
        }
        
    }
}
