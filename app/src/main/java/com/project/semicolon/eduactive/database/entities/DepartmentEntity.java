package com.project.semicolon.eduactive.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "department", foreignKeys = @ForeignKey(
        entity = EmployeesEntity.class,
        parentColumns = "emp_pk",
        childColumns = "managerId",
        onDelete = ForeignKey.RESTRICT,
        onUpdate = ForeignKey.RESTRICT), indices = {@Index("managerId")})
public class DepartmentEntity {
    @PrimaryKey
    @ColumnInfo(name = "dep_pk")
    public int did;
    @ColumnInfo(name = "dep_name")
    private String departmentName;
    @ColumnInfo(name = "dep_code")
    private String departmentCode;
    private int managerId;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
}
