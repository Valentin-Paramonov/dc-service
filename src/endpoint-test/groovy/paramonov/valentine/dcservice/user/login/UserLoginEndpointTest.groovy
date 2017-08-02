package paramonov.valentine.dcservice.user.login

import org.junit.Test
import paramonov.valentine.dcservice.EndpointTestBase

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class UserLoginEndpointTest extends EndpointTestBase {
    @Test
    void "should pass email and password to login manager"() {
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
    }
}