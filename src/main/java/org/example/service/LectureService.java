package org.example.service;

import org.example.model.dto.*;
import org.example.repository.InstructorMapper;
import org.example.repository.LectureMapper;
import org.example.repository.StudentMapper;
import org.example.util.BooleanUtil;
import org.example.util.instructor.InstructorUtil;
import org.example.util.lecture.LectureUtil;
import org.example.util.student.StudentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static org.example.util.lecture.LectureUtil.*;

@Service
public class LectureService {
    @Autowired
    private LectureMapper lectureMapper;
    @Autowired
    private InstructorMapper instructorMapper;
    @Autowired
    private StudentMapper studentMapper;


    public List<LectureCourseInfo> getLectureCourseInfo() {
        return lectureMapper.selectLectureCourseInfos();
    }

    public List<LectureCourseDetail> getLectureCourseDetails(Map<String, Object> params) {
        List<LectureCourseDetail>  list = lectureMapper.selectLectureCourseDetails(params);
        //복호화도 하고
        // 다른비지니스처리르 100개정도한다면
        // => 세분화 대상
        // java convetion rule & code style
        return lectureMapper.selectLectureCourseDetails(params);
    }

    public String registLectureCourse(LectureCourseDetail lecture) {
        Integer apiResult = null;
        if(lecture.getInstructorId() == null) return "담당 강사 id는 필수입니다.";
        //강사 존재 여부 확인
        if(BooleanUtil.isFalse(InstructorUtil.isExistInstructor(instructorMapper, lecture.getInstructorId()))){
            return "강사 id에 해당하는 강사가 없습니다.";
        }

        if(BooleanUtil.isFalse(dontExceedRepresentCourseCount(lectureMapper, lecture.getInstructorId()))){
            return "담당 강사가 맡을 수 있는 강의 수를 초과하였습니다.";
        }

        apiResult = lectureMapper.insertLectureCourse(lecture);

        if(BooleanUtil.isFalse(apiResult)){
            return "강의 추가에 실패했습니다.";
        }

        return "강의 추가에 성공했어요!";
    }
    public String patchCourseInstructor(LectureInstructor instructor) {
        Integer apiResult = null;

        if(BooleanUtil.isFalse(InstructorUtil.isExistInstructor(instructorMapper, instructor.getInstructorId()))
                || BooleanUtil.isFalse(InstructorUtil.isExistInstructor(instructorMapper, instructor.getAfterInstructorId()))){
            return "강사 id에 해당하는 강사가 없습니다.";
        }

        if(BooleanUtil.isFalse(LectureUtil.isExistCourse(lectureMapper, instructor.getLectureCourseId()))){
            return "강의 id에 해당하는 강의가 없습니다.";
        }

        if(BooleanUtil.isFalse(dontExceedRepresentCourseCount(lectureMapper, instructor.getAfterInstructorId()))){
            return "담당 강사가 맡을 수 있는 강의 수를 초과하였습니다.";
        }

        apiResult = lectureMapper.updateCourseInstructor(instructor);

        if(BooleanUtil.isFalse(apiResult)){
            return "강의 담당자 변경에 실패했습니다.";
        }

        return "강의 담당자 변경에 성공했습니다!";
    }

    public String postApplicantCourse(LectureApplicant applicantInfo) {
        Integer applicantCount = null;
        //1. 수강 신청한 course가 진짜 존재하는지 확인
        if(BooleanUtil.isFalse(isExistCourse(lectureMapper, applicantInfo.getCourseId()))){
            return "수강 신청할 과목 id를 다시 확인하세요.";
        }

        //2. student id가 정말 존재하는지 확인
        if(BooleanUtil.isFalse(StudentUtil.isExistStudent(studentMapper, applicantInfo.getId()))){
            return "학생 id를 다시 확인하세요";
        }

        //3. 이미 수강신청했는지 확인
        if(BooleanUtil.isFalse(alreadyApplicant(lectureMapper, applicantInfo))){
            return "이미 수강신청한 과목입니다!";
        }

        //4. capacity안넘는지 확인

        if(BooleanUtil.isFalse(dontExceedApplicantCount(lectureMapper, applicantInfo))){
            return "이미 수강 인원이 모두 찼습니다";
        }
        applicantCount = lectureMapper.applicantCourse(applicantInfo);

        if(BooleanUtil.isFalse(applicantCount)){
            return "나도 왜안되는지 모르겠다.....";
        }

        return "수강신청 완료!";
    }

    public String attendanceCourse(AttendanceInfo attendanceInfo) {
        Integer apiResult = null;
        if(BooleanUtil.isFalse(LectureUtil.alreadyAttendanceToday(lectureMapper, attendanceInfo))){
            return "이미 출석체크한 과목입니다.";
        }

        apiResult = lectureMapper.attendanceCourse(attendanceInfo);
        if(BooleanUtil.isFalse(apiResult)){
            return "뭔가... 뭔가 이상햊매러맺ㄷ로;ㅐㅁ졷래";
        }

        return "출석체크가 완료되었습니다~";
    }
}
