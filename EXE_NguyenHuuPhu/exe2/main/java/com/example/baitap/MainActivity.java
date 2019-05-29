package com.example.baitap;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private List<XucXac> xucxacList;
    private RecyclerView recyclerView;
    private Adapter XucxacAdapter;
    SensorManager sensorManager;
    private Sensor sensor;
    private float vibrate = 0;
    private float lastX, lastY, lastZ;
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    private void setSensor(){
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(sensor.TYPE_ACCELEROMETER) != null){
            sensor =  sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
            vibrate = sensor.getMaximumRange() / 2;
        }
    }
    private void doiHinh(SensorEvent event) {
        float DeltaX = Math.abs(lastX - event.values[0]);
        float DeltaY = Math.abs(lastY - event.values[1]);
        float DeltaZ = Math.abs(lastZ - event.values[2]);
        if (DeltaX > vibrate){
            setEvent();
        }
        if (DeltaY > vibrate){
            setEvent();
        }
        if (DeltaZ > vibrate){
            setEvent();
        }

        lastX = event.values[0];
        lastY = event.values[1];
        lastZ = event.values[2];
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            doiHinh(event);
        }
    }

    RadioButton nai,bau,ga,ca,cua,tom;
    ImageView imgs;
    Button btnNhap,btnThoat;
    ArrayList<Integer> arrayImg1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        addControl();
        setSensor();
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

    }
    public void setControl(){
        btnThoat = findViewById(R.id.thoat);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Thoát",Toast.LENGTH_LONG).show();
                finish();
            }
        });
        imgs = (ImageView) findViewById(R.id.imgxucxac1);
        btnNhap = (Button) findViewById(R.id.btnNhap);
        nai = (RadioButton) findViewById(R.id.nai);
        bau = (RadioButton) findViewById(R.id.bau);
        ga = (RadioButton) findViewById(R.id.ga);
        ca = (RadioButton) findViewById(R.id.ca);
        cua = (RadioButton) findViewById(R.id.cua);
        tom = (RadioButton) findViewById(R.id.tom);

        arrayImg1 = new ArrayList<>();

        arrayImg1.add(R.drawable.bau);
        arrayImg1.add(R.drawable.ca);
        arrayImg1.add(R.drawable.cua);
        arrayImg1.add(R.drawable.ga);
        arrayImg1.add(R.drawable.nai);
        arrayImg1.add(R.drawable.tom);

    }
    public void setEvent(){
        XucXac xucxac = new XucXac();
        xucxacList.add(xucxac);
        XucxacAdapter.notifyDataSetChanged();

        Random random = new Random();

        int xx = random.nextInt(arrayImg1.size());

        if(nai.isChecked()){
            if(xx == 0)
            {
                Toast.makeText(getApplicationContext(), "THẮNG", Toast.LENGTH_LONG).show();
                xucxac.setKetqua("THẮNG");
            }else {
                Toast.makeText(getApplicationContext(), "THUA", Toast.LENGTH_LONG).show();
                xucxac.setKetqua("THUA");
            }
        }
        else if (bau.isChecked())
        {
            if(xx == 1 )
            {
                Toast.makeText(getApplicationContext(), "THẮNG", Toast.LENGTH_LONG).show();
                xucxac.setKetqua("THẮNG");
            }else {
                Toast.makeText(getApplicationContext(), "THUA", Toast.LENGTH_LONG).show();
                xucxac.setKetqua("THUA");
            }
        }
        else if (ga.isChecked())
        {
            if(xx == 2)
            {
                Toast.makeText(getApplicationContext(), "THẮNG", Toast.LENGTH_LONG).show();
                xucxac.setKetqua("THẮNG");
            }else {
                Toast.makeText(getApplicationContext(), "THUA", Toast.LENGTH_LONG).show();
                xucxac.setKetqua("THUA");
            }
        }
        else if (ca.isChecked())
        {
            if(xx == 3)
            {
                Toast.makeText(getApplicationContext(), "THẮNG", Toast.LENGTH_LONG).show();
                xucxac.setKetqua("THẮNG");
            }else {
                Toast.makeText(getApplicationContext(), "THUA", Toast.LENGTH_LONG).show();
                xucxac.setKetqua("THUA");
            }
        }
        else if (cua.isChecked())
        {
            if(xx == 4)
            {
                Toast.makeText(getApplicationContext(), "THẮNG", Toast.LENGTH_LONG).show();
                xucxac.setKetqua("THẮNG");
            }else {
                Toast.makeText(getApplicationContext(), "THUA", Toast.LENGTH_LONG).show();
                xucxac.setKetqua("THUA");
            }
        }
        else if (tom.isChecked())
        {
            if(xx == 5)
            {
                Toast.makeText(getApplicationContext(), "THẮNG", Toast.LENGTH_LONG).show();
                xucxac.setKetqua("THẮNG");
            }else {
                Toast.makeText(getApplicationContext(), "THUA", Toast.LENGTH_LONG).show();
                xucxac.setKetqua("THUA");
            }
        }
        imgs.setImageResource(arrayImg1.get(xx));

        if(xx == 0)
        {
            xucxac.setIcon1(R.drawable.nai);
        }
        else if(xx == 1)
        {
            xucxac.setIcon1(R.drawable.bau);

        }
        else if(xx == 2 )
        {
            xucxac.setIcon1(R.drawable.ga);
        }
        else if(xx == 3)
        {
            xucxac.setIcon1(R.drawable.ca);
        }
        else if(xx == 4)
        {
            xucxac.setIcon1(R.drawable.cua);
        }
        else if(xx == 5)
        {
            xucxac.setIcon1(R.drawable.tom);
        }

    }
    private void addControl() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        xucxacList = new ArrayList<>();
        XucxacAdapter = new Adapter(this,xucxacList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(XucxacAdapter);
    }
    private void addEvent() {
        createData1();
    }
    public void createData1() {

    }
    public void reset() {
        imgs.setImageResource(R.drawable.baucua);
    }
}
