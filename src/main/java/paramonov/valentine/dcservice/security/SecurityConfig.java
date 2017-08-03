package paramonov.valentine.dcservice.security;

import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import paramonov.valentine.dcservice.ConfigurationProfile;

@EnableWebSecurity
@Profile({
    ConfigurationProfile.prod,
    ConfigurationProfile.integrationTest
})
class SecurityConfig {
}
