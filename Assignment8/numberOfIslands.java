//4). https://leetcode.com/problems/number-of-islands/


public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        for(int i =0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j] == '1') {
                    count += calculateIsland(grid, i, j);
                }
            }
        }
        return count;
    }
    
    public static int calculateIsland(char[][] grid, int i, int j) {
        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1 || grid[i][j] == '0') {
            return 0;
        }
        grid[i][j] = '0';
        
        calculateIsland(grid, i-1, j);
        calculateIsland(grid, i, j-1);
        calculateIsland(grid, i+1, j);
        calculateIsland(grid, i, j+1);
        
        return 1;
    }

    public static void main(String args[]) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println("The numsber of islands is "+numIslands(grid));
    }
}
