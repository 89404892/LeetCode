import java.util.HashMap;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> dic = new HashMap<>();
        int start = 0;
        char[] req = s.toCharArray();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (dic.containsKey(req[i])) {
                start = Math.max(start, dic.get(req[i])+1);
            }
            dic.put(req[i], i);
            result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
