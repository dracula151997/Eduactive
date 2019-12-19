package com.project.semicolon.eduactive.database.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.project.semicolon.eduactive.database.entities.CoursesEntity;

import java.util.List;

@Dao
public interface CoursesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertCourse(CoursesEntity course);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertCourses(CoursesEntity... courses);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void updateCourse(CoursesEntity course);

    @Query("DELETE FROM courses")
    void deleteAllCourses();

    @Query("SELECT * FROM courses ORDER BY crs_name ASC")
    LiveData<List<CoursesEntity>> getAllCourses();

    @Delete
    void deleteCourse(CoursesEntity course);

}
