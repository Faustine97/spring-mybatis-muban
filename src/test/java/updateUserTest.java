import com.ucarinc.bean.User;
import com.ucarinc.serviceImpl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class updateUserTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
       // UserDaoImpl impl = ac.getBean("userImpl", UserDaoImpl.class);
        UserServiceImpl impl = new UserServiceImpl();
        User user = new User(1,"Tommy","123456","123@qq.com","11012011900");
        impl.updateUser(user);
    }
}
