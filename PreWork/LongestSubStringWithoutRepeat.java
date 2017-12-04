
/*

Longest Substring Without Repeat

Given a string, 
find the length of the longest substring without repeating characters.

Example:

The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.

*/

public class LongestSubStringWithoutRepeat {
	public int lengthOfLongestSubstring(String a) {
	    
	    if(a==null || a.length()==0)
            return 0;
 
        HashSet<Character> set = new HashSet<Character>();
 
        int max=0;
 
        int i=0;
        int start=0;
        while(i<a.length()){
            char c = a.charAt(i);
            if(!set.contains(c)){
                set.add(c);
            }else{
                max = Math.max(max, set.size());
 
                while(start<i&&a.charAt(start)!=c){
                    set.remove(a.charAt(start));
                    start++;
                }
                start++;
            }
 
            i++;
        }
 
        max = Math.max(max, set.size());
 
        return max;
	}
}