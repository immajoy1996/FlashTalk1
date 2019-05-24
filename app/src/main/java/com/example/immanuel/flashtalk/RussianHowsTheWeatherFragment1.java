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


public class RussianHowsTheWeatherFragment1 extends Fragment {

    MediaPlayer mediaPlayer;
    int STEP_TIME=100;
    //ImageView volume;
    //ImageView pause;

    public RussianHowsTheWeatherFragment1() {
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
            }
            else {
                // do what you like
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_hows_the_weather_fragment1, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");

        SharedPreferences mPrefs=getContext().getSharedPreferences("Hints",0);
        String str0=mPrefs.getString("var_HowsTheWeather","not shown");
        SharedPreferences.Editor mEditor=mPrefs.edit();

        if(str0.equals("not shown")) {

            SpannableString msg1 = new SpannableString("Read the instructions carefully! Swipe right to see new words.");
            //SpannableString msg2=new SpannableString("Swipe right to see");
            (new MyApplication(getContext())).show_hints(getFragmentManager(), msg1,"-1");
            mEditor.putString("var_HowsTheWeather","shown");
            mEditor.commit();
        }

        TextView intro_textview=rootView.findViewById(R.id.intro);
        String str_intro="хорошо is an adverb. It modifies a verb. All Russian adverbs end in a final -о. Read the dialogue between Anna and Sergei to learn a few more.";
        String keyword1="хорошо";
        String keyword2="-о";

        SpannableStringBuilder spannableStringBuilder_intro=new SpannableStringBuilder(str_intro);
        spannableStringBuilder_intro.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str_intro.indexOf(keyword1), str_intro.indexOf(keyword1)+keyword1.length(), 0);
        spannableStringBuilder_intro.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str_intro.indexOf(keyword2), str_intro.indexOf(keyword2)+keyword2.length(), 0);
        spannableStringBuilder_intro.setSpan(new StyleSpan(Typeface.BOLD), str_intro.indexOf(keyword1), str_intro.indexOf(keyword1)+keyword1.length(), 0);
        spannableStringBuilder_intro.setSpan(new StyleSpan(Typeface.BOLD), str_intro.indexOf(keyword2), str_intro.indexOf(keyword2)+keyword2.length(), 0);
        intro_textview.setText(spannableStringBuilder_intro);

        ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.howstheweather_pager);

        //final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/basic_verbs_fragment1");
        //mediaPlayer=MediaPlayer.create(rootView.getContext(),uri);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(view.getContext(),RussianLanguageActivity.class));
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
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page+1);
            }
        });


        final TextView example1=rootView.findViewById(R.id.example1);
        String str1="СЕРГЕЙ : Как погода сегодня?";
        String str1_name="СЕРГЕЙ";

        SpannableStringBuilder spannableStringBuilder1=new SpannableStringBuilder(str1);
        //SpannableString spannableString1=new SpannableString(str1);
        //spannableStringBuilder1.setSpan(new UnderlineSpan(), str1.indexOf("Холодно"), str1.indexOf("Холодно")+7, 0);
        //spannableStringBuilder1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str1.indexOf("Холодно"), str1.indexOf("Холодно")+7, 0);
        //spannableStringBuilder1.setSpan(new StyleSpan(Typeface.ITALIC),str1.indexOf(str1_name),str1.indexOf(str1_name)+str1_name.length(),0);
        example1.setText(spannableStringBuilder1);

        TextView example2=rootView.findViewById(R.id.example2);
        String str2="АННА : Очень интересно. Это не очень холодно и это не очень жарко.";
        String str2_name="АННА";
        String str2_keyword1="Очень";
        String str2_keyword2="интересно";
        String str2_keyword3="жарко";
        String str2_keyword4="холодно";

        SpannableStringBuilder spannableStringBuilder2=new SpannableStringBuilder(str2);
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str2.indexOf(str2_keyword2),str2.indexOf(str2_keyword2)+str2_keyword2.length(),0);
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str2.indexOf(str2_keyword3),str2.indexOf(str2_keyword3)+str2_keyword3.length(),0);
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str2.indexOf(str2_keyword4),str2.indexOf(str2_keyword4)+str2_keyword4.length(),0);
        //SpannableString spannableString1=new SpannableString(str1);
        spannableStringBuilder2.setSpan(new UnderlineSpan(), str2.indexOf(str2_keyword1), str2.indexOf(str2_keyword1)+str2_keyword1.length(), 0);
        //spannableStringBuilder2.setSpan(new StyleSpan(Typeface.ITALIC),str2.indexOf(str2_name),str2.indexOf(str2_name)+str2_name.length(),0);
        example2.setText(spannableStringBuilder2);

        TextView example3=rootView.findViewById(R.id.example3);
        String str3="СЕРГЕЙ : Хорошо. Ты говоришь по-русски очень хорошо!";
        String str3_name="СЕРГЕЙ";

        SpannableStringBuilder spannableStringBuilder3=new SpannableStringBuilder(str3);
        //SpannableString spannableString1=new SpannableString(str1);
        //spannableStringBuilder3.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str3.indexOf(keyword3), str3.indexOf(keyword3)+keyword3.length(), 0);
        //spannableStringBuilder3.setSpan(new UnderlineSpan(), str3.indexOf("Жарко"), str3.indexOf("Жарко")+5, 0);
        //spannableStringBuilder3.setSpan(new StyleSpan(Typeface.ITALIC),str3.indexOf(str3_name),str3.indexOf(str3_name)+str3_name.length(),0);
        example3.setText(spannableStringBuilder3);

        LinearLayout linearLayout1=rootView.findViewById(R.id.linearLayout1);
        LinearLayout linearLayout2=rootView.findViewById(R.id.linearLayout2);
        LinearLayout linearLayout3=rootView.findViewById(R.id.linearLayout3);

        final TextView explanation1=rootView.findViewById(R.id.explanation1);
        final TextView explanation2=rootView.findViewById(R.id.explanation2);
        final TextView explanation3=rootView.findViewById(R.id.explanation3);


        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(explanation1.getVisibility()==View.VISIBLE){
                    explanation1.setVisibility(View.GONE);
                }
                else{
                    explanation1.setVisibility(View.VISIBLE);
                }
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(explanation2.getVisibility()==View.VISIBLE){
                    explanation2.setVisibility(View.GONE);
                }
                else{
                    explanation2.setVisibility(View.VISIBLE);
                }
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(explanation3.getVisibility()==View.VISIBLE){
                    explanation3.setVisibility(View.GONE);
                }
                else{
                    explanation3.setVisibility(View.VISIBLE);
                }
            }
        });

        final Uri uri1=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri2=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri3=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");

        linearLayout1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                doit(view,uri1);
                return true;
            }
        });

        linearLayout2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                doit(view,uri2);
                return true;
            }
        });

        linearLayout3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                doit(view,uri3);
                return true;
            }
        });

        //TextView example4=rootView.findViewById(R.id.example4);
        //String str4="АННА : Ты говоришь по-русски очень хорошо!";

        //SpannableStringBuilder spannableStringBuilder4=new SpannableStringBuilder(str4);
        //SpannableString spannableString1=new SpannableString(str1);
        //spannableStringBuilder4.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str4.indexOf("хорошо"), str4.indexOf("хорошо")+6, 0);
        //spannableStringBuilder4.setSpan(new StyleSpan(Typeface.ITALIC),str4.indexOf("АННА"),str4.indexOf("АННА")+4,0);
        //example4.setText(spannableStringBuilder4);

        /*TextView example5=rootView.findViewById(R.id.example5);
        String str5="СЕРГЕЙ : Спасибо! Пока, Анна.";

        SpannableStringBuilder spannableStringBuilder5=new SpannableStringBuilder(str5);
        //SpannableString spannableString1=new SpannableString(str1);
        //spannableStringBuilder2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str2.indexOf("Холодно (khol-od-na)"), str2.indexOf("Холодно (khol-od-na)")+20, 0);
        spannableStringBuilder5.setSpan(new StyleSpan(Typeface.ITALIC),str5.indexOf("СЕРГЕЙ"),str5.indexOf("СЕРГЕЙ")+6,0);
        example5.setText(spannableStringBuilder5);*/


        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        endit();
        /*mediaPlayer.stop();
        mediaPlayer.release();
        Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/basic_pronouns_fragment1_word1");
        mediaPlayer=MediaPlayer.create(getContext(),uri);*/


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
