
/*

Fraction
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example :

Given numerator = 1, denominator = 2, return "0.5"
Given numerator = 2, denominator = 1, return "2"
Given numerator = 2, denominator = 3, return "0.(6)"

*/

public class Solution {
	public String fractionToDecimal(int numerator, int denominator) {
	    if (numerator == 0)
		return "0";
	    if (denominator == 0)
		    return "";
 
	    StringBuilder result = new StringBuilder();
 
	    // is result is negative
	    if ((numerator < 0) ^ (denominator < 0)) {
	    	result.append("-");
	    }
 
	    // convert int to long
	    long num = numerator, den = denominator;
	    num = Math.abs(num);
	    den = Math.abs(den);
 
	    // quotient 
	    long res = num / den;
	    result.append(String.valueOf(res));
 
	    // if remainder is 0, return result
	    long remainder = (num % den) * 10;
	    if (remainder == 0)
	    	return result.toString();
 
	    // right-hand side of decimal point
    	HashMap<Long, Integer> map = new HashMap<Long, Integer>();
	    result.append(".");
	    while (remainder != 0) {
		    // if digits repeat
		    if (map.containsKey(remainder)) {
			    int beg = map.get(remainder); 
			    String part1 = result.substring(0, beg);
		    	String part2 = result.substring(beg, result.length());
		    	
		    	return part1 + "(" + part2 + ")";
	    	}
 
	    	// continue
		    map.put(remainder, result.length());
	    	res = remainder / den;
	    	result.append(String.valueOf(res));
	    	remainder = (remainder % den) * 10;
    	}
 
    	return result.toString();
	}
}
