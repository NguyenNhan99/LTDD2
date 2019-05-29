package tdc.edu.myapplication;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Main4Activity extends AppCompatActivity {
    AnimationDrawable animationDrawable;
    Animation animation, animation2;
    ImageView imh1, imh2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        imh1 = (ImageView) findViewById(R.id.h1);
        imh2 = (ImageView) findViewById(R.id.thanos);



        animation = AnimationUtils.loadAnimation(this, R.anim.slidedown);
        imh1.setImageResource(R.drawable.animation1);
        animationDrawable = (AnimationDrawable) imh1.getDrawable();
        animationDrawable.start();
        imh1.startAnimation(animation);

        animation2 = AnimationUtils.loadAnimation(this, R.anim.move);
        imh2.setAnimation(animation);


    }
}
