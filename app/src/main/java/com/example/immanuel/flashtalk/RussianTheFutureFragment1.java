package com.example.immanuel.flashtalk;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class RussianTheFutureFragment1 extends Fragment {

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
                Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/basic_verbs_fragment1_sentence1");
                mediaPlayer=MediaPlayer.create(getContext(),uri);*/
                //volume.setVisibility(View.VISIBLE);
                //pause.setVisibility(View.GONE);
                endit();
            }
            else {
                // do what you like
            }
        }
    }

    public RussianTheFutureFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_the_future_fragment1, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");

        ImageView back_button=(ImageView)rootView.findViewById(R.id.back_button);
        ImageView forward_button=(ImageView)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=(ViewPager)getActivity().findViewById(R.id.thefuture_pager);

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

        TextView conjugation1=(TextView)rootView.findViewById(R.id.conjugation1);
        String str1="я буду делать";
        String keyword1="буду";
        SpannableString spannableString1=new SpannableString(str1);
        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str1.indexOf(keyword1),str1.indexOf(keyword1)+keyword1.length(),0);
        conjugation1.setText(spannableString1);

        TextView conjugation2=(TextView)rootView.findViewById(R.id.conjugation2);
        String str2="ты будешь делать";
        String keyword2="будешь";
        SpannableString spannableString2=new SpannableString(str2);
        spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str2.indexOf(keyword2),str2.indexOf(keyword2)+keyword2.length(),0);
        conjugation2.setText(spannableString2);

        TextView conjugation3=(TextView)rootView.findViewById(R.id.conjugation3);
        String str3="он/она будет делать";
        String keyword3="будет";
        SpannableString spannableString3=new SpannableString(str3);
        spannableString3.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str3.indexOf(keyword3),str3.indexOf(keyword3)+keyword3.length(),0);
        conjugation3.setText(spannableString3);

        TextView conjugation4=(TextView)rootView.findViewById(R.id.conjugation4);
        String str4="мы будем делать";
        String keyword4="будем";
        SpannableString spannableString4=new SpannableString(str4);
        spannableString4.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str4.indexOf(keyword4),str4.indexOf(keyword4)+keyword4.length(),0);
        conjugation4.setText(spannableString4);

        TextView conjugation5=(TextView)rootView.findViewById(R.id.conjugation5);
        String str5="вы будете делать";
        String keyword5="будете";
        SpannableString spannableString5=new SpannableString(str5);
        spannableString5.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str5.indexOf(keyword5),str5.indexOf(keyword5)+keyword5.length(),0);
        conjugation5.setText(spannableString5);

        TextView conjugation6=(TextView)rootView.findViewById(R.id.conjugation6);
        String str6="они будут делать";
        String keyword6="будут";
        SpannableString spannableString6=new SpannableString(str6);
        spannableString6.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str6.indexOf(keyword6),str6.indexOf(keyword6)+keyword6.length(),0);
        conjugation6.setText(spannableString6);

        final Uri uri1=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/awill1"); // header1
        final Uri uri2=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/awill2");
        final Uri uri3=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/awill3");
        final Uri uri4=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/awill4");
        final Uri uri5=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/awill5"); // header2
        final Uri uri6=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/awill6");
        final Uri uri7=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/awill7");

        LinearLayout linearLayout1=rootView.findViewById(R.id.headerLayout1);
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
                doit(view,uri1);

            }
        });

        LinearLayout linearLayout2=rootView.findViewById(R.id.example1);
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

        LinearLayout linearLayout3=rootView.findViewById(R.id.example2);
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

        LinearLayout linearLayout4=rootView.findViewById(R.id.example3);
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri4);
                mediaPlayer.start();*/
                doit(view,uri4);
            }
        });

        LinearLayout linearLayout5=rootView.findViewById(R.id.example4);
        linearLayout5.setOnClickListener(new View.OnClickListener() {
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

        LinearLayout linearLayout6=rootView.findViewById(R.id.example5);
        linearLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri6);
                mediaPlayer.start();*/
                doit(view,uri6);
            }
        });

        LinearLayout linearLayout7=rootView.findViewById(R.id.example6);
        linearLayout7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri7);
                mediaPlayer.start();*/
                doit(view,uri7);
            }
        });

        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        endit();
        /*mediaPlayer.stop();
        mediaPlayer.release();
        Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1_sentence1");
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
