import com.ucarinc.bean.Guestbook;
import com.ucarinc.daoImpl.GuestbookDaoImpl;
import com.ucarinc.serviceImpl.GuestbookServiceImpl;
import javafx.util.converter.TimeStringConverter;

import java.sql.Timestamp;

public class addGuestbookTest
{
    public static void main(String[] args) {
        GuestbookServiceImpl impl = new GuestbookServiceImpl();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Guestbook book = new Guestbook("asdf","asdf",timestamp,timestamp,1);
        System.out.println("插入结果：" + impl.addGuestbook(book));
    }
}

