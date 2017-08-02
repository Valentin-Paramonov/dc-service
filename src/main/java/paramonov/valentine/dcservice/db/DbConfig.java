package paramonov.valentine.dcservice.db;

import org.dizitart.no2.Nitrite;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
                .filePath(filePath)
                .openOrCreate(username, password)
        );
    }
}
