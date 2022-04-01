import com.fenlon.pojo.Hello;
import com.fenlon.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());

        Student student = (Student) context.getBean("student");
        System.out.println(student.getName());
        System.out.println(student.toString());
    }

    @Test
    public void test(){
        System.out.println("测试");
    }
}
