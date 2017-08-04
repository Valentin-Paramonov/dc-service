package paramonov.valentine.dcservice.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import paramonov.valentine.dcservice.user.Users;

import static java.util.Collections.emptyList;

class UserDetailsProvider implements UserDetailsService {
    private final Users users;

    UserDetailsProvider(Users users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users
            .findByEmail(username)
            .map(user -> new User(user.getEmail(), user.getPassword(), emptyList()))
            .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
