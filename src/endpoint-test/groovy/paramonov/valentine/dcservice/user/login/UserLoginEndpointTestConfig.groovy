package paramonov.valentine.dcservice.user.login

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import paramonov.valentine.dcservice.ConfigurationProfile
import paramonov.valentine.dcservice.security.Authenticator
import spock.mock.DetachedMockFactory

@Configuration
@Profile(ConfigurationProfile.test)
class UserLoginEndpointTestConfig {
    DetachedMockFactory factory = new DetachedMockFactory()

    @Bean
    Authenticator authenticator() {
        factory.Mock(Authenticator)
    }
}
