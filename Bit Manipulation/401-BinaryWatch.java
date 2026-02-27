//Problem

    /*A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 LEDs on the bottom to represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.
    
    For example, the below binary watch reads "4:51".
    
    
    Given an integer turnedOn which represents the number of LEDs that are currently on (ignoring the PM), return all possible times the watch could represent. You may return the answer in any order.
    
    The hour must not contain a leading zero.
    
    For example, "01:00" is not valid. It should be "1:00".
    The minute must consist of two digits and may contain a leading zero.
    
    For example, "10:2" is not valid. It should be "10:02".
     
    
    Example 1:
    
    Input: turnedOn = 1
    Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
    Example 2:
    
    Input: turnedOn = 9
    Output: []
     
    
    Constraints:
    
    0 <= turnedOn <= 10*/

//Solution

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new ArrayList<>();

        
        for(int i = 0; i < 12; i++){
            int powerUsed = 0;
            int temp = i;
            for(int k = 0; k < 4; k++,temp>>=1){
                int bit = temp & 1;
                if(bit == 1) powerUsed++;
            }

            if(powerUsed > turnedOn) continue;
            int powerRemaning = turnedOn - powerUsed;
            
            for(int j = 0; j < 60; j++){
                int minTemp = j;
                int powerUsedForMin = 0;
                for(int k = 0; k < 6; k++,minTemp>>=1){
                    int bt = minTemp & 1;
                    if(bt == 1) powerUsedForMin++;
                }
                if(powerUsedForMin != powerRemaning) continue;

                String st = i + ":";
                if(j < 10){
                    st += "0" + j; 
                } else {
                    st += j;
                }
                list.add(st);
            }
        }

        return list;
    }
}
