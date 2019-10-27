public class Demo_substring {

    /**
     * 字符串截取
     public String substring(int index);截取从参数到结尾的字符，返回新字符串
     public String substring（int begin， int end）;截取从begin开始到end结尾的字符[begin,end)，返回一个新字符串。
     */
    public static void main(String[] args) {
        String str = "HelloWorld";
        String str2 = str.substring(5);
        System.out.println(str2);
        System.out.println(str.substring(2,5));
    }
}
