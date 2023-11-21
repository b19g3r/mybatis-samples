package org.mytabis.samples;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Test
    public void test() throws IOException {
        String resource = "mybatis/config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行SQL语句
        List list = sqlSession.selectList("org.mybatis.samples.mappers.TransactionDao.findAll");
        System.out.println(list);
    }
}
