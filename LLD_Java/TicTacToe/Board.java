package Java.TicTacToe;

import java.util.Arrays;

public class Board {
    public int size;
    int winGameCount;
    // public Vector<Vector<Character>> board;
    Character [][] board; 
    public int remaining;
    public Board(int sz, int wz){
        this.size = sz;
        this.board = new Character[sz][sz];
        for (Character[] row: board) {
            Arrays.fill(row, '-');
        }
        remaining = sz*sz;
        if (wz<=0){
            this.winGameCount = sz; // default
        } else{
            this.winGameCount = wz;
        }
    }

    public boolean isFull(){
        if (remaining==0){
            return true;
        } else {
            return false;
        }
    }

    public boolean IsEmpty(Coordinate coordinate){
        if (board[coordinate.y][coordinate.x]=='-'){
            return true;
        } else {
            return false;
        }
    }

    public void Display(){
        String border = "+---".repeat(size)+"+";
        for (int i=0; i<size; i++){
            System.out.println(border);
            for(int j=0; j<size; j++){
                System.out.printf("| %s ", board[i][j]);
            }
            System.out.println("|");
        }
        System.out.println(border);
    }

    public Character getChar(Player player){
        char sym;
        switch (player.symbol){
            case X:{
                sym = 'X';
                break;
            }
            case O: {
                sym = 'O';
                break;
            }
            default: {
                sym = '-';
            }
        }
        return sym;
    }

    public void addSymbol(Player player, Coordinate coordinate){

        board[coordinate.y][coordinate.x] = getChar(player);
        remaining--;
    } 
    public boolean check(Coordinate coordinate, Player player){
        // col
        int col = coordinate.x;
        int row = coordinate.y;
        int count = 0;
        for (int i=row; i<size; i++){
            if (board[i][col]==getChar(player)){
                count++;
            } else {
                break;
            }
        }
        for (int i=row; i>=0; i--){
            if (board[i][col]==getChar(player)){
                count++;
            } else {
                break;
            }
        }
        if (count-1==winGameCount){
            return true;
        }
        count = 0;
        // To-Do change it to curr to left and curr to right logic (to count consecutive from current pos) -> Done
        for (int j=col; j<size; j++){
            if (board[row][j]==getChar(player)){
                count++;
            } else {
                break;
            }
        }
        for (int j=col; j>=0; j--){
            if (board[row][j]==getChar(player)){
                count++;
            } else {
                break;
            }
        }

        if (count-1==winGameCount){ // duplicate curr count
            return true;
        }

        count = 0;
        // left to right & up to down diag
        for(int i=row, j=col; i<size && j<size; i++, j++){
            if (board[i][j]==getChar(player)){
                count++;
            } else {
                break;
            }
        }
        // right to left & down to up diag
        for(int i=row, j=col; i>=0 && j>=0; i--, j--){
            if (board[i][j]==getChar(player)){
                count++;
            } else {
                break;
            }
        }
        if (count-1==winGameCount){ // duplicate count of current cell
            return true;
        }

        count = 0;
        // left to right & up to down diag
        for(int i=row, j=col; i>=0 && j<size; i--, j++){
            if (board[i][j]==getChar(player)){
                count++;
            } else {
                break;
            }
        }

        // right to left & down to up diag
        for(int i=row, j=col; i<size && j>=0; i++, j--){
            if (board[i][j]==getChar(player)){
                count++;
            } else {
                break;
            }
        }
        if (count-1==winGameCount){
            return true;
        }

        return false;
    }
}

