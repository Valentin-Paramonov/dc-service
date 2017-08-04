package paramonov.valentine.dcservice.debtcase.submission

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import paramonov.valentine.dcservice.ConfigurationProfile
import spock.mock.DetachedMockFactory

@Configuration
@Profile(ConfigurationProfile.test)
class DebtCaseSubmissionEndpointTestConfig {
    @Bean
    DebtCaseCreator debtCaseCreator(DetachedMockFactory mockFactory) {
        return mockFactory.Mock(DebtCaseCreator)
    }
}
