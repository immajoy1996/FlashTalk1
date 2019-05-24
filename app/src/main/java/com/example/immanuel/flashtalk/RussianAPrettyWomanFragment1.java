package com.example.immanuel.flashtalk;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class RussianAPrettyWomanFragment1 extends Fragment {

    MediaPlayer mediaPlayer;
    int STEP_TIME=100;
    //ImageView volume;
    //ImageView pause;

    public RussianAPrettyWomanFragment1() {
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
                mediaPlayer=MediaPlayer.create(getContext(),uri);*/
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_apretty_woman_fragment1, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");

        SharedPreferences mPrefs=getContext().getSharedPreferences("Hints",0);
        String str0=mPrefs.getString("var_APrettyWoman","not shown");
        SharedPreferences.Editor mEditor=mPrefs.edit();

        if(str0.equals("not shown")) {

            SpannableString msg1 = new SpannableString("Click for audio. Swipe right to practice.");
            SpannableString msg2=new SpannableString("Click the quiz icon at the end of this lesson to test yourself.");
            (new MyApplication(getContext())).show_hints(getFragmentManager(), msg1,msg2,"-1","-1");
            mEditor.putString("var_APrettyWoman","shown");
            mEditor.commit();
        }

        TextView textView_intro=rootView.findViewById(R.id.intro);
        String str_intro="Making adjectives is easy. Just remove the final -о from the adverb and add the adjective ending. Whether you add -ый (ee), -ая (a-ya), or -ое (a-ye) depends on the gender of the noun. Get the pattern?";

        String keyword0="-о";

        String keyword1="-ый (ee)";
        String keyword2="-ая (a-ya)";
        String keyword3="-ое (a-ye)";

        String keyword4="ee";
        String keyword5="a-ya";
        String keyword6="a-ye";

        SpannableStringBuilder spannableStringBuilder_intro=new SpannableStringBuilder(str_intro);
        spannableStringBuilder_intro.setSpan(new StyleSpan(Typeface.BOLD),str_intro.indexOf(keyword0),str_intro.indexOf(keyword0)+keyword0.length(),0);
        spannableStringBuilder_intro.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str_intro.indexOf(keyword1),str_intro.indexOf(keyword1)+keyword1.length(),0);
        spannableStringBuilder_intro.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)),str_intro.indexOf(keyword2),str_intro.indexOf(keyword2)+keyword2.length(),0);
        spannableStringBuilder_intro.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str_intro.indexOf(keyword3),str_intro.indexOf(keyword3)+keyword3.length(),0);

        spannableStringBuilder_intro.setSpan(new StyleSpan(Typeface.BOLD),str_intro.indexOf(keyword1),str_intro.indexOf(keyword1)+3,0);
        spannableStringBuilder_intro.setSpan(new StyleSpan(Typeface.BOLD),str_intro.indexOf(keyword2),str_intro.indexOf(keyword2)+3,0);
        spannableStringBuilder_intro.setSpan(new StyleSpan(Typeface.BOLD),str_intro.indexOf(keyword3),str_intro.indexOf(keyword3)+3,0);

        spannableStringBuilder_intro.setSpan(new StyleSpan(Typeface.ITALIC),str_intro.indexOf(keyword4),str_intro.indexOf(keyword4)+keyword4.length(),0);
        spannableStringBuilder_intro.setSpan(new StyleSpan(Typeface.ITALIC),str_intro.indexOf(keyword5),str_intro.indexOf(keyword5)+keyword5.length(),0);
        spannableStringBuilder_intro.setSpan(new StyleSpan(Typeface.ITALIC),str_intro.indexOf(keyword6),str_intro.indexOf(keyword6)+keyword6.length(),0);


        textView_intro.setText(spannableStringBuilder_intro);

        TextView example1=rootView.findViewById(R.id.example1);
        String str1="Это интересный день.";
        String str1_keyword1="интересный";

        SpannableString spannableString1=new SpannableString(str1);
        spannableString1.setSpan(new UnderlineSpan(), str1.indexOf(str1_keyword1), str1.indexOf(str1_keyword1)+str1_keyword1.length(), 0);
        example1.setText(spannableString1);

        TextView example2=rootView.findViewById(R.id.example2);
        String str2="Это интересная книга.";
        String str2_keyword1="интересная";

        SpannableString spannableString2=new SpannableString(str2);
        spannableString2.setSpan(new UnderlineSpan(), str2.indexOf(str2_keyword1), str2.indexOf(str2_keyword1)+str2_keyword1.length(), 0);
        example2.setText(spannableString2);

        TextView example3=rootView.findViewById(R.id.example3);
        String str3="Это интересное место.";
        String str3_keyword1="интересное";

        SpannableString spannableString3=new SpannableString(str3);
        spannableString3.setSpan(new UnderlineSpan(), str3.indexOf(str3_keyword1), str3.indexOf(str3_keyword1)+str3_keyword1.length(), 0);
        example3.setText(spannableString3);

        /*TextView example4=rootView.findViewById(R.id.example4);
        String str4="Это холодный день.";
        String str4_keyword1="холодный";

        SpannableString spannableString4=new SpannableString(str4);
        spannableString4.setSpan(new UnderlineSpan(), str4.indexOf(str4_keyword1), str4.indexOf(str4_keyword1)+str4_keyword1.length(), 0);
        example4.setText(spannableString4);

        TextView example5=rootView.findViewById(R.id.example5);
        String str5="Это холодная погода.";
        String str5_keyword1="холодная";

        SpannableString spannableString5=new SpannableString(str5);
        spannableString5.setSpan(new UnderlineSpan(), str5.indexOf(str5_keyword1), str5.indexOf(str5_keyword1)+str5_keyword1.length(), 0);
        example5.setText(spannableString5);

        TextView example6=rootView.findViewById(R.id.example6);
        String str6="Это холодное здание.";
        String str6_keyword1="холодное";

        SpannableString spannableString6=new SpannableString(str6);
        spannableString6.setSpan(new UnderlineSpan(), str6.indexOf(str6_keyword1), str6.indexOf(str6_keyword1)+str6_keyword1.length(), 0);
        example6.setText(spannableString6);*/

        final Uri uri1=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/id1");
        final Uri uri2=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/id2");
        final Uri uri3=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/id3");
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

        /*LinearLayout linearLayout4=rootView.findViewById(R.id.linearLayout4);
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
        });

        LinearLayout linearLayout6=rootView.findViewById(R.id.linearLayout6);
        linearLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri6);
                mediaPlayer.start();
            }
        });*/


        //final TextView title=rootView.findViewById(R.id.title);
        //volume=rootView.findViewById(R.id.audio);
        //pause=rootView.findViewById(R.id.pause);
        //final SeekBar seekBar=rootView.findViewById(R.id.seekbar);
        //final LinearLayout seekbar_layout=rootView.findViewById(R.id.seekbar_layout);

        ImageButton back_button=rootView.findViewById(R.id.back_button);
        ImageButton forward_button=rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.prettywoman_pager);
        //final int MAX=mediaPlayer.getDuration() / STEP_TIME;

        //final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/question_words_fragment1");
        //mediaPlayer= MediaPlayer.create(rootView.getContext(),uri);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri);*/
                endit();
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

        //TextView example7=rootView.findViewById(R.id.example7);
        //String str7="Он красивый человек.";

        /*SpannableString spannableString7=new SpannableString(str7);
        spannableString7.setSpan(new UnderlineSpan(), str7.indexOf("красивый"), str7.indexOf("красивый")+8, 0);
        example7.setText(spannableString7);

        TextView example8=rootView.findViewById(R.id.example8);
        String str8="Она красивая девушка.";

        SpannableString spannableString8=new SpannableString(str8);
        spannableString8.setSpan(new UnderlineSpan(), str8.indexOf("красивая"), str8.indexOf("красивая")+8, 0);
        example8.setText(spannableString8);

        TextView example9=rootView.findViewById(R.id.example9);
        String str9="Это красивое место.";

        SpannableString spannableString9=new SpannableString(str9);
        spannableString9.setSpan(new UnderlineSpan(), str9.indexOf("красивое"), str9.indexOf("красивое")+8, 0);
        example9.setText(spannableString9);*/


        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        endit();
        /*mediaPlayer.stop();
        mediaPlayer.release();
        Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        mediaPlayer= MediaPlayer.create(getContext(),uri);*/

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
