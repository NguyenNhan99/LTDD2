package com.example.layouy_pj;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class GiaiThichDung extends AppCompatActivity {

    SharedPreferences mSharedPreferences;
    SoundClass sou;
    private Button quaytiep;
    private TextView giaithichdung;
    ArrayList<Integer> arraychondung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giai_thich_dung);
        sou = new SoundClass(GiaiThichDung.this);
        mSharedPreferences = getApplicationContext().getSharedPreferences("MyPref", 0);
        arraychondung = new ArrayList<>();
        arraychondung.add(R.raw.chondung01);
        arraychondung.add(R.raw.chondung02);
        arraychondung.add(R.raw.chondung03);
        arraychondung.add(R.raw.chondung04);
        Random random = new Random();
        int vitrinen = random.nextInt(arraychondung.size());
        sou.playSound(arraychondung.get(vitrinen));
        giaithichdung = (TextView) findViewById(R.id.giaithichdung);
        Intent intent = getIntent();
        String values = intent.getStringExtra("msg");
        giaithichdung.setText(values);
        quaytiep = (Button) findViewById(R.id.quaytiepnao);
        quaytiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(GiaiThichDung.this,ManHinhGameActivity.class);
                startActivity(intent1);
            }
        });
    }
}
