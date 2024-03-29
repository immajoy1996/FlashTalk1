package com.languageapp.immanuel.flashtalk;

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


public class RussianICanFragment1 extends Fragment {

    MediaPlayer mediaPlayer;
    int STEP_TIME=100;
    //ImageView volume;
    //ImageView pause;

    public RussianICanFragment1() {
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
                Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/basic_verbs_fragment1");
                mediaPlayer=MediaPlayer.create(getContext(),uri);
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_ican_fragment1, container, false);

        ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.ican_pager);



        final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/basic_verbs_fragment1");
        mediaPlayer=MediaPlayer.create(rootView.getContext(),uri);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(view.getContext(),RussianLanguageActivity.class));
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri);
                //volume.setVisibility(View.VISIBLE);
                //pause.setVisibility(View.GONE);
                getActivity().finish();
            }
        });
        forward_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page+1);
            }
        });

        TextView textView_intro=rootView.findViewById(R.id.intro);
        String intro_str="мочь is an irrregular verb but it's very useful.";
        String keyword1="мочь";
        SpannableString spannableString1=new SpannableString(intro_str);
        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),intro_str.indexOf(keyword1),intro_str.indexOf(keyword1)+keyword1.length(),0);
        spannableString1.setSpan(new StyleSpan(Typeface.BOLD),intro_str.indexOf(keyword1),intro_str.indexOf(keyword1)+keyword1.length(),0);
        textView_intro.setText(spannableString1);

        final Uri uri1=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri2=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri3=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri4=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri5=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri6=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri7=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");

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
                mediaPlayer= MediaPlayer.create(getContext(),uri6);
                mediaPlayer.start();
            }
        });

        LinearLayout linearLayout7=rootView.findViewById(R.id.linearLayout7);
        linearLayout7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri7);
                mediaPlayer.start();
            }
        });
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");
        return rootView;
    }
}
