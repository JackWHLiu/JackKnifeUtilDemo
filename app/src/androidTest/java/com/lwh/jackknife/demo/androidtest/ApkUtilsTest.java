package com.lwh.jackknife.demo.androidtest;

import android.content.Context;
import android.util.Log;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import com.lwh.jackknife.util.ApkUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ApkUtilsTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.lwh.jackknife.demo.jackknifeutil", appContext.getPackageName());
        //getAppName(Context context)
        String appName = ApkUtils.getAppName(appContext);
        assertEquals(appName, "JackKnifeUtilDemo");
        //getVersionName(Context context)
        String versionName = ApkUtils.getVersionName(appContext);
        assertEquals(versionName, "1.0");
        //getVersionCode(Context context)
        int versionCode = ApkUtils.getVersionCode(appContext);
        assertEquals(versionCode, 1);
        //getAllPackageNames(Context context)
//        List<String> allPackageNames = ApkUtils.getAllPackageNames(appContext);
//        Log.d("ApkUtilsTest", allPackageNames.toArray().toString());
    }
}
