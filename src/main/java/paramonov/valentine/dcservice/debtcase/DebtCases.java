package paramonov.valentine.dcservice.debtcase;

import paramonov.valentine.dcservice.DebtCase;
import paramonov.valentine.dcservice.Repo;
import paramonov.valentine.dcservice.db.Db;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

public class DebtCases implements Repo<DebtCase> {
    private final Db db;

    DebtCases(Db db) {
        this.db = db;
    }

    public String create(String customer, LocalDate dueDate, BigDecimal amount) {
        DebtCase debtCase = new DebtCase(customer, dueDate, amount, "Open");
        db.repo(DebtCase.class).insert(debtCase);
        return debtCase.getId();
    }

    public void close(String id, String resolutionStatus) {
        DebtCase debtCase = findById(id)
            .orElseThrow(() -> new EntityNotFoundException("DebtCase with id: " + id));
        debtCase.setStatus(resolutionStatus);
        db
            .repo(DebtCase.class)
            .update(debtCase);
    }

    public Optional<DebtCase> findById(String id) {
        return wrap(
            db
                .repo(DebtCase.class)
                .find(eq("id", id))
                .firstOrDefault()
        );
    }
}
