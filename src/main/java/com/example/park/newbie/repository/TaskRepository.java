package com.example.park.newbie.repository;

import com.example.park.newbie.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
