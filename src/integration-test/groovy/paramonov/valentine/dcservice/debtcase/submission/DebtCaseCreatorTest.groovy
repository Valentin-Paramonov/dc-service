package paramonov.valentine.dcservice.debtcase.submission

import org.springframework.beans.factory.annotation.Autowired
import paramonov.valentine.dcservice.Customer
import paramonov.valentine.dcservice.DebtCase
import paramonov.valentine.dcservice.IntegrationTestBase
import paramonov.valentine.dcservice.db.Db

import java.time.LocalDate

import static org.dizitart.no2.objects.filters.ObjectFilters.eq

class DebtCaseCreatorTest extends IntegrationTestBase {
    @Autowired
    private Db db

    @Autowired
    private DebtCaseCreator creator

    def setup() {
        db.repo(Customer).insert(new Customer(personalId: 'person', agent: 'agent'))
    }

    def "should create a debt case record"() {
        given:
            def dueDate = LocalDate.parse('2017-06-22')
            def amount = 420.69
        when:
            creator.create('person', dueDate, amount)
        then:
            def debtCase = db.repo(DebtCase).find(eq('customer', 'person')).first()
            debtCase.customer == 'person'
            debtCase.dueDate == dueDate
            debtCase.amount == amount
            debtCase.status == 'Open'
    }
}
