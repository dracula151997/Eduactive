package com.project.semicolon.eduactive.database.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.project.semicolon.eduactive.database.entities.NewsEntity;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface NewsDao {

    @Insert(onConflict = REPLACE)
    long insertArticle(NewsEntity article);

    @Insert(onConflict = REPLACE)
    List<Long> insertArticleList(List<NewsEntity> articles);

    @Query("DELETE FROM articles")
    int deleteAllArticles();

    @Query("DELETE FROM articles WHERE article_pk =:id")
    int deleteArticleById(int id);

    @Query("SELECT * FROM articles")
    LiveData<List<NewsEntity>> getAllArticles();

    @Query("SELECT * FROM articles WHERE article_pk=:id")
    NewsEntity getArticleById(int id);


}
