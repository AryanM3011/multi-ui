package edu.bothell.multi_ui.core;

public class State {
    private final char[][] grid;

    public State(int rows, int cols) {
        grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == ' ';
    }

    public void makeMove(int row, int col, char player) {
        grid[row][col] = player;
    }

    public boolean checkWin(char player) {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == player && grid[i][1] == player && grid[i][2] == player) return true;
        }
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[0][j] == player && grid[1][j] == player && grid[2][j] == player) return true;
        }
        if (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) return true;
        if (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player) return true;

        return false;
    }
}


/* package edu.bothell.multi_ui.core;

import java.util.Arrays;

public class State implements Statable<int[]> {
    public final char[][]   S = new char[32][48];
    /*[][]//[64][96];
    {
        {' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' '}
    };

    public State(){
        System.out.println("CREATING THE STATE...");
        for(char[] row: S)
            for(int x = 0; x < row.length; x++)
                row[x] = ' ';
    }


    public void setIt(char it, int x, int y){
        this.S[y][x] = it;
        System.out.println(Arrays.deepToString(S));
    } 

    public char getIt(int x, int y){
        return S[y][x];
    }

    public char[][] getIt(){
        return S;
    }
    
    

    @Override
    public Object getIt(int[] pos){
        return S[pos[1]][pos[0]];
    }

    @Override
    public boolean isOpen(int[] pos){
        return S[pos[1]][pos[0]] == ' ';
    }

    @Override
    public int[] getAdj(int x, int y, Directions d) {
        return new int[]{x + d.dX(), y + d.dY() };
    }
    
}
*/


