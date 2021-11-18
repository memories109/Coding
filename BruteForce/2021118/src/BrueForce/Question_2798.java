package BrueForce;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 
 * 백준 BrueForce 알고리즘 2798번 문제
 * 블랙잭 구하는 공식이다 
 * 
 * Test용이 하기 위해 str, str2 직접 입력값 추가 하였다
 * 
 * 문제 
 * 주어진 n개 값에 대해서 m 가까운 최종합계를 가지는 3개의 값을 구하시오
 * ex) 
 * blackJack 값 21이며 
 * 5+7 = 12
 * 12 + 9 = 21
 * 
 * result 5,7,9 
 *  더해진 값들중 블랙잭에 제일 가까운 수는 21이다 
 * 
 * 모든 경우를 탐색한다. 
 * 브루트포스 
 * 시간복잡도 O(N3)
 */
public class Question_2798 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = "5 21";
        String str2 = "5 6 7 8 9";
        StringTokenizer st = new StringTokenizer(str, " ");
        
        
        int n = Integer.parseInt(st.nextToken());
        int blackJack = Integer.parseInt(st.nextToken());
        
        StringTokenizer st2 = new StringTokenizer(str2, " ");
        
        int[] num = new int[n];
        
        for(int i = 0; i < n ; i++){
            num[i] = Integer.parseInt(st2.nextToken());
        }
        
        int result = search(num, n, blackJack);
        System.out.print(result);        

    }
    public static int search(int[] num, int count, int to) {
        int result = 0;
        for(int i = 0; i < count-2; i++){
            for(int j = 0; j < count-1 ; j++){
                for(int k = 0; k < count; k++){
                    int temp= num[i] + num[j] + num[k];
                    if(temp == to){
                        return to;
                    }

                    if(result < temp && temp < to){
                        result = temp ;
                    }
                }
            }
        }
        return result;
    }
}
