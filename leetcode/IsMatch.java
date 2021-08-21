//正则表达式匹配
public class IsMatch {
    class Solution {
        public boolean isMatch(String s, String p) {
            int sLength = s.length();
            int pLength = p.length();
            boolean[][] dp = new boolean[sLength+1][pLength+1];
            dp[0][0]=true;
            for (int i = 1; i < pLength; i += 2) {
                if (p.charAt(i)=='*')
                    dp[0][i+1] = true;
            }

            for (int i = 1; i < sLength; i++) {
                char ss = s.charAt(i - 1);
                for (int t = 1; t < pLength; t++) {
                    char pp = p.charAt(t - 1);
                    if (ss == pp||pp=='.') {
                        dp[i][t] = dp[i-1][t-1];
                    }
                    else if (pp == '*') {
                        if (p.charAt(t - 2) == ss||p.charAt(t-2)=='.') {
                            dp[i][t] = dp[i - 1][t] || dp[i][t - 2];
                        }
                    } else {

                    }
                }
            }
            return dp[sLength - 1][pLength - 1];
        }
    }
}
