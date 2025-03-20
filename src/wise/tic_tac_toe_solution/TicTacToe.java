package wise.tic_tac_toe_solution;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

enum Result {SUCCESS, ERROR, WIN}

class Game {
    private final Map<String, Integer> board;
    private final Map<UUID, Integer> players;
    private final int winningCount;
    private final int boardSize;
    //boardSize not used since board of infinite size
    //could be used to check x and y within board though
    public Game(int boardSize, int winningCount, Map<UUID, Integer> players) {
        this.board = new HashMap<>();
        this.players = players;
        this.winningCount = winningCount;
        this.boardSize = boardSize;
        System.out.println("Game initialized with board size: " + boardSize + " and winning count: " + winningCount);
    }

    public Result move(UUID player, int x, int y) {
        System.out.println("Player " + player + " attempting move at (" + x + ", " + y + ")");
        if (!players.containsKey(player)) {
            System.out.println("Error: Player not registered");
            return Result.ERROR;
        }
        String key = x + "," + y;
        if (board.containsKey(key)) {
            System.out.println("Error: Cell already occupied");
            return Result.ERROR;
        }

        int playerSymbol = players.get(player);
        board.put(key, playerSymbol);
        System.out.println("Move registered for player " + player + " at (" + x + ", " + y + ")");

        if (checkWin(x, y, playerSymbol)) {
            System.out.println("Player " + player + " wins!");
            return Result.WIN;
        }
        return Result.SUCCESS;
    }

    private boolean checkWin(int x, int y, int playerSymbol) {
        return checkDirection(x, y, playerSymbol, 1, 0) || // Horizontal
                checkDirection(x, y, playerSymbol, 0, 1) || // Vertical
                checkDirection(x, y, playerSymbol, 1, 1) || // Diagonal /
                checkDirection(x, y, playerSymbol, 1, -1);  // Diagonal \
    }

    private boolean checkDirection(int x, int y, int playerSymbol, int dx, int dy) {
        int count = 1;
        count += countInDirection(x, y, playerSymbol, dx, dy);
        count += countInDirection(x, y, playerSymbol, -dx, -dy);
        return count >= winningCount;
    }

    private int countInDirection(int x, int y, int playerSymbol, int dx, int dy) {
        int count = 0;
        int newX = x + dx;
        int newY = y + dy;
        while (board.getOrDefault(newX + "," + newY, -1) == playerSymbol) {
            count++;
            newX += dx;
            newY += dy;
        }
        return count;
    }

    public static void main(String[] args) {
        // Creating players
        UUID player1 = UUID.randomUUID();
        UUID player2 = UUID.randomUUID();
        Map<UUID, Integer> players = new HashMap<>();
        players.put(player1, 1);
        players.put(player2, 2);

        // Initializing game
        Game game = new Game(3, 3, players);

        // Simulating a game
        System.out.println(game.move(player1, 0, 0)); // SUCCESS
        System.out.println(game.move(player2, 1, 0)); // SUCCESS
        System.out.println(game.move(player1, 0, 1)); // SUCCESS
        System.out.println(game.move(player2, 1, 1)); // SUCCESS
        System.out.println(game.move(player1, 0, 2)); // WIN
    }
}
