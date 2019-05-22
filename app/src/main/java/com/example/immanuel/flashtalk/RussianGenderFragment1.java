package com.example.immanuel.flashtalk;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;


public class RussianGenderFragment1 extends Fragment {

    MediaPlayer mediaPlayer;
    int STEP_TIME=100;
    //ImageView volume;
    //ImageView pause;

    public RussianGenderFragment1() {
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
                Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_gender_fragment1, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");
        TextView intro_textview=rootView.findViewById(R.id.intro);
        String str="Russian has three genders. Every Russian noun is either masculine, feminine, or neuter. This has nothing to do with whether the noun itself is masculine or feminine. It's just a grammatical term.";

        SpannableStringBuilder ssBuilder = new SpannableStringBuilder(str);

        ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str.indexOf("masculine"),str.indexOf("masculine")+9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)),str.indexOf("feminine"),str.indexOf("feminine")+8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str.indexOf("neuter"),str.indexOf("neuter")+6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //ssBuilder.setSpan(new StyleSpan(Typeface.ITALIC),55,65, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //ssBuilder.setSpan(new StyleSpan(Typeface.ITALIC),66,75, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //ssBuilder.setSpan(new StyleSpan(Typeface.ITALIC),79,86, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        intro_textview.setText(ssBuilder);

        String str_textView1="e.g. девушка, подруга, машина";
        String str_textView2="e.g. задание, место";
        String str_textView3="e.g. человек, друг, дом";

        String str_rule1="Feminine nouns usually end in а or я";
        String str_rule2="Neuter nouns usually end in о or е";
        String str_rule3="Masculine nouns are whatever is left!";

        String rule1_keyword1="а";
        String rule1_keyword2="я";
        String rule2_keyword1="о";
        String rule2_keyword2="е";
        //String str_textView4="твой (t-voy) дом";
        //String str_textView5="твоя (t-va-ya) машина";
        //String str_textView6="твоё (t-va-yo) фото";

        String keyword1="девушка";
        String keyword2="подруга";
        String keyword3="машина";
        String keyword4="задание";
        String keyword5="место";
        String keyword6="человек";
        String keyword7="друг";
        String keyword8="дом";

        TextView example1=rootView.findViewById(R.id.example1);
        TextView example2=rootView.findViewById(R.id.example2);
        TextView example3=rootView.findViewById(R.id.example3);

        TextView rule1=rootView.findViewById(R.id.rule1);
        TextView rule2=rootView.findViewById(R.id.rule2);
        TextView rule3=rootView.findViewById(R.id.rule3);

        SpannableString rule_spannableString1=new SpannableString(str_rule1);
        SpannableString rule_spannableString2=new SpannableString(str_rule2);
        //SpannableString rule_spannableString3=new SpannableString(str_rule3);

        SpannableString spannableString1=new SpannableString(str_textView1);
        SpannableString spannableString2=new SpannableString(str_textView2);
        SpannableString spannableString3=new SpannableString(str_textView3);

        rule_spannableString1.setSpan(new StyleSpan(Typeface.BOLD),str_rule1.indexOf(rule1_keyword1),str_rule1.indexOf(rule1_keyword1)+rule1_keyword1.length(),0);
        rule_spannableString1.setSpan(new StyleSpan(Typeface.BOLD),str_rule1.indexOf(rule1_keyword2),str_rule1.indexOf(rule1_keyword2)+rule1_keyword2.length(),0);
        rule_spannableString2.setSpan(new StyleSpan(Typeface.BOLD),str_rule2.indexOf(rule2_keyword1),str_rule2.indexOf(rule2_keyword1)+rule2_keyword1.length(),0);
        rule_spannableString2.setSpan(new StyleSpan(Typeface.BOLD),str_rule2.indexOf(rule2_keyword2),str_rule2.indexOf(rule2_keyword2)+rule2_keyword2.length(),0);
        //SpannableString spannableString4=new SpannableString(str_textView4);
        //SpannableString spannableString5=new SpannableString(str_textView5);
        //SpannableString spannableString6=new SpannableString(str_textView6);

        rule1.setText(rule_spannableString1);
        rule2.setText(rule_spannableString2);

        spannableString1.setSpan(new StyleSpan(Typeface.BOLD),str_textView1.indexOf(keyword1),str_textView1.indexOf(keyword1)+keyword1.length(),0);
        spannableString1.setSpan(new StyleSpan(Typeface.BOLD),str_textView1.indexOf(keyword2),str_textView1.indexOf(keyword2)+keyword2.length(),0);
        spannableString1.setSpan(new StyleSpan(Typeface.BOLD),str_textView1.indexOf(keyword3),str_textView1.indexOf(keyword3)+keyword3.length(),0);

        spannableString2.setSpan(new StyleSpan(Typeface.BOLD),str_textView2.indexOf(keyword4),str_textView2.indexOf(keyword4)+keyword4.length(),0);
        spannableString2.setSpan(new StyleSpan(Typeface.BOLD),str_textView2.indexOf(keyword5),str_textView2.indexOf(keyword5)+keyword5.length(),0);

        spannableString3.setSpan(new StyleSpan(Typeface.BOLD),str_textView3.indexOf(keyword6),str_textView3.indexOf(keyword6)+keyword6.length(),0);
        spannableString3.setSpan(new StyleSpan(Typeface.BOLD),str_textView3.indexOf(keyword7),str_textView3.indexOf(keyword7)+keyword7.length(),0);
        spannableString3.setSpan(new StyleSpan(Typeface.BOLD),str_textView3.indexOf(keyword8),str_textView3.indexOf(keyword8)+keyword8.length(),0);

        example1.setText(spannableString1);
        example2.setText(spannableString2);
        example3.setText(spannableString3);


        /*final TextView title=rootView.findViewById(R.id.title);
        volume=rootView.findViewById(R.id.audio);
        pause=rootView.findViewById(R.id.pause);
        final SeekBar seekBar=rootView.findViewById(R.id.seekbar);
        final LinearLayout seekbar_layout=rootView.findViewById(R.id.seekbar_layout);*/

        ImageButton back_button=rootView.findViewById(R.id.back_button);
        ImageButton forward_button=rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.russian_gender_pager);
        //final int MAX=mediaPlayer.getDuration() / STEP_TIME;

        //final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/question_words_fragment1");
        //mediaPlayer=MediaPlayer.create(rootView.getContext(),uri);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri);*/
                //volume.setVisibility(View.VISIBLE);
                //pause.setVisibility(View.GONE);
                endit();
                getActivity().finish();
            }
        });

        forward_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mediaPlayer.stop();
                //mediaPlayer.release();
                //mediaPlayer=MediaPlayer.create(getContext(),uri);
                //volume.setVisibility(View.VISIBLE);
                //pause.setVisibility(View.GONE);
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page+1);
            }
        });

        final Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.wobble);
        back_button.startAnimation(anim);
        forward_button.startAnimation(anim);


        /*mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                //Log.d("DEBUG", "Done 1");
                pause.setVisibility(View.GONE);
                volume.setVisibility(View.VISIBLE);
                //mediaPlayer.seekTo(0);
            }
        });

        volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volume.setVisibility(View.GONE);
                pause.setVisibility(View.VISIBLE);
                seekbar_layout.setVisibility(View.VISIBLE);
                title.setVisibility(View.GONE);
                seekBar.setMax(mediaPlayer.getDuration() / STEP_TIME);
                mediaPlayer.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volume.setVisibility(View.VISIBLE);
                pause.setVisibility(View.GONE);
                mediaPlayer.pause();

            }
        });

        final Handler mHandler = new Handler();
        //Update Seekbar on UI thread
        getActivity().runOnUiThread(new Runnable() {

            @Override
            public void run() {
                if(mediaPlayer != null){
                    int mCurrentPosition = mediaPlayer.getCurrentPosition() / STEP_TIME;
                    seekBar.setProgress(mCurrentPosition);
                }
                mHandler.postDelayed(this, STEP_TIME);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(mediaPlayer != null && fromUser){
                    //Log.d("DEBUG", "Progress is: "+progress);
                    mediaPlayer.release();
                    mediaPlayer=MediaPlayer.create(getContext(),uri);

                    mediaPlayer.seekTo(progress*STEP_TIME);
                    //mediaPlayer.start();

                    if(pause.getVisibility()==View.VISIBLE){
                        mediaPlayer.start();
                    }

                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            //Log.d("DEBUG", "Done 1");
                            pause.setVisibility(View.GONE);
                            volume.setVisibility(View.VISIBLE);
                            //mediaPlayer.seekTo(0);
                        }
                    });
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });*/

        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        endit();
        /*mediaPlayer.stop();
        mediaPlayer.release();
        Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        mediaPlayer=MediaPlayer.create(getContext(),uri);*/

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
