// Given an array of strings strs, 
// group the together. You can return
// the answer in any order.
// - 1 ≤ strs.length ≤ 10^4
// - 0 ≤ strs[i].length ≤ 100
// - strs[i] consists of lowercase English letters

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0){
            return new ArrayList<>();
        }

        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] charKey=str.toCharArray();
            Arrays.sort(charKey);
            String key=new String(charKey);
            if(map.containsKey(key)){
              map.get(key).add(str);
            }
            else{
              map.put(key,new ArrayList<>());
              map.get(key).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
}

// Time	O(n × k log k)
// Space	O(n × k)
// n = “how many strings we have to process”
// k = “how long each string is (worst case)”

