package com.example.l4z.lotterygame;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final int MAX = 100;
    private static final int MIN = 0;
    private static final int BAR_COUNT = 5;
    private static Random random = new Random();
    private TextView summTeamA, summTeamB;
    private ArrayList<SelectionBox> teamA, teamB;
    private LinearLayout teamViewA, teamViewB;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);

        teamViewA = (LinearLayout) findViewById(R.id.TeamAContainer);
        teamViewB = (LinearLayout) findViewById(R.id.TeamBContainer);

        summTeamA = (TextView) findViewById(R.id.summTeamA);
        summTeamB = (TextView) findViewById(R.id.summTeamB);

        teamA = new ArrayList<>();
        teamB = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SelectionBox sbA = new SelectionBox();
            SelectionBox sbB = new SelectionBox();
            teamA.add(sbA);
            teamB.add(sbB);
        }
        addToView(teamA, teamViewA);
        addToView(teamB, teamViewB);
    }

    @Override
    protected void onStart() {
        super.onStart();
        restartPoints();


    }

    @NonNull
    private List<Integer> getRandomPoints() {
        List<Integer> points = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            points.add(generateRandomPoint());
        }
        return points;
    }

    private void restartPoints() {
        List<Integer> points = getRandomPoints();
        for (int i = 0; i < 5; i++) {
            SelectionBox sbA = teamA.get(i);
            sbA.setNewPoints(points.get(i));
            SelectionBox sbB = teamB.get(i);
            sbB.setNewPoints(points.get(i));

        }
    }

    private void addToView(List<SelectionBox> list, View view) {
        for (int i = 0; i < list.size(); i++) {
            SelectionBox sb = list.get(i);
            getFragmentManager().beginTransaction().add(view.getId(), sb, "Levy").commit();
        }
    }

    public void showScores(View view) {

        playSound(Sound.FIGHT);
        int a = 0, b = 0;
        for (SelectionBox sb : teamA) {
            a += sb.getScore();
        }
        for (SelectionBox sb : teamB) {
            b += sb.getScore();
        }
        summTeamA.setText(a + "");
        summTeamB.setText(b + "");
        showToast();
        restartPoints();
    }

    protected void playSound(Sound sound) {
        if (mp != null) {
            mp.reset();
            mp.release();
        }
        mp = MediaPlayer.create(this, sound.getSound());
        mp.start();
    }

    private int generateRandomPoint() {
        return MIN + random.nextInt(MAX - MIN + 1);
    }

    private void showToast() {
        Context context = getApplicationContext();
        CharSequence teamA = "Team A Win!";
        CharSequence teamB = "Team B Win!";
        int duration = Toast.LENGTH_SHORT;

        String summStringA = summTeamA.getText().toString();
        String summStringB = summTeamB.getText().toString();

        int teamScoresA = Integer.parseInt(summStringA);
        int teamScoresB = Integer.parseInt(summStringB);

        if (teamScoresA > teamScoresB) {
            Toast toast = Toast.makeText(context, teamA, duration);
            toast.show();
        }

        if (teamScoresA < teamScoresB) {
            Toast toast = Toast.makeText(context, teamB, duration);
            toast.show();
        }
    }
}


