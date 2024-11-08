package leetcode.arraystring;

public class RemoveElement {
    public static void main(String[] args) {
        Solution_RemoveElement s = new Solution_RemoveElement();
        s.removeElement(new int[]{3,2,2,3}, 3);
        s.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
    }
}

class Solution_RemoveElement{
    /*
    val과 다른 애들만 nums에 남겨야함-> index어떻게 앞으로 당길지?
     */
    public int removeElement(int[] nums, int val) {
        int valCnt = 0;

        for (int i=0;i<nums.length;i++) {
            if (nums[i] == val) {
                valCnt++;

                for (int j=nums.length-1;j>=i;j--) {
                    if(nums[j] >= 0 && nums[j] != val) {
                        //swap
                        nums[i] = nums[j];
                        nums[j] = -1;
                        break;
                    }
                }
            }
        }

        return nums.length - valCnt;
    }
}
