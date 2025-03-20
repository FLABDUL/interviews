package wise.tic_tac_toe_practice;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import static wise.tic_tac_toe_practice.Result.*;

enum Result {SUCCESS, ERROR, WIN};//failure not needed

class Game {
    private static final Logger logger = Logger.getLogger(Game.class.getName());
    //add vars for board, players, winningcount, boardsize
    private Map<String, Integer> board;
    private Map<UUID, Integer> players;
    private int winningCount;

    //constructor for game
    public Game(int winningCount, Map<UUID, Integer> players) {
        this.board = new HashMap<>();
        this.players = players;
        this.winningCount = winningCount;
    }

    /*move method*/
    //check player existence
    //check position occupation
    //check symbol (value) and put on board
    //check win
    public Result move(UUID player, int x, int y){
        if(!players.containsKey(player)){
            logger.info("Player doesn't exist!");
            return ERROR;
        }

        String key = x + ", " + y;
        int symbol = players.get(player);
        if(board.containsKey(key)){
            logger.info("Already been marked!");
            return ERROR;
        }else{
            board.put(key, symbol);
        }

        if (checkWin(symbol, x, y)){
            return WIN;
        }

        return SUCCESS;
    }

    /*check win method*/
    //check in all directions
    boolean checkWin(int symbol, int x, int y){
        return checkDirection(symbol, x, y, 1, 0) ||//horizontal
        checkDirection(symbol, x, y, 0, 1) ||//vertical
        checkDirection(symbol, x, y, 1, 1) ||//diagonal
        checkDirection(symbol, x, y, 1, -1);//diagonal
    }

    /*check direction method*/
    //calls count in both directions +ve/-ve
    //check winning count
    private boolean checkDirection(int symbol, int x, int y, int dx, int dy) {
        int count = 1;
        count += countDirection(symbol, x, y, dx, dy);
        count += countDirection(symbol, x, y, -dx, -dy);
        return count>=winningCount;
    }

    private int countDirection(int symbol, int x, int y, int dx, int dy) {
        int count = 0;
        int newX = x + dx;
        int newY = y + dy;
        while(board.getOrDefault(newX + ", " + newY, -1) == symbol){
            count++;
            newX += dx;
            newY += dy;
        }
        return count;
    }

    /*count direction method*/
    //count matches
    public static void main(String[] args) {
        // Creating players
        UUID player1 = UUID.randomUUID();
        UUID player2 = UUID.randomUUID();
        Map<UUID, Integer> players = new HashMap<>();
        players.put(player1, 1);
        players.put(player2, 2);

        // Initializing game
        Game game = new Game(3, players);

        // Simulating a game
        System.out.println(game.move(player1, 0, 0)); // SUCCESS
        System.out.println(game.move(player2, 1, 0)); // SUCCESS
        System.out.println(game.move(player1, 0, 1)); // SUCCESS
        System.out.println(game.move(player2, 1, 1)); // SUCCESS
        System.out.println(game.move(player1, 0, 2)); // WIN
    }
}
