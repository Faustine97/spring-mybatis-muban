import com.ucarinc.bean.UserInfo;
import com.ucarinc.serviceImpl.UserInfoServiceImpl;

import java.util.List;

public class getAllUserInfoTest {
    public static void main(String[] args) {
        UserInfoServiceImpl impl = new UserInfoServiceImpl();
        List<UserInfo> list = impl.getAllUserInfo();
        System.out.println(list);
    }
}
