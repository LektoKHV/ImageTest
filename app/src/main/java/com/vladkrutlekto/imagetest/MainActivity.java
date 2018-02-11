package com.vladkrutlekto.imagetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    DrawView shit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shit = findViewById(R.id.shit);
        shit.setImageResource(R.drawable.image);
    }
}
