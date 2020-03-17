/*
Author: Michael Smith
Date: 2/25/2020
Function: This program allows two users to play connect four on various sized boards.
The user will input and length and height for the board and then the game will begin.
The game will continue until one player has four in a row vertically or horizontally.
The program will then declare a winner and terminate.
 */
import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What would you like the height of the board to be?");
        int height = keyboard.nextInt();
        System.out.println("What would you like the length of the board to be?");
        int length = keyboard.nextInt();
        //Gets height and length of the board from the user.
        char board[][] = new char[height][length];
        initializeBoard(board);
        boolean winner = false;
        printBoard(board);
        //Method initializeBoard is called to create the board and then the printBoard method is called to print it.
        System.out.println("Player 1: x");
        System.out.println("Player 2: o");
        int col;
        int row;
        char type;
        //Rest of variables are declared.
        while(!winner){
            System.out.println("Player 1: Which column would you like to choose?");
            col = keyboard.nextInt();
            type = 'x';
            row = insertChip(board, col, type);
            board[row][col] = type;
            printBoard(board);
            if(checkIfWinner(board, height, length, type)==true){
                winner = true;
                System.out.println("Player 1 won the game!");
                break;
            }
            if(checkIfTie(board)==true){
                winner = true;
                System.out.println("Draw. Nobody wins.");
                break;
            }
            //Code block above allows user one to select a column and places the token into the appropriate spot.
            //Additionally, checks for a winner after the token is placed and if there is a tie.

            System.out.println("Player 2: Which column would you like to choose?");
            col = keyboard.nextInt();
            type = 'o';
            row = insertChip(board, col, type);
            board[row][col] = type;
            printBoard(board);
            if(checkIfWinner(board, height, length, type)==true){
                winner = true;
                System.out.println("Player 2 won the game!");
                break;
            }
            if(checkIfTie(board)==true){
                winner = true;
                System.out.println("Draw. Nobody wins.");
                break;
            }
            //Code block above allows user two to select a column and places the token into the appropriate spot.
            //Additionally, checks for a winner after the token is placed and if there is a tie.

        }
    }
    public static void printBoard(char[][] array){
        //prints board
        for (int row=0; row<array.length; row++){
            for(int col = 0; col<array[row].length; col++){
                System.out.print(array[row][col]);
            }
            System.out.println("");

        }
        //System.out.println("0"+"1"+"2"+"3");
    }//Method prints the inputed array.
    public static void initializeBoard(char[][] array){
        //initialize board
        for (int row=0; row<array.length; row++){
            for(int col=0; col<array[row].length; col++){
                array[row][col] = '-';
            }
        }
    }//Method assigns every spot in the array to '-'
    public static int insertChip(char[][] array, int col, char chipType){
        //decides how far the board the chip will fall
        int result = 0;
        for(int row=array.length-1; row>=0; row--){
            if(array[array.length-1][col] == '-'){
                result = array.length-1;
            }
            if(array[row][col] == 'x' || array[row][col] == 'o' ){
                result = row-1;
            }
        }
        return result;
    }//Method inserts the chip either at the bottom of the column or stacked ontop of other chiops
    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType){
        //checks four in a row
        boolean result = false;
        int count = 0;
        for(int coll=0; coll<array[row-1].length; coll++) {
            for (int roww = 0; roww < array.length; roww++) {
                if (array[roww][coll] == chipType) {
                    count++;
                    if (count == 4) {
                        result = true;
                    }
                } else {
                    count = 0;
                }

            }
            count = 0;
        }//Checks for a vertical victory.
       for(int roww=0; roww<array.length; roww++){
            for(int coll=0; coll<array[roww].length; coll++){
                if(array[roww][coll]==chipType){
                    count++;
                    if(count==4){
                        result = true;
                    }
                }else{
                    count = 0;
                }
            }
            count = 0;
        }//Checks for a horizontal victory
        return result;
    }//Method checks if a user has created four in a row and returns true if so.
    public static boolean checkIfTie(char array[][]){
        boolean result = true;
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[i].length; j++){
                if(array[i][j] == '-'){
                    result = false;
                }
            }
        }
        return result;
    }//Method checks to see if board has been filled completely

}//THIS IS THE FINAL PRODUCT
