package itjinxun.Utils;

public class StringUtils {
    /*
    * 去掉字符串中所有的空格
    * */
    public static String trimAll(String str){
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ' '){
                continue;
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    /*
     * 字符串反转
     * */
    public static String reverse(String str){
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = chars.length-1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
