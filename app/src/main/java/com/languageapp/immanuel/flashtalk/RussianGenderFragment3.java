package com.languageapp.immanuel.flashtalk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.languageapp.immanuel.flashtalk.R;


public class RussianGenderFragment3 extends Fragment {

    public RussianGenderFragment3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_gender_fragment3, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");

        /*String str="Whether you use мой, моя, or моё depends on the gender of the noun. Get the pattern?";

        SpannableStringBuilder ssBuilder = new SpannableStringBuilder(str);

        ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str.indexOf("мой"),str.indexOf("мой")+3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)),str.indexOf("моя"),str.indexOf("моя")+3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str.indexOf("моё"),str.indexOf("моё")+3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView textView=rootView.findViewById(R.id.intro);
        textView.setText(ssBuilder);*/

        return rootView;
    }
}
