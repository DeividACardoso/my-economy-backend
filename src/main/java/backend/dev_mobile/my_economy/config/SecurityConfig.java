package backend.dev_mobile.my_economy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()  // Desabilita CSRF temporariamente para testes
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/signup", "/login", "/h2-console/**").permitAll()  // Permite acesso público às rotas específicas e ao console H2
                    .anyRequest().authenticated()
            )
            .headers(headers -> headers.frameOptions().disable())  // Necessário para o console H2 funcionar corretamente
            .formLogin().disable();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
