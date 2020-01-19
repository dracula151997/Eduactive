package com.project.semicolon.eduactive.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.project.semicolon.eduactive.adapters.ListItemViewModel;

@Entity(tableName = "courses", foreignKeys = {
        @ForeignKey(entity = InstructorsEntity.class,
                parentColumns = "inst_pk",
                childColumns = "instructorId",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE)},
        indices = @Index("instructorId"))
public class CoursesEntity extends ListItemViewModel {
    //course_pk column: as auto generated primary key
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "course_pk")
    public int cid;
    public int instructorId;
    //crs_name column: for course name.
    @ColumnInfo(name = "crs_name")
    private String courseTitle;
    //crs_code: for course code.
    @ColumnInfo(name = "crs_code")
    private String courseCode;
    //crs_hours: for course hours
    @ColumnInfo(name = "crs_hours")
    private int hours;
    //crs_content: for course content
    @ColumnInfo(name = "crs_content")
    private String courseContent;
    //crs_group_link: for facebook group link
    @ColumnInfo(name = "crs_group_link")
    private String courseGroupLink;
    //crs_references: for book references.
    @ColumnInfo(name = "crs_references")
    private String references;
    @ColumnInfo(name = "max_std_no")
    private int maxStudentNumber;
    private int departmentId;


    public CoursesEntity(String courseTitle, String courseCode, int hours, String courseContent,
                         String courseGroupLink, String references, int maxStudentNumber, int instructorId) {
        this.courseTitle = courseTitle;
        this.courseCode = courseCode;
        this.hours = hours;
        this.courseContent = courseContent;
        this.courseGroupLink = courseGroupLink;
        this.references = references;
        this.maxStudentNumber = maxStudentNumber;
        this.instructorId = instructorId;
    }

    @Ignore
    public CoursesEntity(String courseTitle, String courseCode, int hours,
                         String courseContent, int studentNumber, int instructorId, int departmentId) {
        this.courseTitle = courseTitle;
        this.courseCode = courseCode;
        this.hours = hours;
        this.courseContent = courseContent;
        this.maxStudentNumber = studentNumber;
        this.instructorId = instructorId;
        this.departmentId = departmentId;
    }

    @Ignore
    public CoursesEntity() {
    }


    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getCourseContent() {
        return courseContent;
    }

    public void setCourseContent(String courseContent) {
        this.courseContent = courseContent;
    }

    public String getCourseGroupLink() {
        return courseGroupLink;
    }

    public void setCourseGroupLink(String courseGroupLink) {
        this.courseGroupLink = courseGroupLink;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getMaxStudentNumber() {
        return maxStudentNumber;
    }

    public void setMaxStudentNumber(int maxStudentNumber) {
        this.maxStudentNumber = maxStudentNumber;
    }

    @Override
    public String toString() {
        return "CoursesEntity{" +
                "cid=" + cid +
                ", courseTitle='" + courseTitle + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", hours=" + hours +
                ", courseContent='" + courseContent + '\'' +
                ", courseGroupLink='" + courseGroupLink + '\'' +
                ", references='" + references + '\'' +
                ", maxStudentNumber=" + maxStudentNumber +
                ", instructorId=" + instructorId +
                ", departmentId=" + departmentId +
                '}';
    }
}
