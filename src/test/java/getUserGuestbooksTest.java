import com.ucarinc.bean.Guestbook;
import com.ucarinc.serviceImpl.GuestbookServiceImpl;

import java.util.List;

public class getUserGuestbooksTest {
    public static void main(String[] args) {
        GuestbookServiceImpl impl = new GuestbookServiceImpl();
        String name = "Tom";
        List<Guestbook> list = impl.getUserGuestbooks(name);
        List<Guestbook> list2 = impl.getUserGuestbooks(name,1,3);
        System.out.println(list);
        System.out.println(list2);
    }
}
