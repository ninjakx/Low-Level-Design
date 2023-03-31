package TicTacToe;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Game {
    public Deque<Player> players;
    Board board;
    int nPlayer;

    Game(int numPlayer, int sz, int wz){
        this.board = new Board(sz, wz);
        this.nPlayer = numPlayer;
        this.players =  new ArrayDeque<Player>();

    }
    public void addPlayer(Player player){
        this.players.add(player);
    }
    public Deque<Player> getPlayers(){
        return this.players;
    }
    public void play(){
        while(true){
            Player currPlayer = players.poll();
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a coordinate: ");

            String coordinate = input.nextLine();
            String[] parts = coordinate.split(",");
            Coordinate coord = new Coordinate();
            coord.y = Integer.parseInt(parts[0]);
            coord.x = Integer.parseInt(parts[1]);
            if (board.isFull()){
                System.out.println("It's a Tie!!");
                break;
            }
            while (!board.IsEmpty(coord) && !board.isFull()){
                System.out.println("Enter coordinate again: ");

                coordinate = input.nextLine();
                parts = coordinate.split(",");      
                coord.y = Integer.parseInt(parts[0]);
                coord.x = Integer.parseInt(parts[1]);        
            }

            currPlayer.setMoves(coord);
            board.addSymbol(currPlayer, coord);
            board.Display();
            
            if (board.check(coord, currPlayer)){
                System.out.printf("Player %s is the winner\n", currPlayer.getName());
                break;
            } 
            players.add(currPlayer);
        }
    }
    
}
