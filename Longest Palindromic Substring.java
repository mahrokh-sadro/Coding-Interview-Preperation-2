// Given a string s, return the longest
// palindromic substring in s.

// 1 <= s.length <= 1000
// s consist of only digits and English letters.
class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n==1) return s;
        String str="";
        for(int i=0;i<n;i++){
            String s1=getPalin(s,i,i);
            String s2=getPalin(s,i,i+1);
            if(str.length()<s1.length()){
                str=s1;
            }
            if(str.length()<s2.length()){
                str=s2;
            }
        }

        return str;
    }

    private String getPalin(String s,int l,int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }  
        l++;
        return s.substring(l,r);
    }
}

// Time: O(n²)
// Space: O(n²)

class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n<2){
            return s;
        }
        String string="";
        int len=0;
        int start=0,end=0;
        for(int i=0;i<n;i++){
            int len1=expand(s,i,i);
            int len2=expand(s,i,i+1);
            len=Math.max(len1,len2);

            if(len>end-start){
               start=i-(len-1)/2;
               end=i+len/2;
            }
        }

        return s.substring(start,end+1);

    }

    private int expand(String s,int l,int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        l++;
        r--;
        return r-l+1; 
    }
}
// Time: O(n²)
// Space: O(1)