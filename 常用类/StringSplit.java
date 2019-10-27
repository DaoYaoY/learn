public class StringSplit {
    /**
     * public String Split(String regex);按照参数规则，将字符串切割成多部分
     * 参数为正则表达式，英文字符“.”需要转义：“\\.”
     */

    public static void main(String[] args) {
        String  str = "aaa,bbb,ccc,ddd";
        String[] str2 = str.split(",");
        for (int i = 0; i < str2.length; i++) {
            System.out.println(str2[i]);
        }
        System.out.println("==========");
        String str3 = "aaa bbb ccc";
        String[] s = str3.split(" ");
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
        System.out.println("==========");
        String str4 = "xxx.yyy.zzz";
        String[] array = str4.split("\\.");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
