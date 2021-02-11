package com.tistory.suhyeokeee.grade_cal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.management.MXBean;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  // 요청이 오면 요청 전에 체크를 하겠다라는 뜻
public class SecurtyConfig extends WebSecurityConfigurerAdapter {



    // static 디렉토리의 하위 파일은 인증 무시
    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/css/**","/js/**");
    }






//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests()
//                .antMatchers("/**").permitAll();
//            .and()  // 로그인설정
//                .formLogin()
//                .loginProcessingUrl("/member/signIn")    // 인증이 필요한 모든 페이지는 여기에 써져있는 url로 자동으로 가진다
//                .defaultSuccessUrl("/")
//                .permitAll()
//
//            .and()  // 로그아웃설정
//                .logout()
//                .logoutSuccessUrl("/")
//                .invalidateHttpSession(true);
//    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().disable()
                .headers().frameOptions().disable();
        http.authorizeRequests()
            .antMatchers("/postSave").authenticated()
            .anyRequest().permitAll()
            .and()
            .formLogin()
            .loginPage("/member/signIn")
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
