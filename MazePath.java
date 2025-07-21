import java.util.*;
public class MazePath {
    static int countPathsInMaze(int r, int c){
        if (r == 1 || c == 1)
            return 1;
        int left = countPathsInMaze(r - 1, c);
        int right = countPathsInMaze(r, c - 1);

        return left + right;
    }
    static void allPaths(String path, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(path);
            return;
        }

        if (r > 1) {
            allPaths(path + "D", r - 1, c);
        }
        if (c > 1)
            allPaths(path + "R", r, c - 1);
    }
    static void allPathsWithDiagonal(String path, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(path);
            return;
        }


        if (r > 1 && c > 1) {
            allPathsWithDiagonal(path + "↘", r - 1, c - 1);
        }
        if (r > 1) {
            allPathsWithDiagonal(path + "↓", r - 1, c);
        }
        if (c > 1)
            allPathsWithDiagonal(path + "→", r, c - 1);
    }

    static void allPathsWithObs(boolean[][] maze, String path, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(path);
            return;
        }

        if (!maze[r][c])    // stop recursion if obstacle present
            return;
        if (r < maze.length - 1 && c < maze[0].length - 1) {
            allPathsWithObs(maze, path + "↘", r + 1, c + 1);
        }
        if (r < maze.length - 1) {
            allPathsWithObs(maze, path + "↓", r + 1, c);
        }
        if (c < maze[0].length - 1)
            allPathsWithObs(maze, path + "→", r, c + 1);
    }

    static void allDirections(boolean[][] maze, String path, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(path);
            return;
        }

        if (!maze[r][c])    // stop recursion if obstacle present
            return;

        //        mark as visited
        maze[r][c] = false;

        if (r < maze.length - 1 && c < maze[0].length - 1)
            allDirections(maze, path + "↘", r + 1, c + 1);
        if (r > 0 && c > 0)
            allDirections(maze, path + "↖", r - 1, c - 1);
        if (r < maze.length - 1)
            allDirections(maze, path + "↓", r + 1, c);
        if (c < maze[0].length - 1)
            allDirections(maze, path + "→", r, c + 1);
        if (r > 0)
            allDirections(maze, path + "↑", r - 1, c);
        if (c > 0)
            allDirections(maze, path + "←", r, c - 1);

        // backtrack changes
        maze[r][c] = true;
    }


    public static void main(String arg[]) {
        //        System.out.print(countPathsInMaze(3, 3));
        boolean [][] maze = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        allDirections(maze, "", 0, 0);
    }
}
