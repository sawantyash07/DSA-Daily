class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int diff = 0;
        int q = 0;

        for (int i = 0; i < n; i++) {
            int sign = i < n / 2 ? 1 : -1;

            if (num.charAt(i) == '?') {
                q += sign;
            } else {
                diff += sign * (num.charAt(i) - '0');
            }
        }

        return q % 2 != 0 || diff * 2 != -q * 9;
    }
}