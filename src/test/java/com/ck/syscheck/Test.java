package com.ck.syscheck;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
/**
  *  测试Shiro加盐，一般在注册的时候进行如下处理，最后保存到数据库
  * @author ck
  * @date 2019/7/8
  */
public class Test {

    public static void main(String[] args) {
        String newPs = new SimpleHash("MD5", "123456", ByteSource.Util.bytes("AaBbCc"), 1024).toHex();

        System.out.println(newPs);
        //038bdaf98f2037b31f1e75b5b4c9b26e
        //2e693ea46ee44678bdcafe66346771b0
    }
}
