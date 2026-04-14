//Problem
    
    /*
    You have a keyboard layout as shown above in the X-Y plane, where each English uppercase letter is located at some coordinate.
    
    For example, the letter 'A' is located at coordinate (0, 0), the letter 'B' is located at coordinate (0, 1), the letter 'P' is located at coordinate (2, 3) and the letter 'Z' is located at coordinate (4, 1).
    Given the string word, return the minimum total distance to type such string using only two fingers.
    
    The distance between coordinates (x1, y1) and (x2, y2) is |x1 - x2| + |y1 - y2|.
    
    Note that the initial positions of your two fingers are considered free so do not count towards your total distance, also your two fingers do not have to start at the first letter or the first two letters.
    
     
    
    Example 1:
    
    Input: word = "CAKE"
    Output: 3
    Explanation: Using two fingers, one optimal way to type "CAKE" is: 
    Finger 1 on letter 'C' -> cost = 0 
    Finger 1 on letter 'A' -> cost = Distance from letter 'C' to letter 'A' = 2 
    Finger 2 on letter 'K' -> cost = 0 
    Finger 2 on letter 'E' -> cost = Distance from letter 'K' to letter 'E' = 1 
    Total distance = 3
    Example 2:
    
    Input: word = "HAPPY"
    Output: 6
    Explanation: Using two fingers, one optimal way to type "HAPPY" is:
    Finger 1 on letter 'H' -> cost = 0
    Finger 1 on letter 'A' -> cost = Distance from letter 'H' to letter 'A' = 2
    Finger 2 on letter 'P' -> cost = 0
    Finger 2 on letter 'P' -> cost = Distance from letter 'P' to letter 'P' = 0
    Finger 1 on letter 'Y' -> cost = Distance from letter 'A' to letter 'Y' = 4
    Total distance = 6
     
    
    Constraints:
    
    2 <= word.length <= 300
    word consists of uppercase English letters.*/

//Solution

class Solution {

    int[][][][][] dp = new int[301][7][7][7][7];

    public int[] getCoordinate(char ch) {
        int pos = ch - 'A';
        return new int[]{pos / 6, pos % 6};
    }

    public int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public int solve(String word, int i, int x1, int y1, int x2, int y2) {
        if (i == word.length())
            return 0;

        if (dp[i][x1 + 1][y1 + 1][x2 + 1][y2 + 1] != -1)
            return dp[i][x1 + 1][y1 + 1][x2 + 1][y2 + 1];

        int[] coord = getCoordinate(word.charAt(i));
        int x = coord[0], y = coord[1];

        if (x1 == -1 && y1 == -1 && x2 == -1 && y2 == -1) {
            return dp[i][x1 + 1][y1 + 1][x2 + 1][y2 + 1] =
                    solve(word, i + 1, x, y, x2, y2); 
        }

        if (x2 == -1 && y2 == -1) {
            int moveF2 = solve(word, i + 1, x1, y1, x, y);

            int moveF1 = solve(word, i + 1, x, y, x2, y2)
                    + getDistance(x1, y1, x, y);

            return dp[i][x1 + 1][y1 + 1][x2 + 1][y2 + 1] =
                    Math.min(moveF1, moveF2);
        }

        int moveF1 = solve(word, i + 1, x, y, x2, y2)
                + getDistance(x1, y1, x, y);

        int moveF2 = solve(word, i + 1, x1, y1, x, y)
                + getDistance(x2, y2, x, y);

        return dp[i][x1 + 1][y1 + 1][x2 + 1][y2 + 1] =
                Math.min(moveF1, moveF2);
    }

    public int minimumDistance(String word) {
        for (int i = 0; i < 301; i++)
            for (int a = 0; a < 7; a++)
                for (int b = 0; b < 7; b++)
                    for (int c = 0; c < 7; c++)
                        Arrays.fill(dp[i][a][b][c], -1);

        return solve(word, 0, -1, -1, -1, -1);
    }
}
