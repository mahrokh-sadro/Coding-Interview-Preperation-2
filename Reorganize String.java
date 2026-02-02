// Given a string s, rearrange the 
// characters of s so that any two
// adjacent characters are not the same.

// Return any possible rearrangement
// of s or return "" if not possible.
class Solution {
    public String reorganizeString(String s) {
        int n=s.length();
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.get(ch)>(n+1)/2) return "";
        }

        PriorityQueue<Character> pq=new PriorityQueue<>(
            (a,b)->map.get(b)-map.get(a)
        );
        pq.addAll(map.keySet());

        StringBuilder sb=new StringBuilder();
        while(pq.size()>=2){
            char first=pq.poll();
            char second=pq.poll();
            sb.append(first).append(second); 
            
            map.put(first,map.get(first)-1);
            map.put(second,map.get(second)-1);

            if(map.get(first)>0) pq.add(first);
            if(map.get(second)>0) pq.add(second);
        }

        if(!pq.isEmpty()){
            sb.append(pq.poll());
        }

        return sb.toString();
        
    }
}
// Time: O(n log k) → effectively O(n)
// Space: O(n)