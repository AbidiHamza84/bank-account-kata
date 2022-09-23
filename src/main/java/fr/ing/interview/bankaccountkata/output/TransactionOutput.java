package fr.ing.interview.bankaccountkata.output;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionOutput {
    private Long id;
    private BigDecimal amount;
    private LocalDateTime processedAt;

    public TransactionOutput(Long id, BigDecimal amount, LocalDateTime processedAt) {
        this.id = id;
        this.amount = amount;
        this.processedAt = processedAt;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getProcessedAt() {
        return processedAt;
    }
}
