// Given a string s, find the first 
// non-repeating character in it and
// return its index. If it does not exist, return -1.
// Constraints:
// - 1 <= s.length <= 10^5
// - s consists of only lowercase English letters.
class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }

        return -1;
    }
}

// time:o(n)
// space:o(n)