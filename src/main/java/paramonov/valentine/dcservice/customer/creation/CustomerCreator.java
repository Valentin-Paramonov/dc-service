package paramonov.valentine.dcservice.customer.creation;


import paramonov.valentine.dcservice.security.SecurityContextProvider;

class CustomerCreator {
    private final SecurityContextProvider securityContext;
    private final Customers customers;

    CustomerCreator(SecurityContextProvider securityContext, Customers customers) {
        this.securityContext = securityContext;
        this.customers = customers;
    }

    void create(String name, String surname, String email, String personalId) {
        securityContext.getContext().getAuthentication();
        customers.create(name, surname, email, personalId, securityContext.getAuthenticatedUsername());
    }
}
