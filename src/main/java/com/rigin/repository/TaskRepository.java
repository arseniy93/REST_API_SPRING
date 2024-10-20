package com.rigin.repository;

import com.rigin.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    @Modifying
    @Query(value = "SELECT * FROM Task t LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Task> getAllWithLimitAndOffset(@Param("limit") int limit, @Param("offset") int offset);

}
