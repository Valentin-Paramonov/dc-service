package paramonov.valentine.dcservice.debtcase.submission;

import paramonov.valentine.dcservice.customer.creation.Customers;
import paramonov.valentine.dcservice.debtcase.DebtCases;
import paramonov.valentine.dcservice.security.SecurityContextProvider;

import java.math.BigDecimal;
import java.time.LocalDate;

class DebtCaseCreator {
    private final SecurityContextProvider securityContext;
    private final Customers customers;
    private final DebtCases debtCases;

    DebtCaseCreator(SecurityContextProvider securityContext, Customers customers, DebtCases debtCases) {
        this.securityContext = securityContext;
        this.customers = customers;
        this.debtCases = debtCases;
    }

    String create(String customer, LocalDate dueDate, BigDecimal amount) {
        customers
            .findByPersonalIdAndAgent(customer, securityContext.getAuthenticatedUsername())
            .orElseThrow(() -> new IllegalArgumentException("Customer not found: " + customer));
        return debtCases.create(customer, dueDate, amount);
    }
}
