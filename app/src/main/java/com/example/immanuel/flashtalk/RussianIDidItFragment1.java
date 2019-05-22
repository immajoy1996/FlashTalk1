package com.example.immanuel.flashtalk;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class RussianIDidItFragment1 extends Fragment {

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
                Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/im_studying_conjug1");
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_idid_it_fragment1, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");

        ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.ididit_pager);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endit();
                getActivity().finish();
                //startActivity(new Intent(view.getContext(),RussianLanguageActivity.class));
            }
        });

        forward_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page+1);
            }
        });

        /*String str="The past tense is very simple. Just remove the -ть ending from the verb and add the past one. The ending you add depends on whether the subject is masc., fem., neut., or pl. Get the pattern?";

        SpannableStringBuilder ssBuilder = new SpannableStringBuilder(str);
        String keyword0="-ть";
        String keyword1="masc.";
        String keyword2="fem.";
        String keyword3="neut.";
        String keyword4="pl.";

        ssBuilder.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf(keyword0),str.indexOf(keyword0)+keyword0.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str.indexOf(keyword1),str.indexOf(keyword1)+keyword1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)),str.indexOf(keyword2),str.indexOf(keyword2)+keyword2.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str.indexOf(keyword3),str.indexOf(keyword3)+keyword3.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.purple)),str.indexOf(keyword4),str.indexOf(keyword4)+keyword4.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)),str.indexOf("эта (eta)"),str.indexOf("эта (eta)")+9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str.indexOf("это (eta)"),str.indexOf("это (eta)")+9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView textView=rootView.findViewById(R.id.intro);
        textView.setText(ssBuilder);*/

        final Uri uri0=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/did1");
        final Uri uri1=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/did2"); // header1
        final Uri uri2=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/did3");
        final Uri uri3=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/did4");
        final Uri uri4=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/theydid");

        LinearLayout headerLayout1=rootView.findViewById(R.id.headerLayout1);
        headerLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doit(view,uri0);

            }
        });

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
                mediaPlayer=MediaPlayer.create(getContext(),uri3);
                mediaPlayer.start();*/
                doit(view,uri3);
            }
        });

        LinearLayout linearLayout4=rootView.findViewById(R.id.linearLayout4);
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


        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
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
