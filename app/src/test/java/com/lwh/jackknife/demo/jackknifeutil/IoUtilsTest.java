package com.lwh.jackknife.demo.jackknifeutil;

import com.lwh.jackknife.util.IoUtils;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class IoUtilsTest {

    @Test
    public void addition_isCorrect() {
        //b2H(byte b)
        String s = IoUtils.b2H((byte) 15);
        assertEquals(s, "0f");
        //bs2H(byte[] src, String separator)
        byte[] bytes = new byte[] {
                12, 24, 36
        };
        String s1 = IoUtils.bs2H(bytes, ",");
        assertEquals(s1, "0c,18,24");
        //bs2H(byte[] src)
        String s2 = IoUtils.bs2H(bytes);
        assertEquals(s2, "0c1824");
        //H2bs(String H, String separator)
        String s3 = IoUtils.bs2H(bytes, ":");
        assertEquals(s3, "0c:18:24");
        //formatFileSize(double size)
        String s4 = IoUtils.formatFileSize(1024);
        assertEquals(s4, "1.00KB");
        //getParentPath(String path)
        String parentPath = IoUtils.getParentPath("/sdcard"+ File.separator+"a"+File.separator+"b"+File.separator+"c");
        String parentPath2 = IoUtils.getParentPath("/sdcard"+ File.separator+"a"+File.separator+"b"+File.separator+"c"+File.separator);
        assertEquals(parentPath, "/sdcard"+File.separator+"a"+File.separator+"b");
        assertEquals(parentPath2, "/sdcard"+File.separator+"a"+File.separator+"b");
        //getFileNameFromPath(String path, boolean withSuffix)
        String fileName = IoUtils.getFileNameFromPath("/sdcard"+File.separator+"dest"+File.separator+"output.txt", true);
        String fileName2 = IoUtils.getFileNameFromPath("/sdcard"+File.separator+"dest"+File.separator+"output.txt", false);
        assertEquals(fileName, "output.txt");
        assertEquals(fileName2, "output");
    }
}
