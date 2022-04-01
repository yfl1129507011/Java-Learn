import com.fenlon.mapper.UserDaoMysqlImpl;
import com.fenlon.service.UserServiceImpl;

public class TestIoc {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        userService.setUserDao(new UserDaoMysqlImpl());
        userService.getUser();
    }
}
