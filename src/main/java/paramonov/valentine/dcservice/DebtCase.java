package paramonov.valentine.dcservice;

import org.dizitart.no2.objects.Id;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class DebtCase implements Serializable {
    @Id
    private String id = UUID.randomUUID().toString();
    private String customer;
    private LocalDate dueDate;
    private BigDecimal amount;
    private String status;

    public DebtCase() {
    }

    public DebtCase(String customer, LocalDate dueDate, BigDecimal amount, String status) {
        this.customer = customer;
        this.dueDate = dueDate;
        this.amount = amount;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

