package paramonov.valentine.dcservice.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.ZonedDateTime;
import java.util.Date;

class TokenCreator {
    private final String key;

    TokenCreator(String key) {
        this.key = key;
    }

    String createFor(String username) {
        return Jwts
            .builder()
            .setSubject(username)
            .signWith(SignatureAlgorithm.HS512, key)
            .setIssuedAt(Date.from(ZonedDateTime.now().toInstant()))
            .compact();
    }
}
