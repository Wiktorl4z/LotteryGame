package com.example.l4z.lotterygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView score1, score2, score3, score4, score5, score6, score7, score8, score9, score10;
    TextView summTeamA, summTeamB;
    ImageView imageView0, imageView1, imageView2, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11;
    ImageView imageView12, imageView13, imageView14, imageView15, imageView16, imageView17, imageView18, imageView19, imageView20, imageView21, imageView22;
    ImageView imageView23, imageView24, imageView25, imageView26, imageView27, imageView28, imageView29, imageView30;
    ToggleButton toggle1, toggle2, toggle3;
    int a, b, c, d, e, f, g, h, i, j;

    // int[] myImageList = new int[]{R.drawable.img_0, R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4};

    Random random = new Random();


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

        toggle1 = (ToggleButton) findViewById(R.id.toggle1);
        toggle2 = (ToggleButton) findViewById(R.id.toggle2);
        toggle3 = (ToggleButton) findViewById(R.id.toggle3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView8 = (ImageView) findViewById(R.id.imageView8);
        imageView9 = (ImageView) findViewById(R.id.imageView9);
        imageView10 = (ImageView) findViewById(R.id.imageView10);
        imageView11 = (ImageView) findViewById(R.id.imageView11);
        imageView12 = (ImageView) findViewById(R.id.imageView12);
        imageView13 = (ImageView) findViewById(R.id.imageView13);
        imageView14 = (ImageView) findViewById(R.id.imageView14);
        imageView15 = (ImageView) findViewById(R.id.imageView15);
        imageView16 = (ImageView) findViewById(R.id.imageView16);
        imageView17 = (ImageView) findViewById(R.id.imageView17);
        imageView18 = (ImageView) findViewById(R.id.imageView18);
        imageView19 = (ImageView) findViewById(R.id.imageView19);
        imageView20 = (ImageView) findViewById(R.id.imageView20);
        imageView21 = (ImageView) findViewById(R.id.imageView21);
        imageView22 = (ImageView) findViewById(R.id.imageView22);
        imageView23 = (ImageView) findViewById(R.id.imageView23);
        imageView24 = (ImageView) findViewById(R.id.imageView24);
        imageView25 = (ImageView) findViewById(R.id.imageView25);
        imageView26 = (ImageView) findViewById(R.id.imageView26);
        imageView27 = (ImageView) findViewById(R.id.imageView27);
        imageView28 = (ImageView) findViewById(R.id.imageView28);
        imageView29 = (ImageView) findViewById(R.id.imageView29);
        imageView30 = (ImageView) findViewById(R.id.imageView30);

        toggle1.setOnCheckedChangeListener(changeChecker);
        toggle2.setOnCheckedChangeListener(changeChecker);
        toggle3.setOnCheckedChangeListener(changeChecker);

    }

    CompoundButton.OnCheckedChangeListener changeChecker = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                if (buttonView == toggle1) {
                    toggle2.setChecked(false);
                    toggle3.setChecked(false);

                }
                if (buttonView == toggle2) {
                    toggle1.setChecked(false);
                    toggle3.setChecked(false);

                }
                if (buttonView == toggle3) {
                    toggle1.setChecked(false);
                    toggle2.setChecked(false);
                }
            }
        }
    };


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

            int A = a + c + e + g + i;
            int B = b + d + f + h + j;
            summTeamA.setText(Integer.toString(A));
            summTeamB.setText(Integer.toString(B));
        }
}

/*    public void startImage(View view) {


        Integer rand = random.nextInt(myImageList.length - 1);
        imageView0.setImageResource(myImageList[rand]);
        imageView1.setImageResource(myImageList[rand]);
        imageView2.setImageResource(myImageList[rand]);
        imageView4.setImageResource(myImageList[rand]);
        imageView5.setImageResource(myImageList[rand]);
        imageView6.setImageResource(myImageList[rand]);
        imageView7.setImageResource(myImageList[rand]);
        imageView8.setImageResource(myImageList[rand]);
        imageView9.setImageResource(myImageList[rand]);
        imageView10.setImageResource(myImageList[rand]);
        imageView11.setImageResource(myImageList[rand]);
        imageView12.setImageResource(myImageList[rand]);
        imageView13.setImageResource(myImageList[rand]);
        imageView14.setImageResource(myImageList[rand]);
        imageView15.setImageResource(myImageList[rand]);
        imageView16.setImageResource(myImageList[rand]);
        imageView17.setImageResource(myImageList[rand]);
        imageView18.setImageResource(myImageList[rand]);
        imageView19.setImageResource(myImageList[rand]);
        imageView20.setImageResource(myImageList[rand]);
        imageView21.setImageResource(myImageList[rand]);
        imageView22.setImageResource(myImageList[rand]);
        imageView23.setImageResource(myImageList[rand]);
        imageView24.setImageResource(myImageList[rand]);


    }*/


