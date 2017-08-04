package paramonov.valentine.dcservice.db;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.internals.JacksonMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import paramonov.valentine.dcservice.ConfigurationProfile;

@Configuration
@Profile(ConfigurationProfile.prod)
class DbConfig {
    @Bean
    Db db(
        @Value("${db.filePath}") String filePath,
        @Value("${db.username}") String username,
        @Value("${db.password}") String password
    ) {
        return new Db(
            Nitrite
                .builder()
                .compressed()
                .nitriteMapper(mapper())
                .filePath(filePath)
                .openOrCreate(username, password)
        );
    }

    private JacksonMapper mapper() {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        JacksonMapper mapper = new JacksonMapper();
        mapper.getObjectMapper().registerModule(javaTimeModule);
        return mapper;
    }
}
