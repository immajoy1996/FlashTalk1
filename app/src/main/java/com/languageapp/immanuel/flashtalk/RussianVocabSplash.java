package com.languageapp.immanuel.flashtalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class RussianVocabSplash extends AppCompatActivity {

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_vocab_splash);

        /*Toolbar toolbar = findViewById(R.id.toolbar_fragment1);
        toolbar.setTitle("FlashTalk");*/

        Intent intent_received=getIntent();
        final int page_num=intent_received.getIntExtra("PAGE_POSITION",0);
        String vocab_title=intent_received.getStringExtra("VOCAB_TITLE");
        String img_src=intent_received.getStringExtra("IMAGE_SRC");

        TextView title=findViewById(R.id.title);
        CircularImageViewTest circularImageView2=findViewById(R.id.image);

        final Animation anim_wobble = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.wobble);
        anim_wobble.setRepeatCount(Animation.INFINITE);

        circularImageView2.startAnimation(anim_wobble);

        title.setText(vocab_title);

        int id = circularImageView2.getContext().getResources().getIdentifier(img_src, "drawable", circularImageView2.getContext().getPackageName());
        circularImageView2.setImageResource(id);


        timer=new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent_msg=new Intent(getApplicationContext(),RussianVocabActivity.class);
                intent_msg.putExtra("PAGE_POSITION",page_num);
                startActivity(intent_msg);
                finish();
            }
        },1500);
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        timer.cancel();
    }
}
