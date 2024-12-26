package com.csbu.mvc_management.records;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class AddTransactionRequest {
    @NotNull
    private String id;
    @NotNull
    private String transactionType;

    @NotNull
    private Integer amount;

    @NotNull
    private String currency;

    @NotNull
    private String description;
    @NotNull
    private  String budgetId;

    public @NotNull String getId() {
        return id;
    }

    public void setId(@NotNull String id) {
        this.id = id;
    }

    public @NotNull String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(@NotNull String transactionType) {
        this.transactionType = transactionType;
    }

    public @NotNull Integer getAmount() {
        return amount;
    }

    public void setAmount(@NotNull Integer amount) {
        this.amount = amount;
    }

    public @NotNull String getCurrency() {
        return currency;
    }

    public void setCurrency(@NotNull String currency) {
        this.currency = currency;
    }

    public @NotNull String getDescription() {
        return description;
    }

    public void setDescription(@NotNull String description) {
        this.description = description;
    }

    public @NotNull String getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(@NotNull String budgetId) {
        this.budgetId = budgetId;
    }
}
