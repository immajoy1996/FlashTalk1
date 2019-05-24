package com.example.immanuel.flashtalk;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class RussianCleanupFragment1 extends Fragment {

    MediaPlayer mediaPlayer;
    int STEP_TIME=100;
    //ImageView volume;
    //ImageView pause;

    public RussianCleanupFragment1() {
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
                Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/basic_verbs_fragment2_sentence1");
                mediaPlayer= MediaPlayer.create(getContext(),uri);*/
                final Uri uri_flip=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/pageflipmod");
                doit(getView(),uri_flip);
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_cleanup_fragment1, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Cleanup");

        SharedPreferences mPrefs=getContext().getSharedPreferences("Hints",0);
        String str0=mPrefs.getString("var_Cleanup","not shown");
        SharedPreferences.Editor mEditor=mPrefs.edit();

        if(str0.equals("not shown")) {

            SpannableString msg1 = new SpannableString("Click for audio. Swipe right to practice.");
            SpannableString msg2=new SpannableString("Click the quiz icon at the end of this lesson to test yourself.");
            (new MyApplication(getContext())).show_hints(getFragmentManager(), msg1,msg2,"-1","-1");
            mEditor.putString("var_Cleanup","shown");
            mEditor.commit();
        }

        TextView textView_intro1=rootView.findViewById(R.id.intro1);
        //TextView textView_intro2=rootView.findViewById(R.id.intro2);
        String intro1="Conjugations for plurals follow the same pattern: remove the -ать or -ить ending and add the new one. Swipe to see examples.";
        //String intro2="To conjugate, remove the -ать or -ить ending and add the new one.";
        //String intro_keyword1="ь";
        String intro_keyword2="-ать";
        String intro_keyword3="-ить";
        SpannableString spannableString_intro1=new SpannableString(intro1);
        //SpannableString spannableString_intro2=new SpannableString(intro2);
        //spannableString_intro1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)), intro1.indexOf(intro_keyword1), intro1.indexOf(intro_keyword1)+intro_keyword1.length(), 0);
        spannableString_intro1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)), intro1.indexOf(intro_keyword2), intro1.indexOf(intro_keyword2)+intro_keyword2.length(), 0);
        spannableString_intro1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)), intro1.indexOf(intro_keyword3), intro1.indexOf(intro_keyword3)+intro_keyword3.length(), 0);
        ////spannableString_intro.setSpan(new StyleSpan(Typeface.BOLD), intro.indexOf(intro_keyword4), intro.indexOf(intro_keyword4)+2, 0);
        spannableString_intro1.setSpan(new StyleSpan(Typeface.BOLD), intro1.indexOf(intro_keyword2), intro1.indexOf(intro_keyword2)+intro_keyword2.length(), 0);
        spannableString_intro1.setSpan(new StyleSpan(Typeface.BOLD), intro1.indexOf(intro_keyword3), intro1.indexOf(intro_keyword3)+intro_keyword3.length(), 0);
        //spannableString_intro2.setSpan(new StyleSpan(Typeface.BOLD), intro2.indexOf(intro_keyword3), intro2.indexOf(intro_keyword3)+intro_keyword3.length(), 0);
        textView_intro1.setText(spannableString_intro1);

        final Uri uri1=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/blah1"); // header1
        final Uri uri2=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/blah2");
        final Uri uri3=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/blah3");
        final Uri uri4=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/blah4");
        final Uri uri5=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/blah5"); // header2
        final Uri uri6=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/blah6");
        final Uri uri7=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/blah7");
        final Uri uri8=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/blah8");
        final Uri uri9=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/blah9"); //header3
        final Uri uri10=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/blah10");
        final Uri uri11=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/blah11");
        final Uri uri12=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/blah12");

        LinearLayout headerLayout1=rootView.findViewById(R.id.header_layout1);
        headerLayout1.setOnClickListener(new View.OnClickListener() {
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

        LinearLayout headerLayout2=rootView.findViewById(R.id.header_layout2);
        headerLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri5);
                mediaPlayer.start();*/
                doit(view,uri5);
            }
        });

        LinearLayout headerLayout3=rootView.findViewById(R.id.header_layout3);
        headerLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri9);
                mediaPlayer.start();*/
                doit(view,uri9);
            }
        });


        LinearLayout linearLayout1=rootView.findViewById(R.id.verb_layout1);
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*SoundPool soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
                final int soundId = soundPool.load(view.getContext(), R.raw.correct_answer, 1);
                soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
                    @Override
                    public void onLoadComplete(SoundPool soundPool, int i, int i1) {
                        soundPool.play(soundId, 1, 1, 0, 0, 1);
                    }
                });*/
                /*mediaPlayer.stop();
                mediaPlayer.reset();
                mediaPlayer.release();
                mediaPlayer=null;
                mediaPlayer=MediaPlayer.create(getContext(),uri1);
                mediaPlayer.start();*/
                doit(view,uri2);

            }
        });

        LinearLayout linearLayout2=rootView.findViewById(R.id.verb_layout2);
        linearLayout2.setOnClickListener(new View.OnClickListener() {
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

        LinearLayout linearLayout3=rootView.findViewById(R.id.verb_layout3);
        linearLayout3.setOnClickListener(new View.OnClickListener() {
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

        LinearLayout linearLayout4=rootView.findViewById(R.id.verb_layout4);
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri4);
                mediaPlayer.start();*/
                doit(view,uri6);
            }
        });

        LinearLayout linearLayout5=rootView.findViewById(R.id.verb_layout5);
        linearLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri5);
                mediaPlayer.start();*/
                doit(view,uri7);
            }
        });

        LinearLayout linearLayout6=rootView.findViewById(R.id.verb_layout6);
        linearLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri6);
                mediaPlayer.start();*/
                doit(view,uri8);
            }
        });

        LinearLayout linearLayout7=rootView.findViewById(R.id.verb_layout7);
        linearLayout7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri7);
                mediaPlayer.start();*/
                doit(view,uri10);
            }
        });

        LinearLayout linearLayout8=rootView.findViewById(R.id.verb_layout8);
        linearLayout8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri8);
                mediaPlayer.start();*/
                doit(view,uri11);
            }
        });

        LinearLayout linearLayout9=rootView.findViewById(R.id.verb_layout9);
        linearLayout9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri8);
                mediaPlayer.start();*/
                doit(view,uri12);
            }
        });

        /*final TextView title=rootView.findViewById(R.id.title);
        volume=rootView.findViewById(R.id.audio);
        pause=rootView.findViewById(R.id.pause);
        final SeekBar seekBar=rootView.findViewById(R.id.seekbar);
        final LinearLayout seekbar_layout=rootView.findViewById(R.id.seekbar_layout);*/

        ImageButton back_button=rootView.findViewById(R.id.back_button);
        ImageButton forward_button=rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.cleanup_pager);

        //final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/basic_verbs_fragment2_sentence1");
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
        Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/basic_verbs_fragment2_sentence1");
        mediaPlayer= MediaPlayer.create(getContext(),uri);*/

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
}
