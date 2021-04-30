//Given a 2-D matrix(the body) of some strong(represented as ‘X’) and some weak cells(represented as ‘0’), you need to check if the virus can infect the body. If the virus reaches the end, the body is considered to be infected, if the virus cannot reach the end, the body is considered to be not infected.  The virus can infect only the weakcells.The starting position is the top left corner of the matrix. The starting position will always be a weak cell.It takes 1 second for the virus to move to the adjacent cell(top/left/bottom/right). If the virus can reach the end (bottom-right corner) of the matrix within nseconds, return the string “can infect”, else return “cannot infect”.

// Time Complexity - O(n^2)
// Space Complexity - O(1)


public class Solution {

    public static String getResult(char[][] body, int maxTime){

        return canInfect(body, 0,0,maxTime, 0) ? "can infect" : "cannot infect";
    }

    public static boolean canInfect(char[][] body, int x, int y, int maxTime, int time){

        if(x == body.length - 1 && y == body[0].length - 1){
            return true;
        }

        if(time == maxTime) return false;

        if(x + 1 < body.length && body[x+1][y] != 'X' && body[x+1][y] != '1'){
            if(canInfect(body, x+1, y, maxTime, time+1)){
                return true;
            }
        }

        if(x - 1 > 0 && body[x-1][y] != 'X' && body[x-1][y] != '1'){
            if(canInfect(body, x-1, y, maxTime, time+1)){
                return true;
            }
        }

        if(y + 1 < body[0].length && body[x][y+1] != 'X' && body[x][y+1] != '1'){
            if(canInfect(body, x, y+1, maxTime, time+1)){
                return true;
            }
        }

        if(y - 1 > 0 && body[x][y-1] != 'X' && body[x][y-1] != '1'){
            if(canInfect(body, x, y-1, maxTime, time+1)){
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {

        char[][] matrix = {
                {'0','0','X','0'},
                {'X','0','X','X'},
                {'X','0','0','0'}};

        System.out.println(getResult(matrix, 5));

    }
}