package paramonov.valentine.dcservice

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@Profile(ConfigurationProfile.test)
class EndpointTestConfig extends WebSecurityConfigurerAdapter {
    EndpointTestConfig() {
        super(true)
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
            authorizeRequests().
            antMatchers('/*').permitAll()
    }
}
