
/*

Sorted Insert Position
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.

[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

*/

public class Solution {
	public int searchInsert(ArrayList<Integer> a, int b) {
	    
	    int i = 0;
	    int j = a.size()-1;
	    
	    while(i<=j) {
	        int mid = (i+j)/2;
	        if(b > a.get(mid)) {
	            i = mid+1;
	        } else if(b < a.get(mid)) {
	            j = mid-1;
	        } else {
	            return mid;
	        }
	    }
	    return i;
	}
}