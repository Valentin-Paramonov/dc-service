package paramonov.valentine.dcservice.security

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import spock.lang.Specification

import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class StatelessAuthenticationFilterTest extends Specification {
    def authentication = Mock(Authentication)
    def authenticationProvider = Mock(TokenAuthenticationProvider)
    def securityContext = Mock(SecurityContext)
    def contextProvider = Mock(SecurityContextProvider) {
        it.getContext() >> securityContext
    }
    def filter = new StatelessAuthenticationFilter(authenticationProvider, contextProvider)

    def "Should set authentication to context and then set it to null"() {
        given:
            def request = Mock(HttpServletRequest)
            def response = Mock(HttpServletResponse)
            def filterChain = Mock(FilterChain)
        when:
            filter.doFilter(request, response, filterChain)
        then:
            1 * authenticationProvider.getFrom(request) >> authentication
            1 * securityContext.setAuthentication(authentication)
            1 * filterChain.doFilter(request, response)
            1 * securityContext.setAuthentication(null)
    }
}
