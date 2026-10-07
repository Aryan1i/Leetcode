//Problem
    
    /*Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.
    
     
    
    Example 1:
    
    Input: nums = [3,10,5,25,2,8]
    Output: 28
    Explanation: The maximum result is 5 XOR 25 = 28.
    Example 2:
    
    Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
    Output: 127
     
    
    Constraints:
    
    1 <= nums.length <= 2 * 105
    0 <= nums[i] <= 231 - 1*/

//Solution

class Solution {
public:
    int findMaximumXOR(vector<int>& nums) {
        class Node{
            public:
            Node* children[2];
            Node(){
                children[0]=nullptr;
                children[1]=nullptr;
            }
        };
        Node* root = new Node();
        for(int x : nums){
            Node* curr = root;
            for(int i = 30 ;i>=0 ;i--){
                int p;
                p = (x>>i)&1;
                if(p!=0){
                    if(curr->children[1]==nullptr){
                        curr->children[1]=new Node();
                    }
                    curr=curr->children[1]; 
                }else{
                    if(curr->children[0]==nullptr){
                        curr->children[0]=new Node();
                    }
                    curr=curr->children[0]; 
                }
            }
        }

        // insert is ended 

        // searching 

        int maximum=0; 

        for(int x : nums){
            int ans =0;
            Node*curr=root;
            for(int i=30;i>=0;i--){
                int bit = (x >> i) & 1;
                int opp = 1-bit;
                if(curr->children[opp]!=nullptr){
                    curr=curr->children[opp];
                    ans = ans | (1<<i);
                }else{
                    curr=curr->children[bit];
                }
                
            }
            maximum = max(maximum,ans);
        }

        return maximum;
    }
};
