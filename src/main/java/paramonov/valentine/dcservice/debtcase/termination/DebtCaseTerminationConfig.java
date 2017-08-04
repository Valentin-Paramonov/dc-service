package paramonov.valentine.dcservice.debtcase.termination;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import paramonov.valentine.dcservice.ConfigurationProfile;
import paramonov.valentine.dcservice.customer.creation.Customers;
import paramonov.valentine.dcservice.debtcase.DebtCases;
import paramonov.valentine.dcservice.security.SecurityContextProvider;

@Configuration
@Profile({
    ConfigurationProfile.prod,
    ConfigurationProfile.integrationTest,
})
class DebtCaseTerminationConfig {
    @Bean
    DebtCaseCloser debtCaseCloser(DebtCases debtCases, Customers customers, SecurityContextProvider securityContext) {
        return new DebtCaseCloser(debtCases, customers, securityContext);
    }
}
