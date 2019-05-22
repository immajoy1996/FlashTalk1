package com.example.immanuel.flashtalk;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class RussianWhatManWhatWomanFragment2 extends Fragment {

    MediaPlayer mediaPlayer;
    int STEP_TIME=100;
    //ImageView volume;
    //ImageView pause;

    public RussianWhatManWhatWomanFragment2() {
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_what_man_what_woman_fragment2, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");

        TextView textView_intro=rootView.findViewById(R.id.intro);
        String str_intro="To say something like \"what class\" or \"which woman\", use this one. It acts just like an adjective! Notice that \"what\" and \"which\" are the same word in Russian. The meaning depends on context.";
        //String intro_keyword1="красиво";
        SpannableStringBuilder spannableStringBuilder_intro=new SpannableStringBuilder(str_intro);
        //spannableStringBuilder_intro.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str_intro.indexOf(intro_keyword1),str_intro.indexOf(intro_keyword1)+intro_keyword1.length(),0);
        //spannableStringBuilder_intro.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)),str_intro.indexOf("-ая"),str_intro.indexOf("-ая")+3,0);
        //spannableStringBuilder_intro.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str_intro.indexOf("-ое"),str_intro.indexOf("-ое")+3,0);
        textView_intro.setText(spannableStringBuilder_intro);

        TextView example1=rootView.findViewById(R.id.example1);
        String str1="Какой (kak-oy) класс?";
        String a1="Какой";
        String a2="класс";
        String a3="kak-oy";

        SpannableString spannableString1=new SpannableString(str1);
        spannableString1.setSpan(new StyleSpan(Typeface.BOLD), str1.indexOf(a1), str1.indexOf(a1)+a1.length(), 0);
        spannableString1.setSpan(new StyleSpan(Typeface.BOLD), str1.indexOf(a2), str1.indexOf(a2)+a2.length(), 0);
        spannableString1.setSpan(new StyleSpan(Typeface.ITALIC), str1.indexOf(a3), str1.indexOf(a3)+a3.length(), 0);
        example1.setText(spannableString1);

        TextView example2=rootView.findViewById(R.id.example2);
        String str2="Какая (kak-a-ya) девушка?";
        String b1="Какая";
        String b2="девушка";
        String b3="kak-a-ya";

        SpannableString spannableString2=new SpannableString(str2);
        spannableString2.setSpan(new StyleSpan(Typeface.BOLD), str2.indexOf(b1), str2.indexOf(b1)+b1.length(), 0);
        spannableString2.setSpan(new StyleSpan(Typeface.BOLD), str2.indexOf(b2), str2.indexOf(b2)+b2.length(), 0);
        spannableString2.setSpan(new StyleSpan(Typeface.ITALIC), str2.indexOf(b3), str2.indexOf(b3)+b3.length(), 0);
        example2.setText(spannableString2);

        TextView example3=rootView.findViewById(R.id.example3);
        String str3="Какое (kak-o-ye) место?";
        String c1="Какое";
        String c2="место";
        String c3="kak-o-ye";
        //String str3_keyword1="холодное";

        SpannableString spannableString3=new SpannableString(str3);
        spannableString3.setSpan(new StyleSpan(Typeface.BOLD), str3.indexOf(c1), str3.indexOf(c1)+c1.length(), 0);
        spannableString3.setSpan(new StyleSpan(Typeface.BOLD), str3.indexOf(c2), str3.indexOf(c2)+c2.length(), 0);
        spannableString3.setSpan(new StyleSpan(Typeface.ITALIC), str3.indexOf(c3), str3.indexOf(c3)+c3.length(), 0);
        example3.setText(spannableString3);

        /*TextView example4=rootView.findViewById(R.id.example4);
        String str4="Какой человек?";
        //String str4_keyword1="красивый";

        SpannableString spannableString4=new SpannableString(str4);
        //spannableString4.setSpan(new UnderlineSpan(), str4.indexOf(str4_keyword1), str4.indexOf(str4_keyword1)+str4_keyword1.length(), 0);
        example4.setText(spannableString4);

        TextView example5=rootView.findViewById(R.id.example5);
        String str5="Какая книга?";
        //String str5_keyword1="красивая";

        SpannableString spannableString5=new SpannableString(str5);
        //spannableString5.setSpan(new UnderlineSpan(), str5.indexOf(str5_keyword1), str5.indexOf(str5_keyword1)+str5_keyword1.length(), 0);
        example5.setText(spannableString5);

        TextView example6=rootView.findViewById(R.id.example6);
        String str6="Какое здание?";
        //String str6_keyword1="красивое";

        SpannableString spannableString6=new SpannableString(str6);
        //spannableString6.setSpan(new UnderlineSpan(), str6.indexOf(str6_keyword1), str6.indexOf(str6_keyword1)+str6_keyword1.length(), 0);
        example6.setText(spannableString6);*/

        /*TextView example7=rootView.findViewById(R.id.example7);
        String str7="Он красивый человек.";

        SpannableString spannableString7=new SpannableString(str7);
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

        final Uri uri1=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/wat1");
        final Uri uri2=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/wat2");
        final Uri uri3=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/wat3");
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

        //final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/basic_pronouns_fragment3");
        //mediaPlayer=MediaPlayer.create(rootView.getContext(),uri);

        ImageButton back_button=rootView.findViewById(R.id.back_button);
        //ImageButton forward_button=rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.whatmanwhatwoman_pager);

        CircularImageViewTest games=rootView.findViewById(R.id.games);
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri);*/
                endit();
                Intent intent=new Intent(view.getContext(),RussianLessonGamesSplashActivity.class);
                intent.putExtra("LESSON_NAME","What?");
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
                getActivity().finish();
            }
        });


        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        endit();
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
