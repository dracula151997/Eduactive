package com.project.semicolon.eduactive.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Arrays;
import java.util.Date;

@Entity(tableName = "instructors")
public class InstructorsEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "inst_pk")
    public int id;
    @ColumnInfo(name = "inst_first_name")
    private String firstName;
    @ColumnInfo(name = "inst_last_name")
    private String lastName;
    @ColumnInfo(name = "inst_code")
    private String code;
    @ColumnInfo(name = "inst_job_title")
    private String jobTitle;
    @ColumnInfo(name = "inst_image", typeAffinity = ColumnInfo.BLOB)
    private byte[] image;
    @ColumnInfo(name = "inst_mobile")
    private String mobile;
    @ColumnInfo(name = "inst_telephone")
    private String telephone;
    @ColumnInfo(name = "inst_user_name")
    private String username;
    @ColumnInfo(name = "inst_password")
    private String password;
    @ColumnInfo(name = "inst_state")
    private String state;
    @ColumnInfo(name = "inst_city")
    private String city;
    @ColumnInfo(name = "inst_address")
    private String address;
    @ColumnInfo(name = "inst_email")
    private String email;
    @ColumnInfo(name = "created_at")
    private Date createdAt;


    @Ignore
    public InstructorsEntity() {
    }

    public InstructorsEntity(String firstName, String lastName, String code, String jobTitle, String mobile,
                             String username, String password, String state, String city, String email) {
        createdAt = new Date();
        this.firstName = firstName;
        this.lastName = lastName;
        this.code = code;
        this.jobTitle = jobTitle;
        this.mobile = mobile;
        this.username = username;
        this.password = password;
        this.state = state;
        this.city = city;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "InstructorsEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", code='" + code + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", image=" + Arrays.toString(image) +
                ", mobile='" + mobile + '\'' +
                ", telephone='" + telephone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
