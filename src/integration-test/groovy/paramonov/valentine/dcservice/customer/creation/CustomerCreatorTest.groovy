package paramonov.valentine.dcservice.customer.creation

import org.dizitart.no2.objects.filters.ObjectFilters
import org.springframework.beans.factory.annotation.Autowired
import paramonov.valentine.dcservice.Customer
import paramonov.valentine.dcservice.IntegrationTestBase
import paramonov.valentine.dcservice.db.Db

class CustomerCreatorTest extends IntegrationTestBase {
    @Autowired
    CustomerCreator customerCreator

    @Autowired
    Db db

    def "should create customer record"() {
        when:
            customerCreator.create('Alex', 'B', 'a@b.cd', 'id')
        then:
            def customer = db.repo(Customer).find(ObjectFilters.eq('personalId', 'id')).first()
            customer.name == 'Alex'
            customer.surname == 'B'
            customer.email == 'a@b.cd'
            customer.personalId == 'id'
            customer.agent == 'agent'
    }
}
