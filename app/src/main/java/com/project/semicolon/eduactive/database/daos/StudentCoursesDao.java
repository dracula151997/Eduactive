package com.project.semicolon.eduactive.database.daos;

import androidx.room.Dao;
import androidx.room.Query;

import com.project.semicolon.eduactive.database.entities.CoursesEntity;
import com.project.semicolon.eduactive.database.entities.StudentCoursesEntity;
import com.project.semicolon.eduactive.database.entities.StudentEntity;

import java.util.List;

@Dao
public interface StudentCoursesDao extends BaseDao<StudentCoursesEntity> {
    @Query("SELECT * FROM courses AS c INNER JOIN " +
            "student_courses AS sc ON c.course_pk=sc.crsId WHERE sc.stdId=:stdId")
    List<CoursesEntity> getCoursesForStudent(int stdId);

    @Query("SELECT * FROM students as std INNER JOIN student_courses AS sc ON std.std_id=sc.stdId")
    List<StudentEntity> getAllStudents();


}