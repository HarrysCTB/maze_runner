package algorithm;

public class Maze {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    /**
    * Initializes and defines the maze with specified parameters.
    * The display height and width are calculated by multiplying params1 and params2 by 3, respectively.
    * If params3 is "imperfect", calls the ImperfectMaze method with calculated display height and width.
    *
    * @param params1 Used to calculate the display height of the maze.
    * @param params2 Used to calculate the display width of the maze.
    * @param params3 Determines the type of maze to be generated. If "imperfect", ImperfectMaze method is called.
    * @param params4 Unused parameter in the current method implementation.
    */

    public void DefineMaze(int params1, int params2, String params3, String params4) {
        int displayHeight = params1 * 3;
        int displayWidth = params2 * 3;

        if (params3.equals("imperfect") && params4.equals("simple")) {
            ImperfectMaze(displayHeight, displayWidth);
        }

        if (params3.equals("perfect") && params4.equals("simple")) {
            PerfectMaze(displayHeight, displayWidth);
        }

        if (params4.equals("graph")) {
            System.out.println(ANSI_RED + "🚨 La fonctionnalité n'est pas encore disponible!" + ANSI_RESET);
        }

        if (params4.equals("optimized")) {
            System.out.println(ANSI_RED + "🚨 La fonctionnalité n'est pas encore disponible!" + ANSI_RESET);
        }
    }

    public static void PerfectMaze(int params1, int params2) {
        SimplePerfectMazeGenerator perfect = new SimplePerfectMazeGenerator();

        char[][] maze = perfect.generateMaze(params1, params2);
        perfect.printMaze(maze);
    }


    /**
    * Generates and prints an imperfect maze using SimpleImperfectMazeGenerator.
    * The method initializes a SimpleImperfectMazeGenerator, generates a maze with the specified dimensions,
    * applies recursive division algorithm, and then prints the maze to the console.
    *
    * @param params1 Height of the maze to be generated.
    * @param params2 Width of the maze to be generated.
    */

    public static void ImperfectMaze(int params1, int params2) {
        SimpleImperfectMazeGenerator imperfect = new SimpleImperfectMazeGenerator();

        char[][] maze = imperfect.generateMaze(params1, params2);
        imperfect.recursiveDivision(maze, 1, 1, params1 - 2, params2 - 2);
        imperfect.printMaze(maze);
    }

    public static void GraphMaze() {}

    public static void OptimizedMaze() {}


    public Maze() {}
}
