package leetcode.arraystring;

public class ZigzagConversion {
    /*
    전달받은 문자열을 zigzag패턴으로 재배열해서 출력

    제한
    - 문자열길이 1~1000
    - numrows 1~1000 (가로세로 최대 1000 char 2차배열 사용)

    todo
    - 패턴생성 -> 2차배열 순회하면서 값이 있는것 stringBuilder에 붙이기

    tc
    - 길이1, 1000 확인
     */
    public static void main(String[] args) {
        System.out.println(convert("ABCD", 2));
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("A", 1));
    }

    public static String convert(String s, int numRows) {

        char[][] charArr = new char[numRows][1001];
        int ax = 0;
        int ay = 0;

        //todo : 2차배열 만들기
        // 내리고 대각선으로 올리고 -> 반복 (numrow 2까지는 대각선 무브가 없음..
        int moveCnt = 0;
        boolean isDownMove = true;
        for (char c : s.toCharArray()) {

            charArr[ay][ax] = c;

            if (isDownMove) {
                //내리기
                ay++;
                moveCnt++;

                if (moveCnt == numRows) {
                    ax++;
                    // numrow가 적어서 대각선처리 시작 y 셋팅이 음수가 될때
                    ay = Math.max(ay-2, 0);
                    moveCnt = 0;

                    // numrows가 2 이상이어야 대각선 모양이 나옴
                    if (numRows > 2) {
                        isDownMove = false;
                    }
                }
            } else {
                // 대각선 올리기
                ax += 1;
                // numrow가 적어서 대각선처리 시작 y 셋팅이 음수가 될때
                ay = Math.max(ay-1, 0);
                moveCnt++;

                if (moveCnt == numRows - 2) {
                    moveCnt = 0;
                    isDownMove = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<numRows;i++) {
            for (int j=0;j<=ax;j++) {
                if (charArr[i][j] > 0) {
                    sb.append(charArr[i][j]);
                }
            }
        }

        return sb.toString();
    }
}
