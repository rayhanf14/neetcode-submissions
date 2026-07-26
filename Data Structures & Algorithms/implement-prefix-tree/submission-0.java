class PrefixTree {

    class TrieNode{
        TrieNode[] children;
        boolean eow;

        public TrieNode(){
            children = new TrieNode[26];
            eow = false;
        }
    }

    private TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            int ind = ch - 'a';
            if(curr.children[ind] == null){
                curr.children[ind] = new TrieNode();
            }
            curr = curr.children[ind];
        }
        curr.eow = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            int ind = ch - 'a';
            if(curr.children[ind] == null){
                return false;
            }
            curr = curr.children[ind];
        }
        if(curr.eow) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char ch: prefix.toCharArray()){
            int ind = ch - 'a';
            if(curr.children[ind] == null){
                return false;
            }
            curr = curr.children[ind];
        }
        return true;
    }
}
