package tdc.edu.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Animation animation, animation1, animation2;
    Button btnGT, btnB;
    ImageView imvB, imv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();

    }

    private void setEvent() {
        animation = AnimationUtils.loadAnimation(this, R.anim.getstarted);
        animation1 = AnimationUtils.loadAnimation(this, R.anim.ballon);
        animation2 = AnimationUtils.loadAnimation(this, R.anim.getstarted);
        btnGT.setAnimation(animation);
        imvB.setAnimation(animation1);

        btnGT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent);
            }
        });
    }

    private void setControl() {
        btnGT = (Button) findViewById(R.id.btnGT);
        btnB = (Button) findViewById(R.id.btnB);
        imvB = (ImageView) findViewById(R.id.imvT);
        imv1 = (ImageView) findViewById(R.id.imv1);
    }
}
