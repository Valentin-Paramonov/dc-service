package paramonov.valentine.dcservice.security;

import io.jsonwebtoken.Jwts;

class TokenParser {
    private final String key;

    TokenParser(String key) {
        this.key = key;
    }

    String username(String token) {
        return Jwts
            .parser()
            .setSigningKey(key)
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }
}
