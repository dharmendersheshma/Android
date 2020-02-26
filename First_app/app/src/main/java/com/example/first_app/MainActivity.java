package com.example.first_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Open_Sick_List(View view) {
        Intent i = new Intent(this, SickIck.class);
        startActivity(i);
    }

    public void Open_illusions_List(View view) {
        Intent i = new Intent(this, illusion.class);
        startActivity(i);
    }

    public void Open_emotional_List(View view) {
        Intent i = new Intent(this, emotional.class);
        startActivity(i);
    }

    public void Open_specials_List(View view) {
        Intent i = new Intent(this, specials.class);
        startActivity(i);
    }

    public void Open_trippy_List(View view) {
        Intent i = new Intent(this, trippy.class);
        startActivity(i);
    }
}
