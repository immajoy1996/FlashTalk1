package com.languageapp.immanuel.flashtalk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.ArrayList;

public class ArabicLanguageActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arabic_language);

        ImageView back_arrow=(ImageView)findViewById(R.id.back_button);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),MainActivity.class));
            }
        });

        final Animation anim_wobble = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.wobble);
        anim_wobble.setRepeatCount(Animation.INFINITE);

        final CircularImageViewTest dialogView=findViewById(R.id.dialog);
        back_arrow.startAnimation(anim_wobble);

        SpannableString msg1=new SpannableString("See the icons in the top right? Click one to read some funny dialogues. Click the other to test yourself.");
        //SpannableString msg2=new SpannableString("Click the buttons for audio.");
        (new MyApplication(getApplicationContext())).show_hints(getSupportFragmentManager(),msg1,"Language_Activity1");

        dialogView.startAnimation(anim_wobble);

        dialogView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Uri uri_swoosh=Uri.parse("android.resource://"+view.getContext().getPackageName()+"/raw/swoosh");
                doit(view,uri_swoosh);
                final Intent intent=new Intent(getApplicationContext(),RussianDialogueSplashActivity.class);
                //intent.putExtra("DIALOG_TITLE","Dialogues");
                //intent.putExtra("IMAGE_SRC","book3");
                //startActivity(intent);

            }
        });

        final CircularImageViewTest gameView=findViewById(R.id.games);
        gameView.startAnimation(anim_wobble);

        gameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Uri uri_swoosh=Uri.parse("android.resource://"+view.getContext().getPackageName()+"/raw/swoosh");
                //doit(view,uri_swoosh);
                //startActivity(new Intent(getApplicationContext(),RussianGamesSplashActivity.class));
            }
        });

        String msg0 = "See the two icons in the toolbar. Click one to see some funny dialogues. Click the other to test yourself.";
        SpannableString spannableString1 = new SpannableString(msg0);

        //(new MyApplication()).show_hints(getSupportFragmentManager(),spannableString1,"HINT_TWO_CIRCLES");


        final ArrayList<String>categories=new ArrayList<>();
        categories.add("~ Part One ~");
        categories.add("~ Part Two ~");
        categories.add("~ Extras ~");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyler_view_arabic_language);
        LinearLayoutManager  layoutMgr=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutMgr);
        final RecyclerViewAdapterArabicLang adapter = new RecyclerViewAdapterArabicLang(this, categories);

        adapter.setClickListener(new RecyclerViewAdapterArabicLang.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });

        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.russian_lang_menu, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        endit();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }

    void doit(View view, Uri uri){
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(view.getContext(), uri);
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    //mediaPlayer_alphabet.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer=null;
                    //mediaPlayer_alphabet = MediaPlayer.create(vw.getContext(), uri);
                };
            });
            //mediaPlayer_alphabet.release();
        } else if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = MediaPlayer.create(view.getContext(), uri);
            mediaPlayer.start();


            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    //mediaPlayer_alphabet.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer=null;

                };
            });
        }
        else {
            mediaPlayer = MediaPlayer.create(view.getContext(), uri);
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    //mediaPlayer_alphabet.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer=null;
                };
            });

        }
    }

    void endit(){
        if(mediaPlayer!=null) {
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer=null;
            //Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/wrong_answer");
            //adapter.mediaPlayer_alphabet= MediaPlayer.create(getContext(),uri);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences mPrefs=getApplicationContext().getSharedPreferences("Hints",0);
        SharedPreferences.Editor mEditor=mPrefs.edit();
        mEditor.putString("var_Alphabet","not shown");
        mEditor.putString("var_Accents","not shown");
        mEditor.putString("var_BasicPronouns","not shown");
        mEditor.putString("var_QuestionWords","not shown");
        mEditor.putString("var_BasicVerbs","not shown");
        mEditor.putString("var_PluralPronouns","not shown");
        mEditor.putString("var_BasicVerbs","not shown");
        mEditor.putString("var_SomethingNice!","not shown");
        mEditor.putString("var_Basic_Pronouns","not shown");
        mEditor.putString("var_BePolite!","not shown");
        mEditor.putString("var_IDontUnderstand","not shown");
        mEditor.putString("var_ImStudying","not shown");
        mEditor.putString("var_Nouns","not shown");
        mEditor.putString("var_HisHouseHerCar","not shown");
        mEditor.putString("var_Dialog2","not shown");
        mEditor.putString("var_Vocab2","not shown");
        mEditor.putString("var_HowsTheWeather","not shown");
        mEditor.putString("var_APrettyWoman","not shown");
        mEditor.putString("var_AnImportantException","not shown");
        mEditor.putString("var_CountriesAndPeople","not shown");
        mEditor.putString("var_Dialog3","not shown");
        mEditor.putString("var_ThisManThisWoman","not shown");
        mEditor.putString("var_What?","not shown");
        mEditor.putString("var_IWant","not shown");
        mEditor.putString("var_ILike","not shown");
        mEditor.putString("var_Dialog4","not shown");
        mEditor.commit();
    }
}
