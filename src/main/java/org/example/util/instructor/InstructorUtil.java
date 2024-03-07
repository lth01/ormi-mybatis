package org.example.util.instructor;

import org.example.repository.InstructorMapper;

public class InstructorUtil {
    public static boolean isExistInstructor(InstructorMapper mapper, Long instructorId){
        if(mapper == null || instructorId == null) return false;

        Boolean chkExistInstructor = mapper.chkExistInstructor(instructorId);

        if(chkExistInstructor == null || chkExistInstructor == false) return false;
        return true;
    }
}
