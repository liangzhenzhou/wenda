package com.zhou.wenda.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liangzhenzhou
 * @create 2018-10-24 22:13
 */
public class ViewObject {
    private Map<String, Object> objs = new HashMap<String, Object>();
    public void set(String key, Object value) {
        objs.put(key, value);
    }

    public Object get(String key) {
        return objs.get(key);
    }
}
