package com.project.semicolon.eduactive.database.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.project.semicolon.eduactive.database.entities.CoursesEntity;

import java.util.List;

@Dao
public interface CoursesDao extends BaseDao<CoursesEntity> {

    @Query("DELETE FROM courses")
    void deleteAllCourses();

    @Query("SELECT * FROM courses ORDER BY crs_name ASC")
    LiveData<List<CoursesEntity>> getAllCourses();

    @Query("SELECT SUM(course_pk) as total FROM courses")
    float sum();





}
