package com.lwh.jackknife.demo.androidtest;

import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class SystemUtilsTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.lwh.jackknife.demo.jackknifeutil", appContext.getPackageName());
        //getScreenWidth(Context context)
//        int screenWidth = SystemUtils.getScreenWidth(appContext);
//        int screenHeight = SystemUtils.getScreenHeight(appContext);
//        assertEquals(screenWidth, 1080);
//        assertEquals(screenHeight, 2141);
        //openBrowser(Context context, String url)
//        SystemUtils.openBrowser(appContext, "http://baidu.com");
    }
}
