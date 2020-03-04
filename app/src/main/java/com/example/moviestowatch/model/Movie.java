package com.example.moviestowatch.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movie_table")
public class Movie {
    @PrimaryKey(autoGenerate = true)
    private long movieId;

    @NonNull
    @ColumnInfo(name = "movie_name")
    private String movieName;

    @ColumnInfo(name = "movie_point")
    private double moviePt;

    public Movie() {
    }

    public Movie(@NonNull String movieName, double moviePt) {
        this.movieName = movieName;
        this.moviePt = moviePt;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(@NonNull String movieName) {
        this.movieName = movieName;
    }

    public double getMoviePt() {
        return moviePt;
    }

    public void setMoviePt(double moviePt) {
        this.moviePt = moviePt;
    }
}
