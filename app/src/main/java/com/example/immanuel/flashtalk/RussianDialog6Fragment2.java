package com.example.immanuel.flashtalk;

import android.content.Intent;
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


public class RussianDialog6Fragment2 extends Fragment {

    MediaPlayer mediaPlayer;
    int STEP_TIME=100;
    //ImageView volume;
    //ImageView pause;

    public RussianDialog6Fragment2() {
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_dialog6_fragment2, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");

        ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        //ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.dialog6_pager);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page-1);
            }
        });

        final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/basic_pronouns_fragment3_sentence1");
        mediaPlayer=MediaPlayer.create(rootView.getContext(),uri);

        CircularImageViewTest games=rootView.findViewById(R.id.games);
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri);
                Intent intent=new Intent(view.getContext(),RussianLessonGamesSplashActivity.class);
                intent.putExtra("LESSON_NAME","Dialogue 6 - An Rude Waiter");
                //pause.setVisibility(View.GONE);
                //volume.setVisibility(View.VISIBLE);
                startActivity(intent);
            }
        });

        final Uri uri1=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/basic_pronouns_fragment1_word1");
        final Uri uri2=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/basic_pronouns_fragment1_word2");
        /*final Uri uri3=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/basic_pronouns_fragment1_word3");
        final Uri uri4=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/basic_pronouns_fragment1_word4");
        final Uri uri5=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/basic_pronouns_fragment1_word5");*/
        //final Uri uri6=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/basic_pronouns_fragment1_word6");
        //final Uri uri7=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/basic_pronouns_fragment1_word7");
        //final Uri uri8=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/basic_pronouns_fragment1_word8");

        LinearLayout linearLayout1=rootView.findViewById(R.id.linearLayout1);
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri1);
                mediaPlayer.start();
            }
        });

        /*LinearLayout linearLayout2=rootView.findViewById(R.id.linearLayout2);
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer= MediaPlayer.create(getContext(),uri2);
                mediaPlayer.start();
            }
        });*/

        /*LinearLayout linearLayout3=rootView.findViewById(R.id.linearLayout3);
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
        });*/


        return rootView;
    }
}
