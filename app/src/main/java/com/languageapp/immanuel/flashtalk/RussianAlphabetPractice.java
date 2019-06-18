package com.languageapp.immanuel.flashtalk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RussianAlphabetPractice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.russian_alphabet_practice);

        ArrayList<String> words=new ArrayList<>();
        words.add("Basketbol");
        words.add("Putin");
        words.add("Donald Trump");
        words.add("sport");
        words.add("tennis");
        words.add("Basketbol");
        words.add("Putin");
        words.add("Donald Trump");
        words.add("sport");
        words.add("tennis");
        words.add("Basketbol");
        words.add("Putin");
        words.add("Donald Trump");
        words.add("sport");
        words.add("tennis");

        RecyclerView recyclerView = findViewById(R.id.recycler_view_practice);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //RecyclerViewAdapterRussAlphPractice adapter = new RecyclerViewAdapterRussAlphPractice(this, words);

        //recyclerView.setAdapter(adapter);
    }
}
