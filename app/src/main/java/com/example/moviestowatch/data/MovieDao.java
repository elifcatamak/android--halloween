package com.example.moviestowatch.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.moviestowatch.model.Movie;

import java.util.List;

@Dao
public interface MovieDao {
    @Insert
    void insertMovie(Movie movie);

    @Query("UPDATE movie_table SET movie_name=:movieName, movie_point=:moviePt WHERE movieId=:movieId")
    int updateMovie(long movieId, String movieName, double moviePt);

    @Query("DELETE FROM movie_table WHERE movieId=:movieId")
    int deleteMovie(long movieId);

    @Query("DELETE FROM movie_table")
    void deleteAllMovies();

    @Query("SELECT * FROM movie_table WHERE movieId=:movieId")
    LiveData<Movie> getMovieById(long movieId);

    @Query("SELECT * FROM movie_table ORDER BY movie_point DESC")
    LiveData<List<Movie>> getAllMovies();
}
