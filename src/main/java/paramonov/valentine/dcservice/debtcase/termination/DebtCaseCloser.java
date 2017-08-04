package paramonov.valentine.dcservice.debtcase.termination;

import paramonov.valentine.dcservice.DebtCase;
import paramonov.valentine.dcservice.Repo;
import paramonov.valentine.dcservice.customer.creation.Customers;
import paramonov.valentine.dcservice.debtcase.DebtCases;
import paramonov.valentine.dcservice.security.SecurityContextProvider;

import java.util.Arrays;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

class DebtCaseCloser {
    private Set<String> resolutions = setOf("Resolved", "Defaulted");
    private final DebtCases debtCases;
    private final Customers customers;
    private final SecurityContextProvider securityContext;

    DebtCaseCloser(DebtCases debtCases, Customers customers, SecurityContextProvider securityContext) {
        this.debtCases = debtCases;
        this.customers = customers;
        this.securityContext = securityContext;
    }

    void close(String id, String resolution) {
        if (!resolutions.contains(resolution)) {
            throw new IllegalArgumentException("Resolution not found: " + resolution);
        }
        checkDebtCaseBelongsToUser(id);
        debtCases.close(id, resolution);
    }

    private void checkDebtCaseBelongsToUser(String id) {
        debtCases
            .findById(id)
            .map(DebtCase::getCustomer)
            .map(customer -> customers.findByPersonalIdAndAgent(customer, securityContext.getAuthenticatedUsername()))
            .orElseThrow(() -> new Repo.EntityNotFoundException("DebtCase id: " + id));
    }

    private Set<String> setOf(String... strings) {
        return Arrays.stream(strings).collect(toSet());
    }
}
