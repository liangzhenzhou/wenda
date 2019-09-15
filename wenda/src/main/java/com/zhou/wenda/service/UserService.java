package com.zhou.wenda.service;

import com.zhou.wenda.dao.LoginTicketDAO;
import com.zhou.wenda.dao.UserDAO;
import com.zhou.wenda.model.LoginTicket;
import com.zhou.wenda.model.User;
import com.zhou.wenda.util.WendaUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author liangzhenzhou
 * @create 2018-10-24 22:23
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private LoginTicketDAO loginTicketDAO;

    public User selectByName(String name) {
        return userDAO.selectByName(name);
    }
    public Map<String,Object> register(String username,String password){
          Map<String,Object> map = new HashMap<String, Object>();
          if(StringUtils.isBlank(username)){
              map.put("msg","用户名不能为空");
              return map;
          }
          if(StringUtils.isBlank(password)){
              map.put("msg","密码不能为空");
              return map;
          }
          User user = userDAO.selectByName(username);
        if(user !=null){
            map.put("msg","用户已经被注册");
            return map;
        }
        // 密码强度
        user = new User();
        user.setName(username);
        user.setSalt(UUID.randomUUID().toString().substring(0, 5));
        String head = String.format("http://images.nowcoder.com/head/%dt.png", new Random().nextInt(1000));
        user.setHeadUrl(head);
        user.setPassword(WendaUtil.MD5(password+user.getSalt()));
        userDAO.addUser(user);

        // 注册完，直接登陆
        String ticket = addLoginTicket(user.getId());
        map.put("ticket", ticket);
        return map;
    }
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isBlank(username)) {
            map.put("msg", "用户名不能为空");
            return map;
        }

        if (StringUtils.isBlank(password)) {
            map.put("msg", "密码不能为空");
            return map;
        }

        User user = userDAO.selectByName(username);

        if (user == null) {
            map.put("msg", "用户名不存在");
            return map;
        }

        if (!WendaUtil.MD5(password+user.getSalt()).equals(user.getPassword())) {
            map.put("msg", "密码不正确");
            return map;
        }

        String ticket = addLoginTicket(user.getId());
        map.put("ticket", ticket);
        return map;
    }

    private String addLoginTicket(int userId) {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime() + 1000*3600*24);
        loginTicket.setExpired(date);
        loginTicket.setStatus(0);
        loginTicket.setTicket(UUID.randomUUID().toString().replaceAll("-", ""));
        loginTicketDAO.addTicket(loginTicket);
        return loginTicket.getTicket();
    }

    public User getUser(int id) {
        return userDAO.selectById(id);
    }

    public void logout(String ticket) {
        loginTicketDAO.updateStatus(ticket, 1);
    }
}
