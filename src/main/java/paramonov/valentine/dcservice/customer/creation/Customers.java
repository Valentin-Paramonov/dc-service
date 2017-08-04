package paramonov.valentine.dcservice.customer.creation;

import paramonov.valentine.dcservice.Customer;
import paramonov.valentine.dcservice.Repo;
import paramonov.valentine.dcservice.db.Db;

class Customers implements Repo<Customer> {
    private final Db db;

    Customers(Db db) {
        this.db = db;
    }

    public void create(String name, String surname, String email, String personalId, String agent) {
        db.repo(Customer.class).insert(new Customer(name, surname, email, personalId, agent));
    }
}
