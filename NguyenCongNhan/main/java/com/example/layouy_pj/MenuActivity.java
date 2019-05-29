package com.example.layouy_pj;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class MenuActivity extends AppCompatActivity {

    SharedPreferences mSharedPreferences;
    SoundClass sou;
    private ImageView anhmenu;
    private Button choigame,xephang,thoat;
    ArrayList<Integer> arraynen;
    ArrayList<Integer> arrayan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        sou = new SoundClass(MenuActivity.this);
        mSharedPreferences = getApplicationContext().getSharedPreferences("MyPref", 0);
        setControl();
        setdoianhmenu();
        setevent();
        arraynen = new ArrayList<>();
        arraynen.add(R.raw.nen01);
        arraynen.add(R.raw.nen02);
        arraynen.add(R.raw.nen03);
        arraynen.add(R.raw.nen04);
        arraynen.add(R.raw.nen05);
        arraynen.add(R.raw.nen06);
        arraynen.add(R.raw.nen07);
        arraynen.add(R.raw.nen08);
        arraynen.add(R.raw.nen09);

        arrayan = new ArrayList<>();
        arrayan.add(R.raw.an01);
        arrayan.add(R.raw.an02);
        arrayan.add(R.raw.an03);

        Random random = new Random();
        int vitrinen = random.nextInt(arraynen.size());
        sou.playSound(arraynen.get(vitrinen));
    }
    public void setControl(){
        anhmenu = (ImageView) findViewById(R.id.anhmenu);
        anhmenu.setImageResource(R.drawable.doianhmenu);
        choigame = (Button) findViewById(R.id.choigame);
    }
    public void setdoianhmenu(){
        AnimationDrawable doianhmenu = (AnimationDrawable)anhmenu.getDrawable();
        doianhmenu.start();
    }
    public void setevent(){
        choigame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int vitrian = random.nextInt(arrayan.size());
                Intent intent = new Intent(MenuActivity.this,ManHinhGameActivity.class);
                startActivity(intent);
                sou.playSound(arrayan.get(vitrian));
            }
        });
    }
}
