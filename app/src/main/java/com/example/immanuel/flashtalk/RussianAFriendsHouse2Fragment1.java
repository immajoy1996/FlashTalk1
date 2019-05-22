package com.example.immanuel.flashtalk;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


public class RussianAFriendsHouse2Fragment1 extends Fragment {

    public RussianAFriendsHouse2Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_afriends_house2_fragment1, container, false);

        ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.friends_house2_pager);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(view.getContext(),RussianLanguageActivity.class));
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

        TextView intro_textview=rootView.findViewById(R.id.intro);

        String str="The genitive case is probably the most important case in Russian. Here's how to form it for regular nouns. It's worth memorizing these rules.";
        SpannableString spannableString=new SpannableString(str);
        spannableString.setSpan(new UnderlineSpan(), str.indexOf("genitive case"), str.indexOf("genitive case")+13, 0);
        intro_textview.setText(spannableString);

        TextView masc_rule1_textview=rootView.findViewById(R.id.masc_rule1);
        String masc_rule1_str="* For most masc. nouns, add an а to the end.";
        SpannableString spannableString_masc_rule1=new SpannableString(masc_rule1_str);
        spannableString_masc_rule1.setSpan(new StyleSpan(Typeface.BOLD),masc_rule1_str.indexOf("а"),masc_rule1_str.indexOf("а")+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_masc_rule1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),masc_rule1_str.indexOf("masc."),masc_rule1_str.indexOf("masc.")+5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        masc_rule1_textview.setText(spannableString_masc_rule1);

        TextView fem_rule1_textview=rootView.findViewById(R.id.fem_rule1);
        String fem_rule1_str="* If a fem. noun ends with an а, replace it with an ы.";
        SpannableString spannableString_fem_rule1=new SpannableString(fem_rule1_str);
        spannableString_fem_rule1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)),fem_rule1_str.indexOf("fem."),fem_rule1_str.indexOf("fem.")+4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_fem_rule1.setSpan(new StyleSpan(Typeface.BOLD),fem_rule1_str.indexOf("а"),fem_rule1_str.indexOf("а")+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_fem_rule1.setSpan(new StyleSpan(Typeface.BOLD),fem_rule1_str.indexOf("ы"),fem_rule1_str.indexOf("ы")+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        fem_rule1_textview.setText(spannableString_fem_rule1);

        TextView fem_rule2_textview=rootView.findViewById(R.id.fem_rule2);
        String fem_rule2_str="* If a fem. noun ends with a я, replace it with an и.";
        SpannableString spannableString_fem_rule2=new SpannableString(fem_rule2_str);
        spannableString_fem_rule2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)),fem_rule2_str.indexOf("fem."),fem_rule2_str.indexOf("fem.")+4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_fem_rule2.setSpan(new StyleSpan(Typeface.BOLD),fem_rule2_str.indexOf("я"),fem_rule2_str.indexOf("я")+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_fem_rule2.setSpan(new StyleSpan(Typeface.BOLD),fem_rule2_str.indexOf("и"),fem_rule2_str.indexOf("и")+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        fem_rule2_textview.setText(spannableString_fem_rule2);

        TextView neut_rule1_textview=rootView.findViewById(R.id.neut_rule1);
        String neut_rule1_str="* If a neut. noun ends with an о, replace it with an а.";
        SpannableString spannableString_neut_rule1=new SpannableString(neut_rule1_str);
        spannableString_neut_rule1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),neut_rule1_str.indexOf("neut."),neut_rule1_str.indexOf("neut.")+5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_neut_rule1.setSpan(new StyleSpan(Typeface.BOLD),neut_rule1_str.indexOf("о"),neut_rule1_str.indexOf("о")+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_neut_rule1.setSpan(new StyleSpan(Typeface.BOLD),neut_rule1_str.indexOf("а"),neut_rule1_str.indexOf("а")+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        neut_rule1_textview.setText(spannableString_neut_rule1);

        TextView neut_rule2_textview=rootView.findViewById(R.id.neut_rule2);
        String neut_rule2_str="* If a neut. noun ends with an е, replace it with an я.";
        SpannableString spannableString_neut_rule2=new SpannableString(neut_rule2_str);
        spannableString_neut_rule2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),neut_rule2_str.indexOf("neut."),neut_rule2_str.indexOf("neut.")+5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_neut_rule2.setSpan(new StyleSpan(Typeface.BOLD),neut_rule2_str.indexOf("е"),neut_rule2_str.indexOf("е")+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString_neut_rule2.setSpan(new StyleSpan(Typeface.BOLD),neut_rule2_str.indexOf("я"),neut_rule2_str.indexOf("я")+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        neut_rule2_textview.setText(spannableString_neut_rule2);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");
        /*String example1_eng="eng. This is a friend's house.";
        String example1_russ="russ. This is the house of a friend.";
        TextView textView_example1_eng=rootView.findViewById(R.id.example1);
        TextView textView_example1_russ=rootView.findViewById(R.id.explanation1);

        SpannableString spannableString_example1_eng=new SpannableString(example1_eng);
        spannableString_example1_eng.setSpan(new UnderlineSpan(),example1_eng.indexOf("eng."),example1_eng.indexOf("eng.")+4,0);
        SpannableString spannableString_example1_russ=new SpannableString(example1_russ);
        spannableString_example1_russ.setSpan(new UnderlineSpan(),example1_russ.indexOf("russ."),example1_russ.indexOf("russ.")+5,0);
        textView_example1_eng.setText(spannableString_example1_eng);
        textView_example1_russ.setText(spannableString_example1_russ);



        String example2_eng="eng. This is my sister's car.";
        String example2_russ="russ. This is the car of my sister.";
        TextView textView_example2_eng=rootView.findViewById(R.id.example2);
        TextView textView_example2_russ=rootView.findViewById(R.id.explanation2);

        SpannableString spannableString_example2_eng=new SpannableString(example2_eng);
        spannableString_example2_eng.setSpan(new UnderlineSpan(),example2_eng.indexOf("eng."),example2_eng.indexOf("eng.")+4,0);
        SpannableString spannableString_example2_russ=new SpannableString(example2_russ);
        spannableString_example2_russ.setSpan(new UnderlineSpan(),example2_russ.indexOf("russ."),example2_russ.indexOf("russ.")+5,0);
        textView_example2_eng.setText(spannableString_example2_eng);
        textView_example2_russ.setText(spannableString_example2_russ);



        String example3_eng="eng. This my sister's friend's house.";
        String example3_russ="russ. This is the house of a friend of my sister.";
        TextView textView_example3_eng=rootView.findViewById(R.id.example3);
        TextView textView_example3_russ=rootView.findViewById(R.id.explanation3);

        SpannableString spannableString_example3_eng=new SpannableString(example3_eng);
        spannableString_example3_eng.setSpan(new UnderlineSpan(),example3_eng.indexOf("eng."),example3_eng.indexOf("eng.")+4,0);
        SpannableString spannableString_example3_russ=new SpannableString(example3_russ);
        spannableString_example3_russ.setSpan(new UnderlineSpan(),example3_russ.indexOf("russ."),example3_russ.indexOf("russ.")+5,0);
        textView_example3_eng.setText(spannableString_example3_eng);
        textView_example3_russ.setText(spannableString_example3_russ);*/


        return rootView;
    }
}
