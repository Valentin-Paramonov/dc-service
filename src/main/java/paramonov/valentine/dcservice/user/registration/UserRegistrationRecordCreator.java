package paramonov.valentine.dcservice.user.registration;

import org.springframework.security.crypto.password.PasswordEncoder;
import paramonov.valentine.dcservice.db.Db;
import paramonov.valentine.dcservice.db.User;

class UserRegistrationRecordCreator {
    private final Db db;
    private final PasswordEncoder encoder;

    UserRegistrationRecordCreator(Db db, PasswordEncoder encoder) {
        this.db = db;
        this.encoder = encoder;
    }

    void create(String email, String password) {
        db
            .repo(User.class)
            .insert(new User(email, encoder.encode(password)));
    }
}
