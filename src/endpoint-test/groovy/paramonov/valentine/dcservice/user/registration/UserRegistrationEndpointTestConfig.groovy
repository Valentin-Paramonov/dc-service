package paramonov.valentine.dcservice.user.registration

import org.mockito.Mockito
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import paramonov.valentine.dcservice.ConfigurationProfile

@Configuration
@Profile(ConfigurationProfile.test)
class UserRegistrationEndpointTestConfig {
    @Bean
    UserRegistrationRecordCreator registrationRecord() {
        return Mockito.mock(UserRegistrationRecordCreator)
    }
}
