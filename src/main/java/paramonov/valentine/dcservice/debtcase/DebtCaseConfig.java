package paramonov.valentine.dcservice.debtcase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import paramonov.valentine.dcservice.ConfigurationProfile;
import paramonov.valentine.dcservice.db.Db;

@Configuration
@Profile({
    ConfigurationProfile.prod,
    ConfigurationProfile.integrationTest,
})
class DebtCaseConfig {
    @Bean
    DebtCases debtCases(Db db) {
        return new DebtCases(db);
    }
}
