package paramonov.valentine.dcservice.registration

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import paramonov.valentine.dcservice.EndpointTestBase

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringJUnit4ClassRunner.class)
class UserRegistrationEndpointTest extends EndpointTestBase {
    @Test
    void "should create record"() {
        mvc().
            perform(
                post("/user/register").
                    contentType("application/json").
                    content(
                        json {
                            email: 'a@b.cd'
                            password: 'ha'
                        }
                    )
            ).
            andExpect(status().isOk()).
            andExpect(content().string("Record Created"))
    }
}