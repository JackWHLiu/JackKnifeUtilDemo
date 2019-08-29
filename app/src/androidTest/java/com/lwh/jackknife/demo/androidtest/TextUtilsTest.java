package com.lwh.jackknife.demo.androidtest;

import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import com.lwh.jackknife.util.TextUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class TextUtilsTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.lwh.jackknife.demo.jackknifeutil", appContext.getPackageName());
        //isEmpty(CharSequence str)
        boolean empty = TextUtils.isEmpty(null);
        assertEquals(empty, true);
        boolean empty2 = TextUtils.isEmpty("");
        assertEquals(empty2, true);
        //isNotEmpty(CharSequence str)
        boolean notEmpty = TextUtils.isNotEmpty("abc");
        assertEquals(notEmpty, true);
        boolean notEmpty2 = TextUtils.isNotEmpty(null);
        assertEquals(notEmpty2, false);
        //checkAllEmpty(String... text)
        String username = "user123";
        String password = "";
        boolean allEmpty = TextUtils.checkAllEmpty(username, password);
        assertEquals(allEmpty, false);
        //checkAllNotEmpty(String... text)
        String text1 = "aa";
        String text2 = "bb";
        String text3 = "cc";
        boolean allNotEmpty = TextUtils.checkAllNotEmpty(text1, text2, text3);
        assertEquals(allNotEmpty, true);
        //isEqualTo(String lhss, String rhss)
        boolean equalTo = TextUtils.isEqualTo("small", "large");
        assertEquals(equalTo, false);
        //isNotEqualTo(String lhss, String rhss)
        boolean notEqualTo = TextUtils.isNotEqualTo("small", "small");
        assertEquals(notEqualTo, false);
        String uuid = TextUtils.getUUID();
        assertEquals(uuid.length(), 32);
        //getPinyin(String ch)
        String chinese = TextUtils.getPinyin("中");
        assertEquals(chinese, "zhong");
        //getPinyinFromSentence(String chs)
        String chinese2 = TextUtils.getPinyinFromSentence("中文");
        assertEquals(chinese2, "zhongwen");
    }
}
