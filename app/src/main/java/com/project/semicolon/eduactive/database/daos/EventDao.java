package com.project.semicolon.eduactive.database.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.project.semicolon.eduactive.database.entities.EventEntity;

import java.util.List;

@Dao
public interface EventDao extends BaseDao<EventEntity> {

    @Query("SELECT * FROM events")
    LiveData<List<EventEntity>> getAllEvents();

    @Query("SELECT * FROM events WHERE event_id=:eventId")
    LiveData<EventEntity> getSingleEvent(int eventId);

}
