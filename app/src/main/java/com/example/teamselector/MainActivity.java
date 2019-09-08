package com.example.teamselector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText teamOne;
    private EditText teamTwo;
    private TextView result;
    private Button teamSelectionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Stores string resource in variable
        teamOne = findViewById(R.id.team_one);
        teamTwo = findViewById(R.id.team_two);
        teamSelectionButton = findViewById(R.id.select_team);
        result = findViewById(R.id.result_here);

        teamSelectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Reads text in EditTexts
                String firstTeam = teamOne.getText().toString();
                String secondTeam = teamTwo.getText().toString();

                // Checks if two teams are entered
                if (firstTeam.isEmpty()||secondTeam.isEmpty()) {
                    Toast enterTeam = Toast.makeText(MainActivity.this, "Please enter TWO team names", Toast.LENGTH_LONG);
                    enterTeam.show();
                    // Removes prior results if one of the teams is removed
                    result.setText("");
                    return;
                }
                chooseRandomTeam(firstTeam, secondTeam);
            }
        });
    }

    private void chooseRandomTeam(String firstTeam, String secondTeam) {
        // Pick a random boolean
        boolean teamOne = new Random().nextBoolean();

        if (teamOne) {
            result.setText(firstTeam);
        } else {
            result.setText(secondTeam);
        }
        // Added "refresh" animation to make it clear when Team Selection Button is pressed, even with same result
        result.setAlpha(0);
        result.animate().alpha(1);
    }
}