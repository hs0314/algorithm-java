package leetcode.backtracking;

import java.util.concurrent.atomic.AtomicBoolean;

public class WordSearch {
    /*
    mXn grid내에서 특정 word가 존재하는지 여부 체크

    제한
    - 같은 cell은 한번만 사용 가능
    - m,n 1~6 (1일때 처리 확인)
    - word길이 1~15

    todo
    - word의 첫글자위치의 cell을 시작점으로 잡고 DFS => 조건으로 4면 이동시에 word의 character가 있는지 체크
    - m*n 시작점 X 4^15 ? => 결국 O(4^wordlen)
    - 이동 시, 직전위치는 이동하지 못하도록 제어 (임의로 '#'으로 제어하고 해당 recursion 마무리 될때 정상화)
    - recursion에서 true/false를 바로 반환받기 위해서 return하는 위치에 대한 이해필요..
     */
    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE"));
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
    }

    static final int[] dx = new int[]{1,0,-1,0};
    static final int[] dy = new int[]{0,1,0,-1};

    public static boolean exist(char[][] board, String word) {

        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[i].length;j++) {

                // 시작점이면 DFS 시작
                if (board[i][j] == word.charAt(0)) {

                    if (search(board, j, i, word, 1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean search(char[][] board, int curx, int cury, String word, int wordIdx) {

        if (wordIdx == word.length()) {
            return true;
        }

        // 중복선택 방지 (직전 위치로 돌아가지 못하게 하도록)
        char tmp = board[cury][curx];
        board[cury][curx] = '#';

        for (int i=0;i<4;i++) {
            // idx 범위 주의
            if (curx + dx[i] >= 0 && cury + dy[i] >= 0 && curx + dx[i] < board[0].length && cury + dy[i] < board.length) {

                // word의 다음 글자와 같으면 recursion
                if (board[cury+dy[i]][curx+dx[i]] == word.charAt(wordIdx)) {
                    if (search(board, curx + dx[i], cury + dy[i], word, wordIdx+1)) {
                        return true; // true반환이 최상위 메서드까지 전파
                    }
                }
            }
        }

        // 직전 위치 선택을 못하게 막아둔 tmp char 정상화
        board[cury][curx] = tmp;
        return false; // 다음 선택이 없는 경우
    }
}
