package com.project.semicolon.eduactive.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "courses", foreignKeys = {
        @ForeignKey(entity = InstructorsEntity.class,
                parentColumns = "inst_pk",
                childColumns = "instructorId",
                onDelete = ForeignKey.RESTRICT,
                onUpdate = ForeignKey.RESTRICT),
        @ForeignKey(entity = DepartmentEntity.class,
                parentColumns = "dep_pk",
                childColumns = "departmentId",
                onUpdate = ForeignKey.RESTRICT,
                onDelete = ForeignKey.RESTRICT)}, indices = {@Index("instructorId"), @Index("departmentId")})
public class CoursesEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "course_pk")
    public int cid;
    @ColumnInfo(name = "crs_name")
    private String courseTitle;
    @ColumnInfo(name = "crs_code")
    private String courseCode;
    @ColumnInfo(name = "crs_hours")
    private int hours;
    @ColumnInfo(name = "crs_content")
    private String courseContent;
    @ColumnInfo(name = "crs_group_link")
    private String courseGroupLink;
    @ColumnInfo(name = "crs_references")
    private String references;
    private int instructorId;
    private int departmentId;


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
}
