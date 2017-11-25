package com.namrata;

/**
 *
 *
 *
 PRETTYPRINT

 Print concentric rectangular pattern in a 2d matrix.
 Let us show you some examples to clarify what we mean.

 Example 1:

 Input: A = 4.
 Output:

 4 4 4 4 4 4 4
 4 3 3 3 3 3 4
 4 3 2 2 2 3 4
 4 3 2 1 2 3 4
 4 3 2 2 2 3 4
 4 3 3 3 3 3 4
 4 4 4 4 4 4 4
 Example 2:

 Input: A = 3.
 Output:

 3 3 3 3 3
 3 2 2 2 3
 3 2 1 2 3
 3 2 2 2 3
 3 3 3 3 3
 The outermost rectangle is formed by A, then the next outermost is formed by A-1 and so on.

 You will be given A as an argument to the function you need to implement, and you need to return a 2D array.
 *
 *
 *
 */

public class PrettyPrint {

    public int[][] prettyPrint(int A) {
        int len = 2 * A - 1;
        int[][] x = new int[len][len];

        for(int i=0;i<A;i++) {
            for(int j=0;j<A;j++) {
                if(j<=i) {
                    x[i][j] = A-j;
                } else {
                    x[i][j] = A-i;
                }
            }
        }

        for(int i=0;i<A;i++) {
            for(int j=len-1;j>=A;j--) {
                x[i][j] = x[i][len-j-1];
            }
        }

        for(int i=len-1;i>=A;--i) {
            for(int j=0;j<len;j++){
                x[i][j] = x[len-i-1][j];
            }
        }

        return x;
    }
}
