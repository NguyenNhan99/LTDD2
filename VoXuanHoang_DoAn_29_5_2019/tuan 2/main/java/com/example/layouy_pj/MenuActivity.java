package com.example.layouy_pj;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity {

    private ImageView anhmenu;
    private Button choigame,xephang,thoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        setControl();
        setdoianhmenu();
        setevent();
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
                Intent intent = new Intent(MenuActivity.this,ManHinhGameActivity.class);
                startActivity(intent);
            }
        });
    }

}
