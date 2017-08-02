package paramonov.valentine.dcservice.user.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import paramonov.valentine.dcservice.db.Db;
import paramonov.valentine.dcservice.db.User;

@Component
class UserRegistrationRecordCreator {
    private final Db db;
    private final PasswordEncoder encoder;

    @Autowired
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
