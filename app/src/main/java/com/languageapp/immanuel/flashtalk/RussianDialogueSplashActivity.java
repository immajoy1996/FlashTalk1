package com.languageapp.immanuel.flashtalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class RussianDialogueSplashActivity extends AppCompatActivity {

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_dialogue_splash);

        /*Toolbar toolbar = findViewById(R.id.toolbar_fragment1);
        toolbar.setTitle("FlashTalk");*/

        Intent intent_received=getIntent();
        final String dialog_title=intent_received.getStringExtra("DIALOG_TITLE");
        String img=intent_received.getStringExtra("IMAGE_SRC");

        TextView title=findViewById(R.id.title);
        CircularImageViewTest dialogue_img=findViewById(R.id.image);

        final Animation anim_wobble = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.wobble);
        anim_wobble.setRepeatCount(Animation.INFINITE);

        dialogue_img.startAnimation(anim_wobble);

        title.setText(dialog_title);

        int id = dialogue_img.getContext().getResources().getIdentifier(img, "drawable", dialogue_img.getContext().getPackageName());
        dialogue_img.setImageResource(id);

        timer=new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                switch (dialog_title){

                    case "Dialogue 1 - A Testy Exchange":
                        Intent intent1=new Intent(getApplicationContext(),RussianDialog1Activity.class);
                        //intent1.putExtra("FROM_PAGE","Lang Activity Page");
                        startActivity(intent1);
                        finish();
                        return;
                    case "Dialogue 2 - A Naive Tourist":
                        Intent intent2=new Intent(getApplicationContext(),RussianDialog2Activity.class);
                        //intent1.putExtra("FROM_PAGE","Lang Activity Page");
                        startActivity(intent2);
                        finish();
                        return;
                    case "Dialogue 3 - The United Nations":
                        Intent intent3=new Intent(getApplicationContext(),RussianDialog3Activity.class);
                        //intent1.putExtra("FROM_PAGE","Lang Activity Page");
                        startActivity(intent3);
                        finish();
                        return;
                    case "Dialogue 4 - A Charming Accent":
                        Intent intent4=new Intent(getApplicationContext(),RussianDialog4Activity.class);
                        //intent1.putExtra("FROM_PAGE","Lang Activity Page");
                        startActivity(intent4);
                        finish();
                        return;
                    case "Dialogue 5 - A Rebel":
                        Intent intent5=new Intent(getApplicationContext(),RussianDialog5Activity.class);
                        //intent1.putExtra("FROM_PAGE","Lang Activity Page");
                        startActivity(intent5);
                        finish();
                        return;
                    case "Dialogue 6 - A Rude Waitress":
                        Intent intent6=new Intent(getApplicationContext(),RussianDialog6Activity.class);
                        //intent1.putExtra("FROM_PAGE","Lang Activity Page");
                        startActivity(intent6);
                        finish();
                        return;
                    case "Dialogue 9 - A Very Boring Man":
                        Intent intent9=new Intent(getApplicationContext(),RussianDialog9Activity.class);
                        //intent1.putExtra("FROM_PAGE","Lang Activity Page");
                        startActivity(intent9);
                        finish();
                        return;

                    default: //Main Dialog Page
                        Intent intent0=new Intent(getApplicationContext(),RussianDialogActivity.class);
                        startActivity(intent0);
                        finish();
                        return;
                }
            }
        },1500);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        timer.cancel();
    }
}
