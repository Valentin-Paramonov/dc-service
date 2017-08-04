package paramonov.valentine.dcservice.security

import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import spock.lang.Specification

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class TokenAuthenticationProviderTest extends Specification {
    def parser = Mock(TokenParser)
    def userDetails = Mock(UserDetailsService)
    def tokenCreator = Mock(TokenCreator)
    def provider = new TokenAuthenticationProvider(parser, tokenCreator, userDetails)

    def "should create authentication from token"() {
        given:
            def request = Mock(HttpServletRequest) {
                it.getHeader('Authentication') >> 'Bearer token'
            }
        when:
            def authentication = provider.getFrom(request)
        then:
            authentication.principal == 'a@b.cd'
            1 * parser.username('token') >> 'a@b.cd'
            1 * userDetails.loadUserByUsername('a@b.cd') >> Mock(UserDetails) {
                it.username >> 'a@b.cd'
            }
    }

    def 'should return null if request has no "Authorization" header'() {
        given:
            def request = Mock(HttpServletRequest) {
                it.getHeader('Authorization') >> null
            }
        expect:
            provider.getFrom(request) == null
    }

    def "should return null if token is malformed"() {
        given:
            def request = Mock(HttpServletRequest) {
                it.getHeader('Authorization') >> 'Bear er token'
            }
        expect:
            provider.getFrom(request) == null
    }

    def "should add token to response"() {
        given:
            def principal = Mock(UserDetails) {
                it.username >> 'a@b.cd'
            }
            def authentication = Mock(Authentication)
            def response = Mock(HttpServletResponse)
        when:
            provider.addTo(response, authentication)
        then:
            1 * authentication.principal >> principal
            1 * tokenCreator.createFor('a@b.cd') >> 'token'
            1 * response.addHeader('Authentication', 'Bearer token')
    }
}
