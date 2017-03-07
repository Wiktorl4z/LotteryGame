package com.example.l4z.lotterygame;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final int MAX = 100, MIN = 0, BAR_COUNT = 5;
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

        List<Integer> points = new ArrayList<>();
        for (int i = 0;  i < 5; i++){
            points.add(generateRandomPoint());
        }

        teamA = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            SelectionBox sb = new SelectionBox();
            Bundle args = new Bundle();
            args.putInt("points", points.get(i));
            sb.setArguments(args);
            teamA.add(sb);
        }

        teamB = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            SelectionBox sb = new SelectionBox();
            Bundle args = new Bundle();
            args.putInt("points", points.get(i));
            sb.setArguments(args);
            teamB.add(sb);
        }

        addToView(teamA, teamViewA);
        addToView(teamB, teamViewB);
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

}


