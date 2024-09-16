package com.todo.TodoApp.command;


import com.todo.TodoApp.entity.Task;
import com.todo.TodoApp.repository.TaskRepository;

public class DeleteTaskCommand implements TaskCommand {
    private final TaskRepository taskRepository;
    private final Task task;

    public DeleteTaskCommand(TaskRepository taskRepository, Task task) {
        this.taskRepository = taskRepository;
        this.task = task;
    }

    @Override
    public void execute() {
        taskRepository.delete(task);
    }

    @Override
    public void undo() {
        taskRepository.save(task);
    }

    public Task getDeletedTask() {
        return task;
    }
}
