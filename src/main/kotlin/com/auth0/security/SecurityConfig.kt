import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
class SecurityConfig {

    @Bean
      fun filterChain (http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/api/public").permitAll()
                    .requestMatchers("/api/private").authenticated()
                    .requestMatchers("/api/private-scoped").hasAuthority("SCOPE_read:messages")
            }.oauth2ResourceServer{ oauth2ResourceServer ->
                oauth2ResourceServer
                    .jwt {}
            }
        return http.build();
    }

}