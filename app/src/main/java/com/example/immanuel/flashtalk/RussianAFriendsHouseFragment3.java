package com.example.immanuel.flashtalk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class RussianAFriendsHouseFragment3 extends Fragment {

    public RussianAFriendsHouseFragment3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_afriends_house_fragment3, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");
        //TextView intro_textview=rootView.findViewById(R.id.intro);

        TextView example1=rootView.findViewById(R.id.example1);
        String str1="Это дом друга.";

        SpannableString spannableString1=new SpannableString(str1);
        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str1.indexOf("а."), str1.indexOf("а.")+1, 0);
        example1.setText(spannableString1);

        TextView example2=rootView.findViewById(R.id.example2);
        String str2="Это собака друга.";

        SpannableString spannableString2=new SpannableString(str2);
        spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str2.indexOf("а."), str2.indexOf("а.")+1, 0);
        example2.setText(spannableString2);

        TextView example3=rootView.findViewById(R.id.example3);
        String str3="Это рубашка девушки.";

        SpannableString spannableString3=new SpannableString(str3);
        spannableString3.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str3.indexOf("и"), str3.indexOf("и")+1, 0);
        example3.setText(spannableString3);

        TextView example4=rootView.findViewById(R.id.example4);
        String str4="Это дом сестры друга.";

        SpannableString spannableString4=new SpannableString(str4);
        spannableString4.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str4.indexOf("ы"), str4.indexOf("ы")+1, 0);
        spannableString4.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str4.indexOf("а"), str4.indexOf("а")+1, 0);
        example4.setText(spannableString4);

        TextView example5=rootView.findViewById(R.id.example5);
        String str5="Это машина папы друга.";

        SpannableString spannableString5=new SpannableString(str5);
        spannableString5.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str5.indexOf("ы"), str5.indexOf("ы")+1, 0);
        spannableString5.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str5.indexOf("а."), str5.indexOf("а.")+1, 0);
        example5.setText(spannableString5);


        return rootView;
    }
}
