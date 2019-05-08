package com.example.immanuel.flashtalk;

import android.content.Intent;
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

public class RussianLanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_language);

        ImageView back_arrow=(ImageView)findViewById(R.id.back_button);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),MainActivity.class));
            }
        });

        final Animation anim_wobble = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.wobble);

        final CircularImageViewTest dialogView=findViewById(R.id.dialog);
        dialogView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent=new Intent(getApplicationContext(),RussianDialogueSplashActivity.class);
                intent.putExtra("DIALOG_TITLE","Dialogues");
                intent.putExtra("IMAGE_SRC","book3");
                dialogView.startAnimation(anim_wobble);
                startActivity(intent);
                /*new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(intent);
                    }
                },250);*/

            }
        });

        final CircularImageViewTest gameView=findViewById(R.id.games);
        gameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameView.startAnimation(anim_wobble);
                startActivity(new Intent(getApplicationContext(),RussianGamesSplashActivity.class));
            }
        });

        String msg1 = "See the two icons in the toolbar. Click one to see some funny dialogues. Click the other to test yourself.";
        SpannableString spannableString1 = new SpannableString(msg1);

        (new MyApplication()).show_hints(getSupportFragmentManager(),spannableString1,"HINT_TWO_CIRCLES");


        final ArrayList<String>categories=new ArrayList<>();
        categories.add("~ Beginner ~");
        /*categories.add("Alphabets");
        categories.add("- Essentials 1 -");
        categories.add("- Essentials 2 -");
        categories.add("Vocab 1 - People");
        categories.add("I Don't Understand");
        categories.add("Nouns");
        categories.add("A Pretty Woman");
        categories.add("I Want");
        categories.add("Vocab 2 - Things");*/
        categories.add("~ Intermediate ~");
        /*categories.add("I Know Him");
        categories.add("I'm Watching A Movie");
        categories.add("I Can");
        categories.add("I'm Reading My Book");*/
        categories.add("~ Functional ~");
        categories.add("~ Extras ~");
        /*categories.add("Imperfective");
        categories.add("Cases 2");
        categories.add("Advanced");
        categories.add("Miscellaneous");*/



        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyler_view_russian_language);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final RecyclerViewAdapterRussLang adapter = new RecyclerViewAdapterRussLang(this, categories);

        adapter.setClickListener(new RecyclerViewAdapterRussLang.ItemClickListener() {
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.russian_lang_menu, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}
