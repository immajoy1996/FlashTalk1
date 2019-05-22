package com.example.immanuel.flashtalk;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class RussianForMeForYouFragment2 extends Fragment {

    MediaPlayer mediaPlayer;
    int STEP_TIME=100;
    //ImageView volume;
    //ImageView pause;

    public RussianForMeForYouFragment2() {
        // Required empty public constructor
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        // Make sure that we are currently visible
        if (this.isVisible()) {
            // If we are becoming invisible, then...
            if (!isVisibleToUser) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/basic_verbs_fragment1");
                mediaPlayer=MediaPlayer.create(getContext(),uri);*/
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_for_me_for_you_fragment2, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");

        ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        //ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.formeforyou_pager);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page-1);
            }
        });

        CircularImageViewTest games=rootView.findViewById(R.id.games);
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri);*/
                endit();
                Intent intent=new Intent(view.getContext(),RussianLessonGamesSplashActivity.class);
                intent.putExtra("LESSON_NAME","For Me, For You");
                //pause.setVisibility(View.GONE);
                //volume.setVisibility(View.VISIBLE);
                startActivity(intent);
            }
        });

        TextView intro_textview=rootView.findViewById(R.id.intro);
        String str="Remember that его, её, and их become него, неё, and них after a preposition.";
        String a1="его,";
        String a2="её,";
        String a3="их become";
        String a4="него";
        String a5="неё";
        String a6="них";

        SpannableStringBuilder spannableStringBuilder1=new SpannableStringBuilder(str);
        //SpannableString spannableString=new SpannableString(str);
        spannableStringBuilder1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)), str.indexOf(a1), str.indexOf(a1)+3, 0);
        spannableStringBuilder1.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf(a1),str.indexOf(a1)+3,0);

        spannableStringBuilder1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)), str.indexOf(a2), str.indexOf(a2)+2, 0);
        spannableStringBuilder1.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf(a2),str.indexOf(a2)+2,0);

        spannableStringBuilder1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)), str.indexOf(a3), str.indexOf(a3)+2, 0);
        spannableStringBuilder1.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf(a3),str.indexOf(a3)+2,0);

        spannableStringBuilder1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)), str.indexOf(a4), str.indexOf(a4)+4, 0);
        spannableStringBuilder1.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf(a4),str.indexOf(a4)+4,0);

        spannableStringBuilder1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)), str.indexOf(a5), str.indexOf(a5)+3, 0);
        spannableStringBuilder1.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf(a5),str.indexOf(a5)+3,0);

        spannableStringBuilder1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)), str.indexOf(a6), str.indexOf(a6)+3, 0);
        spannableStringBuilder1.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf(a6),str.indexOf(a6)+3,0);

        intro_textview.setText(spannableStringBuilder1);

        TextView example1_textview=rootView.findViewById(R.id.example1);
        String str1="Это плохо для него.";
        String keyword1="него";

        SpannableString spannableString1=new SpannableString(str1);
        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str1.indexOf(keyword1), str1.indexOf(keyword1)+keyword1.length(), 0);
        example1_textview.setText(spannableString1);

        TextView example2_textview=rootView.findViewById(R.id.example2);
        String str2="Эти цветы для неё.";
        String keyword2="неё";

        SpannableString spannableString2=new SpannableString(str2);
        spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str2.indexOf(keyword2), str2.indexOf(keyword2)+keyword2.length(), 0);
        example2_textview.setText(spannableString2);

        TextView example3_textview=rootView.findViewById(R.id.example3);
        String str3="Эти книги для них.";
        String keyword3="них";

        SpannableString spannableString3=new SpannableString(str3);
        spannableString3.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str3.indexOf(keyword3), str3.indexOf(keyword3)+keyword3.length(), 0);
        example3_textview.setText(spannableString3);

        final Uri uri1=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/forhim1"); // header1
        final Uri uri2=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/forhim2");
        final Uri uri3=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/forhim3");

        LinearLayout linearLayout1=rootView.findViewById(R.id.linearLayout1);
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doit(view,uri1);

            }
        });

        LinearLayout linearLayout2=rootView.findViewById(R.id.linearLayout2);
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

        LinearLayout linearLayout3=rootView.findViewById(R.id.linearLayout3);
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


        /*SpannableStringBuilder ssBuilder = new SpannableStringBuilder(str);

        ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str.indexOf("masculine"),str.indexOf("masculine")+9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)),str.indexOf("feminine"),str.indexOf("feminine")+8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str.indexOf("neuter"),str.indexOf("neuter")+6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        */

        //ssBuilder.setSpan(new StyleSpan(Typeface.ITALIC),55,65, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //ssBuilder.setSpan(new StyleSpan(Typeface.ITALIC),66,75, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //ssBuilder.setSpan(new StyleSpan(Typeface.ITALIC),79,86, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

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
                };
            });

        }
    }
}
