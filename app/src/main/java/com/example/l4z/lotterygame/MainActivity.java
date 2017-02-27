package com.example.l4z.lotterygame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView summTeamA, summTeamB;
    private ArrayList<SelectionBox> teamA, teamB;
    private LinearLayout teamViewA, teamViewB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamViewA = (LinearLayout) findViewById(R.id.TeamAContainer);
        teamViewB = (LinearLayout) findViewById(R.id.TeamBContainer);

        summTeamA = (TextView) findViewById(R.id.summTeamA);
        summTeamB = (TextView) findViewById(R.id.summTeamB);

        teamA = new ArrayList<>();
        teamA.add(new SelectionBox());
        teamA.add(new SelectionBox());
        teamA.add(new SelectionBox());
        teamA.add(new SelectionBox());

        teamB = new ArrayList<>();
        teamB.add(new SelectionBox());
        teamB.add(new SelectionBox());
        teamB.add(new SelectionBox());
        teamB.add(new SelectionBox());

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
        int a = 0, b = 0;
        for (SelectionBox sb : teamA) {
            a += sb.getScore();
        }
        for (SelectionBox sb : teamB) {
            b += sb.getScore();
        }
        summTeamA.setText(a+"");
        summTeamB.setText(b+"");

    }

    /*CompoundButton.OnCheckedChangeListener changeChecker = new CompoundButton.OnCheckedChangeListener() {*/

     /*   @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                switch (buttonView){
                    case 1:
                        buttonView == toggle1;
                        toggle2.setChecked(false);
                        toggle3.setChecked(false);
                        break;
                    case 2:
                        (buttonView == toggle2) {
                        toggle1.setChecked(false);
                        toggle3.setChecked(false);

                    }
                    if (buttonView == toggle3) {
                        toggle1.setChecked(false);
                        toggle2.setChecked(false);
                    }

                }
            }
        }*/

}


