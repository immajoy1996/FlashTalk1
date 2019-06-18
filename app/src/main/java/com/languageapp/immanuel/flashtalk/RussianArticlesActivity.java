package com.languageapp.immanuel.flashtalk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.languageapp.immanuel.flashtalk.R;

public class RussianArticlesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_articles);

        ImageButton back_button=(ImageButton)findViewById(R.id.back_button);
        //ImageButton forward_button=(ImageButton)findViewById(R.id.forward_button);
        //final ViewPager viewPager=findViewById(R.id._pager);

        //final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/basic_verbs_fragment1");
        //mediaPlayer=MediaPlayer.create(rootView.getContext(),uri);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mediaPlayer.stop();
                //mediaPlayer.release();
                //mediaPlayer= MediaPlayer.create(getContext(),uri);
                //volume.setVisibility(View.VISIBLE);
                //pause.setVisibility(View.GONE);
                finish();
            }
        });

        TextView explanation1=(TextView)findViewById(R.id.example1);
        //final TextView translation1=(TextView)findViewById(R.id.translation1);

        String str1="Russian has no articles. For example, книга means \"book\". It could also mean \"a book\" or \"the book.\" It all depends on what you want to say.";
        String str1_keyword1="книга";

        SpannableString spannableString1=new SpannableString(str1);
        //SpannableString spannableString1_trans=new SpannableString(trans1);
        spannableString1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str1.indexOf(str1_keyword1),str1.indexOf(str1_keyword1)+str1_keyword1.length(),0);
        explanation1.setText(spannableString1);
        //translation1.setText(spannableString1_trans);

        TextView explanation2=(TextView)findViewById(R.id.example2);
        //final TextView translation1=(TextView)findViewById(R.id.translation1);

        String str2="Let's see another example. машина means \"car\". It could also mean \"a car\" or \"the car\" depending on context. This makes things easier. Got it?";
        String str2_keyword1="машина";

        SpannableString spannableString2=new SpannableString(str2);
        //SpannableString spannableString1_trans=new SpannableString(trans1);
        spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.medium_sea_green)),str2.indexOf(str2_keyword1),str2.indexOf(str2_keyword1)+str2_keyword1.length(),0);
        explanation2.setText(spannableString2);
        //translation1.setText(spannableString1_trans);


    }
}
