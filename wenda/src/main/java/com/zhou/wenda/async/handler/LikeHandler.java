package com.zhou.wenda.async.handler;

import com.zhou.wenda.async.EventHandler;
import com.zhou.wenda.async.EventModel;
import com.zhou.wenda.async.EventType;
import com.zhou.wenda.model.Message;
import com.zhou.wenda.model.User;
import com.zhou.wenda.service.MessageService;
import com.zhou.wenda.service.UserService;
import com.zhou.wenda.util.WendaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author liangzhenzhou
 * @create 2019-10-03 21:28
 */

@Component
public class LikeHandler implements EventHandler {
    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    @Override
    public void doHandle(EventModel model) {
        Message message = new Message();
        message.setFromId(WendaUtil.SYSTEM_USERID);
        message.setToId(model.getEntityOwnerId());
        message.setCreatedDate(new Date());
        User user = userService.getUser(model.getActorId());
        message.setContent("用户" + user.getName()
                + "赞了你的评论,http://127.0.0.1:8080/question/" + model.getExt("questionId"));

        messageService.addMessage(message);
    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.LIKE);
    }
}
