package algorithm;

public class SimpleImperfectMazeGenerator implements MazeGenerator {

    public SimpleImperfectMazeGenerator() {}

    /**
    * Recursively divides the given maze using the Recursive Division algorithm.
    * This algorithm creates '#'-walled areas in the maze and leaves '.' as open spaces.
    * The recursion terminates when the specified section of the maze is smaller or equal to 2x2.
    *
    * @param maze The 2D char array representing the maze to be modified.
    * @param startX The starting X coordinate of the section to be divided.
    * @param startY The starting Y coordinate of the section to be divided.
    * @param endX The ending X coordinate of the section to be divided.
    * @param endY The ending Y coordinate of the section to be divided.
    */

    public void recursiveDivision(char[][] maze, int startX, int startY, int endX, int endY) {
        if (endX - startX <= 2 || endY - startY <= 2) {
            return;
        }

        int x = startX + 2 + (int)(Math.random() * (endX - startX - 3) / 2) * 2;
        int y = startY + 2 + (int)(Math.random() * (endY - startY - 3) / 2) * 2;

        for (int i = startY; i <= endY; i++) maze[i][x] = '#';
        for (int i = startX; i <= endX; i++) maze[y][i] = '#';

        int hole1 = startY + (int)(Math.random() * (y - startY - 1));
        int hole2 = y + 1 + (int)(Math.random() * (endY - y - 1));
        int hole3 = startX + (int)(Math.random() * (x - startX - 1));
        int hole4 = x + 1 + (int)(Math.random() * (endX - x - 1));

        maze[hole1][x] = '.';
        maze[hole2][x] = '.';
        maze[y][hole3] = '.';
        maze[y][hole4] = '.';

        recursiveDivision(maze, startX, startY, x - 1, y - 1);
        recursiveDivision(maze, x + 1, startY, endX, y - 1);
        recursiveDivision(maze, startX, y + 1, x - 1, endY);
        recursiveDivision(maze, x + 1, y + 1, endX, endY);
    }

    /**
    * Generates a simple maze represented as a 2D char array.
    * The maze consists of walls ('#') and open spaces ('.').
    * Openings are created at coordinates (0,1) and (height-1, width-2).
    *
    * @param height Height of the generated maze.
    * @param width  Width of the generated maze.
    * @return A 2D char array representing the generated maze.
    */

    @Override
    public char[][] generateMaze(int height, int width) {
        char[][] maze = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || j == 0 || i == height - 1 || j == width - 1) {
                    maze[i][j] = '#';
                } else {
                    maze[i][j] = '.';
                }
            }
        }
        maze[0][1] = '.';
        maze[height - 1][width - 2] = '.';
        return maze;
    }

    /**
    * Prints the given 2D char array maze to the console.
    * Each character in the array is printed individually, and each row of the maze is printed on a new line.
    *
    * @param maze The 2D char array representing the maze to be printed.
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
