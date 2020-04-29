package com.example.demo.encrypt;

import com.example.demo.user.SecurityUtil;

/**
 * @author Boris
 * @date 2020/3/17 15:21
 */
public class TestSecurityUtil {

    public static void main(String[] args) {
        String ciphertext = jiami();
    }

    /**
     * 非对称加密——用于处理用户的密码
     * 1、将用户id、用户输入的密码，程序生成的随机数salt 通过算法 生成的密文字符串
     * 2、将用户id，程序生成的随机数salt，密文字符串
     * 3、校验，根据用户id、用户输入的密码，加上salt，用步骤一的算法生成一个密码字符串，然后和数据库的密码字符串比对，
     *    相同校验通过，不相同校验不通过
     * @return
     */
    private static String  jiami() {
        String salt = SecurityUtil.getNewPsw();
        System.out.println("salt:" + salt);
        Integer id = 33333;
        String password = "123456";
        String ciphertext = SecurityUtil.getStoreLogpwd(String.valueOf(id), password , salt);
        System.out.println(ciphertext);
        return ciphertext;
    }


    public static class JavaBaseTest {

        public static void main(String[] args) {
            testYu();
        }











        /**
         * 测试取与操作
         */
        private static void testYu() {
            int a = 1;
            int b = 2;
            int c = 4;
            int d = 8;
            System.out.println(1&5);
        }




    }
}
