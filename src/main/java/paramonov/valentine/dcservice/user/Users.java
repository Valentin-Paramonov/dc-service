package paramonov.valentine.dcservice.user;

import org.dizitart.no2.objects.ObjectRepository;
import paramonov.valentine.dcservice.Repo;
import paramonov.valentine.dcservice.User;
import paramonov.valentine.dcservice.db.Db;

import java.util.Optional;

import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

public class Users implements Repo<User> {
    private final ObjectRepository<User> users;

    Users(Db db) {
        this.users = db.repo(User.class);
    }

    public Optional<User> findByEmail(String email) {
        return wrap(
            users
                .find(eq("email", email))
                .firstOrDefault()
        );
    }

    public void create(String email, String password) {
        users.insert(new User(email, password));
    }
}
