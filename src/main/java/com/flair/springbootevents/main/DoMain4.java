package com.flair.springbootevents.main;

import com.alibaba.fastjson.JSONObject;
import com.flair.springbootevents.Entity.Person;

public class DoMain4{
    public static void main(String[] args) {
        //判断是否为 默认分组  5
//        Boolean isDefault=null;
//        boolean b = (!(isDefault != null && isDefault));
//        System.out.println(b);

        Person pre=new Person();
        pre.setName("JSON");
        pre.setAge(23);
        pre.setAddress("北京市西城区");

        //1、使用JSONObject
        String s = JSONObject.toJSONString(pre);

        System.out.println(s);

    }
}
