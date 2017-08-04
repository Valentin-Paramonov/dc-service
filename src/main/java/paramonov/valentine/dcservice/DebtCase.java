package paramonov.valentine.dcservice;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class DebtCase implements Serializable {
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

