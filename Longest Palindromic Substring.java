// Given a string s, return the longest in s.

// 1 <= s.length <= 1000
// s consist of only digits and English letters.
class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n==1){
            return s;
        }

        int start=0,end=0;
        int maxLength=0;
        for(int i=0;i<n;i++){
           int len1= getLength( s,i,i);
           int len2=getLength( s,i,i+1);
           maxLength=Math.max(len1,len2);
           if(maxLength>end-start){
             start=i-(maxLength-1)/2;
             end=i+maxLength/2;
           }

        }
        return s.substring(start,end+1);
    }

    private int getLength(String s,int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        l++;
        r--;
        return r-l+1;
    }
}
// Time	O(n²)
// Space	O(1)