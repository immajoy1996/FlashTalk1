package com.example.immanuel.flashtalk;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RussianIDontSeeMyFriendActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_idont_see_my_friend);

        ImageButton back_button=(ImageButton)findViewById(R.id.back_button);
        //ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        //final ViewPager viewPager=getActivity().findViewById(R.id.formeforyou_pager);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endit();
                finish();
                //startActivity(new Intent(view.getContext(),RussianLanguageActivity.class));
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
                intent.putExtra("LESSON_NAME","I Don't See My Friend");
                //pause.setVisibility(View.GONE);
                //volume.setVisibility(View.VISIBLE);
                startActivity(intent);
            }
        });

        TextView intro_textview=findViewById(R.id.intro);
        String str="We know that direct objects take the accusative case. However, if it's masculine and human or animal, then it takes the genitive. This is just a weird Russian quirk!";
        String keyword_intro1="masculine";
        String keyword_intro2="human";
        String keyword_intro3="animal";

        SpannableStringBuilder spannableStringBuilder1=new SpannableStringBuilder(str);
        //SpannableString spannableString=new SpannableString(str);
        //spannableStringBuilder1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)), str.indexOf(keyword1), str.indexOf(keyword1)+keyword1.length(), 0);
        spannableStringBuilder1.setSpan(new UnderlineSpan(),str.indexOf(keyword_intro1),str.indexOf(keyword_intro1)+keyword_intro1.length(),0);
        spannableStringBuilder1.setSpan(new UnderlineSpan(),str.indexOf(keyword_intro2),str.indexOf(keyword_intro2)+keyword_intro2.length(),0);
        spannableStringBuilder1.setSpan(new UnderlineSpan(),str.indexOf(keyword_intro3),str.indexOf(keyword_intro3)+keyword_intro3.length(),0);
        intro_textview.setText(spannableStringBuilder1);

        TextView example1_textview=findViewById(R.id.example1);
        String str1="Я не вижу моего друга.";
        String keyword1="моего друга";

        SpannableString spannableString1=new SpannableString(str1);
        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str1.indexOf(keyword1), str1.indexOf(keyword1)+keyword1.length(), 0);
        example1_textview.setText(spannableString1);

        TextView example2_textview=findViewById(R.id.example2);
        String str2="Ты знаешь президента?";
        String keyword2="президента";

        SpannableString spannableString2=new SpannableString(str2);
        spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str2.indexOf(keyword2), str2.indexOf(keyword2)+keyword2.length(), 0);
        example2_textview.setText(spannableString2);



        TextView example3_textview=findViewById(R.id.example3);
        String str3="Я не вижу мой автобус.";
        //String keyword3="Америки";

        SpannableString spannableString3=new SpannableString(str3);
        //spannableString3.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str3.indexOf(keyword3), str3.indexOf(keyword3)+keyword3.length(), 0);
        example3_textview.setText(spannableString3);


        TextView example4_textview=findViewById(R.id.example4);
        String str4="Я не знаю твоего друга.";
        String keyword4="твоего друга.";

        SpannableString spannableString4=new SpannableString(str4);
        spannableString4.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str4.indexOf(keyword4), str4.indexOf(keyword4)+keyword4.length(), 0);
        example4_textview.setText(spannableString4);

        final Uri uri1=Uri.parse("android.resource://"+this.getPackageName()+"/raw/stra1");
        final Uri uri2=Uri.parse("android.resource://"+this.getPackageName()+"/raw/str2");
        final Uri uri3=Uri.parse("android.resource://"+this.getPackageName()+"/raw/str3");
        final Uri uri4=Uri.parse("android.resource://"+this.getPackageName()+"/raw/str4");

        //final Uri uri4=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        //final Uri uri5=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        //final Uri uri6=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        //final Uri uri7=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        //final Uri uri8=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");

        LinearLayout linearLayout1=findViewById(R.id.linearLayout1);
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri1);
                mediaPlayer.start();*/
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

        LinearLayout linearLayout4=findViewById(R.id.linearLayout4);
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri3);
                mediaPlayer.start();*/
                doit(view,uri4);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        endit();
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
}
