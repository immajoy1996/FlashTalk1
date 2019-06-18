package com.languageapp.immanuel.flashtalk;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

public class ArabicPreliminaryActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    int STEP_TIME=100;
    //ImageView volume;
    //ImageView pause;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arabic_preliminary);

        TextView explanation1=(TextView)findViewById(R.id.intro);
        //final TextView translation1=(TextView)findViewById(R.id.translation1);

        /*SharedPreferences mPrefs=getApplicationContext().getSharedPreferences("Hints",0);
        String str0=mPrefs.getString("var_Accents","not shown");
        SharedPreferences.Editor mEditor=mPrefs.edit();

        if(str0.equals("not shown")) {

            SpannableString msg1 = new SpannableString("Click for audio. Click the quiz icon at the top to test yourself.");
            //SpannableString msg2=new SpannableString("Click the quiz icon at the end of this lesson to test yourself.");
            (new MyApplication(getApplicationContext())).show_hints(getSupportFragmentManager(), msg1,"-1");
            mEditor.putString("var_Accents","shown");
            mEditor.commit();
        }*/

        String str1="Arabic is read from right to left. Arabic letters connect together like English cursive. The alphabet has 24 letters and each letter has three forms. The form you use depends on if the letter is at the beginning of a word, in the middle, or at the end. This may seem like a lot but the forms are usually very similar and easy to remember.";
        String keyword1="right to left";
        String keyword2="three forms";
        String keyword3="beginning";
        String keyword4="middle";
        String keyword5="end.";
        //String keyword4="о.";


        SpannableString spannableString1=new SpannableString(str1);
        //SpannableString spannableString1_trans=new SpannableString(trans1);
        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str1.indexOf(keyword1),str1.indexOf(keyword1)+keyword1.length(),0);
        //spannableString1.setSpan(new UnderlineSpan(),str1.indexOf(keyword1),str1.indexOf(keyword1)+keyword1.length(),0);

        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str1.indexOf(keyword2),str1.indexOf(keyword2)+keyword2.length(),0);
        //spannableString1.setSpan(new UnderlineSpan(),str1.indexOf(keyword2),str1.indexOf(keyword2)+keyword2.length(),0);

        //spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str1.indexOf(keyword3),str1.indexOf(keyword3)+1,0);
        spannableString1.setSpan(new UnderlineSpan(),str1.indexOf(keyword3),str1.indexOf(keyword3)+keyword3.length(),0);

        //spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str1.indexOf(keyword4),str1.indexOf(keyword4)+1,0);
        spannableString1.setSpan(new UnderlineSpan(),str1.indexOf(keyword4),str1.indexOf(keyword4)+keyword4.length(),0);
        spannableString1.setSpan(new UnderlineSpan(),str1.indexOf(keyword5),str1.indexOf(keyword5)+3,0);

        explanation1.setText(spannableString1);

        ImageButton back_button=findViewById(R.id.back_button);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri);*/
                //volume.setVisibility(View.VISIBLE);
                //pause.setVisibility(View.GONE);
                endit();
                finish();
            }
        });


        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.wobble);
        back_button.startAnimation(anim);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        endit();
    }

    void endit(){
        if(mediaPlayer!=null) {
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer=null;
            //Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/wrong_answer");
            //adapter.mediaPlayer_alphabet= MediaPlayer.create(getContext(),uri);
        }
    }

    void doit(View view, Uri uri){
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(view.getContext(), uri);
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    //mediaPlayer_alphabet.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer=null;
                    //mediaPlayer_alphabet = MediaPlayer.create(vw.getContext(), uri);
                };
            });
            //mediaPlayer_alphabet.release();
        } else if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = MediaPlayer.create(view.getContext(), uri);
            mediaPlayer.start();


            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    //mediaPlayer_alphabet.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer=null;

                };
            });
        }
        else {
            mediaPlayer = MediaPlayer.create(view.getContext(), uri);
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    //mediaPlayer_alphabet.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer=null;
                };
            });

        }
    }
}
