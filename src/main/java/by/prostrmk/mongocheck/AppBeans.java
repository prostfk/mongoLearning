package by.prostrmk.mongocheck;

import by.prostrmk.mongocheck.model.service.UserDetailsServiceImpl;
import by.prostrmk.mongocheck.model.service.UserService;
import by.prostrmk.mongocheck.model.service.UserServiceImpl;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableMongoRepositories
public class AppBeans {

    @Bean
    public MongoClient mongoClient(){
        return new MongoClient();
    }

    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoClient(),"SecurityBase");
    }




}
