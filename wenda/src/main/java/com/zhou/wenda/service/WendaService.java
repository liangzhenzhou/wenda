package com.zhou.wenda.service;

import org.springframework.stereotype.Service;


/**
 * @author liangzhenzhou
 * @create 2018-10-17 22:32
 */
@Service
public class WendaService {
    public String getMessage(int userId) {
        return "Hello Message:" + String.valueOf(userId);
    }
}
