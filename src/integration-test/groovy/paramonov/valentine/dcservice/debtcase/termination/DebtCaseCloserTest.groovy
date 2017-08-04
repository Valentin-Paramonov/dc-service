package paramonov.valentine.dcservice.debtcase.termination

import org.springframework.beans.factory.annotation.Autowired
import paramonov.valentine.dcservice.DebtCase
import paramonov.valentine.dcservice.IntegrationTestBase
import paramonov.valentine.dcservice.db.Db

import java.time.LocalDate

import static org.dizitart.no2.objects.filters.ObjectFilters.eq

class DebtCaseCloserTest extends IntegrationTestBase {
    @Autowired
    DebtCaseCloser closer

    @Autowired
    Db db

    def setup() {
        db.repo(DebtCase).insert(
            new DebtCase(
                id: 'case',
                dueDate: LocalDate.parse('2017-08-17'),
                customer: 'alex.id',
                amount: 14.88,
                status: 'Open'
            )
        )
    }

    def "should close debt case"() {
        when:
            closer.close('case', 'Resolved')
        then:
            def debtCase = db.repo(DebtCase).find(eq('id', 'case')).first()
            debtCase.status == 'Resolved'
    }
}
