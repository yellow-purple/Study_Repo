import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class BOJ_7562 {
		//나이트의 이동
    static int T, N;
    static boolean visited[][];
    static int[] dr = { -1, -2, -2, -1, 1, 2, 2, 1 };
    static int[] dc = { -2, -1, 1, 2, -2, -1, 1, 2 };
    static State start, end;
 
    static class State {
        int r, c, dist = 0;
 
        public State(int x, int y, int dist) {
            this.r = x;
            this.c = y;
            this.dist = dist;
        }
    }
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
 
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];
 
            st = new StringTokenizer(br.readLine());
            start = new State(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine());
            end = new State(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            
            System.out.println(bfs());
        }
 
    }
 
    private static int bfs() {
        
        Queue<State> q = new LinkedList<>();
        q.add(start);
        visited[start.r][start.c] = true;
        
        while(!q.isEmpty()) {
            State now = q.poll();
            if(now.r == end.r && now.c == end.c)
                return now.dist;
            for (int d = 0; d < 8; d++) {
                int rr = now.r + dr[d];
                int cc = now.c + dc[d];
                if(rr < 0 || cc < 0 || rr >= N || cc >= N) continue;
                if(visited[rr][cc]) continue;
                
                visited[rr][cc] = true;
                q.add(new State(rr, cc, now.dist + 1));
            }
        }
        
        return 0;
    }
 
}
