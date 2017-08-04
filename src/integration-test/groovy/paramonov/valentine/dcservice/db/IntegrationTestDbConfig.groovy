package paramonov.valentine.dcservice.db

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.dizitart.no2.Nitrite
import org.dizitart.no2.internals.JacksonMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import paramonov.valentine.dcservice.ConfigurationProfile

@Configuration
@Profile(ConfigurationProfile.integrationTest)
class IntegrationTestDbConfig {
    @Bean
    Db db() {
        new Db(
            Nitrite.
                builder().
                nitriteMapper(mapper()).
                openOrCreate()
        )
    }

    private static JacksonMapper mapper() {
        JavaTimeModule javaTimeModule = new JavaTimeModule()
        JacksonMapper mapper = new JacksonMapper()
        mapper.getObjectMapper().registerModule(javaTimeModule)
        return mapper
    }
}
