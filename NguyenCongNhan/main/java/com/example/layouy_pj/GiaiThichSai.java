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

public class GiaiThichSai extends AppCompatActivity {

    SharedPreferences mSharedPreferences;
    SoundClass sou;
    private Button quaytiep;
    private TextView giaithichsai;
    ArrayList<Integer> arraychonsai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giai_thich_sai);
        sou = new SoundClass(GiaiThichSai.this);
        mSharedPreferences = getApplicationContext().getSharedPreferences("MyPref", 0);
        giaithichsai = (TextView) findViewById(R.id.giaithichsai);
        arraychonsai = new ArrayList<>();
        arraychonsai.add(R.raw.sai01);
        arraychonsai.add(R.raw.sai02);
        arraychonsai.add(R.raw.sai03);
        arraychonsai.add(R.raw.sai04);
        arraychonsai.add(R.raw.sai05);
        arraychonsai.add(R.raw.sai06);
        arraychonsai.add(R.raw.sai07);
        arraychonsai.add(R.raw.sai08);
        arraychonsai.add(R.raw.sai09);
        arraychonsai.add(R.raw.sai10);
        arraychonsai.add(R.raw.sai11);
        Random random = new Random();
        int vitrinen = random.nextInt(arraychonsai.size());
        sou.playSound(arraychonsai.get(vitrinen));
        Intent intent = getIntent();
        String values = intent.getStringExtra("msg");
        giaithichsai.setText(values);
        quaytiep = (Button) findViewById(R.id.quaytiepnao);
        quaytiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(GiaiThichSai.this,ManHinhGameActivity.class);
                startActivity(intent1);
            }
        });
    }
}
