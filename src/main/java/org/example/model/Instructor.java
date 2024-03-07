package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
public class Instructor {
    private Long id;
    private String usrId;
    private String name;
    private Integer left;
    private String desc;
    private LocalDate createAt;

    public Instructor() {}

    public Instructor(Long id, String usrId, String name, Integer left, String desc, Date createAt) {
        this.id = id;
        this.usrId = usrId;
        this.name = name;
        this.left = left;
        this.desc = desc;
        this.createAt = createAt.toLocalDate();
    }

    public Instructor(String usrId, String name) {
        this.usrId = usrId;
        this.name = name;
    }

}
