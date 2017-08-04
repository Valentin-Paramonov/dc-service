package paramonov.valentine.dcservice.customer.creation

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import paramonov.valentine.dcservice.ConfigurationProfile
import spock.mock.DetachedMockFactory

@Configuration
@Profile(ConfigurationProfile.test)
class CustomerCreationEndpointTestConfig {
    @Bean
    CustomerCreator customerCreator(DetachedMockFactory mockFactory) {
        mockFactory.Mock(CustomerCreator)
    }
}
