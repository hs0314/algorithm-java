package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    /*
    n,k를 받아서 nCk 를 구하기

    제한
    - N은 1~20까지 (
     */
    public static void main(String[] args) {
        combine(4,2);
        combine(1,1);
    }

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> combinationList = new ArrayList<>();

        getCombinations(n, k, 1, new boolean[21], new ArrayList<>(), combinationList);

        return combinationList;
    }

    public static void getCombinations(int n, int k, int start, boolean[] isPicked, List<Integer> picked, List<List<Integer>> combinationList) {

        // return
        if (picked.size() == k) {
            combinationList.add(new ArrayList<>(picked)); // call by ref 조심
            return;
        }

        // recursion
        // 중복제거를 제외하기 위해서 별도의 체크를 start를 두고 직전선택 이후의 데이터로 선택하도록 처리 (조합)
        for (int i=start;i<=n;i++) {
            if (!isPicked[i]) {
                isPicked[i] = true;
                picked.add(i);

                getCombinations(n, k, i+1, isPicked, picked, combinationList);

                // backtracking
                isPicked[i] = false;
                picked.remove(picked.size()-1);
            }
        }
    }
}
