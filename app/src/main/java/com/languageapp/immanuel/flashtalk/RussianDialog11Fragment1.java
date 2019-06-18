package com.languageapp.immanuel.flashtalk;

import android.content.Intent;
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
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class RussianDialog11Fragment1 extends Fragment {

    MediaPlayer mediaPlayer;
    int STEP_TIME=100;
    //ImageView volume;
    //ImageView pause;

    public RussianDialog11Fragment1() {
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
                Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/basic_verbs_fragment1");
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_dialog11_fragment1, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs")

        ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        //ImageButton games=(ImageButton)rootView.findViewById(R.id.games);
        final ViewPager viewPager=getActivity().findViewById(R.id.dialog11_pager);

        //final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/basic_verbs_fragment1");
        //mediaPlayer=MediaPlayer.create(rootView.getContext(),uri);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri);*/
                //volume.setVisibility(View.VISIBLE);
                //pause.setVisibility(View.GONE);
                getActivity().finish();
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
                intent.putExtra("LESSON_NAME","Dialogue 11 - A Hidden Joke");
                //pause.setVisibility(View.GONE);
                //volume.setVisibility(View.VISIBLE);
                startActivity(intent);
            }
        });

        TextView explanation1=(TextView)rootView.findViewById(R.id.example1);
        final TextView translation1=(TextView)rootView.findViewById(R.id.translation1);

        String str1="ГЕНЕРАЛ : Солдат, вчера я не видел тебя в классе!";
        String trans1="Soldier, yesterday I didn't see you in class!";
        //String str1_keyword1="самолёт";
        //String trans1_keyword1="airplane";
        String str1_name="ГЕНЕРАЛ :";

        SpannableString spannableString1=new SpannableString(str1);
        SpannableString spannableString1_trans=new SpannableString(trans1);
        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str1.indexOf(str1_name),str1.indexOf(str1_name)+str1_name.length(),0);
        //spannableString1.setSpan(new UnderlineSpan(),str1.indexOf(str1_keyword1),str1.indexOf(str1_keyword1)+str1_keyword1.length(),0);
        //spannableString1_trans.setSpan(new UnderlineSpan(),trans1.indexOf(trans1_keyword1),trans1.indexOf(trans1_keyword1)+trans1_keyword1.length(),0);
        explanation1.setText(spannableString1);
        translation1.setText(spannableString1_trans);


        TextView explanation2=(TextView)rootView.findViewById(R.id.example2);
        final TextView translation2=(TextView)rootView.findViewById(R.id.translation2);

        String str2="СОЛДАТ : Правда? Я не знаю. Какой класс?";
        String trans2="Really? I don't know. Which class?";
        String str2_name="СОЛДАТ :";
        /*String str2_keyword1="шутка";
        String trans2_keyword1="joke";
        String str2_keyword2="девушка";
        String trans2_keyword2="girlfriend";*/

        SpannableString spannableString2=new SpannableString(str2);
        SpannableString spannableString2_trans=new SpannableString(trans2);
        spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str2.indexOf(str2_name),str2.indexOf(str2_name)+str2_name.length(),0);
        //spannableString2.setSpan(new UnderlineSpan(),str2.indexOf(str2_keyword1),str2.indexOf(str2_keyword1)+str2_keyword1.length(),0);
        //spannableString2_trans.setSpan(new UnderlineSpan(),trans2.indexOf(trans2_keyword1),trans2.indexOf(trans2_keyword1)+trans2_keyword1.length(),0);
        //spannableString2.setSpan(new UnderlineSpan(),str2.indexOf(str2_keyword2),str2.indexOf(str2_keyword2)+str2_keyword2.length(),0);
        //spannableString2_trans.setSpan(new UnderlineSpan(),trans2.indexOf(trans2_keyword2),trans2.indexOf(trans2_keyword2)+trans2_keyword2.length(),0);

        explanation2.setText(spannableString2);
        translation2.setText(spannableString2_trans);

        TextView explanation3=(TextView)rootView.findViewById(R.id.example3);
        final TextView translation3=(TextView)rootView.findViewById(R.id.translation3);

        String str3="ГЕНЕРАЛ : Класс камуфляжа! Где ты был?";
        String trans3="The camoflauge class. Where were you?";
        String str3_name="ГЕНЕРАЛ :";
        //String str3_keyword1="Извини";
        //String trans3_keyword1="Sorry";

        SpannableString spannableString3=new SpannableString(str3);
        SpannableString spannableString3_trans=new SpannableString(trans3);
        spannableString3.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str3.indexOf(str3_name),str3.indexOf(str3_name)+str3_name.length(),0);
        //spannableString3.setSpan(new UnderlineSpan(),str3.indexOf(str3_keyword1),str3.indexOf(str3_keyword1)+str3_keyword1.length(),0);
        //spannableString3_trans.setSpan(new UnderlineSpan(),trans3.indexOf(trans3_keyword1),trans3.indexOf(trans3_keyword1)+trans3_keyword1.length(),0);
        explanation3.setText(spannableString3);
        translation3.setText(spannableString3_trans);

        TextView explanation4=(TextView)rootView.findViewById(R.id.example4);
        final TextView translation4=(TextView)rootView.findViewById(R.id.translation4);

        String str4="СОЛДАТ : Ой! Спасибо, Генерал!";
        String trans4="Oh! Thanks, General!";
        /*String str4_keyword1="другой";
        String trans4_keyword1="another";*/
        String str4_name="СОЛДАТ :";

        SpannableString spannableString4=new SpannableString(str4);
        SpannableString spannableString4_trans=new SpannableString(trans4);
        //spannableString4.setSpan(new UnderlineSpan(),str4.indexOf(str4_keyword1),str4.indexOf(str4_keyword1)+str4_keyword1.length(),0);
        //spannableString4_trans.setSpan(new UnderlineSpan(),trans4.indexOf(trans4_keyword1),trans4.indexOf(trans4_keyword1)+trans4_keyword1.length(),0);
        spannableString4.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str4.indexOf(str4_name),str4.indexOf(str4_name)+str4_name.length(),0);
        explanation4.setText(spannableString4);
        translation4.setText(spannableString4_trans);


        LinearLayout linearLayout1=rootView.findViewById(R.id.linearLayout1);
        final LinearLayout linearLayout2=rootView.findViewById(R.id.linearLayout2);
        final LinearLayout linearLayout3=rootView.findViewById(R.id.linearLayout3);
        final LinearLayout linearLayout4=rootView.findViewById(R.id.linearLayout4);
        /*final TextView explanation1=rootView.findViewById(R.id.explanation1);
        final TextView explanation2=rootView.findViewById(R.id.explanation2);
        final TextView explanation3=rootView.findViewById(R.id.explanation3);*/


        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(translation1.getVisibility()==View.VISIBLE){
                    translation1.setVisibility(View.GONE);
                }
                else{
                    translation1.setVisibility(View.VISIBLE);
                }
            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(translation2.getVisibility()==View.VISIBLE){
                    translation2.setVisibility(View.GONE);
                }
                else{
                    translation2.setVisibility(View.VISIBLE);
                }
            }
        });

        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(translation3.getVisibility()==View.VISIBLE){
                    translation3.setVisibility(View.GONE);
                }
                else{
                    translation3.setVisibility(View.VISIBLE);
                }
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(translation4.getVisibility()==View.VISIBLE){
                    translation4.setVisibility(View.GONE);
                }
                else{
                    translation4.setVisibility(View.VISIBLE);
                }
            }
        });


        final Uri uri1=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri2=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri3=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri4=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");

        linearLayout1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri1);
                mediaPlayer.start();*/
                doit(view,uri1);
                return true;
            }
        });

        linearLayout2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri2);
                mediaPlayer.start();*/
                doit(view,uri2);
                return true;
            }
        });

        linearLayout3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri3);
                mediaPlayer.start();*/
                doit(view,uri3);
                return true;
            }
        });
        linearLayout4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri4);
                mediaPlayer.start();*/
                doit(view,uri4);
                return true;
            }
        });


        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        /*mediaPlayer.stop();
        mediaPlayer.release();
        Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/basic_pronouns_fragment1_word1");
        mediaPlayer=MediaPlayer.create(getContext(),uri);*/
        endit();

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
