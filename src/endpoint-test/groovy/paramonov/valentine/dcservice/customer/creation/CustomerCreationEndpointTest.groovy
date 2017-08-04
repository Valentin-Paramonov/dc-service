package paramonov.valentine.dcservice.customer.creation

import org.springframework.beans.factory.annotation.Autowired
import paramonov.valentine.dcservice.EndpointTestBase

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class CustomerCreationEndpointTest extends EndpointTestBase {
    @Autowired
    private CustomerCreator customerCreator

    def "should pass customer details to customer creator"() {
        when: 'posting to /customer/create'
            mvc().
                perform(
                    post("/customer/create").
                        contentType("application/json").
                        content(
                            json {
                                name 'Glenn'
                                surname 'Humplik'
                                email 'a@b.cd'
                                personalId 'whatever'
                            }
                        )
                ).
                andExpect(status().isOk())
        then:
            1 * customerCreator.create('Glenn', 'Humplik', 'a@b.cd', 'whatever')
    }
}
