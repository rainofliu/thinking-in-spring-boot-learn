package com.ajin.thinkinginspringboot.annotationdesign;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ajin
 */
public class MapDemo {

    public static void main(String[] args) {
        Map<String,String> map= new HashMap<String, String>();
        // map.computeIfAbsent("name",k->"刘天若");
        map.computeIfAbsent("name",MapDemo::defalutValue);
        System.out.println(map.get("name"));
    }

    private static String defalutValue(String key){
        return  "刘天若";
    }
}
