class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') totalOnes++;
        }

        String t = "1" + s + "1";

        ArrayList<Character> ch = new ArrayList<>();
        ArrayList<Integer> len = new ArrayList<>();

        int i = 0;
        while (i < t.length()) {
            char curr = t.charAt(i);
            int j = i;
            while (j < t.length() && t.charAt(j) == curr) {
                j++;
            }
            ch.add(curr);
            len.add(j - i);
            i = j;
        }

        int ans = totalOnes;

        for (int k = 1; k < ch.size() - 1; k++) {
            if (ch.get(k) == '1' &&
                ch.get(k - 1) == '0' &&
                ch.get(k + 1) == '0') {

                int candidate = totalOnes + len.get(k - 1) + len.get(k + 1);
                ans = Math.max(ans, candidate);
            }
        }

        return ans;
    }
}