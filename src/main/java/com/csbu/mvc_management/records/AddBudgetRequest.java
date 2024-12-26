package com.csbu.mvc_management.records;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class AddBudgetRequest {
    @NotNull
    private String id;
    @NotNull
    private String description;
    @NotNull
    private LocalDate periodStart;
    @NotNull
    private LocalDate periodEnd;
    @NotNull
    private Integer budgetAmount;
    @NotNull
    private String currency;

    public @NotNull String getId() {
        return id;
    }

    public void setId(@NotNull String id) {
        this.id = id;
    }

    public @NotNull String getDescription() {
        return description;
    }

    public void setDescription(@NotNull String description) {
        this.description = description;
    }

    public @NotNull LocalDate getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(@NotNull LocalDate periodStart) {
        this.periodStart = periodStart;
    }

    public @NotNull LocalDate getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(@NotNull LocalDate periodEnd) {
        this.periodEnd = periodEnd;
    }

    public @NotNull Integer getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(@NotNull Integer budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public @NotNull String getCurrency() {
        return currency;
    }

    public void setCurrency(@NotNull String currency) {
        this.currency = currency;
    }
}
