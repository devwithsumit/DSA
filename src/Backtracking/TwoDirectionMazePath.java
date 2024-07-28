package Backtracking;

public class TwoDirectionMazePath {
    private static int mazePath(int sr, int sc, int er, int ec) {
        if(sr > er || sc > ec) return 0;
        if(sr == er && sc == ec) return 1;

        int rightWays = mazePath(sr, sc + 1, er, ec);

        int downWays = mazePath(sr + 1, sc, er, ec);

        return rightWays + downWays;
    }
    private static void mazePath(int sr, int sc, int er, int ec, String s) {
        if(sr > er || sc > ec) return;
        if(sr == er && sc == ec){
            System.out.println(s);
            return;
        };

        mazePath(sr, sc + 1, er, ec, s + "R");

        mazePath(sr + 1, sc, er, ec, s + "D");
    }

    public static void main(String[] args) {
        int[][] maze = {{0, 0, 0},
                        {0, 0, 0},
                        {0, 0, 0}};
        int rows =  2;
        int cols = 3;

        int countWays = mazePath(1, 1, rows, cols);

        System.out.println(countWays);

        mazePath(1,1, 3,3, "");

    }
}
