package com.todo.TodoApp.service;

import com.todo.TodoApp.command.AddTaskCommand;
import com.todo.TodoApp.command.CompleteTaskCommand;
import com.todo.TodoApp.command.DeleteTaskCommand;
import com.todo.TodoApp.command.TaskCommand;
import com.todo.TodoApp.entity.Task;
import com.todo.TodoApp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Stack;


@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final Stack<TaskCommand> undoStack = new Stack<>();
    private final Stack<TaskCommand> redoStack = new Stack<>();

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void addTask(Long taskId, String description) {
        Task task = new Task();
        task.setId(taskId);
        task.setDescription(description);
        taskRepository.save(task);
        undoStack.push(new AddTaskCommand(taskRepository, task));
        redoStack.clear();
    }

    public void completeTask(Long taskId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setCompleted(true);
            taskRepository.save(task);
            undoStack.push(new CompleteTaskCommand(taskRepository, task));
            redoStack.clear();
        }
    }

    public void deleteTask(Long taskId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            taskRepository.delete(task);
            undoStack.push(new DeleteTaskCommand(taskRepository, task));
            redoStack.clear();
        }
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            TaskCommand command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            TaskCommand command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }
}