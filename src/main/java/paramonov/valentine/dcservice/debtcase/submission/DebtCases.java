package paramonov.valentine.dcservice.debtcase.submission;

import paramonov.valentine.dcservice.DebtCase;
import paramonov.valentine.dcservice.db.Db;

import java.math.BigDecimal;
import java.time.LocalDate;

class DebtCases {
    private final Db db;

    DebtCases(Db db) {
        this.db = db;
    }

    void create(String customer, LocalDate dueDate, BigDecimal amount) {
        db
            .repo(DebtCase.class)
            .insert(
                new DebtCase(customer, dueDate, amount, "Open")
            );
    }
}
