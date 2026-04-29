//Problem
/*Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

 

Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
Example 3:

Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: One of the valid triplet is (1, 4, 5), because nums[1] == 1 < nums[4] == 4 < nums[5] == 6.
 

Constraints:

1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1
 

Follow up: Could you implement a solution that runs in O(n) time complexity and O(1) space complexity?*/


//Solution


class Solution {

    public long maximumScore(int[][] grid) {
        int n = grid[0].length;
        if (n == 1) {
            return 0;
        }

        long[][][] dp = new long[n][n + 1][n + 1];
        long[][] prevMax = new long[n + 1][n + 1];
        long[][] prevSuffixMax = new long[n + 1][n + 1];
        long[][] colSum = new long[n][n + 1];

        for (int c = 0; c < n; c++) {
            for (int r = 1; r <= n; r++) {
                colSum[c][r] = colSum[c][r - 1] + grid[r - 1][c];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int currH = 0; currH <= n; currH++) {
                for (int prevH = 0; prevH <= n; prevH++) {
                    if (currH <= prevH) {
                        long extraScore = colSum[i][prevH] - colSum[i][currH];
                        dp[i][currH][prevH] = Math.max(
                            dp[i][currH][prevH],
                            prevSuffixMax[prevH][0] + extraScore
                        );
                    } else {
                        long extraScore =
                            colSum[i - 1][currH] - colSum[i - 1][prevH];
                        dp[i][currH][prevH] = Math.max(
                            dp[i][currH][prevH],
                            Math.max(
                                prevSuffixMax[prevH][currH],
                                prevMax[prevH][currH] + extraScore
                            )
                        );
                    }
                }
            }

            for (int currH = 0; currH <= n; currH++) {
                prevMax[currH][0] = dp[i][currH][0];
                for (int prevH = 1; prevH <= n; prevH++) {
                    long penalty = (prevH > currH)
                        ? (colSum[i][prevH] - colSum[i][currH])
                        : 0;
                    prevMax[currH][prevH] = Math.max(
                        prevMax[currH][prevH - 1],
                        dp[i][currH][prevH] - penalty
                    );
                }

                prevSuffixMax[currH][n] = dp[i][currH][n];
                for (int prevH = n - 1; prevH >= 0; prevH--) {
                    prevSuffixMax[currH][prevH] = Math.max(
                        prevSuffixMax[currH][prevH + 1],
                        dp[i][currH][prevH]
                    );
                }
            }
        }

        long ans = 0;
        for (int k = 0; k <= n; k++) {
            ans = Math.max(ans, Math.max(dp[n - 1][n][k], dp[n - 1][0][k]));
        }

        return ans;
    }
}
