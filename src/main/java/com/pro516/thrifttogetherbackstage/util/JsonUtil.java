package com.pro516.thrifttogetherbackstage.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/30
 * Time: 18:24
 */
public class JsonUtil {

    private static final ObjectMapper obj = new ObjectMapper();

    public static <T> T convertString2Object(String json, Class<T> clazz) {
        try {
            return obj.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T convertString2Object(String json, TypeReference<T> type) {
        try {
            return obj.readValue(json, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T convertAny2Another(Object object, Class<T> clazz) {
        try {
            String json = obj.writeValueAsString(object);
            T temp = obj.readValue(json, clazz);
            return temp;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String convertObject2String(Object object) {
        try {
            return obj.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
