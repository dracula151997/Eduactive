package com.project.semicolon.eduactive.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.project.semicolon.eduactive.database.entities.CoursesEntity;
import com.project.semicolon.eduactive.database.entities.DepartmentEntity;
import com.project.semicolon.eduactive.database.entities.EmployeesEntity;
import com.project.semicolon.eduactive.database.entities.ExamsBankEntity;
import com.project.semicolon.eduactive.database.entities.InstructorsEntity;
import com.project.semicolon.eduactive.database.entities.LabsEntity;
import com.project.semicolon.eduactive.database.entities.NewsEntity;
import com.project.semicolon.eduactive.database.entities.ReportsEntity;
import com.project.semicolon.eduactive.database.entities.StudentEntity;


@Database(entities = {
        CoursesEntity.class,
        DepartmentEntity.class,
        EmployeesEntity.class,
        ExamsBankEntity.class,
        InstructorsEntity.class,
        LabsEntity.class,
        NewsEntity.class,
        ReportsEntity.class,
        StudentEntity.class},
        version = 1)
@TypeConverters(DateConverter.class)
public abstract class DatabaseClient extends RoomDatabase {
    private static final String DB_NAME = "project.db";
    private static volatile DatabaseClient instance;

    public static synchronized DatabaseClient getInstance(Context context) {
        if (instance == null) {
            instance = createDatabase(context);
        }

        return instance;
    }

    private static DatabaseClient createDatabase(Context context) {
        return Room.databaseBuilder(
                context,
                DatabaseClient.class, DB_NAME).build();
    }

}