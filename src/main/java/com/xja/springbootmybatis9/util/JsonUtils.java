package com.xja.springbootmybatis9.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xja.springbootmybatis9.domain.User;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Date;

/**
 * json字符串与对象的转换
 */
public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();
    
    //对象转json字符串
    public static <T> String obj2String(T obj){
        if (obj == null){
            return null;
        }
        try {
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    
    //json字符串转对象
    public static <T> T string2Obj(String str,Class<T> clazz){
        if (StringUtils.isEmpty(str) || clazz == null){
            return null;
        }
        try {
            return clazz.equals(String.class)? (T) str :objectMapper.readValue(str,clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args) {
        User u = new User(1,"tom","2322222",new Date(),3);
        String suser = obj2String(u);
        System.out.println(suser);
        User u1 = string2Obj(suser,User.class);
        System.out.println(u1);
    }
}
