package com.languageapp.immanuel.flashtalk;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.languageapp.immanuel.flashtalk.R;


public class RussianIHaveFragment2 extends Fragment {

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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_ihave_fragment2, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");

        ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.ihave_pager);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page-1);
            }
        });
        forward_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page+1);
            }
        });

        TextView intro1=rootView.findViewById(R.id.intro1);
        TextView intro2=rootView.findViewById(R.id.intro2);
        String str_intro1="In Russian, you don't say \"I have a car\". You literally say, \"In my possession, there is a car\".";
        String str_intro2="The preposition у means possession. The pronoun after у takes the accusative.";
        SpannableStringBuilder spannableStringBuilder_intro2=new SpannableStringBuilder(str_intro2);
        String keyword1="у means";
        String keyword2="у takes";
        spannableStringBuilder_intro2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str_intro2.indexOf(keyword1),str_intro2.indexOf(keyword1)+1,0);
        spannableStringBuilder_intro2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str_intro2.indexOf(keyword2),str_intro2.indexOf(keyword2)+1,0);
        spannableStringBuilder_intro2.setSpan(new StyleSpan(Typeface.BOLD),str_intro2.indexOf(keyword1),str_intro2.indexOf(keyword1)+1,0);
        spannableStringBuilder_intro2.setSpan(new StyleSpan(Typeface.BOLD),str_intro2.indexOf(keyword2),str_intro2.indexOf(keyword2)+1,0);
        intro2.setText(spannableStringBuilder_intro2);
        intro1.setText(str_intro1);

        TextView example1=rootView.findViewById(R.id.example1);
        String str1="У меня есть машина.";

        SpannableString spannableString1=new SpannableString(str1);
        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str1.indexOf("меня"), str1.indexOf("меня")+4, 0);
        example1.setText(spannableString1);

        TextView example2=rootView.findViewById(R.id.example2);
        String str2="У тебя есть машина.";

        SpannableString spannableString2=new SpannableString(str2);
        spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str2.indexOf("тебя"), str2.indexOf("тебя")+4, 0);
        example2.setText(spannableString2);

        //final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/basic_verbs_fragment1");
        //mediaPlayer=MediaPlayer.create(rootView.getContext(),uri);

        final Uri uri1=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri2=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        //final Uri uri3=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");

        LinearLayout linearLayout1=rootView.findViewById(R.id.linearLayout1);
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                doit(view,uri1);
            }
        });

        LinearLayout linearLayout2=rootView.findViewById(R.id.linearLayout2);
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                doit(view,uri2);
            }
        });

        /*TextView example3=rootView.findViewById(R.id.example3);
        String str3="У него есть хороший дом.";

        SpannableString spannableString3=new SpannableString(str3);
        spannableString3.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str3.indexOf("него"), str3.indexOf("него")+4, 0);
        example3.setText(spannableString3);

        TextView example4=rootView.findViewById(R.id.example4);
        String str4="У неё есть хороший дом.";

        SpannableString spannableString4=new SpannableString(str4);
        spannableString4.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str4.indexOf("неё"), str4.indexOf("неё")+3, 0);
        example4.setText(spannableString4);

        TextView example5=rootView.findViewById(R.id.example5);
        String str5="У них есть хорошая машина.";

        SpannableString spannableString5=new SpannableString(str5);
        spannableString5.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str5.indexOf("них"), str5.indexOf("них")+3, 0);
        example5.setText(spannableString5);


        /*String str_lit1="Lit. In my possession, there is a car";
        SpannableString spannableString_lit1=new SpannableString(str_lit1);
        spannableString_lit1.setSpan(new UnderlineSpan(),str_lit1.indexOf("Lit."),str_lit1.indexOf("Lit.")+4,0);

        TextView textView_lit1=rootView.findViewById(R.id.explanation_lit1);
        textView_lit1.setText(spannableString_lit1);



        String str_lit2="Lit. In your possession, there is a car";
        SpannableString spannableString_lit2=new SpannableString(str_lit2);
        spannableString_lit2.setSpan(new UnderlineSpan(),str_lit2.indexOf("Lit."),str_lit2.indexOf("Lit.")+4,0);

        TextView textView_lit2=rootView.findViewById(R.id.explanation_lit2);
        textView_lit2.setText(spannableString_lit2);



        String str_lit3="Lit. In his possession, there is a nice house";
        SpannableString spannableString_lit3=new SpannableString(str_lit3);
        spannableString_lit3.setSpan(new UnderlineSpan(),str_lit3.indexOf("Lit."),str_lit3.indexOf("Lit.")+4,0);

        TextView textView_lit3=rootView.findViewById(R.id.explanation_lit3);
        textView_lit3.setText(spannableString_lit3);



        String str_lit4="Lit. In her possession, there is a nice house";
        SpannableString spannableString_lit4=new SpannableString(str_lit4);
        spannableString_lit4.setSpan(new UnderlineSpan(),str_lit4.indexOf("Lit."),str_lit4.indexOf("Lit.")+4,0);

        TextView textView_lit4=rootView.findViewById(R.id.explanation_lit4);
        textView_lit4.setText(spannableString_lit4);



        String str_lit5="Lit. In her possession, there is a nice house";
        SpannableString spannableString_lit5=new SpannableString(str_lit5);
        spannableString_lit5.setSpan(new UnderlineSpan(),str_lit5.indexOf("Lit."),str_lit5.indexOf("Lit.")+4,0);

        TextView textView_lit5=rootView.findViewById(R.id.explanation_lit5);
        textView_lit5.setText(spannableString_lit5);*/




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
                }
            });

        }
    }
}
