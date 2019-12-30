package com.project.semicolon.eduactive.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*
foreignKeys = @ForeignKey(entity = EmployeesEntity.class,
                parentColumns = "emp_pk",
                childColumns = "employeeId"),
        indices = {@Index("employeeId")}
 */
@Entity(tableName = "articles")
public class NewsEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "article_pk")
    public int id;
    @Ignore
    private int employeeId;
    @ColumnInfo(name = "created_at")
    private Date createdAt = new Date(System.currentTimeMillis());
    @ColumnInfo(name = "article_title")
    private String title;
    @ColumnInfo(name = "article_desc")
    private String description;
    @ColumnInfo(name = "article_image")
    private int image;
    @Ignore
    @ColumnInfo(name = "views_counter")
    private String viewsCounter;

    @Ignore
    public NewsEntity() {
    }


    public NewsEntity(String title, String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getViewsCounter() {
        return viewsCounter;
    }

    public void setViewsCounter(String viewsCounter) {
        this.viewsCounter = viewsCounter;
    }

    @Override
    public String toString() {
        return "NewsEntity{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", createdAt=" + createdAt +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", viewsCounter='" + viewsCounter + '\'' +
                '}';
    }

    public String convertDateToTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd hh:mm a", Locale.ENGLISH);
        return dateFormat.format(createdAt);
    }
}
