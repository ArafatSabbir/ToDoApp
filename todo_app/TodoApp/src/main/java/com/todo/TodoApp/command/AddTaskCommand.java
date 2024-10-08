package com.todo.TodoApp.command;


import com.todo.TodoApp.entity.Task;
import com.todo.TodoApp.repository.TaskRepository;

public class AddTaskCommand implements TaskCommand {
    private final TaskRepository taskRepository;
    private final Task task;

    public AddTaskCommand(TaskRepository taskRepository, Task task) {
        this.taskRepository = taskRepository;
        this.task = task;
    }

    @Override
    public void execute() {
        taskRepository.save(task);
    }

    @Override
    public void undo() {
        taskRepository.delete(task);
    }
}
