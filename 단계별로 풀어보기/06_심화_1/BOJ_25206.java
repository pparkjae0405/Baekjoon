import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 학점의 총합, 전공과목별 (학점*과목평점)의 총합을 선언한다.
        double lectureSum = 0;
        double gradexscoreSum = 0;

        // 2. 과목정보를 20번 입력받는다
        StringTokenizer st;
        for(int i = 0 ; i < 20 ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            // 수강한 과목명
            String lectureName = st.nextToken();
            // 해당 과목의 학점
            double grade = Double.parseDouble(st.nextToken());
            // 받은 성적
            String scoreName = st.nextToken();
            // 성적에 해당하는 과목평점
            double score = 0;

            // P가 아닐 때만 전공과목별 (학점*과목평점)을 계산하여
            if(!(scoreName.equals("P"))){
                switch (scoreName){
                    case "A+":
                        score = 4.5;
                        break;
                    case "A0":
                        score = 4.0;
                        break;
                    case "B+":
                        score = 3.5;
                        break;
                    case "B0":
                        score = 3.0;
                        break;
                    case "C+":
                        score = 2.5;
                        break;
                    case "C0":
                        score = 2.0;
                        break;
                    case "D+":
                        score = 1.5;
                        break;
                    case "D0":
                        score = 1.0;
                        break;
                    case "F":
                        score = 0.0;
                        break;
                }
                // 학점의 총합, 전공과목별 (학점*과목평점)의 총합에 추가한다.
                gradexscoreSum += (grade*score);
                lectureSum += grade;
            }
        }

        // 3. 전공평점을 출력한다.
        bw.write(String.format("%.6f", gradexscoreSum/lectureSum) + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}