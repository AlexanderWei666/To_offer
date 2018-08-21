package com.alexander;

public class Test04 {

    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("hello world");
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(StringBuffer str) {
        //判断输入是否合法
        if (str == null || str.length() < 1) {
            return str.toString();
        }
//        //直接调用String的方法
//        return str.toString().replaceAll(" ", "%20");

        //新建Stringbuffer
        StringBuilder newStr = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                newStr.append('%');
                newStr.append('2');
                newStr.append('0');
            }else{
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }
}
