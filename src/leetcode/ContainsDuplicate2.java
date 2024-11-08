package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ContainsDuplicate2 {
    /*
     * nums의 i,j값이 같고 두 idx차 abs(i-j) 가 k 이내인게 있는지 여부 체크
     * 
     * 1 <= nums.length <= 105
        -109 <= nums[i] <= 109
        0 <= k <= 105
     */
    public static void main(String[] args) {
        containsNearbyDuplicate(new int[]{1}, 1);
        containsNearbyDuplicate(new int[]{1,2,3,1}, 3);
        containsNearbyDuplicate(new int[]{1,0,1,1}, 1);
        containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2);

    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,List<Integer>> cntMap = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            cntMap.computeIfAbsent(nums[i], key -> new ArrayList()).add(i);
        }

        for(Map.Entry<Integer,List<Integer>> entry : cntMap.entrySet()) {
            
            if (entry.getValue().size() > 1) {
                for(int j=0;j<entry.getValue().size()-1;j++){
                    if(Math.abs(entry.getValue().get(j) - entry.getValue().get(j+1)) <= k) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}