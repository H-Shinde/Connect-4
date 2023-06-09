package connect4;

/*
-s-h-e-n-e-n-d-e-h-o-w-a--H-i-g-h--S-c-h-o-o-l

    File: $(name).java 
    Date: $(date)
Purpose:
Author: Harsh Shinde

----------------team20.com-----------hanely.co.nr---------------*/
import java.util.Scanner;
import connect4.Connect4;

public class board {

    Connect4 b2 = new Connect4();
    final int[][] board = new int[6][7];
    private int p1Chips = 21;
    private int p2Chips = 21;
    private int emp = -1;

    public int getP1Chip() {
        return p1Chips;
    }

    public int getP2Chip() {
        return p2Chips;
    }

    public boolean checkWin(int player) {

//vertical
        for (int c = 0; c < 7; c++) {

            for (int r = 0; r < 3; r++) {
                if (board[r][c] == player && board[r + 1][c] == player && board[r + 2][c] == player && board[r + 3][c] == player) {

                    return true;
                }

            }

        }

        // horizontal 
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 4; c++) {
                if (board[r][c] == player && board[r][c + 1] == player && board[r][c + 2] == player && board[r][c + 3] == player) {
                    return true;
                }
            }
        }

        // diagonal left--> right
        for (int r = 5; r >= 0; r--) {
            for (int c = 6; c >= 0; c--) {
                int count = 0;
                int x = c;
                int y = r;
                while (board[y][x] == player) {
                    count++;
                    x++;
                    y--;
                    if (y < 0 || x > 6 || y > 5 || x < 0) {
                        break;
                    }
                }
                if (count == 4) {
                    return true;
                }
            }
        }

        // negative slope
        for (int r = 0; r <= 5; r++) {
            for (int c = 0; c < 7; c++) {
                int count = 0;
                int y = r;
                int x = c;
                while (board[y][x] == player) {
                    count++;
                    y++;
                    x++;
                    if (y < 0 || x > 6 || y > 5 || x < 0) {
                        break;
                    }
                }
                if (count == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    public void display(String p1col, String p2col) {

        System.out.println(p1col + "\t" + p2col);
        System.out.println(p1Chips + "\t" + p2Chips);
        for (int i = 0; i < 7; i++) {
            System.out.print(i + " ");
        }
        System.out.println("");
        for (int[] x : board) {
            for (int y : x) {
                System.out.print(y + "|");
            }
            System.out.println("");
        }
    }

    public void move(int player, int move) {

        if (player == 1) {
            board[empty(move)][move] = 1;
            p1Chips--;
        }
        if (player == 2) {
            board[empty(move)][move] = 2;
            p2Chips--;
        }

    }

    public int empty(int col) {
        emp = 0;
        for (int r = board.length - 1; r >= 0; r--) {
            if (board[r][col] == 0) {
                emp = r;
                break;
            }

        }
        return emp;
    }

    public int fullCol() {
       
        for (int c = 0; c < board[0].length; c++) {
             int count=0;
            for (int r = 0; r < board.length; r++) {
if(board[r][c]!=0){
    count++;
}
            }
            if(count==6)return c;
        }
return -1;
    }

    public void reset() {

        p1Chips = 21;
        p2Chips = 21;
        for (int i = 0; i < board.length; i++) {
            for (int c = 0; c < board[0].length; c++) {
                board[i][c] = 0;
            }
        }
        b2.setTurn(0);
        b2.setWin(false);
        b2.setI(0);
    }

}
