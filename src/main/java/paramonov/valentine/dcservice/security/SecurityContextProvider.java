package paramonov.valentine.dcservice.security;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

interface SecurityContextProvider {
    default SecurityContext getContext() {
        return SecurityContextHolder.getContext();
    }
}
