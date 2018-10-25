package com.zhou.wenda.service;

import com.zhou.wenda.dao.QuestionDAO;
import com.zhou.wenda.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liangzhenzhou
 * @create 2018-10-24 23:21
 */
@Service
public class QuestionService {
    @Autowired
    QuestionDAO questionDAO;

    public List<Question> getLatestQuestions(int userId, int offset, int limit) {
        return questionDAO.selectLatestQuestions(userId, offset, limit);
    }
}
