package com.example.layouy_pj;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class khungnap extends AppCompatActivity {
    ImageView bak2;
    EditText ed1;
    Button nap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nap);
        setControl();
        setEvent();
    }

    public void setControl(){
        ed1 = (EditText)findViewById(R.id.nap);
        bak2 = (ImageView)findViewById(R.id.back2);
        nap = (Button)findViewById(R.id.nutnap);
    }
    public void setEvent(){
        nap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(ed1)){
                    Intent intent = getIntent();
                    String nap = intent.getStringExtra("nap");
                    Intent intent2 = new Intent(getApplicationContext(), ManHinhGameActivity.class);

                    intent2.putExtra("naptien", nap);
                    startActivity(intent2);
                    Toast.makeText(getApplicationContext(), "Bạn đã được cộng " + nap + " đồng",Toast.LENGTH_SHORT).show();
                }
            }
        });
        bak2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), napthe.class);
                startActivity(intent);
            }
        });

    }
    public static boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0) {
            return true;
        } else {
            etText.requestFocus();
            etText.setError("Vui lòng điền thông tin!");
            return false;
        }
    }
}
