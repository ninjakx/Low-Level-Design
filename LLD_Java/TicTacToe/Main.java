package Java.TicTacToe;
public class Main {
    public static void main(String args[]){
       Game game = new Game(2,5,4);
       Player player1 = new Player("Kriti");
       player1.setSymbol(Symbol.X);
       Player player2 = new Player("Gaurav");
       player2.setSymbol(Symbol.O);
       game.addPlayer(player1);
       game.addPlayer(player2);
       game.play();
    }
}