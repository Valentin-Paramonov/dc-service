package paramonov.valentine.dcservice.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.servlet.http.HttpServletResponse;

public class Authenticator {
    private final AuthenticationManager authentication;
    private final TokenAuthenticationProvider authenticationProvider;

    Authenticator(AuthenticationManager authentication, TokenAuthenticationProvider authenticationProvider) {
        this.authentication = authentication;
        this.authenticationProvider = authenticationProvider;
    }

    public void authenticate(HttpServletResponse response, String username, String password) {
        authenticationProvider.addTo(
            response,
            authentication.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            )
        );
    }
}
