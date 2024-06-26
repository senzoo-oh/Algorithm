package Week7.조영호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SkipLog_bj {
     public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int[] arr;
        //각 테스트케이스 최소 난이도 탐색!
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            arr = new int[N];
            //통나무 정보 저장
            for(int j=0;j<N;j++)
                arr[j] = Integer.parseInt(st.nextToken());
                //높이 기준 오름차순 정렬
            Arrays.sort(arr);	
            int answer = -1, pre = arr[0];
            //중간 최대값까지 올라가는 중
            for(int j=2;j<N;j+=2){
                answer = Math.max(answer, Math.abs(pre - arr[j]));
                pre = arr[j];
            }
            //N이 짝수일 때
            if(N%2==0)
                N++;
            //중간 최대값에서 내려가는 중
            for(int j=N-2;j>0;j-=2){
                answer = Math.max(answer, Math.abs(pre - arr[j]));
                pre = arr[j];
            }
            //첫 통나무와 마지막 통나무 난이도 구하기
            answer = Math.max(answer, Math.abs(pre - arr[0]));
            //최소 난이도 BufferedWriter 저장
            bw.write(answer + "\n");	
        }
        //결과 출력
        bw.flush();		
        bw.close();
        br.close();

    }
}
