package com.example.immanuel.flashtalk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


public class RussianForMeForYouFragment2 extends Fragment {

    public RussianForMeForYouFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_for_me_for_you_fragment2, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");

        ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        //ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.formeforyou_pager);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page-1);
            }
        });

        TextView intro_textview=rootView.findViewById(R.id.intro);
        String str="Remember that его, её, and их become него, неё, and них after a preposition.";
        //String keyword1="для";
        //String keyword2="exactly the same";

        SpannableStringBuilder spannableStringBuilder1=new SpannableStringBuilder(str);
        //SpannableString spannableString=new SpannableString(str);
        //spannableStringBuilder1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)), str.indexOf(keyword1), str.indexOf(keyword1)+keyword1.length(), 0);
        //spannableStringBuilder1.setSpan(new UnderlineSpan(),str.indexOf(keyword2),str.indexOf(keyword2)+keyword2.length(),0);
        intro_textview.setText(spannableStringBuilder1);

        TextView example1_textview=rootView.findViewById(R.id.example1);
        String str1="Это плохо для него.";
        String keyword1="него";

        SpannableString spannableString1=new SpannableString(str1);
        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str1.indexOf(keyword1), str1.indexOf(keyword1)+keyword1.length(), 0);
        example1_textview.setText(spannableString1);

        TextView example2_textview=rootView.findViewById(R.id.example2);
        String str2="Эти цветы для неё.";
        String keyword2="неё";

        SpannableString spannableString2=new SpannableString(str2);
        spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str2.indexOf(keyword2), str2.indexOf(keyword2)+keyword2.length(), 0);
        example2_textview.setText(spannableString2);

        TextView example3_textview=rootView.findViewById(R.id.example3);
        String str3="Эти книги для них.";
        String keyword3="них";

        SpannableString spannableString3=new SpannableString(str3);
        spannableString3.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str3.indexOf(keyword3), str3.indexOf(keyword3)+keyword3.length(), 0);
        example3_textview.setText(spannableString3);

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
}