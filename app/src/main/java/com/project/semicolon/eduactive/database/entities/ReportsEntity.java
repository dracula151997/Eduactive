package com.project.semicolon.eduactive.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "reports",
        foreignKeys = @ForeignKey(
                entity = StudentEntity.class,
                parentColumns = "std_pk",
                childColumns = "studentId",
                onUpdate = ForeignKey.RESTRICT,
                onDelete = ForeignKey.RESTRICT),
        indices = {@Index("studentId")})
public class ReportsEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "report_pk")
    private int id;
    private int studentId;
    @ColumnInfo(name = "report_desc")
    private String reportDesc;
    @ColumnInfo(name = "report_title")
    private String title;

    public ReportsEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getReportDesc() {
        return reportDesc;
    }

    public void setReportDesc(String reportDesc) {
        this.reportDesc = reportDesc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
