package com.li.mapper;

import com.li.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import com.li.utils.MybatisUtils;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class userMapperTest {

    @Test
    public void testSelectStudent() {
        // 获取 SqlSession
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            // 获取 userMapper 接口的实现
            userMapper mapper = sqlSession.getMapper(userMapper.class);

            // 调用 selectStudent 方法
            List<Student> students = mapper.selectStudent();

            // 打印查询结果
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
