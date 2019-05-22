package com.example.immanuel.flashtalk;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RussianBePoliteActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    int STEP_TIME=100;
    //ImageView volume;
    //ImageView pause;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_be_polite);

        TextView explanation1=(TextView)findViewById(R.id.intro);
        //final TextView translation1=(TextView)findViewById(R.id.translation1);

        String str1="ты is the friendly way to say \"you\". If you're talking to someone you don't know well, use вы. It can mean either \"you guys\" or a polite \"you\". It's conjugated in the same way. Look at the examples.";
        String keyword1="ты";
        String keyword2="вы.";

        SpannableString spannableString1=new SpannableString(str1);
        //SpannableString spannableString1_trans=new SpannableString(trans1);
        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str1.indexOf(keyword1),str1.indexOf(keyword1)+keyword1.length(),0);
        spannableString1.setSpan(new StyleSpan(Typeface.BOLD),str1.indexOf(keyword1),str1.indexOf(keyword1)+keyword1.length(),0);

        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str1.indexOf(keyword2),str1.indexOf(keyword2)+keyword2.length(),0);
        spannableString1.setSpan(new StyleSpan(Typeface.BOLD),str1.indexOf(keyword2),str1.indexOf(keyword2)+keyword2.length(),0);

        explanation1.setText(spannableString1);

        final Uri uri1=Uri.parse("android.resource://"+this.getPackageName()+"/raw/idontunderstand_fragment1_verb1"); // header1
        final Uri uri2=Uri.parse("android.resource://"+this.getPackageName()+"/raw/idontunderstand_fragment1_verb2");
        final Uri uri3=Uri.parse("android.resource://"+this.getPackageName()+"/raw/idontunderstand_fragment1_verb3");

        LinearLayout linearLayout1=findViewById(R.id.linearLayout1);
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doit(view,uri1);

            }
        });

        LinearLayout linearLayout2=findViewById(R.id.linearLayout2);
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

        LinearLayout linearLayout3=findViewById(R.id.linearLayout3);
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
                endit();
                Intent intent=new Intent(view.getContext(),RussianLessonGamesSplashActivity.class);
                intent.putExtra("LESSON_NAME","Be Polite!");
                //pause.setVisibility(View.GONE);
                //volume.setVisibility(View.VISIBLE);
                startActivity(intent);
            }
        });


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
