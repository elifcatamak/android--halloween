package com.example.moviestowatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewMovieActivity extends AppCompatActivity {
    private EditText movieNameEditText;
    private EditText moviePointEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_movie);

        movieNameEditText = findViewById(R.id.newMovie_et_name);
        moviePointEditText = findViewById(R.id.newMovie_et_point);
        saveButton = findViewById(R.id.newMovie_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String movieName;
                double moviePoint = 0;

                Intent intent = new Intent();

                if(movieNameEditText.getText().toString().isEmpty()){
                    setResult(RESULT_CANCELED, intent);
                    finish();
                }
                else{
                    movieName = movieNameEditText.getText().toString().trim();

                    if(!moviePointEditText.getText().toString().isEmpty()){
                        moviePoint = Double.parseDouble(moviePointEditText.getText().toString().trim());

                        if(moviePoint<0 || moviePoint > 10)
                        {
                            Toast.makeText(NewMovieActivity.this, "Must be between 0 and 10", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            intent.putExtra("movieName", movieName);
                            intent.putExtra("moviePoint", moviePoint);

                            setResult(RESULT_OK, intent);
                            finish();
                        }
                    }
                    else{
                        intent.putExtra("movieName", movieName);

                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }
            }
        });
    }
}
