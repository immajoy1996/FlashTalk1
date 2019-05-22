package com.example.immanuel.flashtalk;

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


public class RussianDativeFragment1 extends Fragment {

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
                Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/basic_pronouns_fragment2");
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

    public RussianDativeFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_dative_fragment1, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");

        ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.dative_pager);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(view.getContext(),RussianLanguageActivity.class));
                endit();
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

        final Uri uri1=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/tome1_1");
        final Uri uri2=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/tome1_2");
        //final Uri uri3=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");

        TextView example1=rootView.findViewById(R.id.example1);
        example1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer= MediaPlayer.create(getContext(),uri1);
                mediaPlayer.start();*/
                doit(view,uri1);
            }
        });

        TextView example2=rootView.findViewById(R.id.example2);
        example2.setOnClickListener(new View.OnClickListener() {
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


        TextView intro_textview=rootView.findViewById(R.id.intro);
        String str="This is the last major lesson on FlashTalk! In Russian, to say \"to me\", \"to you\", \"to him\" etc., we use special pronouns. Get the pattern?";
        //String keyword1="из means";

        SpannableString spannableString=new SpannableString(str);
        //spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)), str.indexOf(keyword1), str.indexOf(keyword1)+2, 0);
        intro_textview.setText(spannableString);

        TextView example1_textview=rootView.findViewById(R.id.example1);
        String str1="to me - мне (mn-ye)";

        SpannableString spannableString1=new SpannableString(str1);
        String keyword1="мне (mn-ye)";
        String a1="мне";
        String a2="mn-ye";
        spannableString1.setSpan(new StyleSpan(Typeface.BOLD), str1.indexOf(a1), str1.indexOf(a1)+a1.length(), 0);
        spannableString1.setSpan(new StyleSpan(Typeface.ITALIC), str1.indexOf(a2), str1.indexOf(a2)+a2.length(), 0);
        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str1.indexOf(keyword1), str1.indexOf(keyword1)+keyword1.length(), 0);
        example1_textview.setText(spannableString1);

        TextView example2_textview=rootView.findViewById(R.id.example2);
        String str2="to you - тебе (teb-ye)";
        String keyword2="тебе (teb-ye)";
        String b1="тебе";
        String b2="teb-ye";

        SpannableString spannableString2=new SpannableString(str2);
        spannableString2.setSpan(new StyleSpan(Typeface.BOLD), str2.indexOf(b1), str2.indexOf(b1)+b1.length(), 0);
        spannableString2.setSpan(new StyleSpan(Typeface.ITALIC), str2.indexOf(b2), str2.indexOf(b2)+b2.length(), 0);
        spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str2.indexOf(keyword2), str2.indexOf(keyword2)+keyword2.length(), 0);
        example2_textview.setText(spannableString2);

        /*TextView example3_textview=rootView.findViewById(R.id.example3);
        String str3="Мы из Франции.";

        SpannableString spannableString3=new SpannableString(str3);
        //spannableString3.setSpan(new UnderlineSpan(), str3.indexOf("him"), str3.indexOf("him")+3, 0);
        example3_textview.setText(spannableString3);*/

        /*SpannableStringBuilder ssBuilder = new SpannableStringBuilder(str);

        ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str.indexOf("masculine"),str.indexOf("masculine")+9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)),str.indexOf("feminine"),str.indexOf("feminine")+8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str.indexOf("neuter"),str.indexOf("neuter")+6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        */

        //ssBuilder.setSpan(new StyleSpan(Typeface.ITALIC),55,65, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //ssBuilder.setSpan(new StyleSpan(Typeface.ITALIC),66,75, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //ssBuilder.setSpan(new StyleSpan(Typeface.ITALIC),79,86, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

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
