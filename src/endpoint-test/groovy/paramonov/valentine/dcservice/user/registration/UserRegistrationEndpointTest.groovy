package paramonov.valentine.dcservice.user.registration

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import paramonov.valentine.dcservice.EndpointTestBase

import static org.mockito.Mockito.times
import static org.mockito.Mockito.verify
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringJUnit4ClassRunner.class)
class UserRegistrationEndpointTest extends EndpointTestBase {
    @Autowired
    private UserRegistrationRecordCreator registrationRecord

    @Test
    void "should create record"() {
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
        verify(registrationRecord, times(1)).create('a@b.cd', 'ha')
    }
}