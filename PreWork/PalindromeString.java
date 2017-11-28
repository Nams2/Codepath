
/*

Palindrome String

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example:

"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

*/


public class PalindromeString {
	
	public int isPalindrome(String a) {
	    a = a.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
	    
	    if(a.length() < 2) {
	        return 1;
	    }
	    
	    Stack<Character> stack = new Stack<Character>();
	    int index = 0 ;
	    while(index<a.length()/2) {
	        stack.push(a.charAt(index));
	        index++;
	    }
	    
	    if(a.length()%2 ==1) {
	        index++;
	    }
	    
	    while(index < a.length()) {
	        if(stack.empty()) {
	            return 0;
	        }
	        char temp = stack.pop();
	        if(a.charAt(index)!=temp) {
	            return 0;
	        } else {
	            index++;
	        }
	    }
	    return 1;
	}
	
	
	/* 
	public int isPalindrome(String a) {
	    a = a.replaceAll("[^a-zA-Z0-9]","");

	    for(int i =0;i<a.length();i++) {
	        if(a.toLowerCase().charAt(i) != a.toLowerCase().charAt(a.length()-1-i)) {
	            return 0;
	        }
	    }
	    
	    return 1;
	    
	}
	*/
}