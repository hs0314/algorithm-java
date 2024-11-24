package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    /*
    n(1~8)개의 유효한 (, ) 조합 생성

    todo
    - 재귀로 처리 O(2^8)
    - valid한 케이스를 찾기 위해서 open cnt를 각 재귀별로 가지고 그다음 추가할 수 있는 (, ) 선택
     */
    public static void main(String[] args) {
        generateParenthesis(3);
        generateParenthesis(1);
    }

    public static List<String> generateParenthesis(int n) {

        List<String> answerList = new ArrayList<>();

        // 시작은 무조건 "(" 여야함
        getCombinations(n, new StringBuilder("("), 1, 1, answerList);

        return answerList;
    }

    public static void getCombinations(int n, StringBuilder picked, int totalOpenCnt, int currentOpenCnt, List<String> answerList) {

        if (picked.length() == n*2) {
            answerList.add(picked.toString());
            return;
        }

        // recursion
        // 주의: picked의 경우 call by ref여서 직전 선택을 뺴줘야하지만 cnt는 call by value여서 백트래킹시 저절로 호출 전 값으로 복원됌
        if (totalOpenCnt == n) {
            // ) 밖에 못씀
            picked.append(")");
            getCombinations(n, picked, totalOpenCnt, currentOpenCnt-1, answerList);
            picked.deleteCharAt(picked.length()-1);

        } else if(currentOpenCnt == 0) {
            // ( 밖에 못씀
            picked.append("(");
            getCombinations(n, picked, totalOpenCnt+1, currentOpenCnt+1, answerList);
            picked.deleteCharAt(picked.length()-1);
        } else {
            // 둘다 가능
            // )
            if (currentOpenCnt > 0) {
                picked.append(")");
                getCombinations(n, picked, totalOpenCnt, currentOpenCnt - 1, answerList);
                picked.deleteCharAt(picked.length() - 1);
            }

            if (totalOpenCnt < n) {
                picked.append("(");
                getCombinations(n, picked, totalOpenCnt + 1, currentOpenCnt + 1, answerList);
                picked.deleteCharAt(picked.length() - 1);
            }
        }
    }
}
