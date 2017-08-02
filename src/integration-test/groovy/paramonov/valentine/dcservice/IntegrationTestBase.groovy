package paramonov.valentine.dcservice

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles(ConfigurationProfile.integrationTest)
class IntegrationTestBase extends Specification {
}
