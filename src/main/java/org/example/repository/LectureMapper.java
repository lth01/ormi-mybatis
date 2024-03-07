package org.example.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.model.dto.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface LectureMapper {

    List<LectureCourseInfo> selectLectureCourseInfos();


    List<LectureCourseDetail> selectLectureCourseDetails(Map<String, Object> params);

    Long selectRepresentLectureCount(Long instructorId);

    Integer insertLectureCourse(LectureCourseDetail lecture);

    Integer updateCourseInstructor(LectureInstructor instructor);

    Boolean chkExistCourse(Long courseId);

    Boolean chkAlreadyApplicant(LectureApplicant applicantInfo);

    Integer applicantCourse(LectureApplicant applicantInfo);

    Long getMaximumApplicantCount(LectureApplicant applicantInfo);

    Long selectApplicantCount(LectureApplicant applicantInfo);

    Boolean chkAlreadyAttendance(AttendanceInfo attendanceInfo);

    Integer attendanceCourse(AttendanceInfo attendanceInfo);
}
