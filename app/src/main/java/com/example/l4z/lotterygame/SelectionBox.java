package com.example.l4z.lotterygame;


import android.app.Fragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

public class SelectionBox extends Fragment {

    private static Random random = new Random();
    private ToggleButton toggle1, toggle2, toggle3;
    private TextView score;
    private int drawnNumber;
    private MediaPlayer mp;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_selection_box, container, false);


        toggle1 = (ToggleButton) rootView.findViewById(R.id.toggle1);
        toggle2 = (ToggleButton) rootView.findViewById(R.id.toggle2);
        toggle3 = (ToggleButton) rootView.findViewById(R.id.toggle3);
        score = (TextView) rootView.findViewById(R.id.score);


        View.OnClickListener listener = getOnClickListener();
        toggle1.setOnClickListener(listener);
        toggle2.setOnClickListener(listener);
        toggle3.setOnClickListener(listener);


        startRullete(0, 100);
        return rootView;
    }

    private View.OnClickListener getOnClickListener() {
        View.OnClickListener l = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToggleButton btn = (ToggleButton) view;
                if (btn.isChecked()) {
                    if (view == toggle1) {
                        playSound(Sound.SOUND_ONE);
                        toggle2.setChecked(false);
                        toggle3.setChecked(false);
                    }
                    if (view == toggle2) {
                        playSound(Sound.SOUND_TWO);
                        toggle1.setChecked(false);
                        toggle3.setChecked(false);
                    }
                    if (view == toggle3) {
                        playSound(Sound.SOUND_THREE);
                        toggle1.setChecked(false);
                        toggle2.setChecked(false);
                    }
                }
            }
        };
        return l;
    }

    private void startRullete(int min, int max) {
        drawnNumber = min + random.nextInt(max - min + 1);
        score.setText(drawnNumber + "");
    }

    public int getScore() {
        score.setVisibility(View.VISIBLE);
        if (toggle1.isChecked()) {
            boolean a;
            a = random.nextBoolean();
            if (a == true) {
                return drawnNumber * 4;
            }
            return drawnNumber;
        }
        if (toggle2.isChecked()) {
            return drawnNumber * 2;
        }
        if (toggle3.isChecked()) {
            int i = 0;
            boolean a;
            do {
                a = random.nextBoolean();
                if (a == true) {
                    a = random.nextBoolean();
                    i++;
                }
            }
            while (a && i < 2);
            {
                return a ? drawnNumber * 10 : 0;
            }
        }
        return 0;
    }

    protected void playSound(Sound sound) {
        if (mp != null) {
            mp.reset();
            mp.release();
        }
        mp = MediaPlayer.create(getActivity(), sound.getSound());
        mp.start();
    }
}


