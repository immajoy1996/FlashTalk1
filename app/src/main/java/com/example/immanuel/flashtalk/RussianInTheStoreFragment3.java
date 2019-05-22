package com.example.immanuel.flashtalk;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class RussianInTheStoreFragment3 extends Fragment {

    MediaPlayer mediaPlayer;
    int STEP_TIME=100;
    //ImageView volume;
    //ImageView pause;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        // Make sure that we are currently visible
        if (this.isVisible()) {
            // If we are becoming invisible, then...
            if (!isVisibleToUser) {
                mediaPlayer.stop();
                mediaPlayer.release();
                Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/basic_verbs_fragment4");
                mediaPlayer= MediaPlayer.create(getContext(),uri);
                //volume.setVisibility(View.VISIBLE);
                //pause.setVisibility(View.GONE);
            }
            else {
                // do what you like
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_in_the_store_fragment3, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");
        //TextView intro_textview=rootView.findViewById(R.id.intro);

        TextView intro=rootView.findViewById(R.id.intro);
        String str_intro="The preposition в can also mean \"in\" and на means \"on\".";
        String intro_keyword1="на";

        SpannableString spannableString_intro=new SpannableString(str_intro);
        spannableString_intro.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)), str_intro.indexOf(intro_keyword1), str_intro.indexOf(intro_keyword1)+intro_keyword1.length(), 0);
        spannableString_intro.setSpan(new StyleSpan(Typeface.BOLD), str_intro.indexOf(intro_keyword1), str_intro.indexOf(intro_keyword1)+intro_keyword1.length(), 0);
        spannableString_intro.setSpan(new StyleSpan(Typeface.BOLD), str_intro.indexOf("в"), str_intro.indexOf("в")+1, 0);
        spannableString_intro.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)), str_intro.indexOf("в"), str_intro.indexOf("в")+1, 0);
        intro.setText(spannableString_intro);

        TextView example1=rootView.findViewById(R.id.example1);
        String str1="Я в магазине.";
        String keyword1="магазине";

        SpannableString spannableString1=new SpannableString(str1);
        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str1.indexOf(keyword1), str1.indexOf(keyword1)+keyword1.length(), 0);
        example1.setText(spannableString1);

        TextView example2=rootView.findViewById(R.id.example2);
        String str2="Я читаю книги в библиотеке.";
        String keyword2="библиотеке";

        SpannableString spannableString2=new SpannableString(str2);
        spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str2.indexOf(keyword2), str2.indexOf(keyword2)+keyword2.length(), 0);
        example2.setText(spannableString2);

        TextView example3=rootView.findViewById(R.id.example3);
        String str3="Сейчас, Я в России в Москве.";
        String str3_keyword1="России";
        String str3_keyword2="Москве";

        SpannableString spannableString3=new SpannableString(str3);
        spannableString3.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str3.indexOf(str3_keyword1), str3.indexOf(str3_keyword1)+str3_keyword1.length(), 0);
        spannableString3.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str3.indexOf(str3_keyword2), str3.indexOf(str3_keyword2)+str3_keyword2.length(), 0);
        example3.setText(spannableString3);

        TextView example4=rootView.findViewById(R.id.example4);
        String str4="Эта книга на столе.";
        String keyword4="столе";

        SpannableString spannableString5=new SpannableString(str4);
        spannableString5.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str4.indexOf(keyword4), str4.indexOf(keyword4)+keyword4.length(), 0);
        example4.setText(spannableString5);

        ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        //ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.in_the_store_pager);

        final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/basic_verbs_fragment4");
        mediaPlayer= MediaPlayer.create(rootView.getContext(),uri);

        CircularImageView2 games=rootView.findViewById(R.id.games);
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri);
                Intent intent=new Intent(view.getContext(),RussianLessonGamesSplashActivity.class);
                intent.putExtra("LESSON_NAME","In The Store");
                //pause.setVisibility(View.GONE);
                //volume.setVisibility(View.VISIBLE);
                startActivity(intent);
            }
        });


        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri);
                volume.setVisibility(View.VISIBLE);
                pause.setVisibility(View.GONE);*/
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page-1);
            }
        });

        final Uri uri1=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/idontunderstand_fragment2_sentence1");
        final Uri uri2=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/idontunderstand_fragment2_sentence2");
        final Uri uri3=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/idontunderstand_fragment2_sentence3");
        final Uri uri4=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/idontunderstand_fragment2_sentence3");

        LinearLayout linearLayout1=rootView.findViewById(R.id.linearLayout1);
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri1);
                mediaPlayer.start();
            }
        });

        LinearLayout linearLayout2=rootView.findViewById(R.id.linearLayout2);
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer= MediaPlayer.create(getContext(),uri2);
                mediaPlayer.start();
            }
        });

        LinearLayout linearLayout3=rootView.findViewById(R.id.linearLayout3);
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri3);
                mediaPlayer.start();
            }
        });

        LinearLayout linearLayout4=rootView.findViewById(R.id.linearLayout4);
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri4);
                mediaPlayer.start();
            }
        });


        return rootView;
    }
}
