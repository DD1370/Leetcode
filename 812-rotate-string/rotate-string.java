class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        String con = s + s;
        int n = goal.length();

        for (int i = 0; i < n; i++) {
            if (con.charAt(i) == goal.charAt(0)) {
                int start = i;
                int index = 0;

                while (index < n && con.charAt(start) == goal.charAt(index)) {
                    index++;
                    start++;
                }

                if (index == n) {
                    return true;
                }
            }
        }

        return false;
    }
}