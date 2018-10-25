package com.zhou.wenda.dao;

import com.zhou.wenda.model.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author liangzhenzhou
 * @create 2018-10-24 22:04
 */
@Mapper
public interface QuestionDAO {
    String TABLE_NAME = " question ";
    String INSERT_FIELDS = " title, content, created_date, user_id, comment_count ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{title},#{content},#{createdDate},#{userId},#{commentCount})"})
    int addQuestion(Question question);

    List<Question> selectLatestQuestions(@Param("userId") int userId, @Param("offset") int offset,
                                         @Param("limit") int limit);

}
