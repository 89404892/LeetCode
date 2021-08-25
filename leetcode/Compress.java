/**
* @Author:zzh
* @Date:2021/8/21
* @Des:443. 压缩字符串
*/
public class Compress {
    public int compress(char[] chars) {
        int count=1;
        int tmp=0,writeTmp=0;
        for (int i = 0; i < chars.length; i++) {
            //前位指针
            tmp=i-1;
            //首位
            if (tmp < 0) {
                count++;
            }
            //当前与之前相等
            else if (chars[tmp] == chars[i]) {
                count++;
                //最后一位
                if (i == chars.length - 1) {
                    String coun=count+"";
                    for (int t = 0; t < coun.length(); t++) {
                        chars[++writeTmp]=coun.charAt(t);
                    }
                }
            }
            //当前与之前不等
            else{
                if (count != 1) {
                    String coun=count+"";
                    for (int t = 0; t < coun.length(); t++) {
                        chars[++writeTmp]=coun.charAt(t);
                    }
                }
                chars[++writeTmp] = chars[i];
                count=1;
            }
        }
        return writeTmp+1;
    }

}
