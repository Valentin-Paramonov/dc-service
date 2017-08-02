package paramonov.valentine.dcservice.user.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserRegistrationEndpoint {
    @Autowired
    private UserRegistrationRecordCreator registrationRecord;

    @RequestMapping(value = "/user/register", method = POST)
    public String register(@RequestBody UserRegistrationBody registration) {
        registrationRecord.create(registration.email, registration.password);
        return "Record Created";
    }
}
