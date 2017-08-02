package paramonov.valentine.dcservice.user.registration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import paramonov.valentine.dcservice.IntegrationTestBase
import paramonov.valentine.dcservice.db.Db
import paramonov.valentine.dcservice.db.User

import static org.dizitart.no2.objects.filters.ObjectFilters.eq

class UserRegistrationRecordCreatorTest extends IntegrationTestBase {
    @Autowired
    UserRegistrationRecordCreator registrationRecord

    @Autowired
    Db db

    @Autowired
    PasswordEncoder encoder

    def "should create a record with encrypted password"() {
        when:
            registrationRecord.create('a@b.cd', 'ha')
        then:
            def record = findByEmail('a@b.cd')
            record.email == 'a@b.cd'
            encoder.matches('ha', record.password)
    }

    private User findByEmail(email) {
        db.
            repo(User).
            find(eq('email', email)).
            first()
    }
}
