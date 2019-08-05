import com.ucarinc.bean.User;
import com.ucarinc.serviceImpl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class getUserTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //UserDaoImpl impl = ac.getBean("userImpl", UserDaoImpl.class);
        UserServiceImpl impl = new UserServiceImpl();
        User user = impl.getUser("Tom");
        System.out.println(user);
    }
}
