public class DemoStringPractise {
    /**
     *  定义一个方法， 把数组{1,2,3}按照指定格式拼接成一个新字符串。格式：[word1#word2#word3].
     *
     *  分析：
     *  准备一个int[]数组，内容是1,2,3；
     *  定义一个方法转换数组为字符串
     *  返回值：String
     *  方法名称：fromArrayToString
     *  参数列表：int[]
     *  格式：[word1#word2#word3].
     */
    public static void main(String[] args) {
        int[] array = {1,2,3};
        String str = fromArrayToString(array);
        System.out.println(str);

    }
    public static String fromArrayToString(int[] array){
        String str = "[" ;
        for (int i = 0; i < array.length; i++) {
            if (i==array.length-1){
                str += "word"+array[i]+"]";
            }
            else {
                str += "word"+array[i]+"#";
            }
        }
        return str;

    }
}
