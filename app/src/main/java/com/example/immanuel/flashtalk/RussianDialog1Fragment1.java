package com.example.immanuel.flashtalk;

import android.content.SharedPreferences;
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


public class RussianDialog1Fragment1 extends Fragment {

    MediaPlayer mediaPlayer;
    int STEP_TIME=100;

    //ImageView volume;
    //ImageView pause;

    public RussianDialog1Fragment1() {
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_dialog1_fragment1, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs")

        SharedPreferences mPrefs=getContext().getSharedPreferences("Hints",0);
        String str0=mPrefs.getString("var_Dialog1","not shown");
        SharedPreferences.Editor mEditor=mPrefs.edit();

        if(str0.equals("not shown")) {

            SpannableString msg1 = new SpannableString("Read the instructions carefully! Swipe right to see new words.");
            //SpannableString msg2=new SpannableString("Click the quiz icon at the end of this lesson to test yourself.");
            (new MyApplication(getContext())).show_hints(getFragmentManager(), msg1,"-1");
            mEditor.putString("var_Dialog1","shown");
            mEditor.commit();
        }

        ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.dialog1_pager);

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

        String str1="НАТАША : Привет Джон. Что ты делаешь?";
        String trans1="Hello John. What are you doing?";
        String str1_name="НАТАША :";

