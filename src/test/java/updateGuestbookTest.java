import com.ucarinc.bean.Guestbook;
import com.ucarinc.serviceImpl.GuestbookServiceImpl;

import java.sql.Timestamp;

public class updateGuestbookTest {
    public static void main(String[] args) {
        GuestbookServiceImpl impl = new GuestbookServiceImpl();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Guestbook book = new Guestbook(26, "asdf","asdf",timestamp,timestamp,1);
        System.out.println("插入结果：" + impl.updateGuestbook(book));
    }
}
