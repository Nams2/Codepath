
/*

Find duplicate in Array

Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.

Sample Input:

[3 4 1 4 1]
Sample Output:

1
If there are multiple possible answers ( like in the sample case above ), output any one.

If there is no duplicate, output -1

*/

public class DuplicateInArray {
	// DO NOT MODIFY THE LIST
	public int repeatedNumber(final List<Integer> a) {
	    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	    int maxCount = 0;
	    int result = -1;
	    
	    for(int i = 0; i< a.size(); i++) {
	        if(map.containsKey(a.get(i))) {
	            int count = map.get(a.get(i));
	            map.put(a.get(i),++count);
	            if(count>maxCount) {
	                maxCount = count;
	                result = a.get(i);
	            }
	        } else {
	            map.put(a.get(i),1);
	        }
	    }
	    return result;
	}
}
