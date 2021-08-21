public class NumDecodings {
    public int numDecodings(String s) {
//        return count(s);
        int length = s.length();
        if (length==0||s.charAt(0)=='0') return 0;
        if (length==1) return 1;
        int[] dp = new int[length+1];
        dp[1] = isQualified(s.substring(length - 1));
//        dp[1]=isQualified(s.substring(length-2))+dp[0];
        for (int i = 2; i <= length ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            if (s.charAt(length-i)=='0'||isQualified(s.substring(length-i,length-i+2))==0)
                dp[i] = dp[i - 1];
            }
        return dp[length];
    }

    public int isQualified(String s) {
        int length = s.length();
        if (s.charAt(0)=='0') return 0;
        if (length == 2&&Integer.valueOf(s)>26) return 0;
        return 1;
    }
   /* public int count(String s) {
        if (s.length() == 0) {
            return 1;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        if (Integer.valueOf(s.substring(0, 2)) <= 26)
            return count(s.substring(1)) + count(s.substring(2));
        else {
            return count(s.substring(1));
        }
    }*/
}
