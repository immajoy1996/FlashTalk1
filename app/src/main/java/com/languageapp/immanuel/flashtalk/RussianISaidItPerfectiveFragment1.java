package com.languageapp.immanuel.flashtalk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.languageapp.immanuel.flashtalk.R;


public class RussianISaidItPerfectiveFragment1 extends Fragment {


    public RussianISaidItPerfectiveFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_isaid_it_perfective_fragment1, container, false);
        //android.support.v7.widget.Toolbar Toolbar=rootView.findViewById(R.id.toolbar);
        //Toolbar.setTitle("Basic Verbs");

        ImageButton back_button=(ImageButton)rootView.findViewById(R.id.back_button);
        ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.isaiditperfective_pager);

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

        TextView intro2=(TextView)rootView.findViewById(R.id.intro2);

        String str="Every verb in Russian has two forms: the Imperfective and the Perfective. All the verbs we've covered are Imperfective. You already know these.";
        String keyword1="Imperfective and";
        String keyword2="Perfective";
        String actual_keyword1="Imperfective";

        SpannableStringBuilder ssBuilder = new SpannableStringBuilder(str);
        ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.orange_red)),str.indexOf(keyword1),str.indexOf(keyword1)+actual_keyword1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.sandy_brown)),str.indexOf(keyword2),str.indexOf(keyword2)+keyword2.length(),0);
        intro2.setText(ssBuilder);

        TextView imperfective=(TextView)rootView.findViewById(R.id.imperfective);
        String str_imperfective="* Use the Imperfective for an action which develops over a span of time.";
        String keyword1_imperfective="Imperfective";
        String keyword2_imperfective="action which develops over a span of time";

        SpannableStringBuilder ssBuilder_imperfective = new SpannableStringBuilder(str_imperfective);

        ssBuilder_imperfective.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.orange_red)),str_imperfective.indexOf(keyword1_imperfective),str_imperfective.indexOf(keyword1_imperfective)+keyword1_imperfective.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder_imperfective.setSpan(new UnderlineSpan(),str_imperfective.indexOf(keyword2_imperfective),str_imperfective.indexOf(keyword2_imperfective)+keyword2_imperfective.length(),0);
        imperfective.setText(ssBuilder_imperfective);

        TextView perfective=(TextView)rootView.findViewById(R.id.perfective);
        String str_perfective="* Use the Perfective for an action which is completed at a single point in time.";
        String keyword1_perfective="Perfective";
        String keyword2_perfective="action which is completed at a single point in time";

        SpannableStringBuilder ssBuilder_perfective = new SpannableStringBuilder(str_perfective);

        ssBuilder_perfective.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.sandy_brown)),str_perfective.indexOf(keyword1_perfective),str_perfective.indexOf(keyword1_perfective)+keyword1_perfective.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssBuilder_perfective.setSpan(new UnderlineSpan(),str_perfective.indexOf(keyword2_perfective),str_perfective.indexOf(keyword2_perfective)+keyword2_perfective.length(),0);
        perfective.setText(ssBuilder_perfective);

        //ssBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str.indexOf("neuter"),str.indexOf("neuter")+6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //ssBuilder.setSpan(new StyleSpan(Typeface.ITALIC),55,65, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //ssBuilder.setSpan(new StyleSpan(Typeface.ITALIC),66,75, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //ssBuilder.setSpan(new StyleSpan(Typeface.ITALIC),79,86, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return rootView;
    }
}
