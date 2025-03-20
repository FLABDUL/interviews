package wise.tic_tac_toe_attempt;

import java.util.HashMap;
import java.util.UUID;

/*
- We are Product Engineers tasked with implementing  a backend for an online TicTacToe game;
- For now, we focus only on a single function of making a move: we ignore anything else like setting up a game;
- Several games can be played in parallel between different players on the same server.
The template below can be used to get started, though modifications and extensions are welcomed.
*/

enum Result {SUCCESS, ERROR, WIN, LOSE}

class Game {
    private int[][]board;
    private HashMap<UUID, Integer> map = new HashMap<>();
    private int winningCount;

    public Game(int boardSize, int winningCount, HashMap<UUID, Integer> map) {
        //setup 2D Array int[bs][bs]
        //2 players
        this.winningCount = winningCount;
        board = new int[boardSize][boardSize];//3*3
        // UUID player1 = new UUID(mostSigBits, leastSigBits)
        // Result result = move()
        this.map = map;//Map.of({Hakim, 1}, {Duncan, 2})//PROBABLY NEEDS CONTROLS

    }

    public Result move(UUID player, int x, int y) {//assuming 0 index
        int playerSymbol = map.get(player);
        board[y][x] = playerSymbol;
        //count
        //player, x, y
        //x, y

        int count = 1;
        //check left and right for count = winning count - 1

        for(int i = x+1; i <= board.length; i++){
            //go right
            if(board[y][x]==playerSymbol){
                count++;
            }else{
                break;
            }
        }
        //go left man
        for(int i = x-1; i >= 0; i--){
            //go right
            if(board[y][x]==playerSymbol){
                count++;
            }else{
                break;
            }
        }
        //hey did i win?
        if(count==winningCount){
            return Result.WIN;
        }

        return Result.SUCCESS; // TODO
    }
}
