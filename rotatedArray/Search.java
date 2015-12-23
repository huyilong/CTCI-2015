public class Solution {
    public int search(int[] nums, int target) {

        int start =0, end=nums.length-1;


        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid] == target){
                return mid;
            }
            

            //we could always use the nums[mid]!!!!!!!! and the relationship
            //with the nums[end] to judge whether first half!!!!
            //or second half is sorted!!!! always sorted half!!!!
            //456789123 nums[mid] = 8  nums[end] =3
            if(nums[mid]<nums[end] ){
                //right side is sorted -- we could sandwich
                if(target>nums[mid] && target <= nums[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
                
            }
            
            else{
                if(target>=nums[start] && target < nums[mid]){
                    end=mid-1;
                }else{
                    start = mid+1;
                }
            }
        }
        return -1;
    }
}

//binary search
/*
Worst case space complexity‎: ‎O(1) Best case performance‎: ‎O(1)
Average case performance‎: ‎O(log n)    Worst case performance‎: ‎O(log n)
*/
//binary-search iterative
public int helper(int[] nums, target){
    int low = 0;
    int high = nums.length-1;
    while(low<=high){
        int mid = (low+high)/2;
        if(nums[mid] > target){
            high = mid-1;
        }else if(nums[mid] < target){
            low = mid+1;
        }else{
            return mid;
        }
    }

//////outside the while(low<=high)  but still not found!!!
    return -1;
}


//recursion
public int helper2(int[] nums, int target, int low, int high){
    if(high<low){
        return -1;
    }
    //find the mid of two numbers we need to 
    int mid = (low+high)/2;
    if(target > nums[mid]){
        helper2(nums, target, mid+1, high);
    }else if(target < nums[mid]){
        helper2(nums, target, low, mid-1);
    }else{
        //return the index of the target
        return mid;
    }

}





public int searchRotated(int[] nums, int target){
    if(nums.length == 0 || nums ==null){
        return -1;
    }
    int low = 0;
    int high = nums.length-1;
    //low and high are defined outside the while
    //but mid must be defined inside the while 
    //because it is always updated each turn
    while(low<=high){
        int mid = (low+high)/2;

        if(nums[mid] == target){
            return mid;
        }

        //judge whether the half is sorted
        if(nums[mid] < nums[high]){
            //second half is sorted
            if(target > nums[mid] && target < nums[high]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }else{
            //first half is sorted
            if(target > nums[low] && target < nums[mid]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
    }

    return -1;
}