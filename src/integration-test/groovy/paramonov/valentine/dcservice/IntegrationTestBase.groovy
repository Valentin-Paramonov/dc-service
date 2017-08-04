package paramonov.valentine.dcservice

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.test.context.ActiveProfiles
import paramonov.valentine.dcservice.db.Db
import paramonov.valentine.dcservice.security.SecurityContextProvider
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles(ConfigurationProfile.integrationTest)
class IntegrationTestBase extends Specification {
    @Autowired
    Db db

    @Autowired
    PasswordEncoder passwordEncoder

    @Autowired
    SecurityContextProvider securityContext

    def setup() {
        db.repo(User).insert(new User('agent', passwordEncoder.encode('pass')))
        securityContext.getContext().setAuthentication(new UsernamePasswordAuthenticationToken('agent', 'pass', []))
    }

    def cleanup() {
        securityContext.getContext().setAuthentication(null)
        db.repo(User).drop()
    }
}
