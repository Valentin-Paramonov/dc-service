package paramonov.valentine.dcservice.debtcase.submission;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import paramonov.valentine.dcservice.ConfigurationProfile;
import paramonov.valentine.dcservice.customer.creation.Customers;
import paramonov.valentine.dcservice.db.Db;
import paramonov.valentine.dcservice.security.SecurityContextProvider;

@Configuration
@Profile({
    ConfigurationProfile.prod,
    ConfigurationProfile.integrationTest,
})
class DebtCaseSubmissionConfig {
    @Bean
    DebtCaseCreator debtCaseCreator(SecurityContextProvider securityContext, Customers customers, DebtCases debtCases) {
        return new DebtCaseCreator(securityContext, customers, debtCases);
    }

    @Bean
    DebtCases debtCases(Db db) {
        return new DebtCases(db);
    }
}
