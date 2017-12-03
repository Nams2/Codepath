
/*


Implement strStr().

 strstr - locate a substring ( needle ) in a string ( haystack ). 



*/



public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int strStr(final String A, final String B) {
        if(A==null || B==null)    
            return 0;
 
        if(B.length() == 0)
            return 0;
 
        for(int i=0; i<A.length(); i++){
            if(i + B.length() > A.length())
                return -1;
 
            int m = i;
            for(int j=0; j<B.length(); j++){
                if(B.charAt(j)==A.charAt(m)){
                    if(j==B.length()-1)
                        return i;
                    m++;
                }else{
                    break;
            }
 
        }    
    }   
 
    return -1;
    }
}
