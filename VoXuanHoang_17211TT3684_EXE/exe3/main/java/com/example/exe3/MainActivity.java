package com.example.exe3;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    ImageView sun, mattrang;
    Button test;
    private float lastX, lastY, lastZ;
    ObjectAnimator cloudAnim2, cloudAnim;
    SensorManager sensorManager;
    private Sensor sensor;
    private float vibrate = 0;
    int i = 1;
    ValueAnimator skyAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animated);
        setControl();
        setSensor();


    }


    private void setSensor(){
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null){
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this,sensor, SensorManager.SENSOR_DELAY_NORMAL);
            vibrate = sensor.getMaximumRange() / 2;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            doihinh(event);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    private void doihinh(SensorEvent event) {
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

    private void setEvent() {
        final AnimatorSet sunSet = (AnimatorSet)AnimatorInflater.loadAnimator(this, R.animator.sun_swing);
        //set the view as target
        sunSet.setTarget(sun);
        //start the animation
        sunSet.start();
        //create a value animator to darken the sky as we move towards and away from the sun
        //passing the view, property and to-from values
        //set same duration and animation properties as others
        skyAnim.setDuration(3000);
        skyAnim.setEvaluator(new ArgbEvaluator());
        skyAnim.setRepeatCount(ValueAnimator.INFINITE);
        skyAnim.setRepeatMode(ValueAnimator.REVERSE);
        //start the animation
        skyAnim.start();

        //create an object animator to move the cloud
        //passing the view, property and to value only
        //same duration and other properties as rest
        cloudAnim.setDuration(3000);
        cloudAnim.setRepeatCount(ValueAnimator.INFINITE);
        cloudAnim.setRepeatMode(ValueAnimator.REVERSE);
        //start the animation
        cloudAnim.start();

        //create an object animator for second cloud
        //same as previous except movement distance

        cloudAnim2.setDuration(3000);
        cloudAnim2.setRepeatCount(ValueAnimator.INFINITE);
        cloudAnim2.setRepeatMode(ValueAnimator.REVERSE);
        cloudAnim2.start();

        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);
        mattrang.setImageResource(R.drawable.mattrang);
        mattrang.startAnimation(animation);
       /* Animation chong = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
        chongchongtre.startAnimation(chong);*/
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cloudAnim.cancel();
                cloudAnim2.cancel();
                sun.clearAnimation();
                mattrang.clearAnimation();
                skyAnim.cancel();
                sunSet.cancel();
                mattrang.setImageResource(R.drawable.cloud);
            }
        });
        }


    public void setControl(){
      //   chongchongtre = (ImageView)findViewById(R.id.imageView);
         mattrang = (ImageView)findViewById(R.id.mattrang);
         sun = (ImageView)findViewById(R.id.sun);
         test = (Button)findViewById(R.id.test);
         cloudAnim2 = ObjectAnimator.ofFloat(findViewById(R.id.cloud2), "x", -300);
         cloudAnim = ObjectAnimator.ofFloat(findViewById(R.id.cloud1), "x", -350);
         skyAnim = ObjectAnimator.ofInt(findViewById(R.id.car_layout), "backgroundColor", Color.rgb(0x66, 0xcc, 0xff), Color.rgb(0x00, 0x66, 0x99));

    }
}
