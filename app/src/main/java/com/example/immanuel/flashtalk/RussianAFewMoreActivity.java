package com.example.immanuel.flashtalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class RussianAFewMoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_afew_more);

        ImageButton back_button=(ImageButton)findViewById(R.id.back_button);
        //ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        //final ViewPager viewPager=getActivity().findViewById(R.id.formeforyou_pager);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),RussianLanguageActivity.class));
            }
        });

        TextView intro_textview=findViewById(R.id.intro);
        String str="Let's use a few more verbs in the past!";
        //String keyword_intro1="masculine";
        //String keyword_intro2="human";
        //String keyword_intro3="animal";

        SpannableStringBuilder spannableStringBuilder1=new SpannableStringBuilder(str);
        //SpannableString spannableString=new SpannableString(str);
        //spannableStringBuilder1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)), str.indexOf(keyword1), str.indexOf(keyword1)+keyword1.length(), 0);
        //spannableStringBuilder1.setSpan(new UnderlineSpan(),str.indexOf(keyword_intro1),str.indexOf(keyword_intro1)+keyword_intro1.length(),0);
        //spannableStringBuilder1.setSpan(new UnderlineSpan(),str.indexOf(keyword_intro2),str.indexOf(keyword_intro2)+keyword_intro2.length(),0);
        //spannableStringBuilder1.setSpan(new UnderlineSpan(),str.indexOf(keyword_intro3),str.indexOf(keyword_intro3)+keyword_intro3.length(),0);
        intro_textview.setText(spannableStringBuilder1);

        TextView example1_textview=findViewById(R.id.example1);
        String str1="Я не видел моего друга.";
        String keyword1="видел";

        SpannableString spannableString1=new SpannableString(str1);
        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str1.indexOf(keyword1), str1.indexOf(keyword1)+keyword1.length(), 0);
        example1_textview.setText(spannableString1);

        TextView example2_textview=findViewById(R.id.example2);
        String str2="Я не думал о проблеме.";
        String keyword2="думал";

        SpannableString spannableString2=new SpannableString(str2);
        spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str2.indexOf(keyword2), str2.indexOf(keyword2)+keyword2.length(), 0);
        example2_textview.setText(spannableString2);



        TextView example3_textview=findViewById(R.id.example3);
        String str3="Мы не хотели идти в парк.";
        String keyword3="хотели";

        SpannableString spannableString3=new SpannableString(str3);
        spannableString3.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str3.indexOf(keyword3), str3.indexOf(keyword3)+keyword3.length(), 0);
        example3_textview.setText(spannableString3);



        TextView example4_textview=findViewById(R.id.example4);
        String str4="Она не хотела видеть тебя.";
        String keyword4="хотела";

        SpannableString spannableString4=new SpannableString(str4);
        spannableString4.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)), str4.indexOf(keyword4), str4.indexOf(keyword4)+keyword4.length(), 0);
        example4_textview.setText(spannableString4);
    }
}
