package paramonov.valentine.dcservice.user.registration

import org.springframework.beans.factory.annotation.Autowired
import paramonov.valentine.dcservice.IntegrationTestBase
import paramonov.valentine.dcservice.db.Db
import paramonov.valentine.dcservice.db.User

import static org.dizitart.no2.objects.filters.ObjectFilters.eq

class UserRegistrationRecordCreatorTest extends IntegrationTestBase {
    @Autowired
    UserRegistrationRecordCreator registrationRecord

    @Autowired
    Db db

    def "should create a record in database"() {
        when:
            registrationRecord.create('a@b.cd', 'ha')
        then:
            def record = findByEmail('a@b.cd')
            record.email == 'a@b.cd'
            record.password.length() == 60
            record.password.startsWith('$2a$10$')
    }

    private User findByEmail(email) {
        db.
            repo(User).
            find(eq('email', email)).
            first()
    }
}
