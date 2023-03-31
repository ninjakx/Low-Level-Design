package TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String name;
    public Symbol symbol;
    public List<Coordinate> moves;

    Player(String name){
        this.moves = new ArrayList<>();
        this.name = name;
    }

    public List<Coordinate> getMoves(){
        return this.moves;
    }
    public void setMoves(Coordinate coordinate){
        moves.add(coordinate);
    }
    public void setSymbol(Symbol symbol){
        this.symbol = symbol;
    }
    public Symbol getSymbol(){
        return this.symbol;
    } 
    public String getName(){
        return this.name;
    } 
}
