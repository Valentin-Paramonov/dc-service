package paramonov.valentine.dcservice.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class TokenAuthenticationProvider {
    private static final String Authentication = "Authentication";
    private static final String tokenPrefix = "Bearer ";
    private final TokenParser parser;
    private final TokenCreator tokenCreator;
    private final UserDetailsService userDetails;

    TokenAuthenticationProvider(TokenParser parser, TokenCreator tokenCreator, UserDetailsService userDetails) {
        this.parser = parser;
        this.tokenCreator = tokenCreator;
        this.userDetails = userDetails;
    }

    Authentication getFrom(HttpServletRequest request) {
        return Optional
            .ofNullable(request.getHeader(Authentication))
            .filter(s -> s.startsWith(tokenPrefix))
            .map(s -> s.substring(tokenPrefix.length()))
            .map(parser::username)
            .map(userDetails::loadUserByUsername)
            .map(user -> new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()))
            .orElse(null);
    }

    HttpServletResponse addTo(HttpServletResponse response, Authentication authentication) {
        response.addHeader(Authentication, tokenPrefix + tokenCreator.createFor(usernameFrom(authentication)));
        return response;
    }

    private String usernameFrom(Authentication authentication) {
        return ((UserDetails) authentication.getPrincipal()).getUsername();
    }
}
