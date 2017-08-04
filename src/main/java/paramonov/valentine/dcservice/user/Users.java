package paramonov.valentine.dcservice.user;

import paramonov.valentine.dcservice.Repo;
import paramonov.valentine.dcservice.User;
import paramonov.valentine.dcservice.db.Db;

import java.util.Optional;

import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

public class Users implements Repo<User> {
    private final Db db;

    Users(Db db) {
        this.db = db;
    }

    public Optional<User> findByEmail(String email) {
        return wrap(
            db
                .repo(User.class)
                .find(eq("email", email))
                .firstOrDefault()
        );
    }

    public void create(String email, String password) {
        db.repo(User.class).insert(new User(email, password));
    }
}
