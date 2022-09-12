package test;

import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void test1() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数=namespace+id
        List<User> userlist = sqlSession.selectList("userMapper.findAll");

        System.out.println(userlist);

        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {

        //模拟user对象
        User user = new User();
        user.setUsername("tom");
        user.setPassword("123");
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数=namespace+id
        int insert = sqlSession.insert("userMapper.save", user);
        //提交
        sqlSession.commit();
        System.out.println(insert);

        sqlSession.close();
    }
    @Test
    public void test3() throws IOException {

        //模拟user对象
        User user = new User();
        user.setId(1);
        user.setUsername("tony");
        user.setPassword("1234");
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数=namespace+id
        int insert = sqlSession.insert("userMapper.update", user);
        //提交
        sqlSession.commit();
        System.out.println(insert);

        sqlSession.close();
    }
    @Test
    public void test4() throws IOException {

        //模拟user对象
        User user = new User();
        user.setUsername("tom");
        user.setPassword("123");
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数=namespace+id
        int insert = sqlSession.delete("userMapper.delete", 2);
        //提交
        sqlSession.commit();
        System.out.println(insert);

        sqlSession.close();
    }
}
