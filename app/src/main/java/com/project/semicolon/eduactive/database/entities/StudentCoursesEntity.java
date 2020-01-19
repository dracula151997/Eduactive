package com.project.semicolon.eduactive.database.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;


@Entity(tableName = "student_courses",
        primaryKeys = {"stdId", "crsId"},
        foreignKeys = {@ForeignKey(
                entity = StudentEntity.class,
                parentColumns = "std_pk",
                childColumns = "stdId"),
                @ForeignKey(
                        entity = CoursesEntity.class,
                        parentColumns = "course_pk",
                        childColumns = "crsId")},
        indices = {@Index("stdId"), @Index("crsId")})
public class StudentCoursesEntity {
    public int stdId;
    public int crsId;

    public StudentCoursesEntity(int stdId, int crsId) {
        this.stdId = stdId;
        this.crsId = crsId;
    }

    public int getCrsId() {
        return crsId;
    }

    public void setCrsId(int crsId) {
        this.crsId = crsId;
    }

    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }
}
