package com.project.semicolon.eduactive.database.daos;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import java.util.List;

public interface BaseDao<T> {

    @Insert
    long insert(T entity);

    @Delete
    int delete(T entity);

    @Update
    int update(T entity);

    @Insert
    long[] insert(List<T> tList);



}
