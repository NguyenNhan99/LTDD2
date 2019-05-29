package com.example.layouy_pj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GiaiThichSai extends AppCompatActivity {

    private Button quaytiep, nghichoi;
    private TextView giaithichsai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giai_thich_sai);
        giaithichsai = (TextView) findViewById(R.id.giaithichsai);
        Intent intent = getIntent();
        String values = intent.getStringExtra("msg");
        giaithichsai.setText(values);
        quaytiep = (Button) findViewById(R.id.quaytiepnao);
        nghichoi = (Button) findViewById(R.id.nghichoi);

        quaytiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(GiaiThichSai.this,ManHinhGameActivity.class);
                startActivity(intent1);
            }
        });

        nghichoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(GiaiThichSai.this,MenuActivity.class);
                startActivity(intent1);
            }
        });

    }
}
