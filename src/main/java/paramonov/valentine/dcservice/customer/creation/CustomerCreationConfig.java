package paramonov.valentine.dcservice.customer.creation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import paramonov.valentine.dcservice.ConfigurationProfile;
import paramonov.valentine.dcservice.db.Db;
import paramonov.valentine.dcservice.security.SecurityContextProvider;

@Configuration
@Profile({
    ConfigurationProfile.prod,
    ConfigurationProfile.integrationTest,
})
class CustomerCreationConfig {
    @Bean
    CustomerCreator customerCreator(SecurityContextProvider securityContext, Customers customers) {
        return new CustomerCreator(securityContext, customers);
    }

    @Bean
    Customers customers(Db db) {
        return new Customers(db);
    }
}
