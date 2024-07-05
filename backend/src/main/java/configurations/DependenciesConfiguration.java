package configurations;

import services.DatabaseUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import interfaces.UserInterface;

@Configuration
public class DependenciesConfiguration {
    @Bean
    @Scope("singleton")
    public UserInterface userService() {
        return new DatabaseUserService();
    }

}