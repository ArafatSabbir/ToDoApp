package com.todo.TodoApp.command;

import com.todo.TodoApp.entity.Task;
import com.todo.TodoApp.repository.TaskRepository;

public class CompleteTaskCommand implements TaskCommand {
    private final TaskRepository taskRepository;
    private final Task task;

    public CompleteTaskCommand(TaskRepository taskRepository, Task task) {
        this.taskRepository = taskRepository;
        this.task = task;
    }

    @Override
    public void execute() {
        task.setCompleted(true);
        taskRepository.save(task);
    }

    @Override
    public void undo() {
        task.setCompleted(false);
        taskRepository.save(task);
    }
}