package com.languageapp.immanuel.flashtalk;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.languageapp.immanuel.flashtalk.R;


public class RussianInTheStoreFragment2 extends Fragment {

    public RussianInTheStoreFragment2() {
        // Required empty public constructor
    }

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
                /*mediaPlayer.stop();
                mediaPlayer.release();
                Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/idontunderstand_fragment1_verb1");
                mediaPlayer= MediaPlayer.create(getContext(),uri);*/
                endit();
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_in_the_store_fragment2, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");
        TextView intro_textview=rootView.findViewById(R.id.intro);
        String str="There's not much to do!";

        //SpannableString spannableString=new SpannableString(str);
        //spannableString.setSpan(new UnderlineSpan(), str.indexOf("accusative case"), str.indexOf("accusative case")+15, 0);
        //intro_textview.setText(spannableString);

        /*TextView rule1_textview=rootView.findViewById(R.id.rule1);
        String rule1_str="* If a noun ends with a vowel, replace it with е.";
        SpannableString spannableString_rule1=new SpannableString(rule1_str);
        spannableString_rule1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)),rule1_str.indexOf("fem."),rule1_str.indexOf("fem.")+4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        rule1_textview.setText(spannableString_rule1);*/

        /*TextView rule2_textview=rootView.findViewById(R.id.rule2);
        String rule2_str="* Otherwise, add an е to the end.";
        SpannableString spannableString_rule2=new SpannableString(rule2_str);
        spannableString_rule2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)),rule2_str.indexOf("fem."),rule2_str.indexOf("fem.")+4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        rule2_textview.setText(spannableString_rule2);
        */

        TextView fem_rule1_textview=rootView.findViewById(R.id.rule1);
        String fem_rule1_str="* If a noun ends with a vowel, replace it with е.";
        SpannableString spannableString_fem_rule1=new SpannableString(fem_rule1_str);
        //spannableString_fem_rule1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)),fem_rule1_str.indexOf("fem."),fem_rule1_str.indexOf("fem.")+4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_fem_rule1.setSpan(new StyleSpan(Typeface.BOLD),fem_rule1_str.indexOf("е"),fem_rule1_str.indexOf("е")+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //spannableString_fem_rule1.setSpan(new StyleSpan(Typeface.BOLD),fem_rule1_str.indexOf("ы"),fem_rule1_str.indexOf("ы")+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        fem_rule1_textview.setText(spannableString_fem_rule1);

        TextView fem_rule2_textview=rootView.findViewById(R.id.rule2);
        String fem_rule2_str="* Otherwise, add an е to the end.";
        SpannableString spannableString_fem_rule2=new SpannableString(fem_rule2_str);
        //spannableString_fem_rule2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)),fem_rule2_str.indexOf("fem."),fem_rule2_str.indexOf("fem.")+4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_fem_rule2.setSpan(new StyleSpan(Typeface.BOLD),fem_rule2_str.indexOf("е"),fem_rule2_str.indexOf("е")+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //spannableString_fem_rule2.setSpan(new StyleSpan(Typeface.BOLD),fem_rule2_str.indexOf("и"),fem_rule2_str.indexOf("и")+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        fem_rule2_textview.setText(spannableString_fem_rule2);

        TextView neut_rule1_textview=rootView.findViewById(R.id.rule3);
        String neut_rule1_str="* If a noun ends in я, replace it with и. ";
        SpannableString spannableString_neut_rule1=new SpannableString(neut_rule1_str);
        //spannableString_neut_rule1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),neut_rule1_str.indexOf("neut."),neut_rule1_str.indexOf("neut.")+5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_neut_rule1.setSpan(new StyleSpan(Typeface.BOLD),neut_rule1_str.indexOf("я"),neut_rule1_str.indexOf("я")+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_neut_rule1.setSpan(new StyleSpan(Typeface.BOLD),neut_rule1_str.indexOf("и"),neut_rule1_str.indexOf("и")+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        neut_rule1_textview.setText(spannableString_neut_rule1);



        //SpannableString spannableString_rule3=new SpannableString(rule3_str);
        //spannableString_rule3.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)),rule3_str.indexOf("fem."),rule3_str.indexOf("fem.")+4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //rule3_textview.setText(spannableString_rule3);

        /*TextView example1_textview=rootView.findViewById(R.id.example1);
        String str1="Я хочу машину.";

        SpannableString spannableString1=new SpannableString(str1);
        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), 12, 13, 0);
        example1_textview.setText(spannableString1);

        TextView example2_textview=rootView.findViewById(R.id.example2);
        String str2="Я знаю девушку.";

        SpannableString spannableString2=new SpannableString(str2);
        spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), 13, 14, 0);
        example2_textview.setText(spannableString2);

        TextView example3_textview=rootView.findViewById(R.id.example3);
        String str3="Я не понимаю книгу.";*/

        ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.in_the_store_pager);

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

        return rootView;
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
                }
            });

        }
    }
}
