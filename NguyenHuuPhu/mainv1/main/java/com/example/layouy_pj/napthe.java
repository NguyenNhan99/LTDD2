package com.example.layouy_pj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class napthe  extends AppCompatActivity {
    ImageView gate1, gate2, gate3, gate4, gate5, gate6, back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.naptien);
        setControl();
        setEvent();
    }

    private void setEvent() {
        gate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), khungnap.class);
                intent.putExtra("nap", "10");
                startActivity(intent);
            }
        });
        gate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), khungnap.class);
                intent.putExtra("nap", "20");
                startActivity(intent);
            }
        });
        gate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), khungnap.class);
                intent.putExtra("nap", "50");
                startActivity(intent);
            }
        });
        gate4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), khungnap.class);
                intent.putExtra("nap", "100");
                startActivity(intent);
            }
        });gate5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), khungnap.class);
                intent.putExtra("nap", "200");
                startActivity(intent);
            }
        });
        gate6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), khungnap.class);
                intent.putExtra("nap", "500");
                startActivity(intent);
            }
        });
        // Quay về Trang Câu Hỏi
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CauHoi.class);
                startActivity(intent);
            }
        });

    }

    private void setControl() {
        gate1 = (ImageView)findViewById(R.id.gate10);
        gate2 = (ImageView)findViewById(R.id.gate20);
        gate3 = (ImageView)findViewById(R.id.gate50);
        gate4 = (ImageView)findViewById(R.id.gate100);
        gate5 = (ImageView)findViewById(R.id.gate200);
        gate6 = (ImageView)findViewById(R.id.gate500);
        back =  (ImageView)findViewById(R.id.back);
    }
}
