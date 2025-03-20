package goldman.optimal_path;

class Practice {
    /**
     **  Find the optimal path.
     */
    public static int optimalPath(int[][] grid) {
        // Set y and x axis lengths
        int y = grid.length;
        int x = grid[0].length;

        int[][] rocks = new int[y][x];

        // Initialize start position (bottom-left corner)
        rocks[y-1][0] = grid[y-1][0];

        // Initialize first column (going up along the left side)
        for (int dy = y-2; dy >= 0; dy--) {
            rocks[dy][0] = grid[dy][0] + rocks[dy+1][0]; // Correctly moving up
        }

        // Initialize first row (going right along the bottom row)
        for (int dx = 1; dx < x; dx++) {
            rocks[y-1][dx] = grid[y-1][dx] + rocks[y-1][dx-1]; // Correctly moving right
        }

        // Fill the rest of the table (except the bottom row and left column)
        for (int dy = y-2; dy >= 0; dy--) { // Ignoring the bottom row
            for (int dx = 1; dx < x; dx++) { // Ignoring the left column
                rocks[dy][dx] = grid[dy][dx] + Math.max(rocks[dy+1][dx], rocks[dy][dx-1]); // Max from below or left
            }
        }

        // Return the value in the top-right corner (destination)
        return rocks[0][x-1];
    }

    /**
     ** Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass() {
        // Test case 1
        int[][] grid1 = {
                {0, 0, 0, 0, 5},
                {0, 1, 1, 1, 0},
                {2, 0, 0, 0, 0}
        };
        int expected1 = 10; // The optimal path is: (2,0) -> (1,0) -> (1,1) -> (1,2) -> (1,3) -> (1,4) -> (0,4)
        if (optimalPath(grid1) != expected1) return false;

        // Test case 2
        int[][] grid2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int expected2 = 21; // The optimal path is: (2,0) -> (1,0) -> (1,1) -> (1,2) -> (0,2)
        if (optimalPath(grid2) != expected2) return false;

        // Test case 3 (edge case)
        int[][] grid3 = {{5}};
        int expected3 = 5; // The grid has only one cell
        if (optimalPath(grid3) != expected3) return false;

        return true;
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }
    }
}
//go read about this!
//and draw it out!

