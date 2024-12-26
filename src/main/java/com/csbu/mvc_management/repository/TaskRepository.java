package com.csbu.mvc_management.repository;
import com.csbu.mvc_management.entities.TaskModel;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, String> {
    @Modifying
    @Transactional
    @Query("UPDATE TaskModel a SET  a.status = true WHERE a.id = :id")
    void updateStatusById(@Param("id") String id);
    Page<TaskModel> findByEmployeeId(String employeeId, Pageable pageable);


}
