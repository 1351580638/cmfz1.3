package com.baizhi.test3;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5 {
    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123465","ABCD",1024);
        String s=md5Hash.toHex();
        System.out.println(s);
    }
}
