//String类转换
public class Demo01String {
    public static void main(String[] args) {
        /**
         * String常用的转换方法
         * 1.public char[] toCharArray();
         * 2.public byte[] getBytes();
         * 3.public String replace(CharSequence oldString, CharSequence newString );//将出现的老字符串全部替换成新字符串返回替换后的新字符串
         * 备注：CharSequence可以接受字符串类型
         */

        char[] chars = "Hello".toCharArray();
        System.out.println(chars[0]);
        System.out.println(chars.length);
        System.out.println("==============");

        byte[] bytes = "abc".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        System.out.println("==============");
        //字符串替换
        String str1 = "how do you do?";
        String str2 = str1.replace("o","*");
        System.out.println(str1);
        System.out.println(str2);
    }
}
