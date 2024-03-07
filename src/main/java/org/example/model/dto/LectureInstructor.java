package org.example.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LectureInstructor {
    private Long lectureCourseId;
    private Long instructorId;
    private Long afterInstructorId;

    public LectureInstructor(Long instructorId, Long afterInstructorId, Long lectureCourseId) {
        this.instructorId = instructorId;
        this.afterInstructorId = afterInstructorId;
        this.lectureCourseId = lectureCourseId;
    }
}
