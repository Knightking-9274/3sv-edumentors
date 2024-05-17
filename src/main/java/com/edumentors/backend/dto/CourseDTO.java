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
public class CourseDTO {
    private long courseId;
    private String courseName;
    private String description;
    private long instructorId; // Reference to the instructor (User)
}
