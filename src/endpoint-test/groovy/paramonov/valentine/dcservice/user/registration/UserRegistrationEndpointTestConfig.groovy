package paramonov.valentine.dcservice.user.registration

import org.mockito.Mockito
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UserRegistrationEndpointTestConfig {
    @Bean
    UserRegistrationRecordCreator registrationRecord() {
        return Mockito.mock(UserRegistrationRecordCreator)
    }
}
