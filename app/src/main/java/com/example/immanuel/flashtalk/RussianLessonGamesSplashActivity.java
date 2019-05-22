package com.example.immanuel.flashtalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class RussianLessonGamesSplashActivity extends AppCompatActivity {

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_lesson_games_splash);
        Intent received=getIntent();
        final String lesson_name=received.getStringExtra("LESSON_NAME");
        //Toast.makeText(getApplicationContext(),lesson_name,Toast.LENGTH_LONG).show();

        TextView textView=findViewById(R.id.text);
        textView.setText(lesson_name);

        TextView title=findViewById(R.id.title);
        CircularImageViewTest circularImageView2=findViewById(R.id.image);

        final Animation anim_wobble = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.wobble);
        anim_wobble.setRepeatCount(Animation.INFINITE);

        circularImageView2.startAnimation(anim_wobble);

        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),RussianActualLessonGameActivity.class);
                intent.putExtra("LESSON_NAME",lesson_name);
                startActivity(intent);
                finish();
            }
        },1500);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        timer.cancel();
    }
}
