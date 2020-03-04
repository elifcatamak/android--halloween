package com.example.moviestowatch.util;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.moviestowatch.model.Movie;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {
    private MovieRepository movieRepository;
    private LiveData<List<Movie>> moveList;

    public MovieViewModel(@NonNull Application application) {
        super(application);

        movieRepository = new MovieRepository(application);
        this.moveList = movieRepository.getMovieList();
    }

    public LiveData<List<Movie>> getMovieList(){
        return moveList;
    }

    public void insertMovie(Movie movie){
        movieRepository.insertMovie(movie);
    }
}
