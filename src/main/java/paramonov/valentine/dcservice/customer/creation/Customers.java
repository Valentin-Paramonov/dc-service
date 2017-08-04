package paramonov.valentine.dcservice.customer.creation;

import paramonov.valentine.dcservice.Customer;
import paramonov.valentine.dcservice.Repo;
import paramonov.valentine.dcservice.db.Db;

import java.util.Optional;

import static org.dizitart.no2.objects.filters.ObjectFilters.and;
import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

public class Customers implements Repo<Customer> {
    private final Db db;

    Customers(Db db) {
        this.db = db;
    }

    public void create(String name, String surname, String email, String personalId, String agent) {
        db
            .repo(Customer.class)
            .insert(new Customer(name, surname, email, personalId, agent));
    }

    public Optional<Customer> findByPersonalIdAndAgent(String personalId, String agent) {
        return wrap(
            db
                .repo(Customer.class)
                .find(and(eq("personalId", personalId), eq("agent", agent)))
                .firstOrDefault()
        );
    }
}
