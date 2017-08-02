package paramonov.valentine.dcservice.db;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.springframework.beans.factory.DisposableBean;

public class Db implements DisposableBean {
    private final Nitrite db;

    Db(Nitrite db) {
        this.db = db;
    }

    public <T> ObjectRepository<T> repo(Class<T> type) {
        return db.getRepository(type);
    }

    @Override
    public void destroy() throws Exception {
        db.close();
    }
}
