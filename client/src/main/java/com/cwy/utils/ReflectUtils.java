package com.cwy.utils;

import org.apache.commons.lang.reflect.FieldUtils;

import java.lang.reflect.Field;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-07-02 01:41:20
 */
public class ReflectUtils {

    public static Object getFieldValue(Object obj, String filename) {
        if (obj == null) {
            return null;
        }
        Field targetField = getTargetField(obj.getClass(), filename);
        try {
            return FieldUtils.readField(targetField, obj, true);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Field getTargetField(Class<?> targetClass, String fieldname) {
        Field field = null;
        try {
            if (targetClass == null) {
                return field;
            }

            if (Object.class.equals(targetClass)) {
                return field;
            }

            field = FieldUtils.getDeclaredField(targetClass, fieldname, true);
            if (field == null) {
                field = getTargetField(targetClass.getSuperclass(), fieldname);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return field;
    }

}
