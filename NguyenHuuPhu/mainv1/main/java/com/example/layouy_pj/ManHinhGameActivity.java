package com.example.layouy_pj;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class ManHinhGameActivity extends AppCompatActivity {

    int a, b;
    ArrayList<CauHoi> data;
    Button cautl01,cautl02,cautl03,cautl04;
    TextView CauHoi,tv, coin;
    ImageView imggame;
    CountDownTimer w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_game);
        setCauHoi();
        setControl();
        setEvent();
        w = new CountDownTimer(60000, 1000) {
            public void onTick(long mil) {
                tv.setText("Seconds remaining: " + mil / 1000);
            }

            public void onFinish() {
                tv.setText("Seconds remaining: 0");
            }
        }.start();
    }
    private void setCauHoi() {
        data = new ArrayList<>();
        data.add(new CauHoi("1+1","99","100","200","2","2","thì bằng 2 chứ bằng mấy","ăn lol r !! ",R.drawable.anhmenu02));
        data.add(new CauHoi("a + b","a","b","abc","ab","ab","sao hay quá v","vậy cug sai",R.drawable.anhmenu01));
    }
    public void setControl() {
        CauHoi = (TextView) findViewById(R.id.cauhoi);
        cautl01 = (Button) findViewById(R.id.traloi01);
        cautl02 = (Button) findViewById(R.id.traloi02);
        cautl03 = (Button) findViewById(R.id.traloi03);
        cautl04 = (Button) findViewById(R.id.traloi04);
        imggame = (ImageView) findViewById(R.id.imggame);
        coin = (TextView)findViewById(R.id.coinsValue);
        tv = (TextView) findViewById(R.id.tv);
    }
    private void setEvent() {
        a = 0 + (int) (Math.random() * ((1 - 0) + 1));
        b = 0 + (int) (Math.random() * ((3 - 0) + 1));
        // Cộng Tiền
        int temp = Integer.parseInt(coin.getText().toString());
        Intent intent = getIntent();
        String tien = intent.getStringExtra("naptien");
        int temp2 = Integer.parseInt(tien);
       int cong =  temp + temp2;
        coin.setText(String.valueOf(cong));

        if (a == 1) {
            CauHoi.setText(data.get(a).getCauHoi());
            imggame.setImageResource(data.get(a).getAnhCauHoi());
        }
        if (a == 0) {
            CauHoi.setText(data.get(a).getCauHoi());
            imggame.setImageResource(data.get(a).getAnhCauHoi());
        }
        switch (b){
            case 0:
                cautl01.setText(data.get(a).getCauTL1());
                cautl02.setText(data.get(a).getCauTL2());
                cautl03.setText(data.get(a).getCauTL3());
                cautl04.setText(data.get(a).getCauTL4());

                cautl01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cautl01.getText() == data.get(a).getDapAn()){
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichDung());
                            startActivity(intent);
                        }else {
                            Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichSai());
                            startActivity(intent);
                        }
                    }
                });
                cautl02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cautl02.getText() == data.get(a).getDapAn()){
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichDung());
                            startActivity(intent);
                        }else {
                            Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichSai());
                            startActivity(intent);
                        }
                    }
                });
                cautl03.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cautl03.getText() == data.get(a).getDapAn()){
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichDung());
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichSai());
                        startActivity(intent);
                    }
                    }
                });
                cautl04.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cautl04.getText() == data.get(a).getDapAn()){
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichDung());
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichSai());
                        startActivity(intent);
                    }
                }
            });
                break;
            case 1:
                cautl01.setText(data.get(a).getCauTL2());
                cautl02.setText(data.get(a).getCauTL1());
                cautl03.setText(data.get(a).getCauTL3());
                cautl04.setText(data.get(a).getCauTL4());
                cautl01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cautl01.getText() == data.get(a).getDapAn()){
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichDung());
                            startActivity(intent);
                        }else {
                            Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichSai());
                            startActivity(intent);
                        }
                    }
                });
                cautl02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cautl02.getText() == data.get(a).getDapAn()){
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichDung());
                            startActivity(intent);
                        }else {
                            Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichSai());
                            startActivity(intent);
                        }
                    }
                });
                cautl03.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cautl03.getText() == data.get(a).getDapAn()){
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichDung());
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichSai());
                        startActivity(intent);
                    }
                    }
                });
                cautl04.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cautl04.getText() == data.get(a).getDapAn()){
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichDung());
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichSai());
                        startActivity(intent);
                    }
                }
            });
                break;
            case 2:
                cautl01.setText(data.get(a).getCauTL3());
                cautl02.setText(data.get(a).getCauTL2());
                cautl03.setText(data.get(a).getCauTL1());
                cautl04.setText(data.get(a).getCauTL4());
                cautl01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cautl01.getText() == data.get(a).getDapAn()){
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichDung());
                            startActivity(intent);
                        }else {
                            Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichSai());
                            startActivity(intent);
                        }
                    }
                });
                cautl02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cautl02.getText() == data.get(a).getDapAn()){
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichDung());
                            startActivity(intent);
                        }else {
                            Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichSai());
                            startActivity(intent);
                        }
                    }
                });
                cautl03.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cautl03.getText() == data.get(a).getDapAn()){
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichDung());
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichSai());
                        startActivity(intent);
                    }
                 }
                });
                cautl04.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cautl04.getText() == data.get(a).getDapAn()){
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichDung());
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichSai());
                        startActivity(intent);
                    }
                }
            });
                break;
            case 3:
                cautl01.setText(data.get(a).getCauTL4());
                cautl02.setText(data.get(a).getCauTL2());
                cautl03.setText(data.get(a).getCauTL3());
                cautl04.setText(data.get(a).getCauTL1());
                cautl01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cautl02.getText() == data.get(a).getDapAn()){
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichDung());
                            startActivity(intent);
                        }else {
                            Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichSai());
                            startActivity(intent);
                        }
                    }
                });
                cautl02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cautl02.getText() == data.get(a).getDapAn()){
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichDung());
                            startActivity(intent);
                        }else {
                            Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                            intent.putExtra("msg",data.get(a).getGiaiThichSai());
                            startActivity(intent);
                        }
                    }
                });
                cautl03.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cautl03.getText() == data.get(a).getDapAn()){
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichDung());
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichSai());
                        startActivity(intent);
                    }
                }
                });
                cautl04.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cautl04.getText() == data.get(a).getDapAn()){
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichDung.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichDung());
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(), "Sai r", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ManHinhGameActivity.this,GiaiThichSai.class);
                        intent.putExtra("msg",data.get(a).getGiaiThichSai());
                        startActivity(intent);
                    }
                }
            });
                break;
        }
    }

}
