package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class OnlineStoreApplication extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(OnlineStoreApplication.class, args);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/index.html", "/login", "/", "/api/catalog/**",
                        "/user", "/assets/**").permitAll()
                .anyRequest().authenticated().and().csrf().disable();
    }
}
