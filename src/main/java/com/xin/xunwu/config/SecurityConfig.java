package com.xin.xunwu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * copyright:
 * Company: 上海悟泰信息科技有限公司
 *
 * @author dx
 * @since 2020/1/7 15:14
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置不需要登录验证
        http.authorizeRequests().anyRequest().permitAll().and().logout().permitAll();
    }
}
