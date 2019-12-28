package com.project.semicolon.eduactive.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "articles",
        foreignKeys = @ForeignKey(entity = EmployeesEntity.class,
                parentColumns = "emp_pk",
                childColumns = "employeeId",
                onDelete = ForeignKey.RESTRICT,
                onUpdate = ForeignKey.RESTRICT),
        indices = {@Index("employeeId")})
public class NewsEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "article_pk")
    public int id;
    private int employeeId;
    @ColumnInfo(name = "created_at")
    private Date createdAt;
    @ColumnInfo(name = "article_title")
    private String title;
    @ColumnInfo(name = "article_desc")
    private String description;
    @ColumnInfo(name = "article_image")
    private int image;
    @ColumnInfo(name = "views_counter")
    private String viewsCounter;

    @Ignore
    public NewsEntity() {
    }

    public NewsEntity(String title, String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.employeeId = 1;
        createdAt = new Date(System.currentTimeMillis());

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
        return createdAt.getTime() + "";
    }
}
