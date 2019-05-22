package com.example.immanuel.flashtalk;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class RussianHisHouseHerCarFragment2 extends Fragment {

    MediaPlayer mediaPlayer;
    int STEP_TIME=100;
    //ImageView volume;
    //ImageView pause;

    public RussianHisHouseHerCarFragment2() {
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
                Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/hishousehercar_fragment1_sentence1");
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_his_house_her_car_fragment2, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");

        final Uri uri1=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/th1");
        final Uri uri2=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/th2");
        final Uri uri3=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/th3");
        //final Uri uri4=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        //final Uri uri5=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        //final Uri uri6=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        //final Uri uri7=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        //final Uri uri8=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");

        LinearLayout linearLayout1=rootView.findViewById(R.id.linearLayout1);
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
                mediaPlayer=MediaPlayer.create(getContext(),uri3);
                mediaPlayer.start();*/
                doit(view,uri3);
            }
        });

        String str="их (eekh) also does not depend on the noun's gender. It always stays the same.";
        String keyword1="их (eekh)";
        String keyword2="eekh";

        SpannableStringBuilder ssBuilder = new SpannableStringBuilder(str);

        //ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str.indexOf("мой"),str.indexOf("мой")+3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)),str.indexOf("моя"),str.indexOf("моя")+3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str.indexOf(keyword1),str.indexOf(keyword1)+keyword1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf(keyword1),str.indexOf(keyword1)+2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str.indexOf(keyword2),str.indexOf(keyword2)+keyword2.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder.setSpan(new StyleSpan(Typeface.ITALIC),str.indexOf(keyword2),str.indexOf(keyword2)+keyword2.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView intro=rootView.findViewById(R.id.intro);
        intro.setText(ssBuilder);

        ImageButton back_button=rootView.findViewById(R.id.back_button);
        //ImageButton forward_button=rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.russian_hishousehercar_pager);
        //final int MAX=mediaPlayer.getDuration() / STEP_TIME;

        //final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/basic_pronouns_fragment3");
        //mediaPlayer=MediaPlayer.create(rootView.getContext(),uri);

        CircularImageViewTest games=rootView.findViewById(R.id.games);
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri);*/
                endit();
                Intent intent=new Intent(view.getContext(),RussianLessonGamesSplashActivity.class);
                intent.putExtra("LESSON_NAME","His House, Her Car");
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

        return rootView;
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
