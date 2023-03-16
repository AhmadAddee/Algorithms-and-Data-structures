package com.example.algo_0.f6;

public class MazeSolver {
    private int[][] maze;
    private int startRow;
    private int startCol;
    private boolean[][] visited;

    public MazeSolver(int[][] maze, int startRow, int startCol) {
        this.maze = maze;
        this.startRow = startRow;
        this.startCol = startCol;
        this.visited = new boolean[maze.length][maze[0].length];
    }

    public boolean solveMaze() {
        return solveMaze(startRow, startCol);
    }

    private boolean solveMaze(int row, int col) {
        //System.out.println("row: " + row + ", col: " + col);
        if (row < 0 || col < 0 || row >= maze.length || col > maze[0].length) return false;
        if (maze[row][col] == 2) {
            return true; // Found the exit
        }

        if (maze[row][col] == 0 || visited[row][col]) {
            return false; // Wall or already visited
        }

        visited[row][col] = true;

        // Check Up
        if (solveMaze(row - 1, col)) {
            return true;
        }

        // Check Right
        if (solveMaze(row, col + 1)) {
            return true;
        }

        // Check Down
        if (solveMaze(row + 1, col)) {
            return true;
        }

        // Check Left
        if (solveMaze(row, col - 1)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        // Start Maze
        int[][] maze = {
                { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
                { 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
                { 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 2, 1 }
        };

        MazeSolver solver = new MazeSolver(maze, 0, 0);
        boolean solved = solver.solveMaze();

        if (solved) {
            System.out.println("Maze solved!");
        } else {
            System.out.println("Maze not solved!");
        }

        // Test Maze 1
        int[][] maze1 = {
                { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
                { 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
                { 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 2, 1 }
        };

        MazeSolver solver1 = new MazeSolver(maze1, 0, 0);
        boolean solved1 = solver1.solveMaze();

        if (solved1) {
            System.out.println("Maze 1 solved!");
        } else {
            System.out.println("Maze 1 not solved!");
        }
    }
}