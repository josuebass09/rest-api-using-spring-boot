package com.example.restcalculatorbyjosuehr.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private ResourceServerTokenServices tokenServices;
    @Autowired
    JsonToUrlEncodedAuthenticationFilter jsonFilter;

    @Value("${security.jwt.resource-ids}")
    private String resourceIds;

    /**
     * Add resource-server specific properties
     * @param resources
     * @throws Exception
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(resourceIds).tokenServices(tokenServices);
    }

    /**
     * Basic http configuration
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(jsonFilter, ChannelProcessingFilter.class)
                .requestMatchers()
                .and()
                .authorizeRequests()
                .antMatchers("/public").permitAll()
                .antMatchers("/operations/**","/users/" ).authenticated();
    }

    /**
     * override the authenticationEntryPoint functions
     * @return custom authenticationEntryPoint
     */
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint(){
        return new CustomAuthenticationEntryPoint();
    }
}
