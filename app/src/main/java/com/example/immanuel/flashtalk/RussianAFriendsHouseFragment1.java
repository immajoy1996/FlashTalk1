package com.example.immanuel.flashtalk;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


public class RussianAFriendsHouseFragment1 extends Fragment {

    public RussianAFriendsHouseFragment1() {
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_afriends_house_fragment1, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");

        ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.friends_house_pager);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(view.getContext(),RussianLanguageActivity.class));
                endit();
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


        String example1_eng="eng. This is a friend's house.";
        String example1_russ="russ. This is the house of a friend.";
        TextView textView_example1_eng=rootView.findViewById(R.id.example1);
        TextView textView_example1_russ=rootView.findViewById(R.id.explanation1);

        SpannableString spannableString_example1_eng=new SpannableString(example1_eng);
        spannableString_example1_eng.setSpan(new UnderlineSpan(),example1_eng.indexOf("eng."),example1_eng.indexOf("eng.")+4,0);
        SpannableString spannableString_example1_russ=new SpannableString(example1_russ);
        spannableString_example1_russ.setSpan(new UnderlineSpan(),example1_russ.indexOf("russ."),example1_russ.indexOf("russ.")+5,0);
        textView_example1_eng.setText(spannableString_example1_eng);
        textView_example1_russ.setText(spannableString_example1_russ);



        String example2_eng="eng. This is my sister's car.";
        String example2_russ="russ. This is the car of my sister.";
        TextView textView_example2_eng=rootView.findViewById(R.id.example2);
        TextView textView_example2_russ=rootView.findViewById(R.id.explanation2);

        SpannableString spannableString_example2_eng=new SpannableString(example2_eng);
        spannableString_example2_eng.setSpan(new UnderlineSpan(),example2_eng.indexOf("eng."),example2_eng.indexOf("eng.")+4,0);
        SpannableString spannableString_example2_russ=new SpannableString(example2_russ);
        spannableString_example2_russ.setSpan(new UnderlineSpan(),example2_russ.indexOf("russ."),example2_russ.indexOf("russ.")+5,0);
        textView_example2_eng.setText(spannableString_example2_eng);
        textView_example2_russ.setText(spannableString_example2_russ);



        String example3_eng="eng. This my sister's friend's house.";
        String example3_russ="russ. This is the house of a friend of my sister.";
        TextView textView_example3_eng=rootView.findViewById(R.id.example3);
        TextView textView_example3_russ=rootView.findViewById(R.id.explanation3);

        SpannableString spannableString_example3_eng=new SpannableString(example3_eng);
        spannableString_example3_eng.setSpan(new UnderlineSpan(),example3_eng.indexOf("eng."),example3_eng.indexOf("eng.")+4,0);
        SpannableString spannableString_example3_russ=new SpannableString(example3_russ);
        spannableString_example3_russ.setSpan(new UnderlineSpan(),example3_russ.indexOf("russ."),example3_russ.indexOf("russ.")+5,0);
        textView_example3_eng.setText(spannableString_example3_eng);
        textView_example3_russ.setText(spannableString_example3_russ);


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
