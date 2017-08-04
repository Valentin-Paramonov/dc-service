package paramonov.valentine.dcservice.debtcase.termination

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import paramonov.valentine.dcservice.ConfigurationProfile
import spock.mock.DetachedMockFactory

@Configuration
@Profile(ConfigurationProfile.test)
class DebtCaseTerminationEndpointTestConfig {
    @Bean
    DebtCaseCloser debtCaseCloser(DetachedMockFactory mockFactory) {
        return mockFactory.Mock(DebtCaseCloser)
    }
}
