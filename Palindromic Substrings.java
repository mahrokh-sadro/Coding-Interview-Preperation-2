// Given a string s, return the number of palindromic
// substrings in it.
// 1 <= s.length <= 1000
// s consists of lowercase English letters.

public int countSubstrings(String s) {
    int count=0;
    for(int i=0;i<s.length();i++){
        count+=getCount(s,i,i);
        count+=getCount(s,i,i+1);
    }
    return count;
}

private int getCount(String s,int l,int r){
    int count=0;
    while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
        count++;
        l--;
        r++;
    }
    return count;
}

// Time: O(n²)
// Space: O(1)
