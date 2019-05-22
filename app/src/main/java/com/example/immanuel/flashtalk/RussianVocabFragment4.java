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
import android.widget.ImageButton;

import java.util.ArrayList;


public class RussianVocabFragment4 extends Fragment {

    int STEP_TIME=100;
    RussianVocabRecycler adapter;

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
                adapter.mediaPlayer_vocab.stop();
                adapter.mediaPlayer_vocab.release();
                Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/wrong_answer");
                adapter.mediaPlayer_vocab= MediaPlayer.create(getContext(),uri);
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

        translit.add("ye-da");translit.add("nap-ee-tok");translit.add("kaf-ye");translit.add("chai"); translit.add("sok");
        translit.add("mor-ozh-yen-o-ye");translit.add("ban-an");translit.add("yab-lok-a"); translit.add("tart");
        translit.add("va-da");translit.add("vod-ka");
        // set up the RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view_vocab);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RussianVocabRecycler(getContext(), russian_words,translit,english_words);

        recyclerView.setAdapter(adapter);

        ImageButton back_button=rootView.findViewById(R.id.back_button);

        final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/wrong_answer");
        adapter.mediaPlayer_vocab=MediaPlayer.create(rootView.getContext(),uri);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.mediaPlayer_vocab.stop();
                adapter.mediaPlayer_vocab.release();
                adapter.mediaPlayer_vocab=MediaPlayer.create(getContext(),uri);
                //volume.setVisibility(View.VISIBLE);
                //pause.setVisibility(View.GONE);
                getActivity().finish();
            }
        });

        CircularImageView2 games=rootView.findViewById(R.id.games);
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.mediaPlayer_vocab.stop();
                adapter.mediaPlayer_vocab.release();
                adapter.mediaPlayer_vocab=MediaPlayer.create(getContext(),uri);
                Intent intent=new Intent(view.getContext(),RussianLessonGamesSplashActivity.class);
                intent.putExtra("LESSON_NAME","Vocab 4 - Food/Beverages");
                //pause.setVisibility(View.GONE);
                //volume.setVisibility(View.VISIBLE);
                startActivity(intent);
            }
        });

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
        adapter.mediaPlayer_vocab.stop();
        adapter.mediaPlayer_vocab.reset();
        adapter.mediaPlayer_vocab.release();
        Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/wrong_answer");
        adapter.mediaPlayer_vocab= MediaPlayer.create(getContext(),uri);
    }
}