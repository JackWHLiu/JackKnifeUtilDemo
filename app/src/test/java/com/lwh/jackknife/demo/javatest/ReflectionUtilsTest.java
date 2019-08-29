package com.lwh.jackknife.demo.javatest;


import com.lwh.jackknife.util.ReflectionUtils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ReflectionUtilsTest {

    @Test
    public void addition_isCorrect() {
        //newInstance(Class<T> clazz)
        ReflectionUtilsTest reflectionUtilsTest = ReflectionUtils.newInstance(getClass());
        assertNotNull(reflectionUtilsTest);
        //getPrimitiveDefaultValue(Class clazz)
        Object primitiveDefaultValue = ReflectionUtils.getPrimitiveDefaultValue(int.class);
        assertEquals(primitiveDefaultValue, 0);
        Object primitiveDefaultValue2 = ReflectionUtils.getPrimitiveDefaultValue(boolean.class);
        assertEquals(primitiveDefaultValue2, false);
        //getGenericType(Object obj)
        List<String> titles = new ArrayList<>();
        Class<?> genericType = ReflectionUtils.getGenericType(titles);  //获取泛型类型
        assertEquals(genericType, String.class);
    }
}
