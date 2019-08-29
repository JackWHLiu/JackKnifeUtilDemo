package com.lwh.jackknife.demo.javatest;

import android.util.Log;

import com.lwh.jackknife.util.Math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathTest {

    @Test
    public void addition_isCorrect() {
        //H2D(String hexadecimal)
        int af = Math.H2D("af");    //10 * 16 + 15 = 175
        assertEquals(af, 175);
        //zeroH(String num, int requiredLength)
        String f = Math.zeroH("F", 3);
        assertEquals(f, "00F");
        //zeroL(String num, int requiredLength)
        String d = Math.zeroL("D", 2);
        assertEquals(d, "D0");
        //clamp(float value, float max, float min)
        float clamp = Math.clamp(102, 100, 0.0f);
        assertEquals(clamp, 100, 0);
        //getRandom(int min, int max)
        int random = Math.getRandom(100, 200);
        System.out.println(random);
        //getRandoms(int min, int max, int count)
        int[] randoms = Math.getRandoms(10, 22, 9);
        System.out.println("----------可重复----------");
        for (int r:randoms) {
            System.out.println(r);
        }
        //getUniqueRandoms(int min, int max, int count)
        int[] uniqueRandoms = Math.getUniqueRandoms(10, 22, 9);
        System.out.println("----------不重复----------");
        for (int r:uniqueRandoms) {
            System.out.println(r);
        }
    }
}
