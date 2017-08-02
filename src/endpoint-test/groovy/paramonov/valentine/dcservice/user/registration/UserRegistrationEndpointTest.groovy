package paramonov.valentine.dcservice.user.registration

import org.springframework.beans.factory.annotation.Autowired
import paramonov.valentine.dcservice.EndpointTestBase

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class UserRegistrationEndpointTest extends EndpointTestBase {
    @Autowired
    private UserRegistrationRecordCreator registrationRecord

    def "should pass email and password to record creator"() {
        when: 'posting to /user/register'
            mvc().
                perform(
                    post("/user/register").
                        contentType("application/json").
                        content(
                            json {
                                email 'a@b.cd'
                                password 'ha'
                            }
                        )
                ).
                andExpect(status().isOk()).
                andExpect(content().string("Record Created"))
        then: 'the parameters are passed on'
            1 * registrationRecord.create('a@b.cd', 'ha')
    }
}