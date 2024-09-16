package com.todo.TodoApp.command;

public interface TaskCommand {
    void execute();
    void undo();

}