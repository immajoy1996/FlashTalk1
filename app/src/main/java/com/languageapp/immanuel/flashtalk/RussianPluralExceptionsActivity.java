package com.languageapp.immanuel.flashtalk;

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
import android.widget.TextView;

import com.languageapp.immanuel.flashtalk.R;

public class RussianPluralExceptionsActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    int STEP_TIME=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_plural_exceptions);

        ImageButton back_button=(ImageButton)findViewById(R.id.back_button);
        //ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);

        //final Uri uri=Uri.parse("android.resource://"+this.getPackageName()+"/raw/question_words_fragment1");
        //mediaPlayer=MediaPlayer.create(getApplicationContext(),uri);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endit();
                //startActivity(new Intent(view.getContext(),RussianLanguageActivity.class));
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getApplicationContext(),uri);*/
                //volume.setVisibility(View.VISIBLE);
                //pause.setVisibility(View.GONE);
                finish();
            }
        });

        CircularImageViewTest games=findViewById(R.id.games);
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getApplicationContext(),uri);*/
                Intent intent=new Intent(view.getContext(),RussianLessonGamesSplashActivity.class);
                intent.putExtra("LESSON_NAME","Exceptions");
                //pause.setVisibility(View.GONE);
                //volume.setVisibility(View.VISIBLE);
                startActivity(intent);
            }
        });

        TextView example1_textview=findViewById(R.id.example1);
        String str1="человек - люди (lyu-dee)";
        String a1="люди (lyu-dee)";
        String a2="человек";
        String a3="люди";
        String a4="lyu-dee";

        SpannableString spannableString1=new SpannableString(str1);
        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str1.indexOf(a1), str1.indexOf(a1)+a1.length(), 0);
        spannableString1.setSpan(new StyleSpan(Typeface.BOLD), str1.indexOf(a2), str1.indexOf(a2)+a2.length(), 0);
        spannableString1.setSpan(new StyleSpan(Typeface.BOLD), str1.indexOf(a3), str1.indexOf(a3)+a3.length(), 0);
        spannableString1.setSpan(new StyleSpan(Typeface.ITALIC), str1.indexOf(a4), str1.indexOf(a4)+a4.length(), 0);

        example1_textview.setText(spannableString1);

        TextView example2_textview=findViewById(R.id.example2);
        String str2="друг - друзья (drooz-ya)";
        String b1="друзья (drooz-ya)";
        String b2="друг";
        String b3="друзья";
        String b4="drooz-ya";

        SpannableString spannableString2=new SpannableString(str2);
        spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str2.indexOf(b1), str2.indexOf(b1)+b1.length(), 0);
        spannableString2.setSpan(new StyleSpan(Typeface.BOLD), str2.indexOf(b2), str2.indexOf(b2)+b2.length(), 0);
        spannableString2.setSpan(new StyleSpan(Typeface.BOLD), str2.indexOf(b3), str2.indexOf(b3)+b3.length(), 0);
        spannableString2.setSpan(new StyleSpan(Typeface.ITALIC), str2.indexOf(b4), str2.indexOf(b4)+b4.length(), 0);


        example2_textview.setText(spannableString2);

        TextView example3_textview=findViewById(R.id.example3);
        String str3="день - дни (dn-ee)";

        String c1="дни (dn-ee)";
        String c2="день";
        String c3="дни";
        String c4="dn-ee";

        SpannableString spannableString3=new SpannableString(str3);
        spannableString3.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str3.indexOf(c1), str3.indexOf(c1)+c1.length(), 0);
        spannableString3.setSpan(new StyleSpan(Typeface.BOLD), str3.indexOf(c2), str3.indexOf(c2)+c2.length(), 0);
        spannableString3.setSpan(new StyleSpan(Typeface.BOLD), str3.indexOf(c3), str3.indexOf(c3)+c3.length(), 0);
        spannableString3.setSpan(new StyleSpan(Typeface.ITALIC), str3.indexOf(c4), str3.indexOf(c4)+c4.length(), 0);

        example3_textview.setText(spannableString3);

        final Uri uri1=Uri.parse("android.resource://"+this.getPackageName()+"/raw/exce1");
        final Uri uri2=Uri.parse("android.resource://"+this.getPackageName()+"/raw/exce2");
        final Uri uri3=Uri.parse("android.resource://"+this.getPackageName()+"/raw/exce3");

        TextView example1=findViewById(R.id.example1);
        example1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                doit(view,uri1);
            }
        });

        TextView example2=findViewById(R.id.example2);
        example2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                doit(view,uri2);
            }
        });

        TextView example3=findViewById(R.id.example3);
        example3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                doit(view,uri3);
            }
        });
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

    void doit(View view,Uri uri){
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
