package com.project.semicolon.eduactive.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
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
    @ColumnInfo(name = "news_pk")
    public int id;
    private int employeeId;
    @ColumnInfo(name = "created_at")
    private Date createdAt;
    @ColumnInfo(name = "article_title")
    private String title;
    @ColumnInfo(name = "article_desc")
    private String description;
    @ColumnInfo(name = "article_image")
    private String image;
    @ColumnInfo(name = "views_counter")
    private String viewsCounter;

    public NewsEntity() {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getViewsCounter() {
        return viewsCounter;
    }

    public void setViewsCounter(String viewsCounter) {
        this.viewsCounter = viewsCounter;
    }
}
