package paramonov.valentine.dcservice.db;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import javax.annotation.PreDestroy;

public class Db {
    private final Nitrite db;

    Db(Nitrite db) {
        this.db = db;
    }

    public <T> ObjectRepository<T> repo(Class<T> type) {
        return db.getRepository(type);
    }

    @PreDestroy
    void closeDb() {
        db.close();
    }
}
