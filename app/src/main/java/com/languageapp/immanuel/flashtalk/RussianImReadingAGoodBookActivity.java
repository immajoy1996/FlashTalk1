package com.languageapp.immanuel.flashtalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.languageapp.immanuel.flashtalk.R;

public class RussianImReadingAGoodBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_im_reading_agood_book);

        ImageView back_button=(ImageView)findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),RussianLanguageActivity.class));
            }
        });

        TextView textView_intro=findViewById(R.id.intro);
        String str_intro="Adjectives also have special forms in the accusative. It's easy. Only the feminine form changes. Get the pattern?";
        SpannableStringBuilder spannableStringBuilder_intro=new SpannableStringBuilder(str_intro);
        /*spannableStringBuilder_intro.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.transliteration_color)),str_intro.indexOf("-ый"),str_intro.indexOf("-ый")+3,0);
        spannableStringBuilder_intro.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)),str_intro.indexOf("-ая"),str_intro.indexOf("-ая")+3,0);
        spannableStringBuilder_intro.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str_intro.indexOf("-ое"),str_intro.indexOf("-ое")+3,0);*/
        textView_intro.setText(spannableStringBuilder_intro);

        TextView example1=findViewById(R.id.example1);
        String str1="Я читаю хороший роман.";

        SpannableString spannableString1=new SpannableString(str1);
        spannableString1.setSpan(new UnderlineSpan(), str1.indexOf("хороший"), str1.indexOf("хороший")+7, 0);
        example1.setText(spannableString1);

        TextView example2=findViewById(R.id.example2);
        String str2="Я читаю хорошую книгу.";

        SpannableString spannableString2=new SpannableString(str2);
        spannableString2.setSpan(new UnderlineSpan(), str2.indexOf("хорошую"), str2.indexOf("хорошую")+7, 0);
        example2.setText(spannableString2);

        TextView example3=findViewById(R.id.example3);
        String str3="Я знаю хорошое место.";

        SpannableString spannableString3=new SpannableString(str3);
        spannableString3.setSpan(new UnderlineSpan(), str3.indexOf("хорошое"), str3.indexOf("хорошое")+7, 0);
        example3.setText(spannableString3);

        TextView example4=findViewById(R.id.example4);
        String str4="Я смотрю красивый фильм.";

        SpannableString spannableString4=new SpannableString(str4);
        spannableString4.setSpan(new UnderlineSpan(), str4.indexOf("красивый"), str4.indexOf("красивый")+8, 0);
        example4.setText(spannableString4);

        TextView example5=findViewById(R.id.example5);
        String str5="Я вижу красивую девушку.";

        SpannableString spannableString5=new SpannableString(str5);
        spannableString5.setSpan(new UnderlineSpan(), str5.indexOf("красивую"), str5.indexOf("красивую")+8, 0);
        example5.setText(spannableString5);

        TextView example6=findViewById(R.id.example6);
        String str6="Я вижу красивое фото.";

        SpannableString spannableString6=new SpannableString(str6);
        spannableString6.setSpan(new UnderlineSpan(), str6.indexOf("красивое"), str6.indexOf("красивое")+8, 0);
        example6.setText(spannableString6);

        TextView example7=findViewById(R.id.example7);
        String str7="Я читаю интернесный роман.";

        SpannableString spannableString7=new SpannableString(str7);
        spannableString7.setSpan(new UnderlineSpan(), str7.indexOf("интернесный"), str7.indexOf("интернесный")+11, 0);
        example7.setText(spannableString7);

        TextView example8=findViewById(R.id.example8);
        String str8="Я читаю интересную книгу.";

        SpannableString spannableString8=new SpannableString(str8);
        spannableString8.setSpan(new UnderlineSpan(), str8.indexOf("интересную"), str8.indexOf("интересную")+11, 0);
        example8.setText(spannableString8);

        TextView example9=findViewById(R.id.example9);
        String str9="Я вижу интересное фото.";

        SpannableString spannableString9=new SpannableString(str9);
        spannableString9.setSpan(new UnderlineSpan(), str9.indexOf("интересное"), str9.indexOf("интересное")+11, 0);
        example9.setText(spannableString9);
    }
}
