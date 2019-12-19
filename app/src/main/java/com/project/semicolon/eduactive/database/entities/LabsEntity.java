package com.project.semicolon.eduactive.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "labs",
        foreignKeys = @ForeignKey(
                entity = EmployeesEntity.class,
                parentColumns = "emp_pk",
                childColumns = "labSupervisor",
                onDelete = ForeignKey.RESTRICT,
                onUpdate = ForeignKey.RESTRICT),
        indices = {@Index("labSupervisor")})
public class LabsEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "lab_pk")
    public int lid;
    private int labSupervisor;
    @ColumnInfo(name = "lab_code")
    private String code;
    @ColumnInfo(name = "students_num")
    private String studentsNumber;

    public LabsEntity() {
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getLabSupervisor() {
        return labSupervisor;
    }

    public void setLabSupervisor(int labSupervisor) {
        this.labSupervisor = labSupervisor;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStudentsNumber() {
        return studentsNumber;
    }

    public void setStudentsNumber(String studentsNumber) {
        this.studentsNumber = studentsNumber;
    }
}
