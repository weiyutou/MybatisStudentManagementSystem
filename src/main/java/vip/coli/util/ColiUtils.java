package vip.coli.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.Reader;

/*
工具类
* */
public class ColiUtils {
    private static SqlSessionFactory sqlMapper = null;
    static {
        try{
            Reader reader = Resources.getResourceAsReader("coli-config.xml");
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
