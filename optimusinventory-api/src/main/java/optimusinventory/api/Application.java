package optimusinventory.api;

/**
 * Created by Acha Bill on 7/17/2017.
 */

import optimusinventory.api.auth.ITokenService;
import optimusinventory.api.dao.IUserDao;
import optimusinventory.api.models.Previleges;
import optimusinventory.api.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ComponentScan
@EnableSwagger2
public class Application {
    @Autowired
    IUserDao usersDao;
    @Autowired
    ITokenService tokenService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Docket vodAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Optimus Inventory")
                .description("Rest API Optimus Inventory")
                .contact("achabill12@gmail.com")
                .version("1.0")
                .build();
    }

    @Bean
    CommandLineRunner init() {
        return args -> {
            List<User> userList = usersDao.findAll();
            if (userList == null || userList.size() == 0) {
                User root = new User();
                root.setUsername("admin");
                root.setPassword(tokenService.digest("admin@123"));
                List<Previleges> previleges = new ArrayList() {{
                    add(Previleges.MANAGE_SALES);
                    add(Previleges.MANAGE_ITEMS);
                    add(Previleges.MANAGE_DEBTORS);
                    add(Previleges.MANAGE_ACCOUNTS);
                    add(Previleges.MANAGE_SUMMARY);
                }};
                root.setPrevileges(previleges);
                usersDao.save(root);
            }
        };
    }
}