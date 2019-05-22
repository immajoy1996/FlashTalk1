package com.example.immanuel.flashtalk;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RussianBetterThanActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_better_than);

        ImageButton back_button = (ImageButton) findViewById(R.id.back_button);
        //ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        //final ViewPager viewPager=getActivity().findViewById(R.id.formeforyou_pager);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endit();
                finish();
                //startActivity(new Intent(view.getContext(), RussianLanguageActivity.class));
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
                intent.putExtra("LESSON_NAME","I'm Better");
                //pause.setVisibility(View.GONE);
                //volume.setVisibility(View.VISIBLE);
                startActivity(intent);
            }
        });

        final Uri uri1=Uri.parse("android.resource://"+this.getPackageName()+"/raw/imstudying_conjug2");
        final Uri uri2=Uri.parse("android.resource://"+this.getPackageName()+"/raw/imstudying_conjug3");
        final Uri uri3=Uri.parse("android.resource://"+this.getPackageName()+"/raw/imstudying_conjug3");
        final Uri uri4=Uri.parse("android.resource://"+this.getPackageName()+"/raw/imstudying_conjug3");

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
                mediaPlayer=MediaPlayer.create(getContext(),uri2);
                mediaPlayer.start();*/
                doit(view,uri3);
            }
        });

        LinearLayout linearLayout4=findViewById(R.id.linearLayout4);
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri2);
                mediaPlayer.start();*/
                doit(view,uri4);
            }
        });

        TextView intro_textview = findViewById(R.id.intro);
        String str = "лучше (looch-shye) means \"better\". чем (chem) means \"than\". лучше чем means \"better than\". You'll probably hear this one a lot!";
        String a1 = "лучше";
        String a2="чем";
        String a3="лучше чем";

        String b1="looch-shye";
        String b2="chem";

        String c1="лучше (looch-shye)";
        String c2="чем (chem)";
        String c3="лучше чем";

        SpannableStringBuilder spannableStringBuilder1 = new SpannableStringBuilder(str);
        //SpannableString spannableString=new SpannableString(str);
        //spannableStringBuilder1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)), str.indexOf(a1), str.indexOf(a1) + a1.length(), 0);
        spannableStringBuilder1.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf(a1),str.indexOf(a1)+a1.length(),0);
        spannableStringBuilder1.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf(a2),str.indexOf(a2)+a2.length(),0);
        spannableStringBuilder1.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf(a3),str.indexOf(a3)+a3.length(),0);

        spannableStringBuilder1.setSpan(new StyleSpan(Typeface.ITALIC),str.indexOf(b1),str.indexOf(b1)+b1.length(),0);
        spannableStringBuilder1.setSpan(new StyleSpan(Typeface.ITALIC),str.indexOf(b2),str.indexOf(b2)+b2.length(),0);

        spannableStringBuilder1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str.indexOf(c1),str.indexOf(c1)+c1.length(),0);
        spannableStringBuilder1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str.indexOf(c2),str.indexOf(c2)+c2.length(),0);
        spannableStringBuilder1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str.indexOf(c3),str.indexOf(c3)+c3.length(),0);

        intro_textview.setText(spannableStringBuilder1);

        TextView example1_textview = findViewById(R.id.example1);
        String str1 = "Я лучше чем ты!";
        String keyword1 = "был";

        SpannableString spannableString1 = new SpannableString(str1);
        //spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str1.indexOf(keyword1), str1.indexOf(keyword1) + keyword1.length(), 0);
        example1_textview.setText(spannableString1);

        TextView example2_textview = findViewById(R.id.example2);
        String str2 = "Америка лучше чем Россия?";
        String keyword2 = "были";

        SpannableString spannableString2 = new SpannableString(str2);
        //spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str2.indexOf(keyword2), str2.indexOf(keyword2) + keyword2.length(), 0);
        example2_textview.setText(spannableString2);


        TextView example3_textview = findViewById(R.id.example3);
        String str3 = "Американская армия лучше чем русская армия.";
        String keyword3 = "был";

        SpannableString spannableString3 = new SpannableString(str3);
        //spannableString3.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str3.indexOf(keyword3), str3.indexOf(keyword3) + keyword3.length(), 0);
        example3_textview.setText(spannableString3);


        TextView example4_textview = findViewById(R.id.example4);
        String str4 = "Она лучше чем ты.";
        String keyword4 = "были";

        SpannableString spannableString4 = new SpannableString(str4);
        //spannableString4.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str4.indexOf(keyword4), str4.indexOf(keyword4) + keyword4.length(), 0);
        example4_textview.setText(spannableString4);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        endit();
    }

    void endit() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = null;
            //Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/wrong_answer");
            //adapter.mediaPlayer_alphabet= MediaPlayer.create(getContext(),uri);
        }
    }

    void doit(View view, Uri uri) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(view.getContext(), uri);
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    //mediaPlayer_alphabet.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = null;
                    //mediaPlayer_alphabet = MediaPlayer.create(vw.getContext(), uri);
                }

                ;
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
                    mediaPlayer = null;

                }

                ;
            });
        } else {
            mediaPlayer = MediaPlayer.create(view.getContext(), uri);
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    //mediaPlayer_alphabet.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }

                ;
            });

        }
    }
}
