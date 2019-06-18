package com.languageapp.immanuel.flashtalk;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewHorizontal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_horizontal);

        RecyclerView recyclerView = findViewById(R.id.horizontal_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<String>lang1=new ArrayList<String>();
        ArrayList<String>lang2=new ArrayList<String>();
        ArrayList<String>lang3=new ArrayList<String>();
        ArrayList<Drawable>draw1=new ArrayList<Drawable>();
        ArrayList<Drawable>draw2=new ArrayList<Drawable>();
        ArrayList<Drawable>draw3=new ArrayList<Drawable>();
        lang1.add("Russian");
        lang2.add("German");
        lang3.add("Spanish");
        lang1.add("Arabic");
        lang2.add("Portugese");
        lang3.add("French");
        ArrayList<Drawable> flags1=new ArrayList<Drawable>();
        ArrayList<Drawable> flags2=new ArrayList<Drawable>();
        ArrayList<Drawable> flags3=new ArrayList<Drawable>();
        flags1.add(getResources().getDrawable(R.drawable.russiaflag));
        flags2.add(getResources().getDrawable(R.drawable.germanflag));
        flags3.add(getResources().getDrawable(R.drawable.spanishflag));
        flags1.add(getResources().getDrawable(R.drawable.syriaflag1));
        flags2.add(getResources().getDrawable(R.drawable.portugalflag));
        flags3.add(getResources().getDrawable(R.drawable.frenchflag));

        RecyclerViewHorizontalAdapter adapter = new RecyclerViewHorizontalAdapter(this, lang1,lang2,lang3,flags1,flags2,flags3);
        recyclerView.setAdapter(adapter);


    }
}
