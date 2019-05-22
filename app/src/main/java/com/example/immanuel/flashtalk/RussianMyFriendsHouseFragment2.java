package com.example.immanuel.flashtalk;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class RussianMyFriendsHouseFragment2 extends Fragment {

    MediaPlayer mediaPlayer;
    int STEP_TIME=100;
    //ImageView volume;
    //ImageView pause;

    public RussianMyFriendsHouseFragment2() {
        // Required empty public constructor
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        // Make sure that we are currently visible
        if (this.isVisible()) {
            // If we are becoming invisible, then...
            if (!isVisibleToUser) {
                mediaPlayer.stop();
                mediaPlayer.release();
                Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/basic_pronouns_fragment3");
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_my_friends_house_fragment2, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");

        ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.myfriendshouse_pager);

        final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/basic_pronouns_fragment3");
        mediaPlayer=MediaPlayer.create(rootView.getContext(),uri);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page-1);
            }
        });

        forward_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page+1);
            }
        });

        TextView example1=rootView.findViewById(R.id.example1);
        String str1="Это дом его друга.";

        SpannableString spannableString1=new SpannableString(str1);
        spannableString1.setSpan(new UnderlineSpan(), str1.indexOf("его"), str1.indexOf("его")+3, 0);
        example1.setText(spannableString1);

        TextView example2=rootView.findViewById(R.id.example2);
        String str2="Это дом его сестры.";

        SpannableString spannableString2=new SpannableString(str2);
        spannableString2.setSpan(new UnderlineSpan(), str2.indexOf("его"), str2.indexOf("его")+3, 0);
        example2.setText(spannableString2);

        TextView example3=rootView.findViewById(R.id.example3);
        String str3="Это вход его здания.";

        SpannableString spannableString3=new SpannableString(str3);
        spannableString3.setSpan(new UnderlineSpan(), str3.indexOf("его"), str3.indexOf("его")+3, 0);
        example3.setText(spannableString3);

        TextView example4=rootView.findViewById(R.id.example4);
        String str4="Это дом её друга.";

        SpannableString spannableString4=new SpannableString(str4);
        spannableString4.setSpan(new UnderlineSpan(), str4.indexOf("её"), str4.indexOf("её")+2, 0);
        example4.setText(spannableString4);

        TextView example5=rootView.findViewById(R.id.example5);
        String str5="Это дом её сестры.";

        SpannableString spannableString5=new SpannableString(str5);
        spannableString5.setSpan(new UnderlineSpan(), str5.indexOf("её"), str5.indexOf("её")+2, 0);
        example5.setText(spannableString5);

        TextView example6=rootView.findViewById(R.id.example6);
        String str6="Это вход её здания?";

        SpannableString spannableString6=new SpannableString(str6);
        spannableString6.setSpan(new UnderlineSpan(), str6.indexOf("её"), str6.indexOf("её")+2, 0);
        example6.setText(spannableString6);

        TextView intro=rootView.findViewById(R.id.intro);
        String str="Remember that его, её and их always stay the same regardless of gender or case.";
        String intro_keyword1="его";
        String intro_keyword2="её";
        String intro_keyword3="их";
        SpannableString spannableString=new SpannableString(str);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf(intro_keyword1),str.indexOf(intro_keyword1)+intro_keyword1.length(),0);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf(intro_keyword2),str.indexOf(intro_keyword2)+intro_keyword2.length(),0);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf(intro_keyword3),str.indexOf(intro_keyword3)+intro_keyword3.length(),0);
        intro.setText(spannableString);

        /*TextView example7=rootView.findViewById(R.id.example7);
        String str7="Это дом их друга.";

        SpannableString spannableString7=new SpannableString(str7);
        spannableString7.setSpan(new UnderlineSpan(), str7.indexOf("их"), str7.indexOf("их")+2, 0);
        example7.setText(spannableString7);

        TextView example8=rootView.findViewById(R.id.example8);
        String str8="Это дом их сестры.";

        SpannableString spannableString8=new SpannableString(str8);
        spannableString8.setSpan(new UnderlineSpan(), str8.indexOf("их"), str8.indexOf("их")+2, 0);
        example8.setText(spannableString8);

        TextView example9=rootView.findViewById(R.id.example9);
        String str9="Это дверь их здания.";

        SpannableString spannableString9=new SpannableString(str9);
        spannableString9.setSpan(new UnderlineSpan(), str9.indexOf("их"), str9.indexOf("их")+2, 0);
        example9.setText(spannableString9);*/

        final Uri uri1=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/flash_audio1");
        final Uri uri2=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/audio_atom");
        final Uri uri3=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri4=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri5=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri6=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        //final Uri uri7=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        //final Uri uri8=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");

        LinearLayout linearLayout1=rootView.findViewById(R.id.linearLayout1);
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer= MediaPlayer.create(getContext(),uri1);
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
                mediaPlayer=MediaPlayer.create(getContext(),uri2);
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

        LinearLayout linearLayout5=rootView.findViewById(R.id.linearLayout5);
        linearLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri5);
                mediaPlayer.start();
            }
        });

        LinearLayout linearLayout6=rootView.findViewById(R.id.linearLayout6);
        linearLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri6);
                mediaPlayer.start();
            }
        });


        return rootView;
    }
}
