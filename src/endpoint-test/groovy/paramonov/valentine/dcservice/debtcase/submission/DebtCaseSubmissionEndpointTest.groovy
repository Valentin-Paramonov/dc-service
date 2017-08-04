package paramonov.valentine.dcservice.debtcase.submission

import org.springframework.beans.factory.annotation.Autowired
import paramonov.valentine.dcservice.EndpointTestBase

import java.time.LocalDate

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class DebtCaseSubmissionEndpointTest extends EndpointTestBase {
    @Autowired
    private DebtCaseCreator debtCases

    def "should pass debt case details to creator"() {
        when: 'posting to /debt-case/<personalId>/submit'
            mvc().
                perform(
                    post("/debt-case/person/submit").
                        contentType("application/json").
                        content(
                            json {
                                dueDate '2017-05-15'
                                amount 17.25
                            }
                        )
                ).
                andExpect(status().isOk()).
                andExpect(content().string('id'))
        then: 'the parameters are passed on'
            1 * debtCases.create('person', LocalDate.parse('2017-05-15'), 17.25) >> 'id'
    }
}
