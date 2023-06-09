/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connect4;

/**
 *
 * @author Shyam
 */
import java.util.Scanner;
import connect4.board;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;

public class Connect4 {

    static int turn = 0;

    public void setTurn(int t) {
        turn = t;
    }

    final static ArrayList<Integer> moves = new ArrayList<Integer>();

    public static void load() {
        BufferedReader inp = null;
        try {
            inp = new BufferedReader(new FileReader("moves.txt"));
            String line;
            //Attempt to read from the file, prime the pump
            line = inp.readLine();
            while (line != null) {//goes to the end of file
                StringTokenizer st = new StringTokenizer(line); //| is the
                //delimiter //Now break up the line
                moves.add(Integer.parseInt(st.nextToken()));
                line = inp.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Connect4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Connect4.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    static Scanner input = new Scanner(System.in);
    static board b1 = new board();

    static boolean win = false;

    public void setWin(boolean f) {
        win = f;
    }
    static String p1color;
    static String p2color;
    static int i = 0;

    public void setI(int c) {
        i = c;
    }

    public static void newGame() {
        

        b1 = new board();
        b1.reset();
        input.skip("\n");
    }

    public static void main(String[] args) {
        // TODO code application logic here
load();
        while (!win || (b1.getP1Chip() != 0 && b1.getP2Chip() != 0)) {
            if (turn == 0) {
              //  load();
                System.out.print("P1 enter color:");
                p1color = input.nextLine();

                System.out.print("P2 enter color:");
                p2color = input.nextLine();
            }

            if (turn % 2 == 0) {
                System.out.println(p1color + " turn...");
                b1.display(p1color, p2color);
                if (i > moves.size() - 1) {
                    System.exit(0);
                }
                while (true) {
                    if (moves.get(i) < 0 || moves.get(i) > 6) {
                        i++;
                    } else {
                        break;
                    }

                }
                if (b1.fullCol() != -1) {
                    if (moves.get(i) == b1.fullCol()) {
                        System.out.println("Bad Move");
                        i++;
                    }
                }
                b1.move(1, moves.get(i));

                turn++;
                i++;
                if (b1.checkWin(1)) {
                    win = true;
                    b1.display(p1color, p2color);
                    System.out.println("p1 Winner");

                    System.out.print("1 to Play Again, 0 to Exit");

                    int opt = input.nextInt();
                    if (opt == 0) {
                        System.out.println("Game Over!");
                        System.exit(0);
                    }
                    if (opt == 1) {
                        newGame();

                    }

                }
                if (b1.getP1Chip() == 0 && b1.getP2Chip() == 0) {
                    System.out.println("Tie");

                    System.out.print("1 to Play Again, 0 to Exit");

                    int opt = input.nextInt();
                    if (opt == 0) {
                        System.out.println("Game Over!");
                        System.exit(0);
                    }
                    if (opt == 1) {
                        load();
                        newGame();
                    }

                }
            }
            if (turn % 2 == 1) {

                System.out.println(p2color + "turn...");
                b1.display(p1color, p2color);
                if (i > moves.size() - 1) {
                    System.exit(0);
                }
                while (true) {
                    if (moves.get(i) < 0 || moves.get(i) > 6) {
                        i++;
                    } else {
                        break;
                    }

                }
                if (b1.fullCol() != -1) {
                    if (moves.get(i) == b1.fullCol()) {
                        i++;
                    }
                }
                b1.move(2, moves.get(i));

                turn++;
                i++;
                if (b1.checkWin(2)) {
                    win = true;
                    b1.display(p1color, p2color);
                    System.out.println("p2 Winner");

                    System.out.print("1 to Play Again, 0 to Exit");

                    int opt = input.nextInt();
                    if (opt == 0) {
                        System.out.println("Game Over!");
                        System.exit(0);
                    }
                    if (opt == 1) {
                        load();
                        newGame();
                    }

                }
                if (b1.getP1Chip() == 0 && b1.getP2Chip() == 0) {
                    System.out.println("Tie");

                    System.out.print("1 to Play Again, 0 to Exit");

                    int opt = input.nextInt();
                    if (opt == 0) {
                        System.out.println("Game Over!");
                        System.exit(0);
                    }
                    if (opt == 1) {
                        load();
                        newGame();
                    }

                }
            }

        }
    }

}
