package paramonov.valentine.dcservice.customer.creation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class CustomerCreationEndpoint {
    @Autowired
    private CustomerCreator customerCreator;

    @RequestMapping(value = "/customer/create", method = POST)
    void createCustomer(@RequestBody CustomerCreationBody customer) {
        customerCreator.create(
            customer.getName(),
            customer.getSurname(),
            customer.getEmail(),
            customer.getPersonalId()
        );
    }
}
