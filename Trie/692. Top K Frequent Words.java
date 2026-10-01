//Problem
    
    /*Given an array of strings words and an integer k, return the k most frequent strings.
    
    Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
    
     
    
    Example 1:
    
    Input: words = ["i","love","leetcode","i","love","coding"], k = 2
    Output: ["i","love"]
    Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
    Example 2:
    
    Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
    Output: ["the","is","sunny","day"]
    Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
     
    
    Constraints:
    
    1 <= words.length <= 500
    1 <= words[i].length <= 10
    words[i] consists of lowercase English letters.
    k is in the range [1, The number of unique words[i]]
     
    
    Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?*/

//Solution

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> fre = new HashMap<>();

        for(String word : words){
            fre.put(word, fre.getOrDefault(word, 0) + 1);
        }

        HashMap<Integer, List<String> > freList = new HashMap<>();
        for(String word : fre.keySet()){
            if(!freList.containsKey(fre.get(word))) freList.put(fre.get(word), new ArrayList<>());
            freList.get(fre.get(word)).add(word);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int f : freList.keySet()){
            pq.offer(f);
        }

        List<String> ans = new ArrayList<>();
        int i = 0;

        while(i < k){
            List<String> temp = freList.get(pq.peek());
            Collections.sort(temp);
            for(int j = 0; j < temp.size() && i < k; j++){
                ans.add(temp.get(j));
                i++;
            }
            pq.remove();
        }

        return ans;
    }
}
