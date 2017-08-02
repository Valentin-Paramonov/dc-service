package paramonov.valentine.dcservice.user.login;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserLoginEndpoint {
    @RequestMapping(value = "/user/login", method = POST)
    void login(@RequestBody UserLoginBody login) {

    }
}
