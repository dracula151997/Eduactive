package com.project.semicolon.eduactive.adapters;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StudyTimeTableModel {
    private String subjectName;
    private String instructorName;
    private String time;
    private String labCode;
    private int weekNum;
    private int type;
    public boolean expanded = false;
    public boolean parent = false;

    public StudyTimeTableModel(String subjectName, String instuctorName, String time, String labCode) {
        this.subjectName = subjectName;
        this.instructorName = instuctorName;
        this.time = time;
        this.labCode = labCode;
    }


    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLabCode() {
        return labCode;
    }

    public void setLabCode(String labCode) {
        this.labCode = labCode;
    }

    public String convertTimestampToTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a", Locale.ENGLISH);
        return dateFormat.format(new Date(time));
    }

    public void setWeekNum(int weekNum) {
        this.weekNum = weekNum;
    }

    public int getWeekNum() {
        return weekNum;
    }
}
