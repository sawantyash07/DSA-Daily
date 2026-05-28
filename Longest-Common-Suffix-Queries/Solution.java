class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int index;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        TrieNode root = new TrieNode();

        root.index = getBestIndex(wordsContainer);

        for (int i = 0; i < wordsContainer.length; i++) {
            insert(root, wordsContainer[i], i, wordsContainer);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(root, wordsQuery[i]);
        }

        return ans;
    }

    private void insert(TrieNode root, String word, int idx, String[] wordsContainer) {

        TrieNode node = root;

        String reversed = new StringBuilder(word).reverse().toString();

        for (char ch : reversed.toCharArray()) {

            int c = ch - 'a';

            if (node.children[c] == null) {
                node.children[c] = new TrieNode();
                node.children[c].index = idx;
            } else {
                int currentBest = node.children[c].index;

                if (isBetter(idx, currentBest, wordsContainer)) {
                    node.children[c].index = idx;
                }
            }

            node = node.children[c];
        }
    }

    private int search(TrieNode root, String query) {

        TrieNode node = root;

        int ans = root.index;

        String reversed = new StringBuilder(query).reverse().toString();

        for (char ch : reversed.toCharArray()) {

            int c = ch - 'a';

            if (node.children[c] == null) {
                break;
            }

            node = node.children[c];
            ans = node.index;
        }

        return ans;
    }

    private int getBestIndex(String[] words) {

        int best = 0;

        for (int i = 1; i < words.length; i++) {
            if (isBetter(i, best, words)) {
                best = i;
            }
        }

        return best;
    }

    private boolean isBetter(int a, int b, String[] words) {

        if (words[a].length() < words[b].length()) {
            return true;
        }

        if (words[a].length() == words[b].length() && a < b) {
            return true;
        }

        return false;
    }
}