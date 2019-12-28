package com.project.semicolon.eduactive.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.project.semicolon.eduactive.database.daos.NewsDao;
import com.project.semicolon.eduactive.database.daos.NewsDao_Impl;
import com.project.semicolon.eduactive.database.daos.StudentDao;
import com.project.semicolon.eduactive.database.daos.StudentDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class DatabaseClient_Impl extends DatabaseClient {
  private volatile StudentDao _studentDao;

  private volatile NewsDao _newsDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `courses` (`course_pk` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `crs_name` TEXT, `crs_code` TEXT, `crs_hours` INTEGER NOT NULL, `crs_content` TEXT, `crs_group_link` TEXT, `crs_references` TEXT, `instructorId` INTEGER NOT NULL, `departmentId` INTEGER NOT NULL, FOREIGN KEY(`instructorId`) REFERENCES `instructors`(`inst_pk`) ON UPDATE RESTRICT ON DELETE RESTRICT , FOREIGN KEY(`departmentId`) REFERENCES `department`(`dep_pk`) ON UPDATE RESTRICT ON DELETE RESTRICT )");
        _db.execSQL("CREATE  INDEX `index_courses_instructorId` ON `courses` (`instructorId`)");
        _db.execSQL("CREATE  INDEX `index_courses_departmentId` ON `courses` (`departmentId`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `department` (`dep_pk` INTEGER NOT NULL, `dep_name` TEXT, `dep_code` TEXT, `managerId` INTEGER NOT NULL, PRIMARY KEY(`dep_pk`), FOREIGN KEY(`managerId`) REFERENCES `employees`(`emp_pk`) ON UPDATE RESTRICT ON DELETE RESTRICT )");
        _db.execSQL("CREATE  INDEX `index_department_managerId` ON `department` (`managerId`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `employees` (`emp_pk` INTEGER NOT NULL, `emp_name` TEXT, `emp_birth_date` INTEGER, `emp_state` TEXT, `emp_city` TEXT, `emp_address` TEXT, `salary` TEXT, `emp_email` TEXT, `emp_image` BLOB, `emp_tel` TEXT, `emp_mob` TEXT, `departmentId` INTEGER NOT NULL, PRIMARY KEY(`emp_pk`), FOREIGN KEY(`departmentId`) REFERENCES `department`(`dep_pk`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE  INDEX `index_employees_departmentId` ON `employees` (`departmentId`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `exams_bank` (`exam_pk` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `exams_pdf` TEXT, `model_answer` TEXT, `has_model_answer` INTEGER NOT NULL, `exam_year` INTEGER, `instructor_name` TEXT, `exam_type` INTEGER NOT NULL, `level` INTEGER NOT NULL, `course_name` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `instructors` (`inst_pk` INTEGER NOT NULL, `inst_first_name` TEXT, `inst_last_name` TEXT, `inst_code` TEXT, `inst_job_title` TEXT, `inst_image` BLOB, `inst_mobile` TEXT, `inst_telephone` TEXT, `inst_user_name` TEXT, `inst_password` TEXT, `inst_state` TEXT, `inst_city` TEXT, `inst_address` TEXT, `inst_email` TEXT, `created_at` INTEGER, PRIMARY KEY(`inst_pk`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `labs` (`lab_pk` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `labSupervisor` INTEGER NOT NULL, `lab_code` TEXT, `students_num` TEXT, FOREIGN KEY(`labSupervisor`) REFERENCES `employees`(`emp_pk`) ON UPDATE RESTRICT ON DELETE RESTRICT )");
        _db.execSQL("CREATE  INDEX `index_labs_labSupervisor` ON `labs` (`labSupervisor`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `articles` (`article_pk` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `employeeId` INTEGER NOT NULL, `created_at` INTEGER, `article_title` TEXT, `article_desc` TEXT, `article_image` INTEGER NOT NULL, `views_counter` TEXT, FOREIGN KEY(`employeeId`) REFERENCES `employees`(`emp_pk`) ON UPDATE RESTRICT ON DELETE RESTRICT )");
        _db.execSQL("CREATE  INDEX `index_articles_employeeId` ON `articles` (`employeeId`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `reports` (`report_pk` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `studentId` INTEGER NOT NULL, `report_desc` TEXT, `report_title` TEXT, FOREIGN KEY(`studentId`) REFERENCES `students`(`std_pk`) ON UPDATE RESTRICT ON DELETE RESTRICT )");
        _db.execSQL("CREATE  INDEX `index_reports_studentId` ON `reports` (`studentId`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `students` (`std_pk` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `std_id` TEXT, `std_name` TEXT, `std_pass` TEXT, `std_mob` TEXT, `std_city` TEXT, `std_state` TEXT, `std_email` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"0956bc03433a656f85217238fab6c2b8\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `courses`");
        _db.execSQL("DROP TABLE IF EXISTS `department`");
        _db.execSQL("DROP TABLE IF EXISTS `employees`");
        _db.execSQL("DROP TABLE IF EXISTS `exams_bank`");
        _db.execSQL("DROP TABLE IF EXISTS `instructors`");
        _db.execSQL("DROP TABLE IF EXISTS `labs`");
        _db.execSQL("DROP TABLE IF EXISTS `articles`");
        _db.execSQL("DROP TABLE IF EXISTS `reports`");
        _db.execSQL("DROP TABLE IF EXISTS `students`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsCourses = new HashMap<String, TableInfo.Column>(9);
        _columnsCourses.put("course_pk", new TableInfo.Column("course_pk", "INTEGER", true, 1));
        _columnsCourses.put("crs_name", new TableInfo.Column("crs_name", "TEXT", false, 0));
        _columnsCourses.put("crs_code", new TableInfo.Column("crs_code", "TEXT", false, 0));
        _columnsCourses.put("crs_hours", new TableInfo.Column("crs_hours", "INTEGER", true, 0));
        _columnsCourses.put("crs_content", new TableInfo.Column("crs_content", "TEXT", false, 0));
        _columnsCourses.put("crs_group_link", new TableInfo.Column("crs_group_link", "TEXT", false, 0));
        _columnsCourses.put("crs_references", new TableInfo.Column("crs_references", "TEXT", false, 0));
        _columnsCourses.put("instructorId", new TableInfo.Column("instructorId", "INTEGER", true, 0));
        _columnsCourses.put("departmentId", new TableInfo.Column("departmentId", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCourses = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysCourses.add(new TableInfo.ForeignKey("instructors", "RESTRICT", "RESTRICT",Arrays.asList("instructorId"), Arrays.asList("inst_pk")));
        _foreignKeysCourses.add(new TableInfo.ForeignKey("department", "RESTRICT", "RESTRICT",Arrays.asList("departmentId"), Arrays.asList("dep_pk")));
        final HashSet<TableInfo.Index> _indicesCourses = new HashSet<TableInfo.Index>(2);
        _indicesCourses.add(new TableInfo.Index("index_courses_instructorId", false, Arrays.asList("instructorId")));
        _indicesCourses.add(new TableInfo.Index("index_courses_departmentId", false, Arrays.asList("departmentId")));
        final TableInfo _infoCourses = new TableInfo("courses", _columnsCourses, _foreignKeysCourses, _indicesCourses);
        final TableInfo _existingCourses = TableInfo.read(_db, "courses");
        if (! _infoCourses.equals(_existingCourses)) {
          throw new IllegalStateException("Migration didn't properly handle courses(com.project.semicolon.eduactive.database.entities.CoursesEntity).\n"
                  + " Expected:\n" + _infoCourses + "\n"
                  + " Found:\n" + _existingCourses);
        }
        final HashMap<String, TableInfo.Column> _columnsDepartment = new HashMap<String, TableInfo.Column>(4);
        _columnsDepartment.put("dep_pk", new TableInfo.Column("dep_pk", "INTEGER", true, 1));
        _columnsDepartment.put("dep_name", new TableInfo.Column("dep_name", "TEXT", false, 0));
        _columnsDepartment.put("dep_code", new TableInfo.Column("dep_code", "TEXT", false, 0));
        _columnsDepartment.put("managerId", new TableInfo.Column("managerId", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDepartment = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysDepartment.add(new TableInfo.ForeignKey("employees", "RESTRICT", "RESTRICT",Arrays.asList("managerId"), Arrays.asList("emp_pk")));
        final HashSet<TableInfo.Index> _indicesDepartment = new HashSet<TableInfo.Index>(1);
        _indicesDepartment.add(new TableInfo.Index("index_department_managerId", false, Arrays.asList("managerId")));
        final TableInfo _infoDepartment = new TableInfo("department", _columnsDepartment, _foreignKeysDepartment, _indicesDepartment);
        final TableInfo _existingDepartment = TableInfo.read(_db, "department");
        if (! _infoDepartment.equals(_existingDepartment)) {
          throw new IllegalStateException("Migration didn't properly handle department(com.project.semicolon.eduactive.database.entities.DepartmentEntity).\n"
                  + " Expected:\n" + _infoDepartment + "\n"
                  + " Found:\n" + _existingDepartment);
        }
        final HashMap<String, TableInfo.Column> _columnsEmployees = new HashMap<String, TableInfo.Column>(12);
        _columnsEmployees.put("emp_pk", new TableInfo.Column("emp_pk", "INTEGER", true, 1));
        _columnsEmployees.put("emp_name", new TableInfo.Column("emp_name", "TEXT", false, 0));
        _columnsEmployees.put("emp_birth_date", new TableInfo.Column("emp_birth_date", "INTEGER", false, 0));
        _columnsEmployees.put("emp_state", new TableInfo.Column("emp_state", "TEXT", false, 0));
        _columnsEmployees.put("emp_city", new TableInfo.Column("emp_city", "TEXT", false, 0));
        _columnsEmployees.put("emp_address", new TableInfo.Column("emp_address", "TEXT", false, 0));
        _columnsEmployees.put("salary", new TableInfo.Column("salary", "TEXT", false, 0));
        _columnsEmployees.put("emp_email", new TableInfo.Column("emp_email", "TEXT", false, 0));
        _columnsEmployees.put("emp_image", new TableInfo.Column("emp_image", "BLOB", false, 0));
        _columnsEmployees.put("emp_tel", new TableInfo.Column("emp_tel", "TEXT", false, 0));
        _columnsEmployees.put("emp_mob", new TableInfo.Column("emp_mob", "TEXT", false, 0));
        _columnsEmployees.put("departmentId", new TableInfo.Column("departmentId", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEmployees = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysEmployees.add(new TableInfo.ForeignKey("department", "NO ACTION", "NO ACTION",Arrays.asList("departmentId"), Arrays.asList("dep_pk")));
        final HashSet<TableInfo.Index> _indicesEmployees = new HashSet<TableInfo.Index>(1);
        _indicesEmployees.add(new TableInfo.Index("index_employees_departmentId", false, Arrays.asList("departmentId")));
        final TableInfo _infoEmployees = new TableInfo("employees", _columnsEmployees, _foreignKeysEmployees, _indicesEmployees);
        final TableInfo _existingEmployees = TableInfo.read(_db, "employees");
        if (! _infoEmployees.equals(_existingEmployees)) {
          throw new IllegalStateException("Migration didn't properly handle employees(com.project.semicolon.eduactive.database.entities.EmployeesEntity).\n"
                  + " Expected:\n" + _infoEmployees + "\n"
                  + " Found:\n" + _existingEmployees);
        }
        final HashMap<String, TableInfo.Column> _columnsExamsBank = new HashMap<String, TableInfo.Column>(9);
        _columnsExamsBank.put("exam_pk", new TableInfo.Column("exam_pk", "INTEGER", true, 1));
        _columnsExamsBank.put("exams_pdf", new TableInfo.Column("exams_pdf", "TEXT", false, 0));
        _columnsExamsBank.put("model_answer", new TableInfo.Column("model_answer", "TEXT", false, 0));
        _columnsExamsBank.put("has_model_answer", new TableInfo.Column("has_model_answer", "INTEGER", true, 0));
        _columnsExamsBank.put("exam_year", new TableInfo.Column("exam_year", "INTEGER", false, 0));
        _columnsExamsBank.put("instructor_name", new TableInfo.Column("instructor_name", "TEXT", false, 0));
        _columnsExamsBank.put("exam_type", new TableInfo.Column("exam_type", "INTEGER", true, 0));
        _columnsExamsBank.put("level", new TableInfo.Column("level", "INTEGER", true, 0));
        _columnsExamsBank.put("course_name", new TableInfo.Column("course_name", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysExamsBank = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesExamsBank = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoExamsBank = new TableInfo("exams_bank", _columnsExamsBank, _foreignKeysExamsBank, _indicesExamsBank);
        final TableInfo _existingExamsBank = TableInfo.read(_db, "exams_bank");
        if (! _infoExamsBank.equals(_existingExamsBank)) {
          throw new IllegalStateException("Migration didn't properly handle exams_bank(com.project.semicolon.eduactive.database.entities.ExamsBankEntity).\n"
                  + " Expected:\n" + _infoExamsBank + "\n"
                  + " Found:\n" + _existingExamsBank);
        }
        final HashMap<String, TableInfo.Column> _columnsInstructors = new HashMap<String, TableInfo.Column>(15);
        _columnsInstructors.put("inst_pk", new TableInfo.Column("inst_pk", "INTEGER", true, 1));
        _columnsInstructors.put("inst_first_name", new TableInfo.Column("inst_first_name", "TEXT", false, 0));
        _columnsInstructors.put("inst_last_name", new TableInfo.Column("inst_last_name", "TEXT", false, 0));
        _columnsInstructors.put("inst_code", new TableInfo.Column("inst_code", "TEXT", false, 0));
        _columnsInstructors.put("inst_job_title", new TableInfo.Column("inst_job_title", "TEXT", false, 0));
        _columnsInstructors.put("inst_image", new TableInfo.Column("inst_image", "BLOB", false, 0));
        _columnsInstructors.put("inst_mobile", new TableInfo.Column("inst_mobile", "TEXT", false, 0));
        _columnsInstructors.put("inst_telephone", new TableInfo.Column("inst_telephone", "TEXT", false, 0));
        _columnsInstructors.put("inst_user_name", new TableInfo.Column("inst_user_name", "TEXT", false, 0));
        _columnsInstructors.put("inst_password", new TableInfo.Column("inst_password", "TEXT", false, 0));
        _columnsInstructors.put("inst_state", new TableInfo.Column("inst_state", "TEXT", false, 0));
        _columnsInstructors.put("inst_city", new TableInfo.Column("inst_city", "TEXT", false, 0));
        _columnsInstructors.put("inst_address", new TableInfo.Column("inst_address", "TEXT", false, 0));
        _columnsInstructors.put("inst_email", new TableInfo.Column("inst_email", "TEXT", false, 0));
        _columnsInstructors.put("created_at", new TableInfo.Column("created_at", "INTEGER", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysInstructors = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesInstructors = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoInstructors = new TableInfo("instructors", _columnsInstructors, _foreignKeysInstructors, _indicesInstructors);
        final TableInfo _existingInstructors = TableInfo.read(_db, "instructors");
        if (! _infoInstructors.equals(_existingInstructors)) {
          throw new IllegalStateException("Migration didn't properly handle instructors(com.project.semicolon.eduactive.database.entities.InstructorsEntity).\n"
                  + " Expected:\n" + _infoInstructors + "\n"
                  + " Found:\n" + _existingInstructors);
        }
        final HashMap<String, TableInfo.Column> _columnsLabs = new HashMap<String, TableInfo.Column>(4);
        _columnsLabs.put("lab_pk", new TableInfo.Column("lab_pk", "INTEGER", true, 1));
        _columnsLabs.put("labSupervisor", new TableInfo.Column("labSupervisor", "INTEGER", true, 0));
        _columnsLabs.put("lab_code", new TableInfo.Column("lab_code", "TEXT", false, 0));
        _columnsLabs.put("students_num", new TableInfo.Column("students_num", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLabs = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysLabs.add(new TableInfo.ForeignKey("employees", "RESTRICT", "RESTRICT",Arrays.asList("labSupervisor"), Arrays.asList("emp_pk")));
        final HashSet<TableInfo.Index> _indicesLabs = new HashSet<TableInfo.Index>(1);
        _indicesLabs.add(new TableInfo.Index("index_labs_labSupervisor", false, Arrays.asList("labSupervisor")));
        final TableInfo _infoLabs = new TableInfo("labs", _columnsLabs, _foreignKeysLabs, _indicesLabs);
        final TableInfo _existingLabs = TableInfo.read(_db, "labs");
        if (! _infoLabs.equals(_existingLabs)) {
          throw new IllegalStateException("Migration didn't properly handle labs(com.project.semicolon.eduactive.database.entities.LabsEntity).\n"
                  + " Expected:\n" + _infoLabs + "\n"
                  + " Found:\n" + _existingLabs);
        }
        final HashMap<String, TableInfo.Column> _columnsArticles = new HashMap<String, TableInfo.Column>(7);
        _columnsArticles.put("article_pk", new TableInfo.Column("article_pk", "INTEGER", true, 1));
        _columnsArticles.put("employeeId", new TableInfo.Column("employeeId", "INTEGER", true, 0));
        _columnsArticles.put("created_at", new TableInfo.Column("created_at", "INTEGER", false, 0));
        _columnsArticles.put("article_title", new TableInfo.Column("article_title", "TEXT", false, 0));
        _columnsArticles.put("article_desc", new TableInfo.Column("article_desc", "TEXT", false, 0));
        _columnsArticles.put("article_image", new TableInfo.Column("article_image", "INTEGER", true, 0));
        _columnsArticles.put("views_counter", new TableInfo.Column("views_counter", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysArticles = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysArticles.add(new TableInfo.ForeignKey("employees", "RESTRICT", "RESTRICT",Arrays.asList("employeeId"), Arrays.asList("emp_pk")));
        final HashSet<TableInfo.Index> _indicesArticles = new HashSet<TableInfo.Index>(1);
        _indicesArticles.add(new TableInfo.Index("index_articles_employeeId", false, Arrays.asList("employeeId")));
        final TableInfo _infoArticles = new TableInfo("articles", _columnsArticles, _foreignKeysArticles, _indicesArticles);
        final TableInfo _existingArticles = TableInfo.read(_db, "articles");
        if (! _infoArticles.equals(_existingArticles)) {
          throw new IllegalStateException("Migration didn't properly handle articles(com.project.semicolon.eduactive.database.entities.NewsEntity).\n"
                  + " Expected:\n" + _infoArticles + "\n"
                  + " Found:\n" + _existingArticles);
        }
        final HashMap<String, TableInfo.Column> _columnsReports = new HashMap<String, TableInfo.Column>(4);
        _columnsReports.put("report_pk", new TableInfo.Column("report_pk", "INTEGER", true, 1));
        _columnsReports.put("studentId", new TableInfo.Column("studentId", "INTEGER", true, 0));
        _columnsReports.put("report_desc", new TableInfo.Column("report_desc", "TEXT", false, 0));
        _columnsReports.put("report_title", new TableInfo.Column("report_title", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysReports = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysReports.add(new TableInfo.ForeignKey("students", "RESTRICT", "RESTRICT",Arrays.asList("studentId"), Arrays.asList("std_pk")));
        final HashSet<TableInfo.Index> _indicesReports = new HashSet<TableInfo.Index>(1);
        _indicesReports.add(new TableInfo.Index("index_reports_studentId", false, Arrays.asList("studentId")));
        final TableInfo _infoReports = new TableInfo("reports", _columnsReports, _foreignKeysReports, _indicesReports);
        final TableInfo _existingReports = TableInfo.read(_db, "reports");
        if (! _infoReports.equals(_existingReports)) {
          throw new IllegalStateException("Migration didn't properly handle reports(com.project.semicolon.eduactive.database.entities.ReportsEntity).\n"
                  + " Expected:\n" + _infoReports + "\n"
                  + " Found:\n" + _existingReports);
        }
        final HashMap<String, TableInfo.Column> _columnsStudents = new HashMap<String, TableInfo.Column>(8);
        _columnsStudents.put("std_pk", new TableInfo.Column("std_pk", "INTEGER", true, 1));
        _columnsStudents.put("std_id", new TableInfo.Column("std_id", "TEXT", false, 0));
        _columnsStudents.put("std_name", new TableInfo.Column("std_name", "TEXT", false, 0));
        _columnsStudents.put("std_pass", new TableInfo.Column("std_pass", "TEXT", false, 0));
        _columnsStudents.put("std_mob", new TableInfo.Column("std_mob", "TEXT", false, 0));
        _columnsStudents.put("std_city", new TableInfo.Column("std_city", "TEXT", false, 0));
        _columnsStudents.put("std_state", new TableInfo.Column("std_state", "TEXT", false, 0));
        _columnsStudents.put("std_email", new TableInfo.Column("std_email", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStudents = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStudents = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStudents = new TableInfo("students", _columnsStudents, _foreignKeysStudents, _indicesStudents);
        final TableInfo _existingStudents = TableInfo.read(_db, "students");
        if (! _infoStudents.equals(_existingStudents)) {
          throw new IllegalStateException("Migration didn't properly handle students(com.project.semicolon.eduactive.database.entities.StudentEntity).\n"
                  + " Expected:\n" + _infoStudents + "\n"
                  + " Found:\n" + _existingStudents);
        }
      }
    }, "0956bc03433a656f85217238fab6c2b8", "15c30067e3a9350430990df3f04f252e");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "courses","department","employees","exams_bank","instructors","labs","articles","reports","students");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `courses`");
      _db.execSQL("DELETE FROM `department`");
      _db.execSQL("DELETE FROM `employees`");
      _db.execSQL("DELETE FROM `exams_bank`");
      _db.execSQL("DELETE FROM `instructors`");
      _db.execSQL("DELETE FROM `labs`");
      _db.execSQL("DELETE FROM `articles`");
      _db.execSQL("DELETE FROM `reports`");
      _db.execSQL("DELETE FROM `students`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public StudentDao getStudentDao() {
    if (_studentDao != null) {
      return _studentDao;
    } else {
      synchronized(this) {
        if(_studentDao == null) {
          _studentDao = new StudentDao_Impl(this);
        }
        return _studentDao;
      }
    }
  }

  @Override
  public NewsDao getNewsDao() {
    if (_newsDao != null) {
      return _newsDao;
    } else {
      synchronized(this) {
        if(_newsDao == null) {
          _newsDao = new NewsDao_Impl(this);
        }
        return _newsDao;
      }
    }
  }
}
