// Given two strings s and t, return true if
// t is an anagram of s, and false otherwise.
// 1 <= s.length, t.length <= 5 * 10^4
// s and t consist of lowercase English letters.
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault( s.charAt(i), 0)+1);
            map.put(t.charAt(i),map.getOrDefault( t.charAt(i), 0)-1);
        }

        for(Map.Entry<Character,Integer> e:map.entrySet()){
            if(e.getValue()!=0){
                return false;
            }
        }

        return true;
    }
}
// Time:  O(n)
// Space: O(n)
