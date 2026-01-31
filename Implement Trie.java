// A trie (pronounced as "try") or prefix 
// tree is a tree data structure used to 
// efficiently store and retrieve keys in 
// a dataset of strings. There are various
// applications of this data structure, 
// such as autocomplete and spellchecker.

// Implement the Trie class:

// Trie() Initializes the trie object.
// void insert(String word) Inserts the
// string word into the trie.
// boolean search(String word) Returns
// true if the string word is in the 
// trie (i.e., was inserted before), and 
// false otherwise.
// boolean startsWith(String prefix)
// Returns true if there is a previously
// inserted string word that has the
// prefix prefix, and false otherwise.
    
// 1 ≤ word.length, prefix.length ≤ 2000
// word and prefix consist only of 
// lowercase English letters.
// At most 3 × 10^4 calls will be made
// to insert, search, and startsWith.
class Trie {

    Trie[] children;
    boolean isWord;
    public Trie() {
        children=new Trie[26];
        isWord=false;
    }
    
    public void insert(String word) {
        var cur=this;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(cur.children[ch-'a']==null){
                cur.children[ch-'a']=new Trie();
            }
            cur=cur.children[ch-'a'];
        }
        cur.isWord=true;
    }
    
    public boolean search(String word) {
        var cur=this;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(cur.children[ch-'a']==null){
                return false;
            }
            cur=cur.children[ch-'a'];
        }
        return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        var cur=this;
        for(int i=0;i<prefix.length();i++){
            char ch=prefix.charAt(i);
            if(cur.children[ch-'a']==null){
                return false;
            }
            cur=cur.children[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */