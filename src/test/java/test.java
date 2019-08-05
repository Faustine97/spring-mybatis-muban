import com.ucarinc.bean.Student;
import javafx.application.Application;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {
    public static void main(String[] args) {
        ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
        SqlSessionTemplate sqlSession = ac.getBean("sqlSession", SqlSessionTemplate.class);
        List<Student> list = sqlSession.selectList("getUserList");
        System.out.println(list);
    }
}
