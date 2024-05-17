package com.edumentors.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private long commentId;
    private String content;
    private long userId; // Reference to the user
    private long courseId; // Reference to the course
}
