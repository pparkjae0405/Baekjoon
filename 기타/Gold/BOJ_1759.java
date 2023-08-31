import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    // 1. 비밀번호의 길이 L, 문자의 종류 C,
    static int L, C;
    // C개의 문자를 저장할 arr, L개를 선택할 배열 selectArr,
    static char[] arr;
    static char[] selectArr;
    // 출력을 위한 sb를 선언한다.
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. L, C가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 3. arr, selectArr의 크기를 설정하고
        arr = new char[C];
        selectArr = new char[L];
        // 문자 정보를 arr에 저장한 뒤 사전 순으로 정렬한다.
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < C ; i++){
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        // 4. 비밀번호 조합을 만들고 출력한다.
        back(0, 0);
        bw.write(sb + "");

        bw.flush();
        bw.close();
        br.close();
    }

    static void back(int depth, int idx) {
        // C개 중 L개를 골랐다면
        if(depth == L) {
            // 조합이 조건을 만족하는지 확인하여
            if(check(selectArr)){
                for(int i = 0 ; i < L ; i++){
                    // 출력하고
                    sb.append(selectArr[i]);
                }
                sb.append("\n");
            }

            // 종료한다.
            return;
        }

        // 이외에는 idx ~ C까지 돌면서
        for (int i = idx ; i < C ; i++) {
            // 문자를 선택하고 재귀를 호출한다.
            selectArr[depth] = arr[i];
            back(depth + 1, i + 1);
        }
    }

    static boolean check(char[] selectArr) {
        // 조건을 만족하는지 확인하기 위해 자음 개수 a, 모음 개수 b를 선언하고
        int a = 0;
        int b = 0;

        // 선택한 문자를 돌면서
        for(int i = 0 ; i < selectArr.length ; i++){
            // 모음이면 b++, 자음이면 a++한 뒤
            if(selectArr[i] == 'a' || selectArr[i] == 'e' ||
                        selectArr[i] == 'i' || selectArr[i] == 'o' ||
                            selectArr[i] == 'u') b++;
            else a++;
        }

        // 모음이 1개이상 자음 2개 이상이면 true
        if(a >= 2 && b >= 1) return true;
        // 아니면 false를 리턴한다.
        else return false;
    }
}