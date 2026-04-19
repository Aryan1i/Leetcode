    //Problem
    
    /*You are given an integer array nums.

    A mirror pair is a pair of indices (i, j) such that:
    
    0 <= i < j < nums.length, and
    reverse(nums[i]) == nums[j], where reverse(x) denotes the integer formed by reversing the digits of x. Leading zeros are omitted after reversing, for example reverse(120) = 21.
    Return the minimum absolute distance between the indices of any mirror pair. The absolute distance between indices i and j is abs(i - j).
    
    If no mirror pair exists, return -1.
    
     
    
    Example 1:
    
    Input: nums = [12,21,45,33,54]
    
    Output: 1
    
    Explanation:
    
    The mirror pairs are:
    
    (0, 1) since reverse(nums[0]) = reverse(12) = 21 = nums[1], giving an absolute distance abs(0 - 1) = 1.
    (2, 4) since reverse(nums[2]) = reverse(45) = 54 = nums[4], giving an absolute distance abs(2 - 4) = 2.
    The minimum absolute distance among all pairs is 1.
    
    Example 2:
    
    Input: nums = [120,21]
    
    Output: 1
    
    Explanation:
    
    There is only one mirror pair (0, 1) since reverse(nums[0]) = reverse(120) = 21 = nums[1].
    
    The minimum absolute distance is 1.
    
    Example 3:
    
    Input: nums = [21,120]
    
    Output: -1
    
    Explanation:
    
    There are no mirror pairs in the array.
    
     
    
    Constraints:
    
    1 <= nums.length <= 105
    1 <= nums[i] <= 109​​​​​​​*/

//Solution

class Solution {

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        HashMap<Integer, ArrayList<Integer>> numsPos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            numsPos.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (ArrayList<Integer> pos : numsPos.values()) {
            int x = pos.get(0);
            int last = pos.get(pos.size() - 1);
            pos.add(0, last - n);
            pos.add(x + n);
        }
        List<Integer> result = new ArrayList<>();
        for (int q : queries) {
            int x = nums[q];
            ArrayList<Integer> posList = numsPos.get(x);

            if (posList.size() == 3) {
                result.add(-1);
                continue;
            }

            int idx = Collections.binarySearch(posList, q);
            if (idx < 0) idx = -idx - 1;

            int dist = Math.min(
                posList.get(idx + 1) - posList.get(idx),
                posList.get(idx) - posList.get(idx - 1)
            );
            result.add(dist);
        }
        return result;
    }
}
