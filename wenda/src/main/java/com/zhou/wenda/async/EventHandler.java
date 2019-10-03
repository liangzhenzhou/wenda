package com.zhou.wenda.async;

import java.util.List;

/**
 * @author liangzhenzhou
 * @create 2019-10-03 21:21
 */
public interface EventHandler {
    void doHandle(EventModel model);

    List<EventType> getSupportEventTypes();
}
