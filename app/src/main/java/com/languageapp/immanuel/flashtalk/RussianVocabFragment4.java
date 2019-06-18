package com.languageapp.immanuel.flashtalk;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import java.util.ArrayList;


public class RussianVocabFragment4 extends Fragment {

    int STEP_TIME=100;
    RussianVocabRecycler adapter;
    int token=0;

    public RussianVocabFragment4() {
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_vocab_fragment4, container, false);
        //Toolbar toolbar = (Toolbar)rootView.findViewById(R.id.toolbar_fragment2);
        //toolbar.setTitle("Alphabets");

        ArrayList<String> russian_words=new ArrayList<String>();
        ArrayList<String> translit=new ArrayList<String>();
        ArrayList<String> english_words=new ArrayList<String>();

        english_words.add("food");english_words.add("drink");english_words.add("coffee");english_words.add("tea");
        english_words.add("juice");english_words.add("ice-cream");english_words.add("banana");english_words.add("apple");
        english_words.add("cake");english_words.add("water");english_words.add("vodka");

        russian_words.add("еда");russian_words.add("напиток");russian_words.add("кофе");russian_words.add("чай");
        russian_words.add("сок");russian_words.add("мороженое");russian_words.add("банан");russian_words.add("яблоко");russian_words.add("торт");russian_words.add("вода");
        russian_words.add("водка");

        translit.add("yeeda");translit.add("napeetak");translit.add("kofee");translit.add("chai"); translit.add("sok");
        translit.add("marozhnae");translit.add("ban-an");translit.add("ya-bla-ka"); translit.add("tort");
        translit.add("va-da");translit.add("vod-ka");
        // set up the RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view_vocab);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RussianVocabRecycler(getContext(), russian_words,translit,english_words);

        recyclerView.setAdapter(adapter);

        ImageButton back_button=rootView.findViewById(R.id.back_button);

        //final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/wrong_answer");
        //adapter.mediaPlayer_vocab=MediaPlayer.create(rootView.getContext(),uri);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*adapter.mediaPlayer_vocab.stop();
                adapter.mediaPlayer_vocab.release();
                adapter.mediaPlayer_vocab=MediaPlayer.create(getContext(),uri);*/
                endit();
                //volume.setVisibility(View.VISIBLE);
                //pause.setVisibility(View.GONE);
                getActivity().finish();
            }
        });

        CircularImageViewTest games=rootView.findViewById(R.id.games);
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //endit();
                final Uri uri_swoosh=Uri.parse("android.resource://"+view.getContext().getPackageName()+"/raw/swoosh");
                doit(view,uri_swoosh);
                token=1;
                Intent intent=new Intent(view.getContext(),RussianLessonGamesSplashActivity.class);
                intent.putExtra("LESSON_NAME","Vocab 4 - Food/Beverages");
                //pause.setVisibility(View.GONE);
                //volume.setVisibility(View.VISIBLE);
                startActivity(intent);
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

    void doit(View view, Uri uri){
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