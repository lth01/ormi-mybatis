package org.example.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class LectureCourseDetail {
    private String title;
    private Long lectureCourseId;
    private LocalDate from;
    private LocalDate to;
    private String instructorName;
    private Long instructorId;
    private String studentName;
    private String studentRegisterName;
    private Long studentId;
    private LocalDate registeredAt;

    public LectureCourseDetail(String title, Long lectureCourseId, LocalDate from, LocalDate to, String instructorName, Long instructorId, String studentName, String studentRegisterName, Long studentId, LocalDate registeredAt) {
        this.title = title;
        this.lectureCourseId = lectureCourseId;
        this.from = from;
        this.to = to;
        this.instructorName = instructorName;
        this.instructorId = instructorId;
        this.studentName = studentName;
        this.studentRegisterName = studentRegisterName;
        this.studentId = studentId;
        this.registeredAt = registeredAt;
    }

    public LectureCourseDetail(String title, Long instructorId) {
        this.title = title;
        this.instructorId = instructorId;
    }
}
