package com.example.l4z.lotterygame;


import android.app.Fragment;
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
                    if (view == toggle3) {
                        toggle1.setChecked(false);
                        toggle2.setChecked(false);
                    }
                    if (view == toggle1) {
                        toggle2.setChecked(false);
                        toggle3.setChecked(false);
                    }
                    if (view == toggle2) {
                        toggle1.setChecked(false);
                        toggle3.setChecked(false);
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
            return drawnNumber * 2;

        }
        if (toggle2.isChecked()) {
            return drawnNumber * 3;
        }
        if (toggle3.isChecked()) {
            return random.nextBoolean() ? drawnNumber * 10 : 0;
        }

        return 0;
    }
}
