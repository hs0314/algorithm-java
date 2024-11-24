package leetcode.dp;

public class ClimbingStairs {
    /**
     * 계단은 1 or 2 칸 -> N칸의 계단까지 갈 수 있는 방법의 수
     * 
     * constraints
     *  - 1<=n<=45
     * 
     * todo
     * - dp사용 O(N)
     * - 1<=i<=N i번째까지의 가는 방법 수 합산
     * 
     * tc / vrfc
     *  - n =1 일때 잘 돌아가는가
     */
    public static void main(String[] args) {
        int n = 1;
        int[] methods = new int[46];
        
        // 초기화
        methods[0] = 1;
        methods[1] = 1;

        // methods n = m(i-2)+1 + m(i-1)+1
        for (int i=2;i<=n;i++) {
            methods[i] = methods[i-2] + methods[i-1];
        }
        System.out.println(methods[n]);
    }
}
