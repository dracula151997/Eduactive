package com.project.semicolon.eduactive.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.project.semicolon.eduactive.adapters.ListItemViewModel;

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
public class NewsEntity extends ListItemViewModel {
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
    @ColumnInfo(name = "type")
    private byte type;
    @ColumnInfo(name = "from")
    private long eventData;
    @ColumnInfo(name = "allowed_number")
    private int allowedNumber;
    @ColumnInfo(name = "free")
    private boolean isFree;
    @ColumnInfo(name = "price")
    private String price;

    @Ignore
    public NewsEntity() {
    }


    public NewsEntity(String title, String description, int image, byte type) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.type = type;
        createdAt = new Date(System.currentTimeMillis());
    }

    @Ignore
    public NewsEntity(String title, String description, int image, byte type, long eventData, int allowedNumber, boolean isFree) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.type = type;
        this.eventData = eventData;
        this.allowedNumber = allowedNumber;
        this.isFree = isFree;
        createdAt = new Date(System.currentTimeMillis());
    }

    public NewsEntity(Date createdAt, String title, String description,
                      int image, String viewsCounter, byte type, long eventData, int allowedNumber, String price) {
        this.createdAt = createdAt;
        this.title = title;
        this.description = description;
        this.image = image;
        this.viewsCounter = viewsCounter;
        this.type = type;
        this.eventData = eventData;
        this.allowedNumber = allowedNumber;
        this.price = price;
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

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public int getAllowedNumber() {
        return allowedNumber;
    }

    public void setAllowedNumber(int allowedNumber) {
        this.allowedNumber = allowedNumber;
    }

    public long getEventData() {
        return eventData;
    }

    public void setEventData(long eventData) {
        this.eventData = eventData;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String convertDateToTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd hh:mm a", Locale.ENGLISH);
        return dateFormat.format(createdAt);
    }

    public String type() {
        String stringType = "";
        switch (type) {
            case (byte) 0:
                stringType = "News";
                break;
            case (byte) 1:
                stringType = "Event";
                break;
            case (byte) 2:
                stringType = "Training";
                break;

        }

        return stringType;
    }

    @Override
    public String toString() {
        return "NewsEntity{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", createdAt=" + createdAt +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                ", viewsCounter='" + viewsCounter + '\'' +
                ", type=" + type +
                ", eventData=" + eventData +
                ", allowedNumber=" + allowedNumber +
                '}';
    }
}
