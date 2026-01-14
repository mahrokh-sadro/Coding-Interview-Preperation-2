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
// Space: O(1)


