package paramonov.valentine.dcservice.debtcase.termination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class DebtCaseTerminationEndpoint {
    @Autowired
    private DebtCaseCloser closer;

    @RequestMapping(value = "/debt-case/{id}/close", method = POST)
    public void close(@PathVariable("id") String id, @RequestBody DebtCaseTerminationBody termination) {
        closer.close(id, termination.getResolution());
    }
}
