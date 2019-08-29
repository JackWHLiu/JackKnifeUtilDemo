package com.lwh.jackknife.demo.javatest;

import com.lwh.jackknife.util.AC;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ACTest {

    @Test
    public void addition_isCorrect() {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        String[] strArrays = new String[5];
        String[] result = AC.getInstance().toA(strings, strArrays);
        assertArrayEquals(result, new String[]{"1", "2", "3", "4", "5"});
        assertEquals(result[1], "2");
        assertEquals(result[2], "3");
        assertEquals(result[3], "4");
        assertEquals(result[4], "5");
        List<String> strs = AC.getInstance().toC(strArrays);
        assertEquals(strs.get(0), "1");
        assertEquals(strs.get(1), "2");
        assertEquals(strs.get(2), "3");
        assertEquals(strs.get(3), "4");
        assertEquals(strs.get(4), "5");
    }
}