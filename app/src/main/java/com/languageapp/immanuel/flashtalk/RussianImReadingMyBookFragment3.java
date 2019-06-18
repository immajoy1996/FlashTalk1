package com.languageapp.immanuel.flashtalk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.languageapp.immanuel.flashtalk.R;


public class RussianImReadingMyBookFragment3 extends Fragment {

    public RussianImReadingMyBookFragment3(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_im_reading_my_book_fragment3, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");

        ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        //ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.readingmybook_pager);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page-1);
            }
        });

        TextView example1=rootView.findViewById(R.id.example1);
        String str1="Я читаю его роман.";

        SpannableString spannableString1=new SpannableString(str1);
        spannableString1.setSpan(new UnderlineSpan(), str1.indexOf("его"), str1.indexOf("его")+3, 0);
        example1.setText(spannableString1);

        TextView example2=rootView.findViewById(R.id.example2);
        String str2="Это дом его сестры.";

        SpannableString spannableString2=new SpannableString(str2);
        spannableString2.setSpan(new UnderlineSpan(), str2.indexOf("его"), str2.indexOf("его")+3, 0);
        example2.setText(spannableString2);

        TextView example3=rootView.findViewById(R.id.example3);
        String str3="Я вижу его здание.";

        SpannableString spannableString3=new SpannableString(str3);
        spannableString3.setSpan(new UnderlineSpan(), str3.indexOf("его"), str3.indexOf("его")+3, 0);
        example3.setText(spannableString3);

        TextView example4=rootView.findViewById(R.id.example4);
        String str4="Я читаю её роман.";

        SpannableString spannableString4=new SpannableString(str4);
        spannableString4.setSpan(new UnderlineSpan(), str4.indexOf("её"), str4.indexOf("её")+2, 0);
        example4.setText(spannableString4);

        TextView example5=rootView.findViewById(R.id.example5);
        String str5="Я читаю её книгу.";

        SpannableString spannableString5=new SpannableString(str5);
        spannableString5.setSpan(new UnderlineSpan(), str5.indexOf("её"), str5.indexOf("её")+2, 0);
        example5.setText(spannableString5);

        TextView example6=rootView.findViewById(R.id.example6);
        String str6="Я вижу её здание.";

        SpannableString spannableString6=new SpannableString(str6);
        spannableString6.setSpan(new UnderlineSpan(), str6.indexOf("её"), str6.indexOf("её")+2, 0);
        example6.setText(spannableString6);

        TextView example7=rootView.findViewById(R.id.example7);
        String str7="Я читаю их роман.";

        SpannableString spannableString7=new SpannableString(str7);
        spannableString7.setSpan(new UnderlineSpan(), str7.indexOf("их"), str7.indexOf("их")+2, 0);
        example7.setText(spannableString7);

        TextView example8=rootView.findViewById(R.id.example8);
        String str8="Я читаю их книгу.";

        SpannableString spannableString8=new SpannableString(str8);
        spannableString8.setSpan(new UnderlineSpan(), str8.indexOf("их"), str8.indexOf("их")+2, 0);
        example8.setText(spannableString8);

        TextView example9=rootView.findViewById(R.id.example9);
        String str9="Я читаю их книгу.";

        SpannableString spannableString9=new SpannableString(str9);
        spannableString9.setSpan(new UnderlineSpan(), str9.indexOf("их"), str9.indexOf("их")+2, 0);
        example9.setText(spannableString9);


        return rootView;
    }
}
