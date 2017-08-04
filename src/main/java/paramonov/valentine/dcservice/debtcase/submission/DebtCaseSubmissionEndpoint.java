package paramonov.valentine.dcservice.debtcase.submission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class DebtCaseSubmissionEndpoint {
    @Autowired
    private DebtCaseCreator debtCases;

    @RequestMapping(value = "/debt-case/{personalId}/submit", method = POST)
    public void submit(@PathVariable("personalId") String personalId, @RequestBody DebtCaseSubmissionBody debtCase) {
        debtCases.create(personalId, debtCase.getDueDate(), debtCase.getAmount());
    }
}
