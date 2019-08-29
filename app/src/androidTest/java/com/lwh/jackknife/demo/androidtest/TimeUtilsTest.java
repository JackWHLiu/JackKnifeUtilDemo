package com.lwh.jackknife.demo.androidtest;

import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import com.lwh.jackknife.util.ApkUtils;
import com.lwh.jackknife.util.TimeUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class TimeUtilsTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.lwh.jackknife.demo.jackknifeutil", appContext.getPackageName());
        //getDaysOfMonth(int year, int month)
        int daysOfMonth = TimeUtils.getDaysOfMonth(2019, 8);
        assertEquals(daysOfMonth, 31);
        //isLeapYear(int year)
        boolean leapYear = TimeUtils.isLeapYear(1800);
        assertEquals(leapYear, false);
    }
}
