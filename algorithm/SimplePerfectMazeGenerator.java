package algorithm;

import java.util.*;

/**
 * Implements the MazeGenerator interface to generate a simple perfect maze.
 * The class uses depth-first search algorithm to generate the maze.
 */

public class SimplePerfectMazeGenerator implements MazeGenerator {

    /**
     * 2D array representing the four possible directions: up, right, down, left.
     */
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    /**
     * Helper method to check if a cell is a valid candidate to move to.
     * A cell is valid if it is empty and hasn't been visited before.
     *
     * @param maze the 2D character array representing the maze
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @param height the total number of rows in the maze
     * @param width the total number of columns in the maze
     * @return true if the cell is valid; false otherwise
     */

    private static boolean isValidCell(char[][] maze, int row, int col, int height, int width) {
        int count = 0;
        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if (newRow >= 0 && newRow < height && newCol >= 0 && newCol < width && maze[newRow][newCol] == '.')
                count++;
        }
        return count == 0;
    }

    /**
     * Generates a simple perfect maze of given dimensions.
     *
     * @param cellHeight the number of rows in the maze
     * @param cellWidth the number of columns in the maze
     * @return a 2D character array representing the generated maze
     */

    @Override
public char[][] generateMaze(int cellHeight, int cellWidth) {
    int height = cellHeight;
    int width = cellWidth;
    char[][] maze = new char[height][width];


    for (int i = 0; i < height; i++)
        Arrays.fill(maze[i], '#');

    Stack<int[]> stack = new Stack<>();
    stack.push(new int[]{1, 1});
    maze[1][1] = '.';

    while (!stack.isEmpty()) {
        int[] cell = stack.pop();
        int row = cell[0], col = cell[1];

        List<int[]> neighbors = new ArrayList<>();
        for (int[] dir : DIRECTIONS) {
            int newRow = row + 2 * dir[0], newCol = col + 2 * dir[1];
            if (newRow > 0 && newRow < height && newCol > 0 && newCol < width && maze[newRow][newCol] == '#') {
                neighbors.add(new int[]{newRow, newCol});
            }
        }
        Collections.shuffle(neighbors);
        for (int[] neighbor : neighbors) {
            if (isValidCell(maze, neighbor[0], neighbor[1], height, width)) {
                stack.push(neighbor);
                int wallRow = row + (neighbor[0] - row) / 2;
                int wallCol = col + (neighbor[1] - col) / 2;
                maze[wallRow][wallCol] = '.';
                maze[neighbor[0]][neighbor[1]] = '.';
            }
        }
    }

    maze[0][1] = '.';
    maze[height - 1][width - 2] = '.';
    return maze;
}

    /**
     * Prints the generated maze to the console.
     *
     * @param maze the 2D character array representing the maze
     */

    @Override
    public void printMaze(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}






