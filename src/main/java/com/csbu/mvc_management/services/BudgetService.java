package com.csbu.mvc_management.services;
import com.csbu.mvc_management.entities.BudgetModel;
import com.csbu.mvc_management.payload.BudgetDto;
import com.csbu.mvc_management.payload.BudgetIdAndCurrencyDto;
import com.csbu.mvc_management.payload.PageResponse;
import com.csbu.mvc_management.repository.BudgetRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BudgetService {
    @Autowired
    private BudgetRepository budgetRepository;

    public void createBudget(BudgetModel budget) {
        try {
            if (budgetRepository.findById(budget.getId()).isPresent()) {
                throw new TransactionException("Budget already exists with id: " + budget.getId());
            }
            budgetRepository.save(budget);
        } catch (TransactionException e) {
            throw e;
        } catch (Exception e) {
            throw new TransactionException("Error saving budget", e);
        }
    }

    public List<BudgetIdAndCurrencyDto> getAllBudgetsIdAndCurrency(
    ) {
        try {
            return budgetRepository.findAll().stream()
                    .map(budget -> new BudgetIdAndCurrencyDto(
                            budget.getId(),
                            budget.getCurrency()
                    )).collect(Collectors.toList());
        } catch (Exception e) {
            throw new TransactionException("Error getting budget", e);
        }
    }
    public PageResponse<BudgetDto> getBudgets(Integer page, Integer size){
        try {
            Sort sort = Sort.by("createdAt").descending();
            Pageable pageable = PageRequest.of(page-1, size, sort);
            Page<BudgetModel> budgetsPage = budgetRepository.findAll(pageable);
            List<BudgetDto> budgetDtos = budgetsPage.getContent()
                    .stream()
                    .map(budget -> new BudgetDto(
                            budget.getId(),
                            budget.getDescription(),
                            budget.getPeriodStart(),
                            budget.getPeriodEnd(),
                            budget.getApprovedAmount(),
                            budget.getRemainingAmount(),
                            budget.getCurrency(),
                            budget.getCreatedAt()
                    ))
                    .collect(Collectors.toList());

            return new PageResponse<BudgetDto>(
                    budgetsPage.getNumber() + 1, // currentPage (1-based index)
                    budgetsPage.getTotalPages(), // totalPages
                    budgetsPage.getSize(), // pageSize
                    (int) budgetsPage.getTotalElements(), // totalElement
                    budgetDtos // data
            );
        }catch (Exception e){
            throw new TransactionException("Error getting budget", e);
        }
    }

    public Page<BudgetDto> searchBudgets(
            String searchQuery
            , String year,
            int page,
            int size
    ){
        try {
            Pageable pageable = PageRequest.of(page-1, size);
            Page<BudgetModel> budgetsPage = budgetRepository.findAll(pageable);
            List<BudgetDto> filteredTransactions = budgetsPage.stream()
                    .filter(budget -> searchQuery == null ||
                            budget.getId().toString().contains(searchQuery)
                    )
                    .filter(budget -> year == null ||
                            (
                                    Integer.parseInt(year)  >= budget.getPeriodStart().getYear() &&
                                            Integer.parseInt(year)  <= budget.getPeriodEnd().getYear()
                            )
                    )
                    .map(budget -> new BudgetDto(
                            budget.getId(),
                            budget.getDescription(),
                            budget.getPeriodStart(),
                            budget.getPeriodEnd(),
                            budget.getApprovedAmount(),
                            budget.getRemainingAmount(),
                            budget.getCurrency(),
                            budget.getCreatedAt()
                    )).collect(Collectors.toList());
            return new PageImpl<>(filteredTransactions, pageable, budgetsPage.getTotalElements());
        }catch (Exception e){
            throw new TransactionException("Error getting budget", e);
        }
    }

    public void deleteBudget(String id){
        try {
            budgetRepository.deleteById(id);
        }catch (Exception e){
            throw new TransactionException("Error deleting budget", e);
        }
    }

    public void updateBudgetAmount(String id, Integer amount){
        try {
            budgetRepository.updateBudgetAmount(id, amount);
        } catch (Exception e) {
            throw new TransactionException("Error updating budget", e);
        }
    }
    public BudgetModel getBudgetById(String id) {
        try {
            return budgetRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new TransactionException("Error getting Budget", e);
        }
    }

}

