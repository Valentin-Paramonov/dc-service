package paramonov.valentine.dcservice.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

class SecurityConfigurer extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetails;
    private final PasswordEncoder encoder;
    private final StatelessAuthenticationFilter authenticationFilter;

    SecurityConfigurer(
        UserDetailsService userDetails,
        PasswordEncoder encoder,
        StatelessAuthenticationFilter authenticationFilter) {
        // disable default configuration
        super(true);
        this.userDetails = userDetails;
        this.encoder = encoder;
        this.authenticationFilter = authenticationFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .exceptionHandling()
            .and()
            .anonymous()
            .and()
            .headers().cacheControl().disable()
            .and()
            .authorizeRequests()
            .antMatchers("/user/register").permitAll()
            .antMatchers("/user/login").permitAll()
            .anyRequest().authenticated()
            .and()
            .addFilterBefore(
                authenticationFilter,
                UsernamePasswordAuthenticationFilter.class
            );
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetails).passwordEncoder(encoder);
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return userDetails;
    }
}
