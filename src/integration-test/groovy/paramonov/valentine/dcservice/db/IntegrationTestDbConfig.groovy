package paramonov.valentine.dcservice.db

import org.dizitart.no2.Nitrite
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
                openOrCreate()
        )
    }
}
