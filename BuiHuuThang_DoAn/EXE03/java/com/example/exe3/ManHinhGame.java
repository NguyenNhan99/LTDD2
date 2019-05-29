package com.example.exe3;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Random;

public class ManHinhGame extends AppCompatActivity {

    CustomDialog dialog;

    LinearLayout manhinhgame;
    SoundClass sou;
    private ImageView img01,img02,img03;
    Button datcuoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_game);
        sou = new SoundClass(ManHinhGame.this);
        dialog = new CustomDialog(ManHinhGame.this);
//        Random a = new Random();
//        long x1 = a.nextInt((11000-10000+1)+10000);
//        long x2 = a.nextInt((11000-10000+1)+10000);
//        long x3 = a.nextInt((11000-10000+1)+10000);
//        TranslateAnimation translateXAnimation2 = new TranslateAnimation(0f, 1700f, 0f, 0f);
//        translateXAnimation2.setDuration(900);
//        translateXAnimation2.setFillAfter(true);
//
//        TranslateAnimation translateXAnimation3 = new TranslateAnimation(0f, 1700f, 0f, 0f);
//        translateXAnimation3.setDuration(x3);
//        translateXAnimation3.setFillAfter(true);
        setControl();
        setEvent();
        setDichuyen();
        setDoihinhnen();
        setNhanVat();

    }
    public void setControl(){
        manhinhgame = (LinearLayout) findViewById(R.id.ln_manhinhgame);
        datcuoc = (Button) findViewById(R.id.datcuoc);
        img01 = (ImageView) findViewById(R.id.imageView);
        img02 = (ImageView) findViewById(R.id.imageView2);
        img03 = (ImageView) findViewById(R.id.imageView3);
        sou.playSound(R.raw.r2);
        img01.setImageResource(R.drawable.run01);
        img02.setImageResource(R.drawable.run02);
        img03.setImageResource(R.drawable.run03);
    }
    public void setEvent(){
        datcuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.showDialog(R.layout.dattien_dialog, "dattienDlg", "", null);
            }
        });
    }
    public void setNhanVat(){
        AnimationDrawable run01 = (AnimationDrawable)img01.getDrawable();
        run01.start();
        run01.setVisible(true, true);

        AnimationDrawable run02 = (AnimationDrawable)img02.getDrawable();
        run02.start();
        run02.setVisible(true, true);

        AnimationDrawable run03 = (AnimationDrawable)img03.getDrawable();
        run03.start();
        run03.setVisible(true, true);

    }
    public void setDichuyen(){
        Animation dichuyens1 = AnimationUtils.loadAnimation(this, R.anim.dichuyens1);
        img01.startAnimation(dichuyens1);
        img02.startAnimation(dichuyens1);
        img03.startAnimation(dichuyens1);
    }
    public  void setDoihinhnen(){
        AnimationDrawable an = (AnimationDrawable)manhinhgame.getBackground();
        an.setEnterFadeDuration(1000);
        an.setExitFadeDuration(1000);
        an.start();
    }

}
