package com.csbu.mvc_management.repository;
import com.csbu.mvc_management.entities.TransactionModel;
import jakarta.transaction.Transactional;
import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel, String> {
    @Modifying
    @Transactional
    @Query("UPDATE TransactionModel a SET a.status = true WHERE a.id = :id")
    void updateTransactionStatus(@Param("id") String id);

    @Modifying
    @Transactional
    @Query("UPDATE TransactionModel a SET a.image = :url WHERE a.id = :id")
    void updateTransactionImg(@Param("id") String id, @Param("url") String url);
}
