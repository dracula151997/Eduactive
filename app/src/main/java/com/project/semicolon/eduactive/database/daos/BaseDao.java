package com.project.semicolon.eduactive.database.daos;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

public interface BaseDao<T> {

    @Insert(onConflict = REPLACE)
    long insert(T entity);

    @Delete
    int delete(T entity);

    @Update
    int update(T entity);

    @Insert(onConflict = REPLACE)
    long[] insert(List<T> tList);



}
