package com.project.semicolon.eduactive.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.project.semicolon.eduactive.adapters.ListItemViewModel;

@Entity(tableName = "exams_bank")
public class ExamsBankEntity extends ListItemViewModel {
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
    private String year;
    @ColumnInfo(name = "instructor_name")
    private String instructorName;
    @ColumnInfo(name = "exam_type")
    private byte type;
    @ColumnInfo(name = "level")
    private byte level;
    @ColumnInfo(name = "course_name")
    private String courseName;

    public ExamsBankEntity(String pdf, String modelAnswer, boolean hasModelAnswer, String year,
                           String instructorName, byte type, byte level, String courseName) {
        this.pdf = pdf;
        this.modelAnswer = modelAnswer;
        this.hasModelAnswer = hasModelAnswer;
        this.year = year;
        this.instructorName = instructorName;
        this.type = type;
        this.level = level;
        this.courseName = courseName;
    }

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
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

    public String getExamLevel() {
        String levelName = "";
        switch (level) {
            case 0:
                levelName = "Level 000";
                break;
            case 1:
                levelName = "Level 100";
                break;
            case 2:
                levelName = "Level 200";
                break;
            case 3:
                levelName = "Level 300";
                break;
            case 4:
                levelName = "Level 400";
        }

        return levelName;
    }

    public String getExamType() {
        String examType = "";
        switch (type) {
            case 0:
                examType = "Mid Term " + year;
                break;
            case 1:
                examType = "Final " + year;
                break;


        }

        return examType;
    }

    @Override
    public String toString() {
        return "ExamsBankEntity{" +
                "eid=" + eid +
                ", pdf='" + pdf + '\'' +
                ", modelAnswer='" + modelAnswer + '\'' +
                ", hasModelAnswer=" + hasModelAnswer +
                ", year='" + year + '\'' +
                ", instructorName='" + instructorName + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
