import java.util.*;
class Solution {
    public int solution(int[] s, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int i=0; i< s.length; i++) {
            pq.add(s[i]);
        }
        
        while(true) {
            int min =0;
            int min2 =0;
            
            
            if(pq.size()>=2){
             min  = pq.poll();
             min2 = pq.poll();
            }else {
                min = pq.poll();
                if(min >=K) {
                    break;
                }else{
                    answer = -1;
                    break;
                }
            }
            
            
            if(min >=K && min2 >=K) {
                break;
            }else {
                int temp = min + min2*2;
                pq.add(temp);
            }
            
            answer++;
        }
        
        return answer;
    }
}