package paramonov.valentine.dcservice.user.registration;

import org.springframework.security.crypto.password.PasswordEncoder;
import paramonov.valentine.dcservice.user.Users;

class UserRegistrationRecordCreator {
    private final Users users;
    private final PasswordEncoder encoder;

    UserRegistrationRecordCreator(Users users, PasswordEncoder encoder) {
        this.users = users;
        this.encoder = encoder;
    }

    void create(String email, String password) {
        users.create(email, encoder.encode(password));
    }
}
