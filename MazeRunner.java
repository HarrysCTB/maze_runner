import ExceptionHandling.ArgsExceptHandling;
import ExceptionHandling.GenerationExceptHandling;
import ExceptionHandling.LabyrinthExceptHandling;
import algorithm.Maze;
import other.Macro;

public class MazeRunner {

    /**
    * Validates input arguments for some process.
    * - args must contain exactly 4 elements.
    * - arg1 and arg2 must both be >= 5.
    * - args[2] must be "perfect" or "imperfect".
    * - args[3] must be "simple", "graph", or "optimized".
    *
    * @param args String arguments array.
    * @param arg1 Integer, must be >= 5.
    * @param arg2 Integer, must be >= 5.
    * @throws ArgsExceptHandling Thrown if args length isn’t 4.
    * @throws GenerationExceptHandling Thrown if arg1 and arg2 < 5.
    * @throws LabyrinthExceptHandling Thrown for invalid args[2] or args[3].
    */

    public static void error_handling(String[] args, int arg1, int arg2)
        throws ArgsExceptHandling,
               GenerationExceptHandling,
               LabyrinthExceptHandling {
        if (args.length != 4) throw new ArgsExceptHandling(Macro.ARGS.getMessage());
        if (arg1 < 5 && arg2 < 5) throw new GenerationExceptHandling(Macro.GEN.getMessage());
        if (!args[2].equals("perfect") && !args[2].equals("imperfect"))
            throw new LabyrinthExceptHandling(Macro.LAB.getMessage());
        if (!args[3].equals("simple") && !args[3].equals("graph") && !args[3].equals("optimized"))
            throw new LabyrinthExceptHandling(Macro.LAB.getMessage());
    }

    /**
    * Entry point for the maze generation program.
    * Parses input arguments, handles errors, and initializes maze generation.
    * Expects 4 arguments: two integers (>= 5) and two strings ("perfect"/"imperfect" and "simple"/"graph"/"optimized").
    *
    * @param args Command-line arguments.
    */

    public static void main(String[] args) {
        Maze maze = new Maze();
        try {
            int arg1 = Integer.parseInt(args[0]);
            int arg2 = Integer.parseInt(args[1]);
            error_handling(args, arg1, arg2);
            maze.DefineMaze(arg1, arg2, args[2], args[3]);
        } catch (ArgsExceptHandling e) {
            System.out.println(e.getMessage());
        } catch (GenerationExceptHandling e) {
            System.out.println(e.getMessage());
        } catch (LabyrinthExceptHandling e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(Macro.NUMB.getMessage());
        }
    }
}