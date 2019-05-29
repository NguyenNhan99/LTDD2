package com.example.exe3;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {


    SharedPreferences mSharedPreferences;
    ImageView may01,may02,may03;
    CustomDialog dialog;
    SoundClass sou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new CustomDialog(MainActivity.this);
        sou = new SoundClass(MainActivity.this);
        mSharedPreferences = getApplicationContext().getSharedPreferences("MyPref", 0);
        setControl();
        setEvent();
    }
    public void setControl(){
        may01 = (ImageView) findViewById(R.id.may01);
        may02 = (ImageView) findViewById(R.id.may02);
        may03 = (ImageView) findViewById(R.id.may03);

    }
    public void setEvent(){

        Animation dichuyenmay01 = AnimationUtils.loadAnimation(this, R.anim.dichuyenmay01);
        may01.startAnimation(dichuyenmay01);
        dichuyenmay01.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Animation dichuyenmay02 = AnimationUtils.loadAnimation(this, R.anim.dichuyenmay02);
        may02.startAnimation(dichuyenmay02);

        Animation dichuyenmay03 = AnimationUtils.loadAnimation(this, R.anim.dichuyenmay03);
        may03.startAnimation(dichuyenmay03);

        final ImageButton play = (ImageButton) findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sou.playSound(R.raw.play);
                Intent intent = new Intent(MainActivity.this, ManHinhGame.class);
                startActivity(intent);
            }
        });

        final ImageButton exit = (ImageButton) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sou.playSound(R.raw.buttons);

                dialog.showDialog(R.layout.purple_dialog, "exitDlg", "Bạn có muốn thoát ?", null);
            }
        });
        final ImageButton sound = (ImageButton) findViewById(R.id.sound);

        if (mSharedPreferences.getInt("sound", 1) == 1) {
            sound.setBackgroundResource(R.drawable.button_sound_on_main);
        } else {
            sound.setBackgroundResource(R.drawable.button_sound_off_main);
        }

        final SharedPreferences.Editor e = mSharedPreferences.edit();
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mSharedPreferences.getInt("sound", 1) == 1) {
                    e.putInt("sound", 0);
                    e.commit();
                    sound.setBackgroundResource(R.drawable.button_sound_off_main);
                } else {
                    e.putInt("sound", 1);
                    e.commit();
                    sound.setBackgroundResource(R.drawable.button_sound_on_main);
                    sou.playSound(R.raw.r1);
                    sou.playSound(R.raw.buttons);
                }
            }
        });
    }
}
