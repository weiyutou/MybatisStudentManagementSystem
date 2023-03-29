package vip.coli.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.Reader;

/*
工具类
* */
public class MybatisUtils {
    private static SqlSessionFactory sqlMapper = null;
    static {
        try{
            Reader reader = Resources.getResourceAsReader("Mybatis-config.xml");
            sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //获取SqlSession对象的静态方法
    public static SqlSession getSession() {
        return sqlMapper.openSession();
    }
}
