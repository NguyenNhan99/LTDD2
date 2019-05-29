package com.example.animation;

import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageButton btnStart;
    ImageView imva, imv1, imvf, imvVS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        setControl();
        setEvent();


    }

    private void setEvent() {

        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.vs);
        imvVS.startAnimation(animation1);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                List<String> list = Arrays.asList("1win", "2win", "hoa");
                int number = 2;

                for (int i = 0; i < number; i++) {
                    int randomIndex = random.nextInt(list.size());

                    if (list.get(randomIndex) == "1win") {
                        imvVS.setImageResource(R.drawable.bg);
                        setTCwin();
                        imvf.setImageResource(R.drawable.ko);
                    } else if (list.get(randomIndex) == "2win") {
                        imvVS.setImageResource(R.drawable.bg);
                        setTClose();
                        imvf.setImageResource(R.drawable.ko);
                    } else if(list.get(randomIndex) == "hoa")
                    {
                        imvVS.setImageResource(R.drawable.bg);
                        setTChoa();
                        imvf.setImageResource(R.drawable.ko);
                    }


                }

            }
        });

    }

    private void setControl() {
        btnStart = (ImageButton)findViewById(R.id.btnStart);
        imva = (ImageView) findViewById(R.id.imva);
        imv1 = (ImageView)findViewById(R.id.imv1);
        imvf = (ImageView)findViewById(R.id.imvf);
        imvVS = (ImageView)findViewById(R.id.imvVS);

    }

    private void setTCwin()
    {
        Animation animationRotale = AnimationUtils.loadAnimation(this, R.anim.rote );

        imva.setImageResource(R.drawable.run);
        AnimationDrawable run = (AnimationDrawable)imva.getDrawable();
        run.start();
        imva.startAnimation(animationRotale);


        Animation animationRotale1 = AnimationUtils.loadAnimation(this, R.anim.rote1 );

        imv1.setImageResource(R.drawable.die);
        AnimationDrawable die = (AnimationDrawable)imv1.getDrawable();
        die.start();
        imv1.startAnimation(animationRotale1);


        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fight);
        imvf.startAnimation(animation);

    }

    private void setTClose()
    {
        Animation animationRotale = AnimationUtils.loadAnimation(this, R.anim.rote2 );

        imv1.setImageResource(R.drawable.run1);
        AnimationDrawable run1 = (AnimationDrawable)imv1.getDrawable();
        run1.start();
        imv1.startAnimation(animationRotale);


        Animation animationRotale1 = AnimationUtils.loadAnimation(this, R.anim.rote1 );

        imva.setImageResource(R.drawable.bdie);
        AnimationDrawable bdie = (AnimationDrawable)imva.getDrawable();
        bdie.start();
        imva.startAnimation(animationRotale1);


        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fight);
        imvf.startAnimation(animation);

    }

    private void setTChoa()
    {
        Animation animationRotale = AnimationUtils.loadAnimation(this, R.anim.rote2 );

        imv1.setImageResource(R.drawable.run1);
        AnimationDrawable run1 = (AnimationDrawable)imv1.getDrawable();
        run1.start();
        imv1.startAnimation(animationRotale);


        Animation animationRotale1 = AnimationUtils.loadAnimation(this, R.anim.rote );

        imva.setImageResource(R.drawable.run);
        AnimationDrawable run = (AnimationDrawable)imva.getDrawable();
        run.start();
        imva.startAnimation(animationRotale1);


        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fight);
        imvf.startAnimation(animation);

    }



}
