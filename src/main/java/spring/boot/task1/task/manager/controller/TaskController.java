package spring.boot.task1.task.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.task1.task.manager.enums.Priority;
import spring.boot.task1.task.manager.enums.Status;
import spring.boot.task1.task.manager.model.Task;
import spring.boot.task1.task.manager.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	private final TaskService service;

	public TaskController(TaskService service) {
		this.service = service;
	}

	@PostMapping
	public Task create(@RequestBody Task task) {
		return service.create(task);
	}

	@GetMapping
	public List<Task> findAll(@RequestParam(required = false) Status status,
			@RequestParam(required = false) Priority priority) {
		return service.findAll(status, priority);
	}

	@GetMapping("/due-today")
	public List<Task> findDueToday() {
		return service.findDueToday();
	}

	@PutMapping("/{id}/done")
	public Task markAsDone(@PathVariable Long id) {
		return service.markAsDone(id);
	}
}
