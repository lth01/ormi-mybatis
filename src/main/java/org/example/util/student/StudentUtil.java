package org.example.util.student;

import org.example.repository.StudentMapper;

public class StudentUtil {
    public static boolean isExistStudent(StudentMapper mapper, Long studentId){
        if(mapper == null || studentId == null) return false;

        Boolean chkExistStudent = mapper.chkExistStudent(studentId);

        if(chkExistStudent == null || chkExistStudent == false){
            return false;
        }
        return true;
    }
}
