package com.project.semicolon.eduactive.database.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.project.semicolon.eduactive.database.entities.ExamsBankEntity;

import java.util.List;

@Dao
public interface ExamsBankDao extends BaseDao<ExamsBankEntity>{

    @Query("SELECT * FROM exams_bank WHERE course_name =:name")
    LiveData<List<ExamsBankEntity>> searchByName(String name);

    @Query("SELECT * FROM exams_bank WHERE level =:level OR exam_year =:year OR course_name =:courseName" )
    LiveData<List<ExamsBankEntity>> filter(byte level, String year, String courseName);

    @Query("SELECT * FROM exams_bank ORDER BY course_name")
    LiveData<List<ExamsBankEntity>> getAllExams();



}
