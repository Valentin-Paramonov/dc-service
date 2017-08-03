package paramonov.valentine.dcservice.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

class StatelessAuthenticationFilter extends GenericFilterBean {
    private final TokenAuthenticationProvider authentication;
    private final SecurityContextProvider contextProvider;

    StatelessAuthenticationFilter(TokenAuthenticationProvider authentication, SecurityContextProvider contextProvider) {
        this.authentication = authentication;
        this.contextProvider = contextProvider;
    }

    @Override
    public void doFilter(
        ServletRequest request,
        ServletResponse response,
        FilterChain chain
    ) throws IOException, ServletException {
        SecurityContext context = contextProvider.getContext();
        context.setAuthentication(authenticationFrom(request));
        chain.doFilter(request, response);
        context.setAuthentication(null);
    }

    private Authentication authenticationFrom(ServletRequest request) {
        return authentication.getFrom((HttpServletRequest) request);
    }
}
