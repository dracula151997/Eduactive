package com.project.semicolon.eduactive.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "exams_bank")
public class ExamsBankEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "exam_pk")
    public int eid;
    @ColumnInfo(name = "exams_pdf")
    private String pdf;
    @ColumnInfo(name = "model_answer")
    private String modelAnswer;
    @ColumnInfo(name = "has_model_answer")
    private boolean hasModelAnswer;
    @ColumnInfo(name = "exam_year")
    private Date year;
    @ColumnInfo(name = "instructor_name")
    private String instructorName;
    @ColumnInfo(name = "exam_type")
    private byte type;
    @ColumnInfo(name = "level")
    private byte level;
    @ColumnInfo(name = "course_name")
    private String courseName;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getModelAnswer() {
        return modelAnswer;
    }

    public void setModelAnswer(String modelAnswer) {
        this.modelAnswer = modelAnswer;
    }

    public boolean isHasModelAnswer() {
        return hasModelAnswer;
    }

    public void setHasModelAnswer(boolean hasModelAnswer) {
        this.hasModelAnswer = hasModelAnswer;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
