// Given two strings s and p, return an array
// of all the start indices of p's anagrams 
// in s. You may return the answer in any order.
// 1 <= s.length, p.length <= 3 * 10^4
// s and p consist of lowercase English letters.

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        if(p.length()>s.length()){
            return list;
        }

        int[] arr_s=new int[26];
        int[] arr_p=new int[26];
        for(int i=0;i<p.length();i++){
            arr_s[s.charAt(i)-'a']++;
            arr_p[p.charAt(i)-'a']++;
        }

        if(Arrays.equals(arr_s,arr_p)){
            list.add(0);
        }

        int l=0;
        int r=p.length();
        while(r<s.length()){
            arr_s[s.charAt(l)-'a']--;
            arr_s[s.charAt(r)-'a']++;
            l++;
            r++;
            if(Arrays.equals(arr_s,arr_p)){
                list.add(l);
            }
           
        }

        return list;

    }
}

//time:o(n)
//space:o(1)
