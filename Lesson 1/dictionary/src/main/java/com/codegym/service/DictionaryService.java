package com.codegym.service;

import java.util.HashMap;
import java.util.Map;

public class DictionaryService {
    private static Map<String,String> dictionary = new HashMap<>();

    public DictionaryService() {
        dictionary.put("hello","xin chào");
        dictionary.put("bye","tạm biệt");
        dictionary.put("provide","cung cấp");
        dictionary.put("quantity","số lượng");
        dictionary.put("future","tương lai");
        dictionary.put("deserve","xứng đáng");
        dictionary.put("car","ô tô");
    }

    public static String find(String key) {
        boolean isContains = dictionary.containsKey(key);
        if(!isContains) {
            return null;
        }
        return dictionary.get(key);
    }
}
