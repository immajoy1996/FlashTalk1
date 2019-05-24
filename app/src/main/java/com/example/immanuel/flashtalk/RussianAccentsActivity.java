package com.example.immanuel.flashtalk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

public class RussianAccentsActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    int STEP_TIME=100;
    //ImageView volume;
    //ImageView pause;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_accents);

        TextView explanation1=(TextView)findViewById(R.id.intro);
        //final TextView translation1=(TextView)findViewById(R.id.translation1);

        SharedPreferences mPrefs=getApplicationContext().getSharedPreferences("Hints",0);
        String str0=mPrefs.getString("var_Accents","not shown");
        SharedPreferences.Editor mEditor=mPrefs.edit();

        if(str0.equals("not shown")) {

            SpannableString msg1 = new SpannableString("Click for audio. Click the quiz icon at the top to test yourself.");
            //SpannableString msg2=new SpannableString("Click the quiz icon at the end of this lesson to test yourself.");
            (new MyApplication(getApplicationContext())).show_hints(getSupportFragmentManager(), msg1,"-1");
            mEditor.putString("var_Accents","shown");
            mEditor.commit();
        }

        String str1="Russian words aren't always pronounced like they're written. When the letter о is unstressed, it sounds like а. See if you can hear it. These stresses are never written. You'll get the hang of it!";
        //String keyword1="о in";
        String keyword2="а.";
        String keyword3="о is";
        //String keyword4="о.";


        SpannableString spannableString1=new SpannableString(str1);
        //SpannableString spannableString1_trans=new SpannableString(trans1);
        //spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str1.indexOf(keyword1),str1.indexOf(keyword1)+1,0);
        //spannableString1.setSpan(new StyleSpan(Typeface.BOLD),str1.indexOf(keyword1),str1.indexOf(keyword1)+1,0);

        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str1.indexOf(keyword2),str1.indexOf(keyword2)+1,0);
        spannableString1.setSpan(new StyleSpan(Typeface.BOLD),str1.indexOf(keyword2),str1.indexOf(keyword2)+1,0);

        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str1.indexOf(keyword3),str1.indexOf(keyword3)+1,0);
        spannableString1.setSpan(new StyleSpan(Typeface.BOLD),str1.indexOf(keyword3),str1.indexOf(keyword3)+1,0);

        //spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str1.indexOf(keyword4),str1.indexOf(keyword4)+1,0);
        //spannableString1.setSpan(new StyleSpan(Typeface.BOLD),str1.indexOf(keyword4),str1.indexOf(keyword4)+1,0);

        explanation1.setText(spannableString1);

        final Uri uri1=Uri.parse("android.resource://"+this.getPackageName()+"/raw/idontunderstand_fragment1_verb1"); // header1
        final Uri uri2=Uri.parse("android.resource://"+this.getPackageName()+"/raw/idontunderstand_fragment1_verb2");
        final Uri uri3=Uri.parse("android.resource://"+this.getPackageName()+"/raw/idontunderstand_fragment1_verb3");

        TextView linearLayout1=findViewById(R.id.example1);
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doit(view,uri1);

            }
        });

        TextView linearLayout2=findViewById(R.id.example2);
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri2);
                mediaPlayer.start();*/
                doit(view,uri2);
            }
        });

        TextView linearLayout3=findViewById(R.id.example3);
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri3);
                mediaPlayer.start();*/
                doit(view,uri3);
            }
        });

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


        CircularImageViewTest games=findViewById(R.id.games);
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri);*/
                final Uri uri_swoosh=Uri.parse("android.resource://"+view.getContext().getPackageName()+"/raw/swoosh");
                doit(view,uri_swoosh);
                Intent intent=new Intent(view.getContext(),RussianLessonGamesSplashActivity.class);
                intent.putExtra("LESSON_NAME","Accents");
                //pause.setVisibility(View.GONE);
                //volume.setVisibility(View.VISIBLE);
                startActivity(intent);
            }
        });

        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.wobble);
        back_button.startAnimation(anim);
        games.startAnimation(anim);

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
