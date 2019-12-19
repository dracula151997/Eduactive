package com.project.semicolon.eduactive.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "students")
public class StudentEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "std_pk")
    public int uid;
    @ColumnInfo(name = "std_id")
    private String studentId;
    @ColumnInfo(name = "std_name")
    private String studentName;
    @ColumnInfo(name = "std_pass")
    private String password;
    @ColumnInfo(name = "std_image", typeAffinity = ColumnInfo.BLOB)
    private byte[] image;
    @ColumnInfo(name = "std_tel")
    private String telephone;
    @ColumnInfo(name = "std_mob")
    private String mobile;
    @ColumnInfo(name = "std_city")
    private String city;
    @ColumnInfo(name = "std_state")
    private String state;
    @ColumnInfo(name = "std_add")
    private String address;
    @ColumnInfo(name = "std_email")
    private String email;
    @ColumnInfo(name = "std_birth_date")
    private Date birthdate;

    public StudentEntity() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getBirthdate() {
        return birthdate;
    }
}
