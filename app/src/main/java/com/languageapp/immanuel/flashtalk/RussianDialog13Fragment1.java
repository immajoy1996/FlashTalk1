package com.languageapp.immanuel.flashtalk;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class RussianDialog13Fragment1 extends Fragment {

    MediaPlayer mediaPlayer;
    int STEP_TIME=100;
    //ImageView volume;
    //ImageView pause;

    public RussianDialog13Fragment1() {
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_dialog13_fragment1, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs")

        ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.dialog13_pager);

        //final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/basic_verbs_fragment1");
        //mediaPlayer=MediaPlayer.create(rootView.getContext(),uri);

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
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page+1);
            }
        });

        TextView explanation1=(TextView)rootView.findViewById(R.id.example1);
        final TextView translation1=(TextView)rootView.findViewById(R.id.translation1);

        String str1="ДОНАЛЬД : Привет, Владимир. Как ты? Как твоя жизнь?";
        String trans1="Hi, Vladimir? How are you? How's your life?";
        String str1_name="ДОНАЛЬД :";

        SpannableString spannableString1=new SpannableString(str1);
        SpannableString spannableString1_trans=new SpannableString(trans1);
        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str1.indexOf(str1_name),str1.indexOf(str1_name)+str1_name.length(),0);
        explanation1.setText(spannableString1);
        translation1.setText(spannableString1_trans);


        TextView explanation2=(TextView)rootView.findViewById(R.id.example2);
        final TextView translation2=(TextView)rootView.findViewById(R.id.translation2);

        String str2="ВЛАДИМИР : Я очень хорошо, спасибо. А ты как? Как твоя жизнь?";
        String trans2="I'm very good, thanks. And how are you? How's your life?";
        String str2_name="ВЛАДИМИР :";
        //String str2_keyword1="совсем";
        //String trans2_keyword1="at all";
        //String str2_keyword2="Потому что";
        //String trans2_keyword2="Because";

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

        String str3="ДОНАЛЬД : Ха-Ха, лучше, чем твоя!";
        String trans3="Ha Ha, better than yours!";
        String str3_name="ДОНАЛЬД :";

        SpannableString spannableString3=new SpannableString(str3);
        SpannableString spannableString3_trans=new SpannableString(trans3);
        spannableString3.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str3.indexOf(str3_name),str3.indexOf(str3_name)+str3_name.length(),0);
        explanation3.setText(spannableString3);
        translation3.setText(spannableString3_trans);

        TextView explanation4=(TextView)rootView.findViewById(R.id.example4);
        final TextView translation4=(TextView)rootView.findViewById(R.id.translation4);

        String str4="ВЛАДИМИР : Что? Почему?";
        String trans4="What? Why?";
        //String str4_keyword1="все";
        //String trans4_keyword1="everyone";
        String str4_name="ВЛАДИМИР :";

        SpannableString spannableString4=new SpannableString(str4);
        SpannableString spannableString4_trans=new SpannableString(trans4);
        //spannableString4.setSpan(new UnderlineSpan(),str4.indexOf(str4_keyword1),str4.indexOf(str4_keyword1)+str4_keyword1.length(),0);
        //spannableString4_trans.setSpan(new UnderlineSpan(),trans4.indexOf(trans4_keyword1),trans4.indexOf(trans4_keyword1)+trans4_keyword1.length(),0);
        spannableString4.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str4.indexOf(str4_name),str4.indexOf(str4_name)+str4_name.length(),0);
        explanation4.setText(spannableString4);
        translation4.setText(spannableString4_trans);

        TextView explanation5=(TextView)rootView.findViewById(R.id.example5);
        final TextView translation5=(TextView)rootView.findViewById(R.id.translation5);

        String str5="ДОНАЛЬД : Потому что я живу в Америке. Америка - самая лучшая страна в мире!";
        String trans5="Because I live in America. America is the best country in the world!";
        String str5_name="ДОНАЛЬД :";

        SpannableString spannableString5=new SpannableString(str5);
        SpannableString spannableString5_trans=new SpannableString(trans5);
        spannableString5.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str5.indexOf(str5_name),str5.indexOf(str5_name)+str5_name.length(),0);
        explanation5.setText(spannableString5);
        translation5.setText(spannableString5_trans);

        TextView explanation6=(TextView)rootView.findViewById(R.id.example6);
        final TextView translation6=(TextView)rootView.findViewById(R.id.translation6);

        String str6="ВЛАДИМИР : Это неправда! Россия - самая лучшая страна в мире.";
        String trans6="That's not true! Russia is the best country in the world.";
        String str6_name="ВЛАДИМИР :";
        //String str5_keyword1="почему";
        //String trans5_keyword1="why";
        SpannableString spannableString6=new SpannableString(str6);
        SpannableString spannableString6_trans=new SpannableString(trans6);
        //spannableString5.setSpan(new UnderlineSpan(),str5.indexOf(str5_keyword1),str5.indexOf(str5_keyword1)+str5_keyword1.length(),0);
        //spannableString5_trans.setSpan(new UnderlineSpan(),trans5.indexOf(trans5_keyword1),trans5.indexOf(trans5_keyword1)+trans5_keyword1.length(),0);
        spannableString6.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str6.indexOf(str6_name),str6.indexOf(str6_name)+str6_name.length(),0);
        explanation6.setText(spannableString6);
        translation6.setText(spannableString6_trans);


        TextView explanation7=(TextView)rootView.findViewById(R.id.example7);
        final TextView translation7=(TextView)rootView.findViewById(R.id.translation7);

        String str7="ДОНАЛЬД : Нет. В Америке - самые лучшие технологии, самые лучшие люди и самый лучший президент, конечно!";
        String trans7="No. In America, there's the best technology, the best people, and the best president, of course!";
        String str7_name="ДОНАЛЬД :";
        //String str5_keyword1="почему";
        //String trans5_keyword1="why";
        SpannableString spannableString7=new SpannableString(str7);
        SpannableString spannableString7_trans=new SpannableString(trans7);
        spannableString7.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str7.indexOf(str7_name),str7.indexOf(str7_name)+str7_name.length(),0);
        //spannableString5.setSpan(new UnderlineSpan(),str5.indexOf(str5_keyword1),str5.indexOf(str5_keyword1)+str5_keyword1.length(),0);
        //spannableString5_trans.setSpan(new UnderlineSpan(),trans5.indexOf(trans5_keyword1),trans5.indexOf(trans5_keyword1)+trans5_keyword1.length(),0);
        explanation7.setText(spannableString7);
        translation7.setText(spannableString7_trans);

        TextView explanation8=(TextView)rootView.findViewById(R.id.example8);
        final TextView translation8=(TextView)rootView.findViewById(R.id.translation8);

        String str8="ВЛАДИМИР : Нет. В России - самая лучшая армия, самая лучшая водка и самый лучший президент.";
        String trans8="No. In Russia, there's the best army, the best vodka and the best president.";
        String str8_name="ВЛАДИМИР :";
        //String str8_keyword1="учитель";
        //String trans8_keyword1="teacher";
        SpannableString spannableString8=new SpannableString(str8);
        SpannableString spannableString8_trans=new SpannableString(trans8);
        //spannableString8.setSpan(new UnderlineSpan(),str8.indexOf(str8_keyword1),str8.indexOf(str8_keyword1)+str8_keyword1.length(),0);
        //spannableString8_trans.setSpan(new UnderlineSpan(),trans8.indexOf(trans8_keyword1),trans8.indexOf(trans8_keyword1)+trans8_keyword1.length(),0);
        spannableString8.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str8.indexOf(str8_name),str8.indexOf(str8_name)+str8_name.length(),0);
        explanation8.setText(spannableString8);
        translation8.setText(spannableString8_trans);


        TextView explanation9=(TextView)rootView.findViewById(R.id.example9);
        final TextView translation9=(TextView)rootView.findViewById(R.id.translation9);

        String str9="ДОНАЛЬД : Это неправда!";
        String trans9="That's not true!";
        String str9_name="ДОНАЛЬД :";
        //String str9_keyword1="Молодец";
        //String trans9_keyword1="Well done!";
        SpannableString spannableString9=new SpannableString(str9);
        SpannableString spannableString9_trans=new SpannableString(trans9);
        //spannableString9.setSpan(new UnderlineSpan(),str9.indexOf(str9_keyword1),str9.indexOf(str9_keyword1)+str9_keyword1.length(),0);
        //spannableString9_trans.setSpan(new UnderlineSpan(),trans9.indexOf(trans9_keyword1),trans9.indexOf(trans9_keyword1)+trans9_keyword1.length(),0);
        spannableString9.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str9.indexOf(str9_name),str9.indexOf(str9_name)+str9_name.length(),0);
        explanation9.setText(spannableString9);
        translation9.setText(spannableString9_trans);


        TextView explanation10=(TextView)rootView.findViewById(R.id.example10);
        final TextView translation10=(TextView)rootView.findViewById(R.id.translation10);

        String str10="ВЛАДИМИР : Нет, это правда. Это просто твоё мнение!";
        String trans10="No, it's true. That's just your opinion!";
        String str10_name="ВЛАДИМИР :";
        String str10_keyword1="мнение";
        String trans10_keyword1="opinion";
        SpannableString spannableString10=new SpannableString(str10);
        SpannableString spannableString10_trans=new SpannableString(trans10);
        spannableString10.setSpan(new UnderlineSpan(),str10.indexOf(str10_keyword1),str10.indexOf(str10_keyword1)+str10_keyword1.length(),0);
        spannableString10_trans.setSpan(new UnderlineSpan(),trans10.indexOf(trans10_keyword1),trans10.indexOf(trans10_keyword1)+trans10_keyword1.length(),0);
        spannableString10.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str10.indexOf(str10_name),str10.indexOf(str10_name)+str10_name.length(),0);
        explanation10.setText(spannableString10);
        translation10.setText(spannableString10_trans);


        LinearLayout linearLayout1=rootView.findViewById(R.id.linearLayout1);
        LinearLayout linearLayout2=rootView.findViewById(R.id.linearLayout2);
        LinearLayout linearLayout3=rootView.findViewById(R.id.linearLayout3);
        LinearLayout linearLayout4=rootView.findViewById(R.id.linearLayout4);
        LinearLayout linearLayout5=rootView.findViewById(R.id.linearLayout5);
        LinearLayout linearLayout6=rootView.findViewById(R.id.linearLayout6);
        LinearLayout linearLayout7=rootView.findViewById(R.id.linearLayout7);
        LinearLayout linearLayout8=rootView.findViewById(R.id.linearLayout8);
        LinearLayout linearLayout9=rootView.findViewById(R.id.linearLayout9);
        LinearLayout linearLayout10=rootView.findViewById(R.id.linearLayout10);

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

        linearLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(translation5.getVisibility()==View.VISIBLE){
                    translation5.setVisibility(View.GONE);
                }
                else{
                    translation5.setVisibility(View.VISIBLE);
                }
            }
        });

        linearLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(translation6.getVisibility()==View.VISIBLE){
                    translation6.setVisibility(View.GONE);
                }
                else{
                    translation6.setVisibility(View.VISIBLE);
                }
            }
        });
        linearLayout7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(translation7.getVisibility()==View.VISIBLE){
                    translation7.setVisibility(View.GONE);
                }
                else{
                    translation7.setVisibility(View.VISIBLE);
                }
            }
        });

        linearLayout8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(translation8.getVisibility()==View.VISIBLE){
                    translation8.setVisibility(View.GONE);
                }
                else{
                    translation8.setVisibility(View.VISIBLE);
                }
            }
        });

        linearLayout9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(translation9.getVisibility()==View.VISIBLE){
                    translation9.setVisibility(View.GONE);
                }
                else{
                    translation9.setVisibility(View.VISIBLE);
                }
            }
        });
        linearLayout10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(translation10.getVisibility()==View.VISIBLE){
                    translation10.setVisibility(View.GONE);
                }
                else{
                    translation10.setVisibility(View.VISIBLE);
                }
            }
        });



        final Uri uri1=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/isj1");
        final Uri uri2=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/dimi1");
        final Uri uri3=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/isj3");
        final Uri uri4=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/dimi2");
        final Uri uri5=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/isj5");
        final Uri uri6=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/dimi3");
        final Uri uri7=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/isj7");
        final Uri uri8=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/dimi4");
        final Uri uri9=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/isj9");
        final Uri uri10=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/dimi5");

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

        linearLayout5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri5);
                mediaPlayer.start();*/
                doit(view,uri5);
                return true;
            }
        });

        linearLayout6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri6);
                mediaPlayer.start();*/
                doit(view,uri6);
                return true;
            }
        });
        linearLayout7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri7);
                mediaPlayer.start();*/
                doit(view,uri7);
                return true;
            }
        });

        linearLayout8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri8);
                mediaPlayer.start();*/
                doit(view,uri8);
                return true;
            }
        });

        linearLayout9.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri9);
                mediaPlayer.start();*/
                doit(view,uri9);
                return true;
            }
        });
        linearLayout10.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri10);
                mediaPlayer.start();*/
                doit(view,uri10);
                return true;
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
