package recursionAndDP;

/**
 * Count all possible paths from top left to bottom right of a mXn matrix
 * The problem is to count all the possible paths from top left to bottom right of a mXn matrix with the constraints
 * that from each cell you can either move only to right or down
 *
 * Examples :
 *
 * Input :  m = 2, n = 2;
 * Output : 2
 * There are two paths
 * (0, 0) -> (0, 1) -> (1, 1)
 * (0, 0) -> (1, 0) -> (1, 1)
 *
 * Input :  m = 2, n = 3;
 * Output : 3
 * There are three paths
 * (0, 0) -> (0, 1) -> (0, 2) -> (1, 2)
 * (0, 0) -> (0, 1) -> (1, 1) -> (1, 2)
 * (0, 0) -> (1, 0) -> (1, 1) -> (1, 2)
 */
public class CountOfAllPossiblePathsMatrix {

    // Returns count of possible paths to reach
    // cell at row number m and column number n
    // from the topmost leftmost cell (cell at 1, 1)

    //Complexity [exponential]
    static int  numberOfPaths(int m, int n)
    {
        // If either given row number is first or
        // given column number is first
        if (m == 1 || n == 1)
            return 1;

        // If diagonal movements are allowed then
        // the last addition is required.
        return  numberOfPaths(m-1, n) + numberOfPaths(m, n-1);
        // + numberOfPaths(m-1,n-1);
    }

    public static void main(String args[])
    {
        System.out.println(numberOfPaths(3, 3));
    }

    // Returns count of possible paths to reach
    // cell at row number m and column number n from
    //  the topmost leftmost cell (cell at 1, 1)
    static int numberOfPathsDP(int m, int n)
    {
        // Create a 2D table to store results
        // of subproblems
        int count[][] = new int[m][n];

        // Count of paths to reach any cell in
        // first column is 1
        for (int i = 0; i < m; i++)
            count[i][0] = 1;

        // Count of paths to reach any cell in
        // first column is 1
        for (int j = 0; j < n; j++)
            count[0][j] = 1;

        // Calculate count of paths for other
        // cells in bottom-up manner using
        // the recursive solution
        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)

                // By uncommenting the last part the
                // code calculatest he total possible paths
                // if the diagonal Movements are allowed
                count[i][j] = count[i-1][j] + count[i][j-1]; //+ count[i-1][j-1];

        }
        return count[m-1][n-1];
    }


    // Returns count of possible paths to reach
    // cell at row number m and column number n from
    // the topmost leftmost cell (cell at 1, 1)
    //Above solution is more intuitive but we can also reduce the space by O(n); where n is column size.

    static int numberOfPathsDPSpace(int m, int n)
    {
        // Create a 1D array to store results of subproblems
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }


}
