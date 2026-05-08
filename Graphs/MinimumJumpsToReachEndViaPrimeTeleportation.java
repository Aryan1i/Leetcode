//Problem
    
    /*You are given an integer array nums of length n.
    
    You start at index 0, and your goal is to reach index n - 1.
    
    From any index i, you may perform one of the following operations:
    
    Adjacent Step: Jump to index i + 1 or i - 1, if the index is within bounds.
    Prime Teleportation: If nums[i] is a prime number p, you may instantly jump to any index j != i such that nums[j] % p == 0.
    Return the minimum number of jumps required to reach index n - 1.
    
     
    
    Example 1:
    
    Input: nums = [1,2,4,6]
    
    Output: 2
    
    Explanation:
    
    One optimal sequence of jumps is:
    
    Start at index i = 0. Take an adjacent step to index 1.
    At index i = 1, nums[1] = 2 is a prime number. Therefore, we teleport to index i = 3 as nums[3] = 6 is divisible by 2.
    Thus, the answer is 2.
    
    Example 2:
    
    Input: nums = [2,3,4,7,9]
    
    Output: 2
    
    Explanation:
    
    One optimal sequence of jumps is:
    
    Start at index i = 0. Take an adjacent step to index i = 1.
    At index i = 1, nums[1] = 3 is a prime number. Therefore, we teleport to index i = 4 since nums[4] = 9 is divisible by 3.
    Thus, the answer is 2.
    
    Example 3:
    
    Input: nums = [4,6,5,8]
    
    Output: 3
    
    Explanation:
    
    Since no teleportation is possible, we move through 0 → 1 → 2 → 3. Thus, the answer is 3.
     
    
    Constraints:
    
    1 <= n == nums.length <= 105
    1 <= nums[i] <= 106*/

//Soluition

class Solution {

    private boolean[] isPrime;

    private void buildSieve(int maxEl) {

        isPrime = new boolean[maxEl + 1];
        Arrays.fill(isPrime, true);

        if(maxEl >= 0) isPrime[0] = false;
        if(maxEl >= 1) isPrime[1] = false;

        for(int num = 2; num * num <= maxEl; num++) {

            if(isPrime[num]) {

                for(int multiple = num * num;
                    multiple <= maxEl;
                    multiple += num) {

                    isPrime[multiple] = false;
                }
            }
        }
    }

    public int minJumps(int[] nums) {

        int n = nums.length;

        HashMap<Integer, List<Integer>> mp = new HashMap<>();
        int maxEl = 0;

        for(int i = 0; i < n; i++) {

            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);

            maxEl = Math.max(maxEl, nums[i]);
        }

        buildSieve(maxEl);

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(0);
        visited[0] = true;

        HashSet<Integer> seen = new HashSet<>();

        int steps = 0;

        while(!queue.isEmpty()) {

            int size = queue.size();

            while(size-- > 0) {

                int i = queue.poll();

                if(i == n - 1) {
                    return steps;
                }

                if(i - 1 >= 0 && !visited[i - 1]) {

                    queue.offer(i - 1);
                    visited[i - 1] = true;
                }

                if(i + 1 < n && !visited[i + 1]) {

                    queue.offer(i + 1);
                    visited[i + 1] = true;
                }

                if(!isPrime[nums[i]] || seen.contains(nums[i])) {
                    continue;
                }

                for(int multiple = nums[i];
                    multiple <= maxEl;
                    multiple += nums[i]) {

                    if(!mp.containsKey(multiple)) {
                        continue;
                    }

                    for(int j : mp.get(multiple)) {

                        if(!visited[j]) {

                            queue.offer(j);
                            visited[j] = true;
                        }
                    }
                }

                seen.add(nums[i]);
            }

            steps++;
        }

        return -1;
    }
}
