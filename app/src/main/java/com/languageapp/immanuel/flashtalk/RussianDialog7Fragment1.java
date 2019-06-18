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


public class RussianDialog7Fragment1 extends Fragment {

    MediaPlayer mediaPlayer;
    int STEP_TIME=100;
    //ImageView volume;
    //ImageView pause;

    public RussianDialog7Fragment1() {
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_dialog7_fragment1, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs")

        ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.dialog7_pager);

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
        forward_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page+1);
            }
        });

        TextView explanation1=(TextView)rootView.findViewById(R.id.example1);
        final TextView translation1=(TextView)rootView.findViewById(R.id.translation1);

        String str1="НАТАША : Мэттью, куда ты идёшь?";
        String trans1="Matthew, where are you going?";
        //String str1_keyword1="новый";
        //String trans1_keyword1="new";
        String str1_name="НАТАША :";

        SpannableString spannableString1=new SpannableString(str1);
        SpannableString spannableString1_trans=new SpannableString(trans1);
        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str1.indexOf(str1_name),str1.indexOf(str1_name)+str1_name.length(),0);
        //spannableString1.setSpan(new UnderlineSpan(),str1.indexOf(str1_keyword1),str1.indexOf(str1_keyword1)+str1_keyword1.length(),0);
        //spannableString1_trans.setSpan(new UnderlineSpan(),trans1.indexOf(trans1_keyword1),trans1.indexOf(trans1_keyword1)+trans1_keyword1.length(),0);
        explanation1.setText(spannableString1);
        translation1.setText(spannableString1_trans);


        TextView explanation2=(TextView)rootView.findViewById(R.id.example2);
        final TextView translation2=(TextView)rootView.findViewById(R.id.translation2);

        String str2="МЭТТЬЮ : Я иду в Макдональдс. Ты знаешь где это?";
        String trans2="I'm going to the McDonalds. Do you know where it is?";
        String str2_name="МЭТТЬЮ :";
        //String str2_keyword1="важный";
        //String trans2_keyword1="important";
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

        String str3="НАТАША : Макдональдс, ха-ха. Ты из Америки? Каждый американец любит Макдональдс.";
        String trans3="McDonalds, ha ha. Are you from America? Every american loves McDonalds.";
        String str3_name="НАТАША :";
        String str3_keyword1="американец";
        String trans3_keyword1="american";

        SpannableString spannableString3=new SpannableString(str3);
        SpannableString spannableString3_trans=new SpannableString(trans3);
        spannableString3.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str3.indexOf(str3_name),str3.indexOf(str3_name)+str3_name.length(),0);
        spannableString3.setSpan(new UnderlineSpan(),str3.indexOf(str3_keyword1),str3.indexOf(str3_keyword1)+str3_keyword1.length(),0);
        spannableString3_trans.setSpan(new UnderlineSpan(),trans3.indexOf(trans3_keyword1),trans3.indexOf(trans3_keyword1)+trans3_keyword1.length(),0);
        explanation3.setText(spannableString3);
        translation3.setText(spannableString3_trans);

        TextView explanation4=(TextView)rootView.findViewById(R.id.example4);
        final TextView translation4=(TextView)rootView.findViewById(R.id.translation4);

        String str4="МЭТТЬЮ : Да, я из Хьюстона. Это не правда! Это стереотип!";
        String trans4="Yes, I'm from Houston. That's not true! It's a stereotype!";
        String str4_keyword1="правда";
        String trans4_keyword1="true";
        String str4_name="МЭТТЬЮ :";

        SpannableString spannableString4=new SpannableString(str4);
        SpannableString spannableString4_trans=new SpannableString(trans4);
        spannableString4.setSpan(new UnderlineSpan(),str4.indexOf(str4_keyword1),str4.indexOf(str4_keyword1)+str4_keyword1.length(),0);
        spannableString4_trans.setSpan(new UnderlineSpan(),trans4.indexOf(trans4_keyword1),trans4.indexOf(trans4_keyword1)+trans4_keyword1.length(),0);
        spannableString4.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str4.indexOf(str4_name),str4.indexOf(str4_name)+str4_name.length(),0);
        explanation4.setText(spannableString4);
        translation4.setText(spannableString4_trans);

        TextView explanation5=(TextView)rootView.findViewById(R.id.example5);
        final TextView translation5=(TextView)rootView.findViewById(R.id.translation5);

        String str5="НАТАША : Ха-Ха. Это правда! Ты любишь Макдональдс.";
        String trans5="Ha Ha. It is true! You like McDonalds.";
        //String str5_keyword1="скучный";
        //String trans5_keyword1="boring";
        String str5_name="НАТАША :";

        SpannableString spannableString5=new SpannableString(str5);
        SpannableString spannableString5_trans=new SpannableString(trans5);
        spannableString5.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str5.indexOf(str5_name),str5.indexOf(str5_name)+str5_name.length(),0);
        //spannableString5.setSpan(new UnderlineSpan(),str5.indexOf(str5_keyword1),str5.indexOf(str5_keyword1)+str5_keyword1.length(),0);
        //spannableString1_trans.setSpan(new UnderlineSpan(),trans5.indexOf(trans5_keyword1),trans5.indexOf(trans5_keyword1)+trans5_keyword1.length(),0);
        explanation1.setText(spannableString1);
        explanation5.setText(spannableString5);
        translation5.setText(spannableString5_trans);

        TextView explanation6=(TextView)rootView.findViewById(R.id.example6);
        final TextView translation6=(TextView)rootView.findViewById(R.id.translation6);

        String str6="МЭТТЬЮ : Хорошо. Этот Макдональдс . . . это налево или направо?";
        String trans6="Okay. This McDonalds ... is it left or right?";
        String str6_name="МЭТТЬЮ :";
        String str6_keyword1="налево";
        String trans6_keyword1="left";
        String str6_keyword2="направо";
        String trans6_keyword2="right";

        SpannableString spannableString6=new SpannableString(str6);
        SpannableString spannableString6_trans=new SpannableString(trans6);
        spannableString6.setSpan(new UnderlineSpan(),str6.indexOf(str6_keyword1),str6.indexOf(str6_keyword1)+str6_keyword1.length(),0);
        spannableString6_trans.setSpan(new UnderlineSpan(),trans6.indexOf(trans6_keyword1),trans6.indexOf(trans6_keyword1)+trans6_keyword1.length(),0);
        spannableString6.setSpan(new UnderlineSpan(),str6.indexOf(str6_keyword2),str6.indexOf(str6_keyword2)+str6_keyword2.length(),0);
        spannableString6_trans.setSpan(new UnderlineSpan(),trans6.indexOf(trans6_keyword2),trans6.indexOf(trans6_keyword2)+trans6_keyword2.length(),0);
        spannableString6.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str6.indexOf(str6_name),str6.indexOf(str6_name)+str6_name.length(),0);
        explanation6.setText(spannableString6);
        translation6.setText(spannableString6_trans);


        TextView explanation7=(TextView)rootView.findViewById(R.id.example7);
        final TextView translation7=(TextView)rootView.findViewById(R.id.translation7);

        String str7="НАТАША : Нет. Ты видишь монумент? Ты идёшь прямо и потом, налево. Макдональдс там.";
        String trans7="No. You see the monument?. You go straight and left after. The Mcdonalds is there.";
        String str7_name="НАТАША :";
        String str7_keyword1="прямо";
        String trans7_keyword1="straight";
        String str7_keyword2="потом";
        String trans7_keyword2="after";

        SpannableString spannableString7=new SpannableString(str7);
        SpannableString spannableString7_trans=new SpannableString(trans7);
        spannableString7.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str7.indexOf(str7_name),str7.indexOf(str7_name)+str7_name.length(),0);
        spannableString7.setSpan(new UnderlineSpan(),str7.indexOf(str7_keyword1),str7.indexOf(str7_keyword1)+str7_keyword1.length(),0);
        spannableString7_trans.setSpan(new UnderlineSpan(),trans7.indexOf(trans7_keyword1),trans7.indexOf(trans7_keyword1)+trans7_keyword1.length(),0);
        spannableString7.setSpan(new UnderlineSpan(),str7.indexOf(str7_keyword2),str7.indexOf(str7_keyword2)+str7_keyword2.length(),0);
        spannableString7_trans.setSpan(new UnderlineSpan(),trans7.indexOf(trans7_keyword2),trans7.indexOf(trans7_keyword2)+trans7_keyword2.length(),0);
        explanation7.setText(spannableString7);
        translation7.setText(spannableString7_trans);

        TextView explanation8=(TextView)rootView.findViewById(R.id.example8);
        final TextView translation8=(TextView)rootView.findViewById(R.id.translation8);

        String str8="МЭТТЬЮ : Хорошо. Спасибо. Это очень большой город!";
        String trans8="Okay. Thank you. This is a very big city!";
        String str8_name="МЭТТЬЮ :";
        //String str8_keyword1="отличный";
        //String trans8_keyword1="excellent";
        SpannableString spannableString8=new SpannableString(str8);
        SpannableString spannableString8_trans=new SpannableString(trans8);
        //spannableString8.setSpan(new UnderlineSpan(),str8.indexOf(str8_keyword1),str8.indexOf(str8_keyword1)+str8_keyword1.length(),0);
        //spannableString8_trans.setSpan(new UnderlineSpan(),trans8.indexOf(trans8_keyword1),trans8.indexOf(trans8_keyword1)+trans8_keyword1.length(),0);
        spannableString8.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str8.indexOf(str8_name),str8.indexOf(str8_name)+str8_name.length(),0);
        explanation8.setText(spannableString8);
        translation8.setText(spannableString8_trans);


        TextView explanation9=(TextView)rootView.findViewById(R.id.example9);
        final TextView translation9=(TextView)rootView.findViewById(R.id.translation9);

        String str9="НАТАША : Да. И очень красивый!";
        String trans9="Yes, and very beautiful!";
        String str9_name="НАТАША :";
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

        String str10="МЭТТЬЮ : Куда ты идёшь сейчас?";
        String trans10="Where are you going now?";
        String str10_name="МЭТТЬЮ :";
        //String str11_keyword1="Извини";
        //String trans11_keyword1="Excuse me";
        SpannableString spannableString10=new SpannableString(str10);
        SpannableString spannableString10_trans=new SpannableString(trans10);
        //spannableString11.setSpan(new UnderlineSpan(),str11.indexOf(str11_keyword1),str11.indexOf(str11_keyword1)+str11_keyword1.length(),0);
        //spannableString11_trans.setSpan(new UnderlineSpan(),trans11.indexOf(trans11_keyword1),trans11.indexOf(trans11_keyword1)+trans11_keyword1.length(),0);
        spannableString10.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str10.indexOf(str10_name),str10.indexOf(str10_name)+str10_name.length(),0);
        //spannableString11.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str11.indexOf(str11_name),str11.indexOf(str11_name)+str11_name.length(),0);
        explanation10.setText(spannableString10);
        translation10.setText(spannableString10_trans);


        TextView explanation11=(TextView)rootView.findViewById(R.id.example11);
        final TextView translation11=(TextView)rootView.findViewById(R.id.translation11);

        String str11="НАТАША : Я иду в магазин. Я хочу водку.";
        String trans11="I'm going to the store. I want vodka.";
        String str11_name="НАТАША :";
        //String str12_keyword1="фраза";
        //String trans12_keyword1="phrase";
        SpannableString spannableString11=new SpannableString(str11);
        SpannableString spannableString11_trans=new SpannableString(trans11);
        //spannableString12.setSpan(new UnderlineSpan(),str12.indexOf(str12_keyword1),str12.indexOf(str12_keyword1)+str12_keyword1.length(),0);
        //spannableString12_trans.setSpan(new UnderlineSpan(),trans12.indexOf(trans12_keyword1),trans12.indexOf(trans12_keyword1)+trans12_keyword1.length(),0);
        spannableString11.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str11.indexOf(str11_name),str11.indexOf(str11_name)+str11_name.length(),0);
        explanation11.setText(spannableString11);
        translation11.setText(spannableString11_trans);

        //TextView explanation13=(TextView)rootView.findViewById(R.id.example13);
        //final TextView translation13=(TextView)rootView.findViewById(R.id.translation13);

        /*String str13="ЛЕНА : Это очень важно!";
        String trans13="This is very important!";
        String str13_name="ЛЕНА :";
        //String str12_keyword1="фраза";
        //String trans12_keyword1="phrase";
        SpannableString spannableString13=new SpannableString(str13);
        SpannableString spannableString13_trans=new SpannableString(trans13);
        //spannableString12.setSpan(new UnderlineSpan(),str12.indexOf(str12_keyword1),str12.indexOf(str12_keyword1)+str12_keyword1.length(),0);
        //spannableString12_trans.setSpan(new UnderlineSpan(),trans12.indexOf(trans12_keyword1),trans12.indexOf(trans12_keyword1)+trans12_keyword1.length(),0);
        spannableString13.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str13.indexOf(str13_name),str13.indexOf(str13_name)+str13_name.length(),0);
        explanation13.setText(spannableString13);
        translation13.setText(spannableString13_trans);

        TextView explanation14=(TextView)rootView.findViewById(R.id.example14);
        final TextView translation14=(TextView)rootView.findViewById(R.id.translation14);

        String str14="ДИМИТРИЙ : Я не знаю это.";
        String trans14="I don't know it.";
        String str14_name="ДИМИТРИЙ :";
        //String str12_keyword1="фраза";
        //String trans12_keyword1="phrase";
        SpannableString spannableString14=new SpannableString(str14);
        SpannableString spannableString14_trans=new SpannableString(trans14);
        //spannableString12.setSpan(new UnderlineSpan(),str12.indexOf(str12_keyword1),str12.indexOf(str12_keyword1)+str12_keyword1.length(),0);
        //spannableString12_trans.setSpan(new UnderlineSpan(),trans12.indexOf(trans12_keyword1),trans12.indexOf(trans12_keyword1)+trans12_keyword1.length(),0);
        spannableString14.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str14.indexOf(str14_name),str14.indexOf(str14_name)+str14_name.length(),0);
        explanation14.setText(spannableString14);
        translation14.setText(spannableString14_trans);

        TextView explanation15=(TextView)rootView.findViewById(R.id.example15);
        final TextView translation15=(TextView)rootView.findViewById(R.id.translation15);

        String str15="ЛЕНА : Я знаю это потому что я изучаю Флешток.";
        String trans15="I know it because I study FlashTalk.";
        String str15_name="ЛЕНА :";
        //String str12_keyword1="фраза";
        //String trans12_keyword1="phrase";
        SpannableString spannableString15=new SpannableString(str15);
        SpannableString spannableString15_trans=new SpannableString(trans15);
        //spannableString12.setSpan(new UnderlineSpan(),str12.indexOf(str12_keyword1),str12.indexOf(str12_keyword1)+str12_keyword1.length(),0);
        //spannableString12_trans.setSpan(new UnderlineSpan(),trans12.indexOf(trans12_keyword1),trans12.indexOf(trans12_keyword1)+trans12_keyword1.length(),0);
        spannableString15.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)),str15.indexOf(str15_name),str15.indexOf(str15_name)+str15_name.length(),0);
        explanation15.setText(spannableString15);
        translation15.setText(spannableString15_trans);*/


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
        //LinearLayout linearLayout12=rootView.findViewById(R.id.linearLayout12);
        /*LinearLayout linearLayout13=rootView.findViewById(R.id.linearLayout13);
        LinearLayout linearLayout14=rootView.findViewById(R.id.linearLayout14);
        LinearLayout linearLayout15=rootView.findViewById(R.id.linearLayout15);*/


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

        /*linearLayout12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(translation12.getVisibility()==View.VISIBLE){
                    translation12.setVisibility(View.GONE);
                }
                else{
                    translation12.setVisibility(View.VISIBLE);
                }
            }
        });*/

        /*linearLayout13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(translation13.getVisibility()==View.VISIBLE){
                    translation13.setVisibility(View.GONE);
                }
                else{
                    translation13.setVisibility(View.VISIBLE);
                }
            }
        });

        linearLayout14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(translation14.getVisibility()==View.VISIBLE){
                    translation14.setVisibility(View.GONE);
                }
                else{
                    translation14.setVisibility(View.VISIBLE);
                }
            }
        });

        linearLayout15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(translation15.getVisibility()==View.VISIBLE){
                    translation15.setVisibility(View.GONE);
                }
                else{
                    translation15.setVisibility(View.VISIBLE);
                }
            }
        });*/

        final Uri uri1=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri2=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri3=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri4=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri5=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri6=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri7=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri8=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri9=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri10=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        final Uri uri11=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");
        //final Uri uri12=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/question_words_fragment1");

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
