package com.edumentors.backend.dto;

import java.time.LocalDateTime;

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
public class EnrollmentDTO {
    private long enrollmentId;
    private long userId; // Reference to the user
    private long courseId; // Reference to the course
    private LocalDateTime enrollmentDate;
}