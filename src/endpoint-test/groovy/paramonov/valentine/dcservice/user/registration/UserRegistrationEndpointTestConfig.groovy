package paramonov.valentine.dcservice.user.registration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import paramonov.valentine.dcservice.ConfigurationProfile
import spock.mock.DetachedMockFactory

@Configuration
@Profile(ConfigurationProfile.test)
class UserRegistrationEndpointTestConfig {
    DetachedMockFactory factory = new DetachedMockFactory()

    @Bean
    UserRegistrationRecordCreator registrationRecord() {
        return factory.Mock(UserRegistrationRecordCreator)
    }
}
