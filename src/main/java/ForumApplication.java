import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author liaoyao
 * @Date 2017/12/26.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class ForumApplication {
    public static void main(String[] arg) {
        SpringApplication.run(ForumApplication.class, arg);
    }
}
