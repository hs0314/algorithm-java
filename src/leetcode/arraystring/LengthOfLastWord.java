package leetcode.arraystring;

public class LengthOfLastWord {
    /*
     * s ->공백포함 문자열에서 마지막 단어 길이 구하기
     * 
     * 제한
     * - 길이 1~10000
     * - 최소 하나의 단어 있음은 보장
     * 
     * todo
     * - loop 반대로 돌면서 공백이 아닌경우 조건으로 word길이 구하기
     * 
     * tc
     * - 한단어 + 공백
     * - 한글자
     */
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a"));
        System.out.println(lengthOfLastWord("Hello    "));
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }

    public static int lengthOfLastWord(String s) {
        
        boolean isCounting = false;
        int startIdx = 0;
        int answer = 1; // 한글자 대비 default

        for(int i=s.length()-1;i>=0;i--) {
            if (s.charAt(i) != ' ' && !isCounting) {
                isCounting = true;
                startIdx = i;
            } else if( (i==0 || s.charAt(i) == ' ') && isCounting) {

                // 길이구하기
                answer = startIdx - i;
                if (i==0 && s.charAt(i) != ' '){
                    // 마지막단어 공백없이 idx=0되는 경우
                    answer++;
                }
                break;
            }
        }

        return answer;
    }
    
}
