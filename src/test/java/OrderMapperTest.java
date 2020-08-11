import com.harry.mybatis.dao.OrderDao;
import com.harry.mybatis.dao.OrderDetailDao;
import com.harry.mybatis.entity.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * Created by harryhx on 2020/4/8.
 */
public class OrderMapperTest {
    public SqlSession sqlSession;
    public OrderDao orderDao;
    public OrderDetailDao orderDetailDao;
    @Before
    public void setUp() throws Exception {
        // mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        sqlSession = sqlSessionFactory.openSession();
        this.orderDao = sqlSession.getMapper(OrderDao.class);
        this.orderDetailDao = sqlSession.getMapper(OrderDetailDao.class);
        System.out.println("git test");



    }
    @Test
    public void queryOrderWithUserByOrderNumber()throws Exception{
        Order order =this.orderDao.queryOrderWithUserByOrderNumber("20200409");
        System.out.println(order.getUser());
    }
    @Test
    public void queryOrderWithUserAndDetailByOrderNumber()throws Exception{
        Order order = orderDetailDao.queryOrderWithUserAndDetailByOrderNumber("20200408");
        System.out.println(order.getUser());
        System.out.println(order.getDetailList());
    }


}
