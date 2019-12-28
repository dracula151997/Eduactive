package com.project.semicolon.eduactive.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.project.semicolon.eduactive.R;
import com.project.semicolon.eduactive.database.daos.NewsDao;
import com.project.semicolon.eduactive.database.daos.StudentDao;
import com.project.semicolon.eduactive.database.entities.CoursesEntity;
import com.project.semicolon.eduactive.database.entities.DepartmentEntity;
import com.project.semicolon.eduactive.database.entities.EmployeesEntity;
import com.project.semicolon.eduactive.database.entities.ExamsBankEntity;
import com.project.semicolon.eduactive.database.entities.InstructorsEntity;
import com.project.semicolon.eduactive.database.entities.LabsEntity;
import com.project.semicolon.eduactive.database.entities.NewsEntity;
import com.project.semicolon.eduactive.database.entities.ReportsEntity;
import com.project.semicolon.eduactive.database.entities.StudentEntity;
import com.project.semicolon.eduactive.utils.AppExactors;

import java.util.ArrayList;
import java.util.List;


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
    private static final String DB_NAME = "graduation_project.db";
    private static volatile DatabaseClient instance;

    public abstract StudentDao getStudentDao();

    public abstract NewsDao getNewsDao();

    public static synchronized DatabaseClient getInstance(Context context) {
        if (instance == null) {
            instance = createDatabase(context);
        }

        return instance;
    }

    private static DatabaseClient createDatabase(final Context context) {
        return Room.databaseBuilder(
                context,
                DatabaseClient.class, DB_NAME).
                addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        addStudentList(context);
                    }
                }).build();
    }

    private static void addStudentList(final Context context) {
        AppExactors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                List<StudentEntity> studentList = new ArrayList<>();
                studentList.add(new StudentEntity("800114265", "Hassan Salah", "drty257*",
                        "Mansoura", "Dakhlya", "hassan.s.mohammed1997@gmail"));
                studentList.add(new StudentEntity("800114355", "Khalid Ezzat",
                        "1234@", "Mansoura", "Dakhlya", "kahlid@hmail.com"));

                List<NewsEntity> articleList = new ArrayList<>();
                articleList.add(new NewsEntity("odio. Nam interdum enim non nisi. Aenean eget metus. In",
                        "Sed diam lorem, auctor quis, tristique ac, eleifend vitae, erat. Vivamus nisi. Mauris nulla. Integer urna. Vivamus molestie dapibus ligula. Aliquam erat volutpat. Nulla dignissim. Maecenas ornare egestas ligula. Nullam feugiat placerat velit. Quisque",
                        R.drawable.article_1));
                articleList.add(new NewsEntity("in aliquet lobortis, nisi nibh lacinia orci, consectetuer euismod est",
                        "convallis dolor. Quisque tincidunt pede ac urna. Ut tincidunt vehicula risus. Nulla eget metus eu erat semper rutrum. Fusce dolor quam, elementum at, egestas a, scelerisque sed, sapien. Nunc pulvinar arcu et pede. Nunc sed orci lobortis augue scelerisque mollis. Phasellus libero mauris, aliquam eu, accumsan sed,\n",
                        R.drawable.article_2));
                articleList.add(new NewsEntity("blandit viverra. Donec tempus, lorem fringilla ornare placerat, orci lacus",
                        "scelerisque dui. Suspendisse ac metus vitae velit egestas lacinia. Sed congue, elit sed consequat auctor, nunc nulla vulputate dui, nec tempus mauris erat eget ipsum. Suspendisse sagittis. Nullam vitae diam. Proin dolor. Nulla semper tellus id nunc interdum feugiat. Sed nec metus facilisis lorem tristique aliquet. Phasellus fermentum convallis ligula. Donec luctus aliquet odio. Etiam ligula tortor, dictum eu, placerat eget, venenatis a, magna. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Etiam laoreet, libero et tristique pellentesque, tellus sem mollis dui, in sodales elit erat vitae risus. Duis",
                        R.drawable.article_3));

                getInstance(context)
                        .getStudentDao().insetStudents(studentList);
                getInstance(context)
                        .getNewsDao().insertArticleList(articleList);
            }
        });


    }

}