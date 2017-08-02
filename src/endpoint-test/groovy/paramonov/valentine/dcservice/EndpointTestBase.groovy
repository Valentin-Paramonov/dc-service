package paramonov.valentine.dcservice

import groovy.json.JsonBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles(ConfigurationProfile.test)
@AutoConfigureMockMvc
abstract class EndpointTestBase extends Specification {
    @Autowired
    private MockMvc mvc

    protected mvc() {
        mvc
    }

    protected static String json(closure) {
        new JsonBuilder(closure).toString()
    }
}
