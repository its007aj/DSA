/*
https://leetcode.com/problems/prime-subtraction-operation/description/
*/


class Solution {
    int length = 0;
    List<Integer> primes = null;
    public boolean primeSubOperation(int[] nums) {
        
        boolean sorted = true;
        int max = nums[0];
        length = nums.length;

        for(int i=1; i<nums.length; i++){
            if(nums[i]<=nums[i-1]){
                sorted = false;
            }
            max = Math.max(max, nums[i]);
        }
        
        if(sorted)
            return true;

        primes = findPrimes(max);

        return calculate(0, 1, nums);

    }

    public boolean calculate(int p, int q, int[] nums){
        if(q==length)
            return true;

        boolean recurse = calculate(p+1, q+1, nums);    
        
        if(recurse){
            if(nums[p]>=nums[q]){
                int primeToSubtract = findPrimeToSubtract(nums[p], nums[p]-nums[q]);
                if(primeToSubtract==-1){
                    return false;
                }
                nums[p] -= primeToSubtract;
            }
        }

        return recurse; 
    }

    public int findPrimeToSubtract(int n, int diff){
        for(Integer i: primes){
            if(i>diff & i<n)
                return i;
        }

        return -1;
    }

    public List<Integer> findPrimes(int n){
        int[] arr = new int[n+1];

        for(int i=2; i<n+1; i++){
            if(arr[i]==0){
                for(int j=i+i; j<n+1; j=j+i){
                    arr[j] = 1;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for(int i=2; i<n+1; i++){
            if(arr[i]==0)
                primes.add(i);
        }

        return primes;
        
    }
}
