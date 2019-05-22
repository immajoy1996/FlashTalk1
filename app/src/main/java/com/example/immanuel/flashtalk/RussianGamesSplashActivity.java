package com.example.immanuel.flashtalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.Timer;
import java.util.TimerTask;

public class RussianGamesSplashActivity extends AppCompatActivity {

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_games_splash);

        final Animation anim_wobble = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.wobble);
        anim_wobble.setRepeatCount(Animation.INFINITE);

        CircularImageViewTest quiz=findViewById(R.id.quiz);

        quiz.startAnimation(anim_wobble);

        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),RussianGameSelectionActivity.class));
                finish();
            }
        },1500);
    }

    @Override
    public void onBackPressed() {
        timer.cancel();
        super.onBackPressed();
    }
}
