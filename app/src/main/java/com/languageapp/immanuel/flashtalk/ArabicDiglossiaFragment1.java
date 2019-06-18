package com.languageapp.immanuel.flashtalk;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


public class ArabicDiglossiaFragment1 extends Fragment {

    MediaPlayer mediaPlayer;
    //int STEP_TIME=100;
    //ImageView volume;
    //ImageView pause;

    public ArabicDiglossiaFragment1() {
        // Required empty public constructor
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        // Make sure that we are currently visible
        if (this.isVisible()) {
            // If we are becoming invisible, then...
            if (!isVisibleToUser) {
                final Uri uri_flip=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/pageflipmod");
                doit(getView(),uri_flip);
                /*mediaPlayer.stop();
                mediaPlayer.release();
                Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
                mediaPlayer=MediaPlayer.create(getContext(),uri);*/
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_arabic_diglossia_fragment1, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");

        ImageButton back_button=rootView.findViewById(R.id.back_button);
        ImageButton forward_button=rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.arabic_diglossia_pager);
        //final int MAX=mediaPlayer.getDuration() / STEP_TIME;

        //final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/question_words_fragment1");
        //mediaPlayer=MediaPlayer.create(rootView.getContext(),uri);

        /*SharedPreferences mPrefs=getContext().getSharedPreferences("Hints",0);
        String str0=mPrefs.getString("var_SomethingNice!","not shown");
        SharedPreferences.Editor mEditor=mPrefs.edit();

        if(str0.equals("not shown")) {

            SpannableString msg1 = new SpannableString("Click for audio. Swipe right to practice.");
            SpannableString msg2=new SpannableString("Click the quiz icon at the end of this lesson to test yourself.");
            (new MyApplication(getContext())).show_hints(getFragmentManager(), msg1,msg2,"-1","-1");
            mEditor.putString("var_SomethingNice!","shown");
            mEditor.commit();
        }*/

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mediaPlayer.stop();
                //mediaPlayer.release();
                //mediaPlayer=MediaPlayer.create(getContext(),uri);
                //volume.setVisibility(View.VISIBLE);
                //pause.setVisibility(View.GONE);
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

        //ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        //ImageButton forward_button=(ImageButton)findViewById(R.id.forward_button);
        //final ViewPager viewPager=findViewById(R.id._pager);

        //final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/basic_verbs_fragment1");
        //mediaPlayer=MediaPlayer.create(rootView.getContext(),uri);

        TextView explanation1=(TextView)rootView.findViewById(R.id.example1);
        //final TextView translation1=(TextView)findViewById(R.id.translation1);

        String str1="Every language has a colloquial and a formal variant. In English, for example, \"y'all\" is very common colloquially but would not be used in a formal setting such as a news article or speech. The colloquial and the formal in English are almost the same. In Arabic, however, they are almost two separate languages. In this course, you will learn Levantine Colloquial Arabic which is spoken or understandable in Syria, Lebanon, Jordan, Palestine, Saudi Arabic, Yemen and Oman.";
        String str1_keyword1="two separate languages";
        String keyword2="Levantine Colloquial Arabic";
        String keyword3="colloquial";
        String keyword4="formal";

        SpannableString spannableString1=new SpannableString(str1);
        //SpannableString spannableString1_trans=new SpannableString(trans1);
        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str1.indexOf(keyword2),str1.indexOf(keyword2)+keyword2.length(),0);
        spannableString1.setSpan(new UnderlineSpan(),str1.indexOf(str1_keyword1),str1.indexOf(str1_keyword1)+str1_keyword1.length(),0);
        spannableString1.setSpan(new UnderlineSpan(),str1.indexOf(keyword3),str1.indexOf(keyword3)+keyword3.length(),0);
        spannableString1.setSpan(new UnderlineSpan(),str1.indexOf(keyword4),str1.indexOf(keyword4)+keyword4.length(),0);
        explanation1.setText(spannableString1);
        //translation1.setText(spannableString1_trans);


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
