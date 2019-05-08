package com.example.immanuel.flashtalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class RussianTheFutureFragment1 extends Fragment {

    public RussianTheFutureFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_the_future_fragment1, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");

        ImageView back_button=(ImageView)rootView.findViewById(R.id.back_button);
        ImageView forward_button=(ImageView)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=(ViewPager)getActivity().findViewById(R.id.thefuture_pager);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),RussianLanguageActivity.class));
            }
        });

        forward_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page+1);
            }
        });

        TextView conjugation1=(TextView)rootView.findViewById(R.id.conjugation1);
        String str1="я буду делать";
        String keyword1="буду";
        SpannableString spannableString1=new SpannableString(str1);
        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str1.indexOf(keyword1),str1.indexOf(keyword1)+keyword1.length(),0);
        conjugation1.setText(spannableString1);

        TextView conjugation2=(TextView)rootView.findViewById(R.id.conjugation2);
        String str2="ты будешь делать";
        String keyword2="будешь";
        SpannableString spannableString2=new SpannableString(str2);
        spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str2.indexOf(keyword2),str2.indexOf(keyword2)+keyword2.length(),0);
        conjugation2.setText(spannableString2);

        TextView conjugation3=(TextView)rootView.findViewById(R.id.conjugation3);
        String str3="он/она будет делать";
        String keyword3="будет";
        SpannableString spannableString3=new SpannableString(str3);
        spannableString3.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str3.indexOf(keyword3),str3.indexOf(keyword3)+keyword3.length(),0);
        conjugation3.setText(spannableString3);

        TextView conjugation4=(TextView)rootView.findViewById(R.id.conjugation4);
        String str4="мы будем делать";
        String keyword4="будем";
        SpannableString spannableString4=new SpannableString(str4);
        spannableString4.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str4.indexOf(keyword4),str4.indexOf(keyword4)+keyword4.length(),0);
        conjugation4.setText(spannableString4);

        TextView conjugation5=(TextView)rootView.findViewById(R.id.conjugation5);
        String str5="вы будете делать";
        String keyword5="будете";
        SpannableString spannableString5=new SpannableString(str5);
        spannableString5.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str5.indexOf(keyword5),str5.indexOf(keyword5)+keyword5.length(),0);
        conjugation5.setText(spannableString5);

        TextView conjugation6=(TextView)rootView.findViewById(R.id.conjugation6);
        String str6="они будут делать";
        String keyword6="будут";
        SpannableString spannableString6=new SpannableString(str6);
        spannableString6.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str6.indexOf(keyword6),str6.indexOf(keyword6)+keyword6.length(),0);
        conjugation6.setText(spannableString6);

        return rootView;
    }
}
