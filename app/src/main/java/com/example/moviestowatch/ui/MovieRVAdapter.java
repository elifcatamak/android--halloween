package com.example.moviestowatch.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviestowatch.R;
import com.example.moviestowatch.model.Movie;

import java.util.List;

public class MovieRVAdapter extends RecyclerView.Adapter<MovieRVAdapter.ViewHolder> {
    private List<Movie> movieList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(movieList != null){
            holder.pointTextView.setText(String.valueOf(movieList.get(position).getMoviePt()));
            holder.nameTextView.setText(movieList.get(position).getMovieName());
        }
        else{
            holder.pointTextView.setText("0");
            holder.nameTextView.setText("None");
        }
    }

    @Override
    public int getItemCount() {
        if(movieList == null)
            return 0;

        return movieList.size();
    }

    // In order to set the list on the activity inside observer
    public void setMovieList(List<Movie> newList){
        this.movieList = newList;

        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView pointTextView;
        private TextView nameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pointTextView = itemView.findViewById(R.id.row_point);
            nameTextView = itemView.findViewById(R.id.row_movieName);
        }
    }
}
