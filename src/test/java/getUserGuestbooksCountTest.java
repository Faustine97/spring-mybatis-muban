import com.ucarinc.serviceImpl.GuestbookServiceImpl;

public class getUserGuestbooksCountTest {
    public static void main(String[] args) {
        GuestbookServiceImpl impl = new GuestbookServiceImpl();
        int count = impl.getUserGuestbooksCount("Tom");
        System.out.println("count: "+count);
    }
}
