package spring.boot.task1.task.manager.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.task1.task.manager.enums.Priority;
import spring.boot.task1.task.manager.enums.Status;
import spring.boot.task1.task.manager.model.Task;
import spring.boot.task1.task.manager.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository repository;

	public Task create(Task task) {
		return repository.save(task);
	}

	public List<Task> findAll(Status status, Priority priority) {
		if (status != null) {

			return repository.findByStatus(status);
		}

		if (priority != null) {

			return repository.findByPriority(priority);
		}

		return repository.findAll();
	}

	public List<Task> findDueToday() {
		return repository.findByDueDateBefore(LocalDate.now().plusDays(1));
	}

	public Task markAsDone(Long id) {
		Task task = repository.findById(id).orElseThrow();
		task.setStatus(Status.CONCLUIDA);
		return repository.save(task);
	}
}
