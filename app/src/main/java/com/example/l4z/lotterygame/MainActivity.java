package com.example.l4z.lotterygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView score1, score2, score3, score4, score5, score6, score7, score8, score9, score10;
    TextView summTeamA, summTeamB;

    int a, b, c, d, e, f, g, h, i, j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score1 = (TextView) findViewById(R.id.score1);
        score2 = (TextView) findViewById(R.id.score2);
        score3 = (TextView) findViewById(R.id.score3);
        score4 = (TextView) findViewById(R.id.score4);
        score5 = (TextView) findViewById(R.id.score5);
        score6 = (TextView) findViewById(R.id.score6);
        score7 = (TextView) findViewById(R.id.score7);
        score8 = (TextView) findViewById(R.id.score8);
        score9 = (TextView) findViewById(R.id.score9);
        score10 = (TextView) findViewById(R.id.score10);

        summTeamA = (TextView) findViewById(R.id.summTeamA);
        summTeamB = (TextView) findViewById(R.id.summTeamB);
    }

    public void startRullete(View view) {
        a = (int) Math.floor(Math.random() * 11);
        b = (int) Math.floor(Math.random() * 11);
        c = (int) Math.floor(Math.random() * 11);
        d = (int) Math.floor(Math.random() * 11);
        e = (int) Math.floor(Math.random() * 11);
        f = (int) Math.floor(Math.random() * 11);
        g = (int) Math.floor(Math.random() * 11);
        h = (int) Math.floor(Math.random() * 11);
        i = (int) Math.floor(Math.random() * 11);
        j = (int) Math.floor(Math.random() * 11);

        score1.setText(Integer.toString(a));
        score2.setText(Integer.toString(b));
        score3.setText(Integer.toString(c));
        score4.setText(Integer.toString(d));
        score5.setText(Integer.toString(e));
        score6.setText(Integer.toString(f));
        score7.setText(Integer.toString(g));
        score8.setText(Integer.toString(h));
        score9.setText(Integer.toString(i));
        score10.setText(Integer.toString(j));

        int A = a+c+e+g+i;
        int B = b+d+f+h+j;
        summTeamA.setText(Integer.toString(A));
        summTeamB.setText(Integer.toString(B));
    }
}

