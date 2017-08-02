package paramonov.valentine.dcservice

import groovy.json.JsonBuilder
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(ConfigurationProfile.test)
@AutoConfigureMockMvc
abstract class EndpointTestBase {
    @Autowired
    private MockMvc mvc

    protected mvc() {
        mvc
    }

    protected static String json(closure) {
        new JsonBuilder(closure).toString()
    }
}
