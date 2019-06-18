package com.languageapp.immanuel.flashtalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class ArabicSplashActivity extends AppCompatActivity {

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arabic_splash);

        Integer[] d={R.drawable.hot_regions,R.drawable.mosque1,R.drawable.russia_map1};
        String[] descrip={"The U.S. State Departments lists Russian as one of the ten most important critical languages for global security","Arabic course designed by Immanuel Joy","Russia is the world's largest country spanning 11 time zones"};
        int n=d.length;

        int p=1;

        TextView pic=findViewById(R.id.pic);
        TextView des=findViewById(R.id.description);

        pic.setBackgroundResource(d[p]);
        des.setText(descrip[p]);

        timer=new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),ArabicLanguageActivity.class));
                finish();
            }
        },3000);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        timer.cancel();
    }
}
