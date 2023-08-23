import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. arr의 크기를 설정하고
        int[] arr = new int[9];
        // 난쟁이들의 키를 arr에 저장하고 합을 구한 뒤
        int sum = 0;
        for(int i = 0 ; i < 9 ; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        // 2. 9개 중 2개를 뺐을 때 100이라면 해당 값을 0으로 바꾸고
        for(int i = 0 ; i < 8 ; i++){
            for(int j = i + 1 ; j < 9 ; j++){
                if(sum - arr[i] - arr[j] == 100){
                    arr[i] = 0;
                    arr[j] = 0;

                    // 정렬한 뒤 0이 아닌 난쟁이의 키를 출력한다.
                    Arrays.sort(arr);
                    for(int k = 2 ; k < 9 ; k++){
                        bw.write(arr[k] + "\n");
                    }

                    bw.flush();
                    bw.close();
                    br.close();
                    return;
                }
            }
        }
    }
}