// Given two strings s1 and s2, return 
// true if s2 contains a of s1, or 
// false otherwise.
// In other words, return true if one
// of s1's permutations is the substring of s2.

// 1 <= s1.length, s2.length <= 10^4
// s1 and s2 consist of lowercase 
// English letters.

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }

        int[] array1=new int[26];
        int[] array2=new int[26];

        for(int i=0;i<s1.length();i++){
            array1[s1.charAt(i)-'a']++;
            array2[s2.charAt(i)-'a']++;
        }

        if(Arrays.equals(array1,array2)){
            return true;
        }

        int l=0;
        int r=s1.length();
        while(r<s2.length()){
            array2[s2.charAt(l)-'a']--;
            array2[s2.charAt(r)-'a']++;
            if(Arrays.equals(array1,array2)){
                return true;
            }
            l++;
            r++;
        }
        return false;

    }
}
// Time: O(n)
// Space: O(1)