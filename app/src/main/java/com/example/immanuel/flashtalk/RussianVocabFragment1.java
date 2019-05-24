package com.example.immanuel.flashtalk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import java.util.ArrayList;


public class RussianVocabFragment1 extends Fragment {

    int STEP_TIME=100;
    RussianVocabRecycler adapter;
    int token=0; //1=whoosh

    public RussianVocabFragment1() {
        // Required empty public constructor
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        // Make sure that we are currently visible
        if (this.isVisible()) {
            // If we are becoming invisible, then...
            if (!isVisibleToUser) {

                final Uri uri_flip=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/pageflipmod");
                doit(getView(),uri_flip);
                /*mediaPlayer.stop();
                mediaPlayer.release();
                Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/im_studying_conjug1");
                mediaPlayer= MediaPlayer.create(getContext(),uri);*/
                //endit();
                //volume.setVisibility(View.VISIBLE);
                //pause.setVisibility(View.GONE);
            }
            else {
                // do what you like
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_vocab_fragment1, container, false);
        //Toolbar toolbar = (Toolbar)rootView.findViewById(R.id.toolbar_fragment1);
        //toolbar.setTitle("Alphabets");

        SharedPreferences mPrefs=getContext().getSharedPreferences("Hints",0);
        String str0=mPrefs.getString("var_Vocab2","not shown");
        SharedPreferences.Editor mEditor=mPrefs.edit();

        if(str0.equals("not shown")) {

            SpannableString msg1 = new SpannableString("Click for audio. Swipe right to peek at later vocab lessons.");
            SpannableString msg2=new SpannableString("Click the quiz icon at the top to test yourself.");
            (new MyApplication(getContext())).show_hints(getFragmentManager(), msg1,msg2,"-1","-1");
            mEditor.putString("var_Vocab2","shown");
            mEditor.commit();
        }

        ArrayList<String> russian_words=new ArrayList<String>();
        ArrayList<String> translit=new ArrayList<String>();
        ArrayList<String> english_words=new ArrayList<String>();

        english_words.add("man");english_words.add("woman");
        english_words.add("person");english_words.add("girl");english_words.add("friend");
        english_words.add("mom");english_words.add("dad");english_words.add("brother");english_words.add("sister");

        russian_words.add("мужчина");russian_words.add("женщина");
        russian_words.add("человек");russian_words.add("девушка");russian_words.add("друг");russian_words.add("мама");
        russian_words.add("папа");russian_words.add("брат");russian_words.add("сестра");

        translit.add("moozh-cheen-a");translit.add("zhen-shcheen-a");
        translit.add("chal-a-vy-ek");translit.add("dev-ush-ka");translit.add("droog");translit.add("ma-ma");
        translit.add("pa-pa");translit.add("braht");translit.add("ces-tra");
        // set up the RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view_vocab);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RussianVocabRecycler(getContext(), russian_words,translit,english_words);

        recyclerView.setAdapter(adapter);

        ImageButton back_button=rootView.findViewById(R.id.back_button);

        //final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/question_words_fragment1");
        //adapter.mediaPlayer_vocab=MediaPlayer.create(rootView.getContext(),uri);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*adapter.mediaPlayer_vocab.stop();
                adapter.mediaPlayer_vocab.release();
                adapter.mediaPlayer_vocab=MediaPlayer.create(getContext(),uri);*/
                //volume.setVisibility(View.VISIBLE);
                //pause.setVisibility(View.GONE);
                endit();
                getActivity().finish();
            }
        });

        CircularImageViewTest games=rootView.findViewById(R.id.games);
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*adapter.mediaPlayer_vocab.stop();
                adapter.mediaPlayer_vocab.release();
                adapter.mediaPlayer_vocab=MediaPlayer.create(getContext(),uri);*/
                final Uri uri_swoosh=Uri.parse("android.resource://"+view.getContext().getPackageName()+"/raw/swoosh");
                doit(view,uri_swoosh);
                token=1;
                Intent intent=new Intent(view.getContext(),RussianLessonGamesSplashActivity.class);
                intent.putExtra("LESSON_NAME","Vocab 1 - People");
                //pause.setVisibility(View.GONE);
                //volume.setVisibility(View.VISIBLE);
                startActivity(intent);
                //token=0;
            }
        });

        final Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.wobble);
        back_button.startAnimation(anim);
        games.startAnimation(anim);

        /*forward_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mediaPlayer.stop();
                //mediaPlayer.release();
                //mediaPlayer=MediaPlayer.create(getContext(),uri);
                //volume.setVisibility(View.VISIBLE);
                //pause.setVisibility(View.GONE);
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page+1);
            }
        });*/


        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        if(token==0){
            endit();
        }
        else{token=0;}

    }

    void endit(){
        if(adapter.mediaPlayer_vocab!=null) {
            adapter.mediaPlayer_vocab.stop();
            adapter.mediaPlayer_vocab.reset();
            adapter.mediaPlayer_vocab.release();
            adapter.mediaPlayer_vocab=null;
            //Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/wrong_answer");
            //adapter.mediaPlayer_alphabet= MediaPlayer.create(getContext(),uri);
        }
    }

    void doit(View view,Uri uri){
        if (adapter.mediaPlayer_vocab == null) {
            adapter.mediaPlayer_vocab = MediaPlayer.create(view.getContext(), uri);
            adapter.mediaPlayer_vocab.start();

            adapter.mediaPlayer_vocab.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    //mediaPlayer_alphabet.stop();
                    adapter.mediaPlayer_vocab.reset();
                    adapter.mediaPlayer_vocab.release();
                    adapter.mediaPlayer_vocab=null;
                    //mediaPlayer_alphabet = MediaPlayer.create(vw.getContext(), uri);
                };
            });
            //mediaPlayer_alphabet.release();
        } else if (adapter.mediaPlayer_vocab.isPlaying()) {
            adapter.mediaPlayer_vocab.stop();
            adapter.mediaPlayer_vocab.reset();
            adapter.mediaPlayer_vocab.release();
            adapter.mediaPlayer_vocab = MediaPlayer.create(view.getContext(), uri);
            adapter.mediaPlayer_vocab.start();


            adapter.mediaPlayer_vocab.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    //mediaPlayer_alphabet.stop();
                    adapter.mediaPlayer_vocab.reset();
                    adapter.mediaPlayer_vocab.release();
                    adapter.mediaPlayer_vocab=null;

                };
            });
        }
        else {
            adapter.mediaPlayer_vocab = MediaPlayer.create(view.getContext(), uri);
            adapter.mediaPlayer_vocab.start();

            adapter.mediaPlayer_vocab.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    //mediaPlayer_alphabet.stop();
                    adapter.mediaPlayer_vocab.reset();
                    adapter.mediaPlayer_vocab.release();
                    adapter.mediaPlayer_vocab=null;
                };
            });

        }
    }
}
