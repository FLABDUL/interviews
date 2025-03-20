package goldman.optimal_path;/* Problem Name is &&& Optimal Path &&& PLEASE DO NOT REMOVE THIS LINE. */

/*
 ** Instructions to candidate.
 **  1) You are an avid rock collector who lives in southern California. Some rare
 **     and desirable rocks just became available in New York, so you are planning
 **     a cross-country road trip. There are several other rare rocks that you could
 **     pick up along the way.
 **
 **  2) You have been given a grid filled with numbers, representing the number of
 **     rare rocks available in various cities across the country. Your objective
 **     is to find the optimal path from So_Cal to New_York that would allow you to
 **     accumulate the most rocks along the way.
 **
 **     Note: You can only travel either north (up) or east (right).
 **
 **  3) Consider adding some additional tests in doTestsPass().
 **
 **  4) Implement optimalPath() correctly.
 **
 **  Here is an example:
 **
 **     {{0,0,0,0,5}, New_York (finish)
 **      {0,1,1,1,0},
 **     So_Cal (start) {2,0,0,0,0}}
 **
 **  - The total for this example would be 10 (2+0+1+1+1+1+0+5).
 */

class Problem {
    /**
     **  Find the optimal path.
     */
    public static int optimalPath(int[][] grid) {
        // TODO: Implement optimalPath
        return 0;
    }

    /**
     ** Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass() {
        // TODO: Implement test cases
        return false;
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }
    }
}
