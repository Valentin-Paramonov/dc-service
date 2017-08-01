package paramonov.valentine.dcservice.registration;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserRegistrationEndpoint {
    @RequestMapping(value = "/user/register", method = POST)
    public String register(@RequestBody UserRegistrationBody registration) {
        return "Record Created";
    }
}
