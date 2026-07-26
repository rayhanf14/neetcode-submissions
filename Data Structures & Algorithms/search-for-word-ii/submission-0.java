class Solution {

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void add(String word) {
            TrieNode curr = root;

            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';

                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }

                curr = curr.children[idx];
            }

            curr.word = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {

        Trie trie = new Trie();

        for (String word : words) {
            trie.add(word);
        }

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, trie.root, ans);
            }
        }

        return ans;
    }

    void dfs(int r, int c, char[][] board, TrieNode node, List<String> ans) {

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return;
        }

        char ch = board[r][c];

        if (ch == '#') {
            return;
        }

        TrieNode next = node.children[ch - 'a'];

        if (next == null) {
            return;
        }

        if (next.word != null) {
            ans.add(next.word);
            next.word = null; // Avoid duplicates
        }

        board[r][c] = '#';

        for (int[] d : dirs) {
            dfs(r + d[0], c + d[1], board, next, ans);
        }

        board[r][c] = ch;
    }
}