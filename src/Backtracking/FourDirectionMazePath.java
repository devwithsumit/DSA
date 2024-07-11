package Backtracking;

import java.util.Arrays;

public class FourDirectionMazePath {
    private static int mazePath(int sr, int sc, int er, int ec) {
        if (sr > er || sc > ec) return 0;
        if (sr == er && sc == ec) return 1;

        int rightWays = mazePath(sr, sc + 1, er, ec);

        int downWays = mazePath(sr + 1, sc, er, ec);

        return rightWays + downWays;
    }

    private static void mazePath(int sr, int sc, int er, int ec, String s, boolean[][] isVisited) {
        if(sr < 0 || sc < 0) return;

        if (sr > er || sc > ec) return;

        if(isVisited[sr][sc]) return;

        if (sr == er && sc == ec) {
            System.out.println(s);
            return;
        }
        isVisited[sr][sc] = true;
        //Right
        mazePath(sr, sc + 1, er, ec, s + "R", isVisited);

        //Down
        mazePath(sr + 1, sc, er, ec, s + "D", isVisited);

        //Up
        mazePath(sr - 1, sc, er, sc, s + "U", isVisited);

        //Left
        mazePath(sr, sc - 1, er, sc, s + "L", isVisited);

        isVisited[sr][sc] = false;
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        int rows = 3;
        int cols = 3;

        int countWays = mazePath(1, 1, rows, cols);

        System.out.println(countWays);
        boolean[][] isVisited = new boolean[rows][cols];

        mazePath(0, 0, rows - 1, cols - 1, "", isVisited);

    }
}
