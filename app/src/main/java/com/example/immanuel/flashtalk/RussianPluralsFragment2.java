package com.example.immanuel.flashtalk;

import android.content.Intent;
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
import android.widget.TextView;


public class RussianPluralsFragment2 extends Fragment {

    MediaPlayer mediaPlayer;
    int STEP_TIME=100;
    //ImageView volume;
    //ImageView pause;

    public RussianPluralsFragment2() {
        // Required empty public constructor
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        // Make sure that we are currently visible
        if (this.isVisible()) {
            // If we are becoming invisible, then...
            if (!isVisibleToUser) {
                endit();
                /*mediaPlayer.stop();
                mediaPlayer.release();
                Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/basic_pronouns_fragment2");
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_plurals_fragment2, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");
        /*TextView intro_textview=rootView.findViewById(R.id.intro);
        String str="In Russian, direct objects take the accusative case. The accusative case is very easy to form. Only feminine nouns change their structure.";

        SpannableString spannableString=new SpannableString(str);
        spannableString.setSpan(new UnderlineSpan(), str.indexOf("accusative case"), str.indexOf("accusative case")+15, 0);
        intro_textview.setText(spannableString);

        TextView rule1_textview=rootView.findViewById(R.id.rule1);
        String rule1_str="* If a fem. noun ends with an а, replace it with an у.";
        SpannableString spannableString_rule1=new SpannableString(rule1_str);
        spannableString_rule1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)),rule1_str.indexOf("fem."),rule1_str.indexOf("fem.")+4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        rule1_textview.setText(spannableString_rule1);

        TextView rule2_textview=rootView.findViewById(R.id.rule2);
        String rule2_str="* If a fem. noun ends with an я, replace it with an ю.";
        SpannableString spannableString_rule2=new SpannableString(rule2_str);
        spannableString_rule2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)),rule2_str.indexOf("fem."),rule2_str.indexOf("fem.")+4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        rule2_textview.setText(spannableString_rule2);*/

        ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        //ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.plurals_pager);

        //final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/question_words_fragment1");
        //mediaPlayer=MediaPlayer.create(rootView.getContext(),uri);

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
                intent.putExtra("LESSON_NAME","Plurals");
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

        TextView intro_textview=rootView.findViewById(R.id.intro);
        String str="It's a general rule in Russian that ы never comes after the letters  ш, г or к. Instead, it is replaced with и. You can remember this with the word \"GoalKeeper!\" Look how it affects plurals.";

        SpannableString spannableString=new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)), str.indexOf("G"), str.indexOf("G")+1, 0);
        //spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)), str.indexOf("Sh"), str.indexOf("Sh")+2, 0);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)), str.indexOf("K"), str.indexOf("K")+1, 0);

        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str.indexOf("ы"), str.indexOf("ы")+1, 0);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str.indexOf("ш"), str.indexOf("ш")+1, 0);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str.indexOf("г"), str.indexOf("г")+1, 0);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str.indexOf("к"), str.indexOf("к")+1, 0);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str.indexOf("и"), str.indexOf("и")+1, 0);

        spannableString.setSpan(new StyleSpan(Typeface.BOLD), str.indexOf("ы"), str.indexOf("ы")+1, 0);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), str.indexOf("ш"), str.indexOf("ш")+1, 0);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), str.indexOf("г"), str.indexOf("г")+1, 0);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), str.indexOf("к"), str.indexOf("к")+1, 0);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), str.indexOf("и"), str.indexOf("и")+1, 0);



        intro_textview.setText(spannableString);

        TextView example1_textview=rootView.findViewById(R.id.example1);
        String str1="девушка - девушки";
        String keyword1="девушки";

        SpannableString spannableString1=new SpannableString(str1);
        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str1.indexOf(keyword1), str1.indexOf(keyword1)+keyword1.length(), 0);
        example1_textview.setText(spannableString1);

        TextView example2_textview=rootView.findViewById(R.id.example2);
        String str2="книга - книги";
        String keyword2="книги";

        SpannableString spannableString2=new SpannableString(str2);
        spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str2.indexOf(keyword2), str2.indexOf(keyword2)+keyword2.length(), 0);
        example2_textview.setText(spannableString2);

        /*TextView example3_textview=rootView.findViewById(R.id.example3);
        String str3="карандаш - карандаши";

        SpannableString spannableString3=new SpannableString(str3);
        spannableString3.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str3.indexOf("карандаши"), str3.indexOf("карандаши")+9, 0);
        example3_textview.setText(spannableString3);*/

        final Uri uri1=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/glkdk1");
        final Uri uri2=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/glkdk2");
        //final Uri uri3=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");

        //TextView example1=rootView.findViewById(R.id.example1);
        example1_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                doit(view,uri1);
            }
        });

        //TextView example2=rootView.findViewById(R.id.example2);
        example2_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                doit(view,uri2);
            }
        });

        //TextView example3=rootView.findViewById(R.id.example3);
        /*example3_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri3);
                mediaPlayer.start();
            }
        });*/



        return rootView;
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
