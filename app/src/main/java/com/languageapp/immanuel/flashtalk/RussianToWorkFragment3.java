package com.languageapp.immanuel.flashtalk;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.languageapp.immanuel.flashtalk.R;


public class RussianToWorkFragment3 extends Fragment {

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
                Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/basic_verbs_fragment4");
                mediaPlayer= MediaPlayer.create(getContext(),uri);*/
                //volume.setVisibility(View.VISIBLE);
                //pause.setVisibility(View.GONE);
                endit();
            }
            else {
                // do what you like
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_to_work_fragment3, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");
        /*final TextView title=rootView.findViewById(R.id.title);
        volume=rootView.findViewById(R.id.audio);
        pause=rootView.findViewById(R.id.pause);
        final SeekBar seekBar=rootView.findViewById(R.id.seekbar);
        final LinearLayout seekbar_layout=rootView.findViewById(R.id.seekbar_layout);*/

        ImageButton back_button=rootView.findViewById(R.id.back_button);
        //ImageButton forward_button=rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.towork_pager);
        //final int MAX=mediaPlayer.getDuration() / STEP_TIME;

        //final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/basic_verbs_fragment4");
        //mediaPlayer= MediaPlayer.create(rootView.getContext(),uri);

        TextView textView_intro=rootView.findViewById(R.id.intro);
        String intro_str="A few more.";
        String keyword1="хорошо";
        SpannableString spannableString1=new SpannableString(intro_str);
        //spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),intro_str.indexOf(keyword1),intro_str.indexOf(keyword1)+keyword1.length(),0);
        //spannableString1.setSpan(new StyleSpan(Typeface.BOLD),intro_str.indexOf(keyword1),intro_str.indexOf(keyword1)+keyword1.length(),0);
        //textView_intro.setText(spannableString1);

        CircularImageViewTest games=rootView.findViewById(R.id.games);
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri);*/
                endit();
                Intent intent=new Intent(view.getContext(),RussianLessonGamesSplashActivity.class);
                intent.putExtra("LESSON_NAME","To Use");
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

        final Uri uri1=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/idontunderstand_fragment2_sentence1");
        final Uri uri2=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/idontunderstand_fragment2_sentence2");
        final Uri uri3=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/idontunderstand_fragment2_sentence3");

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
        /*forward_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri);
                volume.setVisibility(View.VISIBLE);
                pause.setVisibility(View.GONE);
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page+1);
            }
        });*/


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
