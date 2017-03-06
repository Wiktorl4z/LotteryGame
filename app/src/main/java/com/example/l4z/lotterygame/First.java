package com.example.l4z.lotterygame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class First extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
    }

    public void onStartClick(View view) {
        Intent colorsIntent = new Intent(First.this, MainActivity.class);
        startActivity(colorsIntent);
    }

    public void onGuideClick(View view) {
        Intent colorsIntent = new Intent(First.this, Guide.class);
        startActivity(colorsIntent);
    }
}
