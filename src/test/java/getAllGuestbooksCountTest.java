import com.ucarinc.serviceImpl.GuestbookServiceImpl;

public class getAllGuestbooksCountTest {
    public static void main(String[] args) {
        GuestbookServiceImpl impl = new GuestbookServiceImpl();
        int count = impl.getAllGuestbooksCount();
        System.out.println("count: "+count);
    }
}
