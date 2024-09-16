package com.todo.TodoApp.dto;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Long id;

    private String description;

    private boolean completed;
}
