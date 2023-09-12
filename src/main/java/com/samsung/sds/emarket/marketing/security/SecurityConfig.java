package com.samsung.sds.emarket.marketing.security;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
    @Value("${security.enabled:true}")
    private boolean securityEnabled;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        
        if (securityEnabled == true) {
            http.cors().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/**").hasAnyRole("admin", "manager")
                .antMatchers(HttpMethod.PUT, "/api/**").hasAnyRole("admin")
                .antMatchers(HttpMethod.DELETE, "/api/**").hasAnyRole("master")
                .antMatchers("/api/**").authenticated()
                .anyRequest().permitAll();
            http.csrf().disable();
        } else {
            http.cors().and().csrf().disable().authorizeRequests().anyRequest().permitAll();
        }
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
        auth.authenticationProvider(keycloakAuthenticationProvider);
    }

    @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new NullAuthenticatedSessionStrategy();
    }

    public static class KeycloakConfig {
        @Bean
        public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
             return new KeycloakSpringBootConfigResolver();
        }
    }
}