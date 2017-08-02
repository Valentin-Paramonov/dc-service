package paramonov.valentine.dcservice.user.registration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import paramonov.valentine.dcservice.ConfigurationProfile;
import paramonov.valentine.dcservice.db.Db;

@Configuration
@Profile(ConfigurationProfile.prod)
class UserRegistrationConfig {
    @Bean
    UserRegistrationRecordCreator userRegistrationRecordCreator(Db db, PasswordEncoder encoder) {
        return new UserRegistrationRecordCreator(db, encoder);
    }
}
