package paramonov.valentine.dcservice.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import paramonov.valentine.dcservice.ConfigurationProfile;
import paramonov.valentine.dcservice.user.Users;

@EnableWebSecurity
@Profile({
    ConfigurationProfile.prod,
    ConfigurationProfile.integrationTest
})
class SecurityConfig {
    @Bean
    PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetails(Users users) {
        return new UserDetailsProvider(users);
    }

    @Bean
    WebSecurityConfigurerAdapter securityConfigurer(
        UserDetailsService userDetails,
        PasswordEncoder encoder,
        StatelessAuthenticationFilter authenticationFilter
    ) {
        return new SecurityConfigurer(userDetails, encoder, authenticationFilter);
    }

    @Bean
    StatelessAuthenticationFilter authenticationFilter(
        TokenAuthenticationProvider authenticationProvider,
        SecurityContextProvider contextProvider
    ) {
        return new StatelessAuthenticationFilter(authenticationProvider, contextProvider);
    }

    @Bean
    TokenAuthenticationProvider authenticationProvider(TokenParser parser, TokenCreator tokenCreator, UserDetailsService userDetails) {
        return new TokenAuthenticationProvider(parser, tokenCreator, userDetails);
    }

    @Bean
    SecurityContextProvider contextProvider() {
        return new SecurityContextProvider() {
        };
    }

    @Bean
    AuthenticationManager authenticationManager(WebSecurityConfigurerAdapter securityConfigurer) throws Exception {
        return securityConfigurer.authenticationManagerBean();
    }

    @Bean
    TokenParser tokenParser(@Value("${jwt.tokenSignKey}") String key) {
        return new TokenParser(key);
    }

    @Bean
    TokenCreator tokenCreator(@Value("${jwt.tokenSignKey}") String key) {
        return new TokenCreator(key);
    }

    @Bean
    Authenticator authenticator(
        AuthenticationManager authentication,
        TokenAuthenticationProvider authenticationProvider
    ) {
        return new Authenticator(authentication, authenticationProvider);
    }
}
