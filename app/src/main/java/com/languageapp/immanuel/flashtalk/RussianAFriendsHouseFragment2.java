package com.languageapp.immanuel.flashtalk;

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

import com.languageapp.immanuel.flashtalk.R;


public class RussianAFriendsHouseFragment2 extends Fragment {

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

    public RussianAFriendsHouseFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_afriends_house_fragment2, container, false);

        ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        //ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.friends_house_pager);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page-1);
            }
        });

        CircularImageView2 games=rootView.findViewById(R.id.games);
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Uri uri_swoosh=Uri.parse("android.resource://"+view.getContext().getPackageName()+"/raw/swoosh");
                doit(view,uri_swoosh);
                //mediaPlayer.stop();
                //mediaPlayer.release();
                //mediaPlayer= MediaPlayer.create(getContext(),uri);
                Intent intent=new Intent(view.getContext(),RussianLessonGamesSplashActivity.class);
                intent.putExtra("LESSON_NAME","A Friend's House");
                //pause.setVisibility(View.GONE);
                //volume.setVisibility(View.VISIBLE);
                startActivity(intent);
            }
        });

        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");
        //TextView intro_textview=rootView.findViewById(R.id.intro);
        //String str="In Russian, direct objects take the accusative case. The accusative case is very easy to form. Only feminine nouns change their structure.";

        /*SpannableString spannableString=new SpannableString(str);
        spannableString.setSpan(new UnderlineSpan(), str.indexOf("accusative case"), str.indexOf("accusative case")+15, 0);
        intro_textview.setText(spannableString);*/

        /*TextView masc_rule1_textview=rootView.findViewById(R.id.masc_rule1);
        String masc_rule1_str="* For most masc. nouns, add an а to the end.";
        SpannableString spannableString_masc_rule1=new SpannableString(masc_rule1_str);
        spannableString_masc_rule1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),masc_rule1_str.indexOf("masc."),masc_rule1_str.indexOf("masc.")+5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        masc_rule1_textview.setText(spannableString_masc_rule1);

        TextView fem_rule1_textview=rootView.findViewById(R.id.fem_rule1);
        String fem_rule1_str="* If a fem. noun ends with an а, replace it with an ы.";
        SpannableString spannableString_fem_rule1=new SpannableString(fem_rule1_str);
        spannableString_fem_rule1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)),fem_rule1_str.indexOf("fem."),fem_rule1_str.indexOf("fem.")+4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        fem_rule1_textview.setText(spannableString_fem_rule1);

        TextView fem_rule2_textview=rootView.findViewById(R.id.fem_rule2);
        String fem_rule2_str="* If a fem. noun ends with a я, replace it with an и.";
        SpannableString spannableString_fem_rule2=new SpannableString(fem_rule2_str);
        spannableString_fem_rule2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)),fem_rule1_str.indexOf("fem."),fem_rule1_str.indexOf("fem.")+4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        fem_rule2_textview.setText(spannableString_fem_rule2);

        TextView neut_rule1_textview=rootView.findViewById(R.id.neut_rule1);
        String neut_rule1_str="* If a neut. noun ends with an о, replace it with an а.";
        SpannableString spannableString_neut_rule1=new SpannableString(neut_rule1_str);
        spannableString_neut_rule1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),neut_rule1_str.indexOf("neut."),neut_rule1_str.indexOf("neut.")+5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        neut_rule1_textview.setText(spannableString_neut_rule1);

        TextView neut_rule2_textview=rootView.findViewById(R.id.neut_rule2);
        String neut_rule2_str="* If a neut. noun ends with an е, replace it with an я.";
        SpannableString spannableString_neut_rule2=new SpannableString(neut_rule2_str);
        spannableString_neut_rule2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),neut_rule2_str.indexOf("neut."),neut_rule2_str.indexOf("neut.")+5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        neut_rule2_textview.setText(spannableString_neut_rule2);*/

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
