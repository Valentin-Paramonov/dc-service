package paramonov.valentine.dcservice.user.login

import org.springframework.beans.factory.annotation.Autowired
import paramonov.valentine.dcservice.EndpointTestBase
import paramonov.valentine.dcservice.security.Authenticator

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class UserLoginEndpointTest extends EndpointTestBase {
    @Autowired
    private Authenticator authenticator

    def "should pass login details to authenticator"() {
        when: 'posting to /user/login'
            mvc().
                perform(
                    post("/user/login").
                        contentType("application/json").
                        content(
                            json {
                                email 'a@b.cd'
                                password 'ha'
                            }
                        )
                ).
                andExpect(status().isOk())
        then:
            1 * authenticator.authenticate(_, 'a@b.cd', 'ha')
    }
}
