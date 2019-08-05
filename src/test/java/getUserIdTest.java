import com.ucarinc.serviceImpl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class getUserIdTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // UserDaoImpl impl = ac.getBean("userImpl", UserDaoImpl.class);
        UserServiceImpl impl = new UserServiceImpl();
        int id = impl.getUserId("Tom");
        System.out.println("Tom的id: " +id);
    }
}
