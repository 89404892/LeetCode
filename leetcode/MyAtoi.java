/**
 * @Author:zzh
 * @Date:2021/8/11
 * @Des:8.字符串转整数
 */
public class MyAtoi {

    public int myAtoi(String s) {
        //去除前导空格
        String target = cutBlank(s);
        if (target.length() == 0) return 0;
        int sign = 1;
        char first = target.charAt(0);
        StringBuilder tmp = new StringBuilder();
        //判断首位，并去除前导0
        if (!isNum(first)) {
            if (first == '-') {
                sign = -1;
                target = cutZero(target,1);
            } else if (first == '+') {
                sign = 1;
                target = cutZero(target,1);
            } else {
                return 0;
            }
        } else {
            target = cutZero(target,0);
        }
        //获取有效数字
        for (int i = 0; i < target.length() && i < 11; i++) {
            char c = target.charAt(i);
            if (!isNum(c)) break;
            tmp.append(c);
        }
        String part= tmp.toString();
        if (part.length()==0) return 0;
        long l = Long.valueOf(part);
        int result=0;
        //判断越界
        if (sign == 1 && l >= Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        } else if (sign == -1 && l-1 >= Integer.MAX_VALUE) {
            result = Integer.MIN_VALUE;
        } else {
            result = Integer.valueOf(part);
        }
        return result*sign;
    }

    public boolean isNum(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    public String cutBlank(String s) {
        if (s == null) {
            return s;
        }
        int start = 0;
        for (; start < s.length() && s.charAt(start) == ' '; start++) {
        }
        return s.substring(start);
    }

    public String cutZero(String s,int start) {
        if (s == null) {
            return s;
        }
        for (; start < s.length() && s.charAt(start) == '0'; start++) {
        }
        return s.substring(start);
    }
}
