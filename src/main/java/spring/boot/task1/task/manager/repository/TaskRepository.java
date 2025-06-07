package spring.boot.task1.task.manager.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.boot.task1.task.manager.enums.Priority;
import spring.boot.task1.task.manager.enums.Status;
import spring.boot.task1.task.manager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByStatus(Status status);

	List<Task> findByPriority(Priority priority);

	List<Task> findByDueDateBefore(LocalDate date);
}
