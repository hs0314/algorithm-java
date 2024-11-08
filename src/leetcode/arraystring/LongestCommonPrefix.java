package leetcode.arraystring;

public class LongestCommonPrefix {
    /*
     * 주어진 string arr에서 가장 긴 prefix구하기
     * 
     * 제한
     * - 문자열 개수 1~200
     * - 문자열길이 0~200 (0조심)
     * 
     * todo
     * - strs idx별로 돌면서 문자열 i번째 char비교 (다를때까지 )
     * - O(strs길이 * 문자열길이)
     * 
     * tc
     * - 0
     */
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"a"}));
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    public static String longestCommonPrefix(String[] strs) {

        boolean isPrefix = true;
        int currentIdx = 0;
        StringBuilder sb = new StringBuilder();

        while(isPrefix) {

            // 빈 문자열 1개만 있는 경우 방어
            if (strs.length == 1 && ("".equals(strs[0]) || currentIdx > 0)) {
                break;
            }

            for(int i=0;i<strs.length-1;i++) {

                if(strs[i].length() <= currentIdx 
                    || strs[i+1].length() <= currentIdx 
                    || strs[i].charAt(currentIdx) != strs[i+1].charAt(currentIdx)) {
                    
                    isPrefix = false;
                    break;
                }
            }


            if (isPrefix) {
                sb.append(strs[0].charAt(currentIdx));
                currentIdx++;
            }            
        }

        return sb.length() > 0 ? sb.toString() : "";
    }
}
