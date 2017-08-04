package paramonov.valentine.dcservice.customer.creation

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import paramonov.valentine.dcservice.ConfigurationProfile
import spock.mock.DetachedMockFactory

@Configuration
@Profile(ConfigurationProfile.test)
class CustomerCreationEndpointTestConfig {
    private final DetachedMockFactory mockFactory = new DetachedMockFactory()

    @Bean
    CustomerCreator customerCreator() {
        mockFactory.Mock(CustomerCreator)
    }
}
