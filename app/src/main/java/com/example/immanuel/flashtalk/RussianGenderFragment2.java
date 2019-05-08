package com.example.immanuel.flashtalk;

import android.content.Intent;
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
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class RussianGenderFragment2 extends Fragment {

    MediaPlayer mediaPlayer;
    int STEP_TIME=100;
    //ImageView volume;
    //ImageView pause;

    public RussianGenderFragment2() {
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
                Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/nouns_fragment2_sentence1");
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_gender_fragment2, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");

        final Uri uri1=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/nouns_fragment2_sentence1");
        final Uri uri2=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/nouns_fragment2_sentence2");
        final Uri uri3=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/nouns_fragment2_sentence3");
        final Uri uri4=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/nouns_fragment2_sentence4");
        final Uri uri5=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/nouns_fragment2_sentence5");
        final Uri uri6=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/nouns_fragment2_sentence6");
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

        LinearLayout linearLayout4=rootView.findViewById(R.id.linearLayout4);
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri1);
                mediaPlayer.start();*/
                doit(view,uri4);
            }
        });

        LinearLayout linearLayout5=rootView.findViewById(R.id.linearLayout5);
        linearLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri2);
                mediaPlayer.start();*/
                doit(view,uri5);
            }
        });

        LinearLayout linearLayout6=rootView.findViewById(R.id.linearLayout6);
        linearLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri3);
                mediaPlayer.start();*/
                doit(view,uri6);
            }
        });

        String str="Whether you use мой, моя, or моё depends on the gender of the noun. Get the pattern?";

        SpannableStringBuilder ssBuilder = new SpannableStringBuilder(str);

        ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str.indexOf("мой"),str.indexOf("мой")+3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)),str.indexOf("моя"),str.indexOf("моя")+3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str.indexOf("моё"),str.indexOf("моё")+3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        ssBuilder.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf("мой"),str.indexOf("мой")+3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf("моя"),str.indexOf("моя")+3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf("моё"),str.indexOf("моё")+3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView textView=rootView.findViewById(R.id.intro);
        textView.setText(ssBuilder);

        String str_textView1="мой (moy) дом";
        String str_textView2="моя (ma-ya) машина";
        String str_textView3="моё (ma-yo) фото";
        String str_textView4="твой (t-voy) дом";
        String str_textView5="твоя (t-va-ya) машина";
        String str_textView6="твоё (t-va-yo) фото";

        String keyword1="moy";
        String keyword2="ma-ya";
        String keyword3="ma-yo";
        String keyword4="t-voy";
        String keyword5="t-va-ya";
        String keyword6="t-va-yo";

        String a1="мой";
        String a2="дом";
        String b1="моя";
        String b2="машина";
        String c1="моё";
        String c2="фото";
        String d1="твой";
        String d2="дом";
        String e1="твоя";
        String e2="машина";
        String f1="твоё";
        String f2="фото";

        TextView textView1=rootView.findViewById(R.id.textview1);
        TextView textView2=rootView.findViewById(R.id.textview2);
        TextView textView3=rootView.findViewById(R.id.textview3);
        TextView textView4=rootView.findViewById(R.id.textview4);
        TextView textView5=rootView.findViewById(R.id.textview5);
        TextView textView6=rootView.findViewById(R.id.textview6);

        SpannableString spannableString1=new SpannableString(str_textView1);
        SpannableString spannableString2=new SpannableString(str_textView2);
        SpannableString spannableString3=new SpannableString(str_textView3);
        SpannableString spannableString4=new SpannableString(str_textView4);
        SpannableString spannableString5=new SpannableString(str_textView5);
        SpannableString spannableString6=new SpannableString(str_textView6);

        spannableString1.setSpan(new StyleSpan(Typeface.ITALIC),str_textView1.indexOf(keyword1),str_textView1.indexOf(keyword1)+keyword1.length(),0);
        spannableString2.setSpan(new StyleSpan(Typeface.ITALIC),str_textView2.indexOf(keyword2),str_textView2.indexOf(keyword2)+keyword2.length(),0);
        spannableString3.setSpan(new StyleSpan(Typeface.ITALIC),str_textView3.indexOf(keyword3),str_textView3.indexOf(keyword3)+keyword3.length(),0);
        spannableString4.setSpan(new StyleSpan(Typeface.ITALIC),str_textView4.indexOf(keyword4),str_textView5.indexOf(keyword5)+keyword5.length(),0);
        spannableString5.setSpan(new StyleSpan(Typeface.ITALIC),str_textView5.indexOf(keyword5),str_textView5.indexOf(keyword5)+keyword5.length(),0);
        spannableString6.setSpan(new StyleSpan(Typeface.ITALIC),str_textView6.indexOf(keyword6),str_textView6.indexOf(keyword6)+keyword6.length(),0);

        spannableString1.setSpan(new StyleSpan(Typeface.BOLD),str_textView1.indexOf(a1),str_textView1.indexOf(a1)+a1.length(),0);
        spannableString1.setSpan(new StyleSpan(Typeface.BOLD),str_textView1.indexOf(a2),str_textView1.indexOf(a2)+a2.length(),0);
        spannableString2.setSpan(new StyleSpan(Typeface.BOLD),str_textView2.indexOf(b1),str_textView2.indexOf(b1)+b1.length(),0);
        spannableString2.setSpan(new StyleSpan(Typeface.BOLD),str_textView2.indexOf(b2),str_textView2.indexOf(b2)+b2.length(),0);
        spannableString3.setSpan(new StyleSpan(Typeface.BOLD),str_textView3.indexOf(c1),str_textView3.indexOf(c1)+c1.length(),0);
        spannableString3.setSpan(new StyleSpan(Typeface.BOLD),str_textView3.indexOf(c2),str_textView3.indexOf(c2)+c2.length(),0);

        spannableString4.setSpan(new StyleSpan(Typeface.BOLD),str_textView4.indexOf(d1),str_textView4.indexOf(d1)+d1.length(),0);
        spannableString4.setSpan(new StyleSpan(Typeface.BOLD),str_textView4.indexOf(d2),str_textView4.indexOf(d2)+d2.length(),0);
        spannableString5.setSpan(new StyleSpan(Typeface.BOLD),str_textView5.indexOf(e1),str_textView5.indexOf(e1)+e1.length(),0);
        spannableString5.setSpan(new StyleSpan(Typeface.BOLD),str_textView5.indexOf(e2),str_textView5.indexOf(e2)+e2.length(),0);
        spannableString6.setSpan(new StyleSpan(Typeface.BOLD),str_textView6.indexOf(f1),str_textView6.indexOf(f1)+f1.length(),0);
        spannableString6.setSpan(new StyleSpan(Typeface.BOLD),str_textView6.indexOf(f2),str_textView6.indexOf(f2)+f2.length(),0);


        textView1.setText(spannableString1);
        textView2.setText(spannableString2);
        textView3.setText(spannableString3);
        textView4.setText(spannableString4);
        textView5.setText(spannableString5);
        textView6.setText(spannableString6);

        /*final TextView title=rootView.findViewById(R.id.title);
        volume=rootView.findViewById(R.id.audio);
        pause=rootView.findViewById(R.id.pause);
        final SeekBar seekBar=rootView.findViewById(R.id.seekbar);
        final LinearLayout seekbar_layout=rootView.findViewById(R.id.seekbar_layout);*/

        ImageButton back_button=rootView.findViewById(R.id.back_button);
        //ImageButton forward_button=rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.russian_gender_pager);
        //final int MAX=mediaPlayer.getDuration() / STEP_TIME;

        //final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/nouns_fragment2_sentence1");
        //mediaPlayer=MediaPlayer.create(rootView.getContext(),uri);

        CircularImageViewTest games=rootView.findViewById(R.id.games);
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri);*/
                endit();
                Intent intent=new Intent(view.getContext(),RussianLessonGamesSplashActivity.class);
                intent.putExtra("LESSON_NAME","Nouns");
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
