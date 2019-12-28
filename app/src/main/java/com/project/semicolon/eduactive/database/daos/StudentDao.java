package com.project.semicolon.eduactive.database.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.project.semicolon.eduactive.database.entities.StudentEntity;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    long insertStudent(StudentEntity student);

    @Insert
    List<Long> insetStudents(List<StudentEntity> students);

    @Query("DELETE FROM students WHERE std_id=:studentId")
    void deleteStudentById(String studentId);

    @Query("DELETE FROM students")
    void deleteAllStudents();

    @Query("SELECT * FROM students WHERE std_id=:studentId AND std_pass=:studentPass")
    StudentEntity studentLogin(String studentId, String studentPass);



}
