class Solution {
    public char processStr(String s, long k) {
        int n = s.length();

        long[] len = new long[n + 1];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                len[i + 1] = len[i] + 1;
            } 
            else if (ch == '*') {
                len[i + 1] = Math.max(0, len[i] - 1);
            } 
            else if (ch == '#') {
                len[i + 1] = len[i] * 2;
            } 
            else { // '%'
                len[i + 1] = len[i];
            }
        }

        long finalLen = len[n];

        if (k >= finalLen) {
            return '.';
        }

        long pos = k;

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            long before = len[i];
            long after = len[i + 1];

            if (ch >= 'a' && ch <= 'z') {
                if (pos == before) {
                    return ch;
                }
            }
            else if (ch == '*') {
                // position unchanged
            }
            else if (ch == '#') {
                pos %= before;
            }
            else { // '%'
                pos = after - 1 - pos;
            }
        }

        return '.';
    }
}