// Given a string s, sort it in decreasing
// order based on the frequency of the
// characters. The frequency of a 
// character is the number of times 
// it appears in the string.

// Return the sorted string. If there
// are multiple answers, return any of them.

// 1 <= s.length <= 5 * 10^5
// s consists of uppercase and lowercase
// English letters and digits
class Solution {
    public String frequencySort(String s) {
        int n=s.length();
        if(n==1){
            return s;
        }

        Map<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        List<Map.Entry<Character,Integer>> list=new ArrayList<>(map.entrySet());
        list.sort((a,b)->b.getValue()-a.getValue());
        
        StringBuilder sb=new StringBuilder();
        for(var e:list){//e.getKey() e.getValue()
            for(int i=0;i<e.getValue();i++){
                sb.append(e.getKey());
            }
        }

        return sb.toString();

    }
}

// Time:O(Nlogn)
// Space:O(N)