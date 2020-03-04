package com.example.moviestowatch.data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.moviestowatch.model.Movie;

@Database(entities = {Movie.class}, version = 1)
public abstract class MovieRoomDb extends RoomDatabase {
    private static volatile MovieRoomDb INSTANCE;

    public abstract MovieDao getMovieDao();

    // Singleton
    public static MovieRoomDb getDatabase(final Context context){
        if(INSTANCE == null){
            // Locking
            synchronized (MovieRoomDb.class){
                if(INSTANCE == null){
                    // Creating database
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MovieRoomDb.class, "movie_database")
                            .addCallback(movieDbCallback).build();
                }
            }
        }

        return INSTANCE;
    }

    // Need this callback to override methods
    private static RoomDatabase.Callback movieDbCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            new populateMovieDbAsync(INSTANCE).execute();
        }
    };

    private static class populateMovieDbAsync extends AsyncTask<Void, Void, Void> {
        MovieDao dao;

        private populateMovieDbAsync(MovieRoomDb instance) {
            this.dao = instance.getMovieDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllMovies();

            // For testing
            Movie movieOne = new Movie("Candy", 8);
            dao.insertMovie(movieOne);

            Movie movieTwo = new Movie("Treat", 6.5);
            dao.insertMovie(movieTwo);

            return null;
        }
    }
}
