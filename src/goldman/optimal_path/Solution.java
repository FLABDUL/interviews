package goldman.optimal_path;

class Solution {
    /**
     **  Find the optimal path.
     */
    public static int optimalPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Create a dp table to store the maximum rocks collected to reach each cell
        int[][] dp = new int[m][n];

        // Initialize the start position (bottom-left corner)
        dp[m - 1][0] = grid[m - 1][0];
        System.out.println("Initial dp after start position (bottom-left):");
        printGrid(dp);

        // Initialize the first column (can only come from below)
        for (int i = m - 2; i >= 0; i--) {
            dp[i][0] = dp[i + 1][0] + grid[i][0]; // Move up
        }
        System.out.println("dp after filling the first column:");
        printGrid(dp);

        // Initialize the first row (can only come from the left)
        for (int j = 1; j < n; j++) {
            dp[m - 1][j] = dp[m - 1][j - 1] + grid[m - 1][j]; // Move right
        }
        System.out.println("dp after filling the first row:");
        printGrid(dp);

        // Fill the rest of the dp table by considering max of coming from below or left
        for (int i = m - 2; i >= 0; i--) { // From bottom to top
            for (int j = 1; j < n; j++) { // From left to right
                dp[i][j] = grid[i][j] + Math.max(dp[i + 1][j], dp[i][j - 1]); // Take max from below or left
            }
        }
        System.out.println("dp after filling the rest of the table:");
        printGrid(dp);

        // The answer is in the top-right corner of the dp table
        return dp[0][n - 1];
    }

    // Helper method to print the grid
    public static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println(); // Blank line between grids
    }

    /**
     ** Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass() {
        // Test case 1: No rocks at all
        int[][] grid1 = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        int expected1 = 0;
        if (optimalPath(grid1) != expected1) return false;

        // Test case 2: All cells have 1 rock
        int[][] grid2 = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        int expected2 = 6;
        if (optimalPath(grid2) != expected2) return false;

        // Test case 3: Single row grid
        int[][] grid3 = {
                {2, 3, 4, 5}
        };
        int expected3 = 14;
        if (optimalPath(grid3) != expected3) return false;

        // Test case 4: Single column grid
        int[][] grid4 = {
                {1},
                {2},
                {3}
        };
        int expected4 = 6;
        if (optimalPath(grid4) != expected4) return false;

        // Test case 5: Rectangular grid (more columns than rows)
        int[][] grid5 = {
                {0, 1, 2, 3},
                {0, 1, 1, 3},
                {2, 1, 0, 1}
        };
        int expected5 = 6;
        if (optimalPath(grid5) != expected5) return false;

        // Test case 6: 1x1 grid
        int[][] grid6 = {
                {7}
        };
        int expected6 = 7;
        if (optimalPath(grid6) != expected6) return false;

        // Test case 7: Complex grid with mixed values
        int[][] grid7 = {
                {2, 4, 1, 0},
                {1, 2, 3, 1},
                {0, 1, 0, 5}
        };
        int expected7 = 10;
        if (optimalPath(grid7) != expected7) return false;

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
