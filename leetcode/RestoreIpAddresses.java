import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    List<String> results = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        splitIp(4, s,"");
        return results;
    }

    public void splitIp(int rest, String ip, String result) {
        if (rest == 0) {
            results.add(result);
            return;
        }
        int length = ip.length();
        if (rest!=4)
            result += ".";
        //三位
        if (length  >= (rest-1) * 1+3 && length <= (rest-1) * 3+3) {
            int tmp = Integer.valueOf(ip.substring(0, 3));
            if (tmp <= 255&&tmp>=100) {
                splitIp(rest-1, ip.substring(3), result + tmp);
            }
        }
        //两位
        if (length  >= (rest-1) * 1+2 && length <= (rest-1) * 3+2) {
            int tmp = Integer.valueOf(ip.substring(0, 2));
            if (tmp>=10) {
                splitIp(rest-1, ip.substring(2), result + tmp);
            }
        }
        //一位
        if (length  >= (rest-1) * 1+1 && length <= (rest-1) * 3+1) {
            int tmp = Integer.valueOf(ip.substring(0, 1));
            splitIp(rest-1, ip.substring(1), result + tmp);
        }
    }
}
