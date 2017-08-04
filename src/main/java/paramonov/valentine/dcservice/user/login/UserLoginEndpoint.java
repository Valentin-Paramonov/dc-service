package paramonov.valentine.dcservice.user.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import paramonov.valentine.dcservice.security.Authenticator;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserLoginEndpoint {
    @Autowired
    private Authenticator authenticator;

    @RequestMapping(value = "/user/login", method = POST)
    void login(HttpServletResponse response, @RequestBody UserLoginBody login) {
        authenticator.authenticate(response, login.getEmail(), login.getPassword());
    }
}
