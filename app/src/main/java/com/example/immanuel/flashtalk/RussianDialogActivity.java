package com.example.immanuel.flashtalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class RussianDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_dialog);

        ImageButton back_button=(ImageButton)findViewById(R.id.back_button);
        //ImageButton forward_button=(ImageButton)rootView.findViewById(R.id.forward_button);
        //final ViewPager viewPager=findViewById(R.id.in_the_store_pager);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),RussianLanguageActivity.class));
            }
        });


        /*CircularImageView2 vocabView=findViewById(R.id.vocab);
        vocabView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RussianVocabSplash.class));
            }
        });*/

        /*CircularImageView2 gameView=findViewById(R.id.games);
        gameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RussianGamesSplashActivity.class));
            }
        });*/

        final ArrayList<String>dialog_images=new ArrayList<>();
        final ArrayList<String>dialog_titles=new ArrayList<>();

        dialog_images.add("N/A");
        dialog_images.add("lightning1");
        dialog_images.add("lightning1");
        dialog_images.add("lightning1");
        dialog_images.add("lightning1");
        dialog_images.add("N/A");
        dialog_images.add("lightning1");
        dialog_images.add("lightning1");
        dialog_images.add("lightning1");

        dialog_titles.add("~ Beginner ~");
        dialog_titles.add("A Testy Exchange");
        dialog_titles.add("A Naive Tourist");
        dialog_titles.add("The United Nations");
        dialog_titles.add("A Charming Accent");
        dialog_titles.add("~ Intermediate ~");
        dialog_titles.add("A Rebel");
        dialog_titles.add("A Rude Waitress");
        dialog_titles.add("A Very Boring Man");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyler_view_dialogs);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final RecyclerViewAdapterDialog adapter = new RecyclerViewAdapterDialog(this, dialog_images,dialog_titles);


        //Drawable drawable=getResources().getDrawable(R.drawable.recyler_view_divider);
        RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(this);
        recyclerView.addItemDecoration(dividerItemDecoration);

        adapter.setClickListener(new RecyclerViewAdapterDialog.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //TextView txtView=(TextView) view.findViewById(R.id.recyler_view_text_view);
                /*switch (position){
                    case 0:
                        startActivity(new Intent(getApplicationContext(),RussianAlphabetActivity.class));
                        return;
                    case 1:
                        String str=categories.get(2);
                        if(str.equals("Basic Pronouns")){
                            categories.remove(2);
                            categories.remove(2);
                            categories.remove(2);
                            adapter.notifyItemRangeRemoved(2,3);
                        }
                        else {
                            //llayout.setBackgroundColor(getResources().getColor(R.color.yellow));
                            //txtView.setBackgroundResource(R.drawable.rect);
                            categories.add(2, "Basic Pronouns");
                            categories.add(3, "Question Words");
                            categories.add(4, "Basic Verbs");
                            adapter.notifyItemInserted(2);
                            adapter.notifyItemInserted(3);
                            adapter.notifyItemInserted(4);
                        }
                        return;
                }*/
            }
        });

        recyclerView.setAdapter(adapter);

        /*DividerItemDecoration itemDecor = new DividerItemDecoration(getApplicationContext());
        recyclerView.addItemDecoration(itemDecor);*/

    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.russian_lang_menu, menu);
        return true;
    }*/
}
