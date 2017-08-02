package paramonov.valentine.dcservice

import groovy.json.JsonBuilder
import org.junit.Before
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(ConfigurationProfile.test)
abstract class EndpointTestBase {
    @Autowired
    private WebApplicationContext context
    private MockMvc mvc

    @Before
    void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build()
    }

    protected mvc() {
        mvc
    }

    protected static String json(closure) {
        new JsonBuilder(closure).toString()
    }
}
