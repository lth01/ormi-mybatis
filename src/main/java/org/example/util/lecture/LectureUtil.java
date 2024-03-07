package org.example.util.lecture;

import org.example.model.dto.AttendanceInfo;
import org.example.model.dto.LectureApplicant;
import org.example.repository.LectureMapper;

public class LectureUtil {
    static private final int MAX_COURSEREPRESENTCOUNT = 2;

    public static boolean dontExceedRepresentCourseCount(LectureMapper mapper, Long instructorId){
        Long representCount = mapper.selectRepresentLectureCount(instructorId);
        if(representCount == null || representCount >= MAX_COURSEREPRESENTCOUNT) {
            return false;
        }
        return true;
    }
    public static boolean isExistCourse(LectureMapper mapper, Long courseId){
        if(mapper == null || courseId == null) return false;

        Boolean chkExistCourse = mapper.chkExistCourse(courseId);

        if(chkExistCourse == null || chkExistCourse == false) return false;
        return true;
    }

    public static boolean alreadyApplicant(LectureMapper mapper, LectureApplicant applicantInfo){
        if (mapper == null || applicantInfo == null) return false;

        Boolean alreadyApplicant = mapper.chkAlreadyApplicant(applicantInfo);
        if(alreadyApplicant == null || alreadyApplicant == true) return false;
        return true;
    }

    public static boolean dontExceedApplicantCount(LectureMapper mapper, LectureApplicant applicantInfo){
        if(mapper == null || applicantInfo == null) return  false;

        Long maxApplicantCount = mapper.getMaximumApplicantCount(applicantInfo);
        Long nowApplicantCount = mapper.selectApplicantCount(applicantInfo);

        if(maxApplicantCount <= nowApplicantCount) return false;
        return true;
    }

    public static boolean alreadyAttendanceToday(LectureMapper mapper, AttendanceInfo attendanceInfo){
        if(mapper == null || attendanceInfo == null) return false;

        Boolean alreadyAttendance = mapper.chkAlreadyAttendance(attendanceInfo);

        if(alreadyAttendance == null || alreadyAttendance == true) return false;
        return true;
    }
}
