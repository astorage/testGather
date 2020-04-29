package com.example.demo.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Boris
 * @date 2020/3/25 9:08
 */
public class RegexTest {
    public static void main(String[] args) {
        //testPatternCompileUrl();
        testReg();
    }

    /**
     * 测试java正则表达式匹配
     */
    private static void testPatternMatches() {
        String content = "I am noob from runoob.com.";

        String pattern = ".*runoob.*";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }

    /**
     * 测试获取 匹配pattern并获取这一匹配
     */
    private static void testPatternCompile() {
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }
    }


    /**
     * java中匹配pattern并获取这一匹配
     */
    private static void testPatternCompileUrl() {
        // 按指定模式在字符串查找
        String url = "/api/supply/sdfd/testa/fdsfs/query";
        String pattern = "^/api/supply/(.*)$";


        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(url);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
//            System.out.println("Found value: " + m.group(2) );
//            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }
    }

    /**
     * 测试正则表达式：[^(\w\u4e00-\u9fa5)]  表达式表示所有数字英文、中文、数字、一 、_
     * \w匹配包括下划线的任何单词字符，类似但不等价于“[A-Za-z0-9_]”，这里的"单词"字符使用Unicode字符集
     * \u4e00  表示中文的 一   中文的开始
     * \u9fa5 表示中文的 龥    中文的结束
     *
     */
    private static void testReg(){
        String str = "四川爱媛果冻橙5斤, 12枚高山原生态红富士龥".replaceAll("[^(\\w\\u4e00-\\u9fa5)]", "");
        System.out.println(str);

    }



}
