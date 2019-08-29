package com.lwh.jackknife.demo.javatest;

import com.lwh.jackknife.util.TextUtils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextUtilsTest {

    @Test
    public void addition_isCorrect() {
        //transferASCII(String str)
        String ascii = TextUtils.transferASCII("测试");
        assertEquals(ascii, "������");
        //transferASCII(String str)
        String gbk = TextUtils.transferGBK("测试");
        assertEquals(gbk, "娴嬭瘯");
        //transferASCII(String str)
        String utf8 = TextUtils.transferUTF_8("测试");
        assertEquals(utf8, "测试");
    }
}
