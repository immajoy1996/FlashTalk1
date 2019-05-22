package com.example.immanuel.flashtalk;

import android.content.Intent;
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
import android.widget.LinearLayout;
import android.widget.TextView;


public class RussianForMyCountryFragment3 extends Fragment {

    MediaPlayer mediaPlayer;
    int STEP_TIME=100;
    //ImageView volume;
    //ImageView pause;

    public RussianForMyCountryFragment3() {
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
                Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/basic_pronouns_fragment3");
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_for_my_country_fragment3, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");

        ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.mycountry_pager);

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
                intent.putExtra("LESSON_NAME","For My Country");
                //pause.setVisibility(View.GONE);
                //volume.setVisibility(View.VISIBLE);
                startActivity(intent);
            }
        });

        /*forward_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page+1);
            }
        });*/

        TextView example1=rootView.findViewById(R.id.example1);
        String str1="Это для их папы.";
        String keyword1="их папы";

        SpannableString spannableString1=new SpannableString(str1);
        spannableString1.setSpan(new UnderlineSpan(), str1.indexOf(keyword1), str1.indexOf(keyword1)+keyword1.length(), 0);
        example1.setText(spannableString1);

        TextView example2=rootView.findViewById(R.id.example2);
        String str2="Это для их мамы.";
        String keyword2="их мамы";

        SpannableString spannableString2=new SpannableString(str2);
        spannableString2.setSpan(new UnderlineSpan(), str2.indexOf(keyword2), str2.indexOf(keyword2)+keyword2.length(), 0);
        example2.setText(spannableString2);

        TextView example3=rootView.findViewById(R.id.example3);
        String str3="Это для их места.";
        String keyword3="их места";

        SpannableString spannableString3=new SpannableString(str3);
        spannableString3.setSpan(new UnderlineSpan(), str3.indexOf(keyword3), str3.indexOf(keyword3)+keyword3.length(), 0);
        example3.setText(spannableString3);

        final Uri uri1=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/ftm1");
        final Uri uri2=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/ftm2");
        final Uri uri3=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/ftm3");
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


        /*TextView example4=rootView.findViewById(R.id.example4);
        String str4="Это дом её друга.";
        String keyword4="её друга";

        SpannableString spannableString4=new SpannableString(str4);
        spannableString4.setSpan(new UnderlineSpan(), str4.indexOf(keyword4), str4.indexOf(keyword4)+keyword4.length(), 0);
        example4.setText(spannableString4);

        TextView example5=rootView.findViewById(R.id.example5);
        String str5="Это дом её сестры.";
        String keyword5="её сестры.";

        SpannableString spannableString5=new SpannableString(str5);
        spannableString5.setSpan(new UnderlineSpan(), str5.indexOf(keyword5), str5.indexOf(keyword5)+keyword5.length(), 0);
        example5.setText(spannableString5);

        TextView example6=rootView.findViewById(R.id.example6);
        String str6="Это дверь её здания.";
        String keyword6="её здания";

        SpannableString spannableString6=new SpannableString(str6);
        spannableString6.setSpan(new UnderlineSpan(), str6.indexOf(keyword6), str6.indexOf(keyword6)+keyword6.length(), 0);
        example6.setText(spannableString6);*/

        /*TextView example7=rootView.findViewById(R.id.example7);
        String str7="Это дом их друга.";
        String keyword7="их друга";

        SpannableString spannableString7=new SpannableString(str7);
        spannableString7.setSpan(new UnderlineSpan(), str7.indexOf(keyword7), str7.indexOf(keyword7)+keyword7.length(), 0);
        example7.setText(spannableString7);

        TextView example8=rootView.findViewById(R.id.example8);
        String str8="Это дом их сестры.";
        String keyword8="их сестры";

        SpannableString spannableString8=new SpannableString(str8);
        spannableString8.setSpan(new UnderlineSpan(), str8.indexOf(keyword8), str8.indexOf(keyword8)+keyword8.length(), 0);
        example8.setText(spannableString8);

        TextView example9=rootView.findViewById(R.id.example9);
        String str9="Это дверь их здания.";
        String keyword9="их здания";

        SpannableString spannableString9=new SpannableString(str9);
        spannableString9.setSpan(new UnderlineSpan(), str9.indexOf(keyword9), str9.indexOf(keyword9)+keyword9.length(), 0);
        example9.setText(spannableString9);*/


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
