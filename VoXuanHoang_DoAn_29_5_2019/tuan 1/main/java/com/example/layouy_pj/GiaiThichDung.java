package com.example.layouy_pj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GiaiThichDung extends AppCompatActivity {

    private Button quaytiep;
    private TextView giaithichdung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giai_thich_dung);
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