        SpannableString spannableString1=new SpannableString(str1);
        SpannableString spannableString1_trans=new SpannableString(trans1);
        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str1.indexOf(str1_name),str1.indexOf(str1_name)+str1_name.length(),0);
        explanation1.setText(spannableString1);
        translation1.setText(spannableString1_trans);


        TextView explanation2=(TextView)rootView.findViewById(R.id.example2);
        final TextView translation2=(TextView)rootView.findViewById(R.id.translation2);

        String str2="ДЖОН : Баскетбол.";
        String trans2="Basketball.";
        String str2_name="ДЖОН :";
        //String trans2_keyword1="homework";
        SpannableString spannableString2=new SpannableString(str2);
        SpannableString spannableString2_trans=new SpannableString(trans2);
        spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str2.indexOf(str2_name),str2.indexOf(str2_name)+str2_name.length(),0);
        //spannableString2.setSpan(new UnderlineSpan(),str2.indexOf(str2_keyword1),str2.indexOf(str2_keyword1)+str2_keyword1.length(),0);
        //spannableString2_trans.setSpan(new UnderlineSpan(),trans2.indexOf(trans2_keyword1),trans2.indexOf(trans2_keyword1)+trans2_keyword1.length(),0);
        explanation2.setText(spannableString2);
        translation2.setText(spannableString2_trans);

        TextView explanation3=(TextView)rootView.findViewById(R.id.example3);
        final TextView translation3=(TextView)rootView.findViewById(R.id.translation3);

        String str3="НАТАША : Ты делаешь задание?";
        String trans3="Are you doing the homework?";
        String str3_keyword1="задание";
        String trans3_keyword1="homework";
        String str3_name="НАТАША :";

        SpannableString spannableString3=new SpannableString(str3);
        SpannableString spannableString3_trans=new SpannableString(trans3);
        spannableString3.setSpan(new UnderlineSpan(),str3.indexOf(str3_keyword1),str3.indexOf(str3_keyword1)+str3_keyword1.length(),0);
        spannableString3_trans.setSpan(new UnderlineSpan(),trans3.indexOf(trans3_keyword1),trans3.indexOf(trans3_keyword1)+trans3_keyword1.length(),0);
        spannableString3.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str3.indexOf(str3_name),str3.indexOf(str3_name)+str3_name.length(),0);
        explanation3.setText(spannableString3);
        translation3.setText(spannableString3_trans);

        TextView explanation4=(TextView)rootView.findViewById(R.id.example4);
        final TextView translation4=(TextView)rootView.findViewById(R.id.translation4);

        String str4="ДЖОН : Нет, конечно нет!";
        String trans4="No, of course not!";
        String str4_keyword1="конечно";
        String trans4_keyword1="of course";
        String str4_name="ДЖОН :";

        SpannableString spannableString4=new SpannableString(str4);
        SpannableString spannableString4_trans=new SpannableString(trans4);
        spannableString4.setSpan(new UnderlineSpan(),str4.indexOf(str4_keyword1),str4.indexOf(str4_keyword1)+str4_keyword1.length(),0);
        spannableString4_trans.setSpan(new UnderlineSpan(),trans4.indexOf(trans4_keyword1),trans4.indexOf(trans4_keyword1)+trans4_keyword1.length(),0);
        spannableString4.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str4.indexOf(str4_name),str4.indexOf(str4_name)+str4_name.length(),0);
        explanation4.setText(spannableString4);
        translation4.setText(spannableString4_trans);

        TextView explanation5=(TextView)rootView.findViewById(R.id.example5);
        final TextView translation5=(TextView)rootView.findViewById(R.id.translation5);

        String str5="НАТАША : Почему нет? Ты студент здесь.";
        String str5_name="НАТАША :";
        String trans5="Why not? You are a student here.";
        String str5_keyword1="Почему";
        String trans5_keyword1="Why";
        SpannableString spannableString5=new SpannableString(str5);
        SpannableString spannableString5_trans=new SpannableString(trans5);
        spannableString5.setSpan(new UnderlineSpan(),str5.indexOf(str5_keyword1),str5.indexOf(str5_keyword1)+str5_keyword1.length(),0);
        spannableString5_trans.setSpan(new UnderlineSpan(),trans5.indexOf(trans5_keyword1),trans5.indexOf(trans5_keyword1)+trans5_keyword1.length(),0);
        spannableString5.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str5.indexOf(str5_name),str5.indexOf(str5_name)+str5_name.length(),0);
        explanation5.setText(spannableString5);
        translation5.setText(spannableString5_trans);

        TextView explanation6=(TextView)rootView.findViewById(R.id.example6);
        final TextView translation6=(TextView)rootView.findViewById(R.id.translation6);

        String str6="ДЖОН : Я не делаю задание.";
        String trans6="I don't do homework.";
        String str6_name="ДЖОН :";
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

        String str7="НАТАША : Ты знаешь как делать это?";
        String trans7="Do you know how to do it?";
        String str7_name="НАТАША :";
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

        String str8="ДЖОН : Я знаю как, но я не делаю это.";
        String trans8="I know how but I don't do it.";
        String str8_name="ДЖОН :";
        String str8_keyword1="но";
        String trans8_keyword1="but";
        SpannableString spannableString8=new SpannableString(str8);
        SpannableString spannableString8_trans=new SpannableString(trans8);
        spannableString8.setSpan(new UnderlineSpan(),str8.indexOf(str8_keyword1),str8.indexOf(str8_keyword1)+str8_keyword1.length(),0);
        spannableString8_trans.setSpan(new UnderlineSpan(),trans8.indexOf(trans8_keyword1),trans8.indexOf(trans8_keyword1)+trans8_keyword1.length(),0);
        spannableString8.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str8.indexOf(str8_name),str8.indexOf(str8_name)+str8_name.length(),0);
        explanation8.setText(spannableString8);
        translation8.setText(spannableString8_trans);


        TextView explanation9=(TextView)rootView.findViewById(R.id.example9);
        final TextView translation9=(TextView)rootView.findViewById(R.id.translation9);

        String str9="НАТАША : Это проблема.";
        String trans9="This is a problem.";
        String str9_name="НАТАША :";
        //String str5_keyword1="почему";
        //String trans5_keyword1="why";
        SpannableString spannableString9=new SpannableString(str9);
        SpannableString spannableString9_trans=new SpannableString(trans9);
        spannableString9.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str9.indexOf(str9_name),str9.indexOf(str9_name)+str9_name.length(),0);
        //spannableString5.setSpan(new UnderlineSpan(),str5.indexOf(str5_keyword1),str5.indexOf(str5_keyword1)+str5_keyword1.length(),0);
        //spannableString5_trans.setSpan(new UnderlineSpan(),trans5.indexOf(trans5_keyword1),trans5.indexOf(trans5_keyword1)+trans5_keyword1.length(),0);
        explanation9.setText(spannableString9);
        translation9.setText(spannableString9_trans);


        TextView explanation10=(TextView)rootView.findViewById(R.id.example10);
        final TextView translation10=(TextView)rootView.findViewById(R.id.translation10);

        String str10="ДЖОН : Нет. Это не проблема. Пока Наташа.";
        String trans10="No. It's not a problem. Bye Natasha.";
        String str10_name="ДЖОН :";
        //String str5_keyword1="почему";
        //String trans5_keyword1="why";
        SpannableString spannableString10=new SpannableString(str10);
        SpannableString spannableString10_trans=new SpannableString(trans10);
        spannableString10.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str10.indexOf(str10_name),str10.indexOf(str10_name)+str10_name.length(),0);
        //spannableString5.setSpan(new UnderlineSpan(),str5.indexOf(str5_keyword1),str5.indexOf(str5_keyword1)+str5_keyword1.length(),0);
        //spannableString5_trans.setSpan(new UnderlineSpan(),trans5.indexOf(trans5_keyword1),trans5.indexOf(trans5_keyword1)+trans5_keyword1.length(),0);
        explanation10.setText(spannableString10);
        translation10.setText(spannableString10_trans);


        TextView explanation11=(TextView)rootView.findViewById(R.id.example11);
        final TextView translation11=(TextView)rootView.findViewById(R.id.translation11);

        String str11="НАТАША : Извини!";
        String str11_name="НАТАША :";
        String trans11="Excuse me!";
        String str11_keyword1="Извини";
        String trans11_keyword1="Excuse me";
        SpannableString spannableString11=new SpannableString(str11);
        SpannableString spannableString11_trans=new SpannableString(trans11);
        spannableString11.setSpan(new UnderlineSpan(),str11.indexOf(str11_keyword1),str11.indexOf(str11_keyword1)+str11_keyword1.length(),0);
        spannableString11_trans.setSpan(new UnderlineSpan(),trans11.indexOf(trans11_keyword1),trans11.indexOf(trans11_keyword1)+trans11_keyword1.length(),0);
        spannableString11.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str11.indexOf(str11_name),str11.indexOf(str11_name)+str11_name.length(),0);
        explanation11.setText(spannableString11);
        translation11.setText(spannableString11_trans);


        TextView explanation12=(TextView)rootView.findViewById(R.id.example12);
        final TextView translation12=(TextView)rootView.findViewById(R.id.translation12);

        String str12="ДЖОН : Пока.";
        String trans12="Bye.";
        String str12_name="ДЖОН :";
        //String str12_keyword1="Извини";
        //String trans12_keyword1="Excuse me";
        SpannableString spannableString12=new SpannableString(str12);
        SpannableString spannableString12_trans=new SpannableString(trans12);
        spannableString12.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str12.indexOf(str12_name),str12.indexOf(str12_name)+str12_name.length(),0);
        //spannableString11.setSpan(new UnderlineSpan(),str11.indexOf(str11_keyword1),str11.indexOf(str11_keyword1)+str11_keyword1.length(),0);
        //spannableString11_trans.setSpan(new UnderlineSpan(),trans5.indexOf(trans11_keyword1),trans11.indexOf(trans11_keyword1)+trans11_keyword1.length(),0);
        explanation12.setText(spannableString12);
        translation12.setText(spannableString12_trans);


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
        LinearLayout linearLayout11=rootView.findViewById(R.id.linearLayout11);
        LinearLayout linearLayout12=rootView.findViewById(R.id.linearLayout12);


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

        linearLayout11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(translation11.getVisibility()==View.VISIBLE){
                    translation11.setVisibility(View.GONE);
                }
                else{
                    translation11.setVisibility(View.VISIBLE);
                }
            }
        });

        linearLayout12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(translation12.getVisibility()==View.VISIBLE){
                    translation12.setVisibility(View.GONE);
                }
                else{
                    translation12.setVisibility(View.VISIBLE);
                }
            }
        });

        final Uri uri1=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/abcde1");
        final Uri uri2=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/bask1");
        final Uri uri3=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/abcde3");
        final Uri uri4=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/bask2");
        final Uri uri5=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/abcde5");
        final Uri uri6=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/bask3");
        final Uri uri7=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/abcde7");
        final Uri uri8=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/bask4");
        final Uri uri9=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/abcde9");
        final Uri uri10=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/bask5");
        final Uri uri11=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/abcde11");
        final Uri uri12=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/bask6");

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

        linearLayout11.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri11);
                mediaPlayer.start();*/
                doit(view,uri11);
                return true;
            }
        });

        linearLayout12.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri12);
                mediaPlayer.start();*/
                doit(view,uri12);
                return true;
            }
        });



        /*explanation1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int vis=translation1.getVisibility();
                if(vis==View.VISIBLE){
                    translation1.setVisibility(View.GONE);
                }
                else{
                    translation1.setVisibility(View.VISIBLE);
                }
            }
        });

        explanation2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int vis=translation2.getVisibility();
                if(vis==View.VISIBLE){
                    translation2.setVisibility(View.GONE);
                }
                else{
                    translation2.setVisibility(View.VISIBLE);
                }
            }
        });

        explanation3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int vis=translation3.getVisibility();
                if(vis==View.VISIBLE){
                    translation3.setVisibility(View.GONE);
                }
                else{
                    translation3.setVisibility(View.VISIBLE);
                }
            }
        });

        explanation4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int vis=translation4.getVisibility();
                if(vis==View.VISIBLE){
                    translation4.setVisibility(View.GONE);
                }
                else{
                    translation4.setVisibility(View.VISIBLE);
                }
            }
        });

        explanation5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int vis=translation5.getVisibility();
                if(vis==View.VISIBLE){
                    translation5.setVisibility(View.GONE);
                }
                else{
                    translation5.setVisibility(View.VISIBLE);
                }
            }
        });


        explanation6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int vis=translation6.getVisibility();
                if(vis==View.VISIBLE){
                    translation6.setVisibility(View.GONE);
                }
                else{
                    translation6.setVisibility(View.VISIBLE);
                }
            }
        });

        explanation7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int vis=translation7.getVisibility();
                if(vis==View.VISIBLE){
                    translation7.setVisibility(View.GONE);
                }
                else{
                    translation7.setVisibility(View.VISIBLE);
                }
            }
        });

        explanation8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int vis=translation8.getVisibility();
                if(vis==View.VISIBLE){
                    translation8.setVisibility(View.GONE);
                }
                else{
                    translation8.setVisibility(View.VISIBLE);
                }
            }
        });

        explanation9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int vis=translation9.getVisibility();
                if(vis==View.VISIBLE){
                    translation9.setVisibility(View.GONE);
                }
                else{
                    translation9.setVisibility(View.VISIBLE);
                }
            }
        });

        explanation10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int vis=translation10.getVisibility();
                if(vis==View.VISIBLE){
                    translation10.setVisibility(View.GONE);
                }
                else{
                    translation10.setVisibility(View.VISIBLE);
                }
            }
        });

        explanation11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int vis=translation11.getVisibility();
                if(vis==View.VISIBLE){
                    translation11.setVisibility(View.GONE);
                }
                else{
                    translation11.setVisibility(View.VISIBLE);
                }
            }
        });

        explanation12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int vis=translation12.getVisibility();
                if(vis==View.VISIBLE){
                    translation12.setVisibility(View.GONE);
                }
                else{
                    translation12.setVisibility(View.VISIBLE);
                }
            }
        });*/



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
