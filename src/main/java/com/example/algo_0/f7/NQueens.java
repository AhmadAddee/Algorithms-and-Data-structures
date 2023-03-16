package com.example.algo_0.f7;
/**NB 20
 * */
public class NQueens {

    private int rows, columns, queens, solutions;
    int[][] board;
    private boolean[] neDiagonal, nwDiagonal, col;

    public NQueens(int row, int column, int queen) {
        rows = row;
        columns = column;
        queens = queen;
        board = new int[row][column];
        neDiagonal = new boolean[row + column];
        nwDiagonal = new boolean[row + column];
        col = new boolean[column];
        solutions = 0;
    }

    public void solveQueen() {
        solve(0);
    }

    public void solve(int row) {
        for (int i = 0; i < columns; i++) {
            if (neDiagonal[i + row] != true && nwDiagonal[row - i + rows - 1] != true && col[i] != true) {
                neDiagonal[i + row] = true;
                nwDiagonal[row - i + rows - 1] = true;
                col[i] = true;
                board[row][i] = 1;
                if (row == rows - 1) {
                    printSolution();
                } else {
                    solve(row + 1);
                }
                neDiagonal[i + row] = false;
                nwDiagonal[row - i + rows - 1] = false;
                col[i] = false;
                board[row][i] = 0;
            }
        }
    }

    public void printSolution() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf(" %d ", board[i][j]);
            }
            System.out.printf("\n");
        }
        System.out.println("------------------------------------------");
        solutions++;
        System.out.println(solutions);
    }

    public static void main(String arg[]) {
        NQueens test = new NQueens(8, 8, 8);
        test.solveQueen();
    }
}
