import impl.DatabaseUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import service.userService;

@Configuration
public class DependenciesConfiguration {
    @Bean
    @Scope("singleton")
    public userService userService() {
        return new DatabaseUserService();
    }

}