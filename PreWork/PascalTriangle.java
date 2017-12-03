/*

Pascal Triangle

Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]

*/

public class PascalTriangle {
	public ArrayList<ArrayList<Integer>> generate(int a) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    if( a <= 0 ) {
	        return result;
	    }
	    
	    ArrayList<Integer> prev = new ArrayList<Integer>();
	    prev.add(1);
	    result.add(prev);
	    
	    for(int i=2;i<=a;i++) {
	        ArrayList<Integer> curr = new ArrayList<Integer>();
	        curr.add(1);
	        for(int j=0;j<prev.size()-1;j++) {
	            curr.add(prev.get(j) + prev.get(j+1));
	        }
	        curr.add(1);
	        result.add(curr);
	        prev = curr;
	    }
	    return result;
	}
}