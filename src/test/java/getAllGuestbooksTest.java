import com.ucarinc.bean.Guestbook;
import com.ucarinc.serviceImpl.GuestbookServiceImpl;

import java.util.List;

public class getAllGuestbooksTest {
    public static void main(String[] args) {
        GuestbookServiceImpl impl = new GuestbookServiceImpl();
        List<Guestbook> list = impl.getAllGuestbooks(2,5);
        List<Guestbook> list2 = impl.getAllGuestbooks();
        System.out.println(list);
        System.out.println(list2);
    }
}
