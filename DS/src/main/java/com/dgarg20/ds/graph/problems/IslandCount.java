package com.dgarg20.ds.graph.problems;

/**
 * Created by Deepanshu Garg on 09/05/21.
 */


/**
 * Leet Code #200
 * Link - https://leetcode.com/problems/number-of-islands/
 *
 * Problem below
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 *
 */

public class IslandCount {
    public static void main(String[] args) {
        IslandCount is = new IslandCount();
        char[][] grid = {{'1', '1'}, {'0', '0'}};
        System.out.println();
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0 ; i < m; i++)
            for(int j=0 ; j < n; j++){
                if(grid[i][j] == '1'){
                    count ++;

                    dfs(grid, i, j, m, n);

                }
            }
        return count;
    }

    public void dfs(char[][] grid, int i, int j, int m, int n){
        grid[i][j] = 0;

        if(j+1 <n && grid[i][j+1] == '1')
            dfs(grid, i, j+1, m, n);
        if(i+1 < m && grid[i+1][j] == '1')
            dfs(grid, i+1, j, m, n);
        if(j-1 >= 0  && grid[i][j-1] == '1')
            dfs(grid, i, j-1, m, n);
        if(i-1 >= 0 && grid[i-1][j] == '1')
            dfs(grid, i-1, j, m, n);
    }
}
