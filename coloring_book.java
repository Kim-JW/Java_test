import java.util.*;

class Solution {
    int r,c;
    int[][] map;
    boolean[][] visited;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    int cnt =0;
    int Max =0;
    
  public int[] solution(int m, int n, int[][] picture) {
      int numberOfArea = 0;
      int maxSizeOfOneArea = 0;
      
      r = m;
      c = n;
      
      map = new int[r][c];
      visited = new boolean[r][c];
      
      for(int i=0; i< r; i++){
          for(int j=0; j< c; j++){
              map[i][j] = picture[i][j];
          }
      }
      
      for(int i=0; i< r; i++){
          for(int j=0; j< c; j++){
              if(map[i][j] >0&& !visited[i][j]){
                  numberOfArea++;
                  dfs(i,j,map[i][j]);
              }
              Max = Math.max(Max,cnt);
              cnt =0;
          }
      }
      
      maxSizeOfOneArea = Max;
      
      int[] answer = new int[2];
      answer[0] = numberOfArea;
      answer[1] = maxSizeOfOneArea;
      return answer;
  }
    
    public void visited_clear(){
        for(int i=0; i< r; i++){
            for(int j=0; j< c; j++){
                visited[i][j] = false;
            }
        }
    }
    
    public void dfs(int x,int y,int d){
        cnt++;
        visited[x][y] = true;
        
        for(int i=0; i< 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx <0 || ny < 0 || nx>= r || ny >= c){
                continue;
            }
            
            if(!visited[nx][ny]&& map[nx][ny] == d){
                dfs(nx,ny,d);
            }
        }
    }
}