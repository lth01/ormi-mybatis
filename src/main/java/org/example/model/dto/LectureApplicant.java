package org.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LectureApplicant {
    private Long id;
    private Long courseId;
}
