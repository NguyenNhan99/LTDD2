package tdc.edu.myapplication;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Main3Activity extends AppCompatActivity {
    AnimationDrawable animationDrawable;
    ImageView imv;
    Button btnC, btnD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setControl();
        setEvent();

    }

    private void setEvent() {
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationDrawable = (AnimationDrawable) imv.getDrawable();
                animationDrawable.start();
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationDrawable.stop();
            }
        });
    }

    private void setControl() {
        imv = (ImageView) findViewById(R.id.game);
        btnD = (Button) findViewById(R.id.dung);
        btnC = (Button) findViewById(R.id.choi);
    }
}
