package algorithm;

/**
 * Interface for maze generation. Defines methods for creating and printing a maze.
 */

public interface MazeGenerator {
    char[][] generateMaze(int height, int width);
    public void printMaze(char[][] maze);
}
