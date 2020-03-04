package com.example.moviestowatch.util;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.moviestowatch.data.MovieDao;
import com.example.moviestowatch.data.MovieRoomDb;
import com.example.moviestowatch.model.Movie;

import java.util.List;

public class MovieRepository {
    private MovieDao movieDao;
    private LiveData<List<Movie>> movieList;

    public MovieRepository(Application application) {
        MovieRoomDb db = MovieRoomDb.getDatabase(application);

        this.movieDao = db.getMovieDao();
        this.movieList = movieDao.getAllMovies();
    }

    public LiveData<List<Movie>> getMovieList(){
        return movieList;
    }

    public void insertMovie(Movie movie){
        new insertMovieAsync(movieDao).execute(movie);
    }

    private static class insertMovieAsync extends AsyncTask<Movie, Void, Void> {
        MovieDao dao;

        public insertMovieAsync(MovieDao movieDao) {
            this.dao = movieDao;
        }

        @Override
        protected Void doInBackground(Movie... movies) {
            dao.insertMovie(movies[0]);

            return null;
        }
    }
}