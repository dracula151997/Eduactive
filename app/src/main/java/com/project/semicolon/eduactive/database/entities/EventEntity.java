package com.project.semicolon.eduactive.database.entities;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.project.semicolon.eduactive.adapters.ListItemViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Entity(tableName = "events")
public class EventEntity extends ListItemViewModel implements Parcelable {
    public static final Creator<EventEntity> CREATOR = new Creator<EventEntity>() {
        @Override
        public EventEntity createFromParcel(Parcel in) {
            return new EventEntity(in);
        }

        @Override
        public EventEntity[] newArray(int size) {
            return new EventEntity[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "event_id")
    public int id;
    @ColumnInfo(name = "event_title")
    private String eventTitle;
    @ColumnInfo(name = "event_desc")
    private String eventDesc;
    @ColumnInfo(name = "event_date")
    private long eventDate;
    @ColumnInfo(name = "event_place")
    private String eventPlace;
    @ColumnInfo(name = "intersted_number")
    private int interestedNum;
    @ColumnInfo(name = "going_number")
    private int goingNum;
    @ColumnInfo(name = "event_image")
    private String image;
    @ColumnInfo(name = "days")
    private String day;

    public EventEntity(String eventTitle, String eventDesc, long eventDate,
                       String eventPlace, int interestedNum, int goingNum, String image, String day) {
        this.eventTitle = eventTitle;
        this.eventDesc = eventDesc;
        this.eventDate = eventDate;
        this.eventPlace = eventPlace;
        this.interestedNum = interestedNum;
        this.goingNum = goingNum;
        this.image = image;
        this.day = day;
    }

    @Ignore
    public EventEntity() {
    }

    @Ignore
    protected EventEntity(Parcel in) {
        id = in.readInt();
        eventTitle = in.readString();
        eventDesc = in.readString();
        eventDate = in.readLong();
        eventPlace = in.readString();
        interestedNum = in.readInt();
        goingNum = in.readInt();
        image = in.readString();
        day = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public long getEventDate() {
        return eventDate;
    }

    public void setEventDate(long eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    public int getInterestedNum() {
        return interestedNum;
    }

    public void setInterestedNum(int interestedNum) {
        this.interestedNum = interestedNum;
    }

    public int getGoingNum() {
        return goingNum;
    }

    public void setGoingNum(int goingNum) {
        this.goingNum = goingNum;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String date() {
        String pattern = "d MMM";
        DateFormat dateFormat = new SimpleDateFormat(pattern, Locale.ENGLISH);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String time() {
        String pattern = "h:mm a";
        DateFormat dateFormat = new SimpleDateFormat(pattern, Locale.ENGLISH);
        Date date = new Date();
        return "Starts " + dateFormat.format(date) + " - " + day + " day(s).";
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(eventTitle);
        parcel.writeString(eventDesc);
        parcel.writeLong(eventDate);
        parcel.writeString(eventPlace);
        parcel.writeInt(interestedNum);
        parcel.writeInt(goingNum);
        parcel.writeString(image);
        parcel.writeString(day);
    }
}
