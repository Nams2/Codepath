/*

Roman To Integer

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

Read more details about roman numerals at Roman Numeric System

Example :

Input : "XIV"
Return : 14
Input : "XX"
Output : 20

*/


public class RomanToInteger {
	public int romanToInt(String a) {
	    int[] num = new int[a.length()];
	    
	    for(int i=0;i<a.length();i++) {
	        
	        switch(a.charAt(i)) {
	            case 'M':
	                num[i] = 1000;
	                break;
	           
	            case 'D':
	                num[i] = 500;
	                break;
	                
	            case 'C':
	                num[i] = 100;
	                break;
	           
	            case 'L':
	                num[i] = 50;
	                break;
	                
	            case 'X':
	                num[i] = 10;
	                break;
	           
	            case 'V':
	                num[i] = 5;
	                break;
	                
	            case 'I':
	                num[i] = 1;
	                break;
	                
	        }
	    }
	        
	    int sum = 0;
	        
	    for(int i=0;i<num.length-1;i++) {
	       if(num[i] < num[i+1]) {
	           sum = sum - num[i];
	       } else {
	           sum = sum + num[i];
	       }
	   }
	        
	   return sum + num[num.length-1];
	   
	}
}