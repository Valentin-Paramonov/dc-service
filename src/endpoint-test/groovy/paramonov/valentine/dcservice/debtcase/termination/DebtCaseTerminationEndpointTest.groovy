package paramonov.valentine.dcservice.debtcase.termination

import org.springframework.beans.factory.annotation.Autowired
import paramonov.valentine.dcservice.EndpointTestBase

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class DebtCaseTerminationEndpointTest extends EndpointTestBase {
    @Autowired
    private DebtCaseCloser closer

    def "should pass debt case reolution to closer"() {
        when: 'posting to /debt-case/<id>/close'
            mvc().
                perform(
                    post("/debt-case/case/close").
                        contentType("application/json").
                        content(
                            json {
                                resolution 'whatever'
                            }
                        )
                ).
                andExpect(status().isOk())
        then: 'the parameters are passed on'
            1 * closer.close('case', 'whatever')
    }
}
