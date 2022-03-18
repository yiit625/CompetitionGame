package com.competitiongame.competitiongame.repositories;

import com.competitiongame.competitiongame.entities.Task;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaSpecificationExecutor<Task>,
        PagingAndSortingRepository<Task, Integer>, CrudRepository<Task,Integer> {
}
