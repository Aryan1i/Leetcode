//Problem

/*You are given a positive integer array sides of length 3.

Determine if there exists a triangle with positive area whose three side lengths are given by the elements of sides.

If such a triangle exists, return an array of three floating-point numbers representing its internal angles (in degrees), sorted in non-decreasing order. Otherwise, return an empty array.

Answers within 10-5 of the actual answer will be accepted.

 

Example 1:

Input: sides = [3,4,5]

Output: [36.86990,53.13010,90.00000]

Explanation:

You can form a right-angled triangle with side lengths 3, 4, and 5. The internal angles of this triangle are approximately 36.869897646, 53.130102354, and 90 degrees respectively.

Example 2:

Input: sides = [2,4,2]

Output: []

Explanation:

You cannot form a triangle with positive area using side lengths 2, 4, and 2.

 

Constraints:

sides.length == 3
1 <= sides[i] <= 1000*/


//Solution

class Solution {
    public double[] internalAngles(int[] sides) {
        int a = sides[0];
        int b = sides[1];
        int c = sides[2];

        double s = (a + b + c) / 2.0;
        double temp = s * (s - a) * (s - b) * (s - c);
        if(temp <= 0) return new double[0];

        double angleA = Math.acos((b*b + c*c - a*a) / (2.0 * b * c));
        angleA = Math.toDegrees(angleA);

        
        double angleB = Math.acos((a*a + c*c - b*b) / (2.0 * a * c));
        angleB = Math.toDegrees(angleB);

        double angleC = Math.acos((a*a + b*b - c*c) / (2.0 * a * b));
        angleC = Math.toDegrees(angleC);

        double[] arr = new double[3];
        arr[0] = angleA;
        arr[1] = angleB;
        arr[2] = angleC;

        Arrays.sort(arr);
        return arr;
    }
}
