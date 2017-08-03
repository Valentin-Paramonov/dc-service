package paramonov.valentine.dcservice.user.registration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import paramonov.valentine.dcservice.ConfigurationProfile;
import paramonov.valentine.dcservice.user.Users;

@Configuration
@Profile({
    ConfigurationProfile.prod,
    ConfigurationProfile.integrationTest
})
class UserRegistrationConfig {
    @Bean
    UserRegistrationRecordCreator userRegistrationRecordCreator(Users users, PasswordEncoder encoder) {
        return new UserRegistrationRecordCreator(users, encoder);
    }
}
