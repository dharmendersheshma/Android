package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreA = 0;
    int scoreB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * Displays the given score for Team A.
     */

    public void displayForTeamA(int score) {
        TextView scoreViewA = (TextView) findViewById(R.id.team_a_score);
        scoreViewA.setText(String.valueOf(score));
    }
    public void displayForTeamB(int score) {
        TextView scoreViewA = (TextView) findViewById(R.id.team_b_score);
        scoreViewA.setText(String.valueOf(score));
    }

    public void team_A_increment_by_3(View view){
        scoreA = scoreA + 3;
        displayForTeamA(scoreA);
    }
    public void team_A_increment_by_2(View view){
        scoreA = scoreA + 2;
        displayForTeamA(scoreA);
    }
    public void team_A_increment_by_1(View view){
        scoreA = scoreA + 1;
        displayForTeamA(scoreA);
    }

    public void team_B_increment_by_3(View view){
        scoreB = scoreB + 3;
        displayForTeamB(scoreB);
    }
    public void team_B_increment_by_2(View view){
        scoreB = scoreB + 2;
        displayForTeamB(scoreB);
    }
    public void team_B_increment_by_1(View view){
        scoreB = scoreB + 1;
        displayForTeamB(scoreB);
    }

    public void set_zero(View view) {
        scoreA = 0;
        scoreB = 0;
        displayForTeamA(0);
        displayForTeamB(0);
    }

}
