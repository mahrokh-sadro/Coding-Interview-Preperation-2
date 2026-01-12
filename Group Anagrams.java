// Given an array of strings strs, group
// the anagrams together. You can return the answer in any order.

//  1 <= strs.length <= 10^4
// 0 <= strs[i].length <= 100
// strs[i] consists of lowercase
// English letters.
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();

        for(String s:strs){
            char[] keyChars=s.toCharArray();
            Arrays.sort(keyChars);
            String key=new String(keyChars);
            if(!map.containsKey(key)){
               map.put(key,new ArrayList<>());
               map.get(key).add(s);
            }
            else{
               map.get(key).add(s);
            }
        }

        return new ArrayList<>(map.values());
    }
}

//Time: O(n * k log k)
//Space: O(n)
