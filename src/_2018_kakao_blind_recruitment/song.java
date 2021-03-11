package _2018_kakao_blind_recruitment;

public class song {
    public static void main(String[] args) {
        Solution_song s = new Solution_song();
        s.solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"});
    }
}

class Solution_song{
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        /*
         m -> 들은 멜로디
         시작, 종료, 곡명, 악보정보
         악보정보 각 음은 1분에 하나씩
           1) 재생시간 < 악보 -> 처음부터 재생시간까지
           2) 재생시간 > 악보 -> 처음부터 중복해서 재생

         00:00 ~ 00:00 까지이므로 24*60 = 1440개의 악보길이 허용
          즉 각 musicinfo별 아무리 길어봐야 String길이가 1439 이하이고  100개이하의 곡이므로 노가다해도 될 듯

          *주의
           - A곡재생이후 바로 B곡재생 이어지는 경우
           - 조건불일치 처리
           - 조건일치 -> 재생시간비교 처리
         */

        // musicinfo 별 실제재생악보 구하기
        int max = 0;
        for(int i=0;i<musicinfos.length;i++){
            String musicinfo = musicinfos[i];
            String songTitle = musicinfo.split(",")[2];

            String realPlayedMelody = getRealPlayedMelody(musicinfo);

            if(realPlayedMelody.contains(convertSharpStr(m))) {
                if (max < realPlayedMelody.length()) {
                    max = realPlayedMelody.length();
                    answer = songTitle;
                }
            }
        }

        return answer;
    }

    public String convertSharpStr(String targetStr){
        /* 편의를 위해서 다음과 같이 변환
         C# ->V
         D# ->W
         F# ->X
         G# ->Y
         A# ->Z
         */
        targetStr = targetStr.replaceAll("C#", "V");
        targetStr = targetStr.replaceAll("D#", "W");
        targetStr = targetStr.replaceAll("F#", "X");
        targetStr = targetStr.replaceAll("G#", "Y");
        targetStr = targetStr.replaceAll("A#", "Z");

        return targetStr;
    }

    public String getRealPlayedMelody(String musicinfo){
        String[] splitedMusicinfo = musicinfo.split(",");
        int strtTime = Integer.parseInt(splitedMusicinfo[0].split(":")[0]);
        int strtMin = Integer.parseInt(splitedMusicinfo[0].split(":")[1]);
        int endTime = Integer.parseInt(splitedMusicinfo[1].split(":")[0]);
        int endMin = Integer.parseInt(splitedMusicinfo[1].split(":")[1]);

        int musicPlayedMin = (endTime*60 + endMin) - (strtTime*60 + strtMin); // 재생된 음악 길이(분)
        int musicLength = convertSharpStr(splitedMusicinfo[3]).length();

        StringBuilder playedMelody = new StringBuilder();
        String musicMelody = convertSharpStr(splitedMusicinfo[3]); // # 컨버팅처리

        for(int i=0;i<musicPlayedMin/musicLength;i++){
            playedMelody.append(musicMelody); // 재생된 음악길이가 실제음악보다 길다면 그만큼 실제음악악보 append
        }
        playedMelody.append(musicMelody, 0, musicPlayedMin%musicLength);

        return playedMelody.toString();
    }
}
