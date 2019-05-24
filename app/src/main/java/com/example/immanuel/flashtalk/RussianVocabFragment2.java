package com.example.immanuel.flashtalk;

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


public class RussianVocabFragment2 extends Fragment {

    int STEP_TIME=100;
    RussianVocabRecycler adapter;

    int token=0; //1=whoosh

    public RussianVocabFragment2() {
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_vocab_fragment2, container, false);
        //Toolbar toolbar = (Toolbar)rootView.findViewById(R.id.toolbar_fragment2);
        //toolbar.setTitle("Alphabets");

        ArrayList<String> russian_words=new ArrayList<String>();
        ArrayList<String> translit=new ArrayList<String>();
        ArrayList<String> english_words=new ArrayList<String>();

        english_words.add("Today");english_words.add("day");english_words.add("weather");english_words.add("book");
        english_words.add("building");english_words.add("place");english_words.add("house");english_words.add("car");

        russian_words.add("сегодня");russian_words.add("день");russian_words.add("погода");russian_words.add("книга");
        russian_words.add("здание");russian_words.add("место");russian_words.add("дом");russian_words.add("машина");

        translit.add("cev-od-nya");translit.add("dyen");translit.add("pag-o-da");translit.add("k-nee-ga"); translit.add("z-dan-ye");
        translit.add("mes-ta");translit.add("dom");translit.add("mash-een-a");
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
                /*adapter.mediaPlayer_vocab.stop();
                adapter.mediaPlayer_vocab.release();
                adapter.mediaPlayer_vocab=MediaPlayer.create(getContext(),uri);*/
                final Uri uri_swoosh=Uri.parse("android.resource://"+view.getContext().getPackageName()+"/raw/swoosh");
                doit(view,uri_swoosh);
                token=1;
                Intent intent=new Intent(view.getContext(),RussianLessonGamesSplashActivity.class);
                intent.putExtra("LESSON_NAME","Vocab 2 - General");
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