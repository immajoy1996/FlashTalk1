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
import android.widget.LinearLayout;
import android.widget.TextView;


public class RussianIHaveFragment3 extends Fragment {

    MediaPlayer mediaPlayer;
    int STEP_TIME=100;
    //ImageView volume;
    //ImageView pause;

    public RussianIHaveFragment3() {
        // Required empty public constructor
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        // Make sure that we are currently visible
        if (this.isVisible()) {
            // If we are becoming invisible, then...
            if (!isVisibleToUser) {
                mediaPlayer.stop();
                mediaPlayer.release();
                Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/basic_verbs_fragment1");
                mediaPlayer= MediaPlayer.create(getContext(),uri);
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_ihave_fragment3, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");

        ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        //ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.ihave_pager);

        final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/basic_pronouns_fragment3");
        mediaPlayer=MediaPlayer.create(rootView.getContext(),uri);

        CircularImageView2 games=rootView.findViewById(R.id.games);
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri);
                Intent intent=new Intent(view.getContext(),RussianLessonGamesSplashActivity.class);
                intent.putExtra("LESSON_NAME","I Have");
                //pause.setVisibility(View.GONE);
                //volume.setVisibility(View.VISIBLE);
                startActivity(intent);
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page-1);
            }
        });

        final Uri uri1=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri2=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri3=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");

        LinearLayout linearLayout1=rootView.findViewById(R.id.linearLayout1);
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri1);
                mediaPlayer.start();
            }
        });

        LinearLayout linearLayout2=rootView.findViewById(R.id.linearLayout2);
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri2);
                mediaPlayer.start();
            }
        });

        LinearLayout linearLayout3=rootView.findViewById(R.id.linearLayout3);
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri3);
                mediaPlayer.start();
            }
        });

        TextView intro=rootView.findViewById(R.id.intro);
        String str="After у, the pronouns его, её and их become него, неё, and них respectively.";
        String intro_keyword1="него";
        String intro_keyword2="неё";
        String intro_keyword3="них";
        String intro_keyword4="у";
        String intro_keyword5="его, е";
        String intro_keyword6="её and";
        String intro_keyword7="их b";
        SpannableString spannableString=new SpannableString(str);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf(intro_keyword1),str.indexOf(intro_keyword1)+intro_keyword1.length(),0);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf(intro_keyword2),str.indexOf(intro_keyword2)+intro_keyword2.length(),0);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf(intro_keyword3),str.indexOf(intro_keyword3)+intro_keyword3.length(),0);

        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str.indexOf(intro_keyword1),str.indexOf(intro_keyword1)+intro_keyword1.length(),0);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str.indexOf(intro_keyword2),str.indexOf(intro_keyword2)+intro_keyword2.length(),0);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str.indexOf(intro_keyword3),str.indexOf(intro_keyword3)+intro_keyword3.length(),0);

        spannableString.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf(intro_keyword4),str.indexOf(intro_keyword4)+intro_keyword1.length(),0);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf(intro_keyword5),str.indexOf(intro_keyword5)+3,0);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf(intro_keyword6),str.indexOf(intro_keyword6)+2,0);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),str.indexOf(intro_keyword7),str.indexOf(intro_keyword7)+2,0);
        intro.setText(spannableString);
        //TextView intro=rootView.findViewById(R.id.intro);
        //TextView intro2=rootView.findViewById(R.id.intro2);
        //String str_intro="After у, the pronouns его, её and их become него, неё, and них respectively.";
        //String str_intro2="The preposition у means possession. The pronoun after у takes the accusative.";
        //SpannableStringBuilder spannableStringBuilder_intro2=new SpannableStringBuilder(str_intro2);
        //String keyword1="у means";
        //String keyword2="у takes";
        //String keyword3=""
        //spannableStringBuilder_intro2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str_intro2.indexOf(keyword1),str_intro2.indexOf(keyword1)+1,0);
        //spannableStringBuilder_intro2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str_intro2.indexOf(keyword2),str_intro2.indexOf(keyword2)+1,0);
        //intro.setText(spannableStringBuilder_intro2);
        //intro1.setText(str_intro1);

        TextView example1=rootView.findViewById(R.id.example1);
        String str1="У него есть брат.";
        String str1_keyword1="него";

        SpannableString spannableString1=new SpannableString(str1);
        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str1.indexOf(str1_keyword1), str1.indexOf(str1_keyword1)+str1_keyword1.length(), 0);
        example1.setText(spannableString1);

        TextView example2=rootView.findViewById(R.id.example2);
        String str2="У неё есть брат.";
        String str2_keyword1="неё";

        SpannableString spannableString2=new SpannableString(str2);
        spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str2.indexOf(str2_keyword1), str2.indexOf(str2_keyword1)+str2_keyword1.length(), 0);
        example2.setText(spannableString2);

        TextView example3=rootView.findViewById(R.id.example3);
        String str3="У них есть дом.";
        String str3_keyword1="них";

        SpannableString spannableString3=new SpannableString(str3);
        spannableString3.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str3.indexOf(str3_keyword1), str3.indexOf(str3_keyword1)+str3_keyword1.length(), 0);
        example3.setText(spannableString3);




        return rootView;
    }
}
