package tdc.edu.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Animation a,a1;
    Button btn1, btn2;
    ImageView  imv1,imv2, imv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setControl();

        imv2.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.nhatden));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = AnimationUtils.loadAnimation(getApplication(), R.anim.ronate);
                imv3.setAnimation(a);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imv3.clearAnimation();
                Toast.makeText(getApplication(),"Bạn đã có 900 điểm nè hihi", Toast.LENGTH_LONG).show();
            }
        });
    }
    private void setControl() {
        btn1 = (Button) findViewById(R.id.btnP);
        btn2 = (Button) findViewById(R.id.btnT);
        imv1 = (ImageView) findViewById(R.id.iron);
        imv2 = (ImageView) findViewById(R.id.nd);
        imv3 = (ImageView) findViewById(R.id.tn);
    }
}
