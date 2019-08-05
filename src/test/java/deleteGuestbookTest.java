import com.ucarinc.bean.Guestbook;
import com.ucarinc.service.GuestbookService;
import com.ucarinc.serviceImpl.GuestbookServiceImpl;

import java.sql.Timestamp;

public class deleteGuestbookTest {
    public static void main(String[] args) {
        GuestbookService impl = new GuestbookServiceImpl();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Guestbook book = new Guestbook(27,"asdf","asdf",timestamp,timestamp,1);
        System.out.println("插入结果：" + impl.deleteGuestbook(book));
    }
}
