package com.todolist.exam.model;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private Long id;
    private boolean completed;
    private String todoName;
}
