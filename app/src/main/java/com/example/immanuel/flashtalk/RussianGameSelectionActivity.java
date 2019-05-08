package com.example.immanuel.flashtalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Map;

public class RussianGameSelectionActivity extends AppCompatActivity implements AdapterCallBack {

    private Map<String,Boolean>my_selections;
    private String return_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_game_selection);

        Toolbar toolbar=findViewById(R.id.main_toolbar);

        final Button play=findViewById(R.id.play);
        play.setClickable(false);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TextView play_textview=view.findViewById(R.id.game_textview);
                if(play.getCurrentTextColor()!=getResources().getColor(R.color.light_grey)){

                    Intent intent=new Intent(getApplicationContext(),RussianActualGameActivity.class);

                    /*ArrayList<String>Keys=new ArrayList<String>();
                    ArrayList<Integer>Bits=new ArrayList<Integer>();
                    Keys.add("~ Beginner ~");
                    Keys.add("~ Intermediate ~");
                    Keys.add("~ Functional ~");
                    //Keys.add("~ Advanced ~");
                    for(int i=0;i<Keys.size();i++){
                        String s=Keys.get(i);
                        if(my_selections.containsKey(s) && my_selections.get(s)==true){
                            Bits.add(1);
                        }
                        else{
                            Bits.add(0);
                        }
                    }*/


                    //intent.putExtra("Keys",Keys);
                    //intent.putExtra("Bits",Bits);

                    intent.putExtra("RETURN_STRING",return_string);
                    startActivity(intent);
                }
            }
        });

        /*CircularImageView2 vocabView=findViewById(R.id.vocab);
        vocabView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RussianVocabSplash.class));
            }
        });

        CircularImageView2 gameView=findViewById(R.id.games);
        gameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RussianGamesSplashActivity.class));
            }
        });*/

        final ArrayList<String>categories=new ArrayList<>();
        categories.add("~ Beginner ~");
        categories.add("~ Intermediate ~");
        categories.add("~ Functional ~");
        categories.add("~ Extras ~");
        //categories.add("~ Advanced ~");
        /*categories.add("Imperfective");
        categories.add("Cases 2");
        categories.add("Advanced");
        categories.add("Miscellaneous");*/

        ImageButton back_button=findViewById(R.id.back_button);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyler_view_russian_language);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //TextView textView=findViewById(R.id.game_textview);
        //textView.setText("Choose which lessons to practice");



        AdapterCallBack adapterCallBack=new AdapterCallBack() {
            /*@Override
            public void onSomeItemsSelected(int count, Map<String,Boolean>Selected) {
                my_selections=Selected;
                if(count==0) {
                    play.setTextColor(getResources().getColor(R.color.light_grey));
                    play.setBackgroundResource(R.drawable.game_selector_grey);
                    play.setClickable(false);
                    //textView.setText("Choose which lessons to practice");
                }
                else {
                    play.setTextColor(getResources().getColor(R.color.black));
                    play.setBackgroundResource(R.drawable.custom_ripple);
                    play.setClickable(true);
                }
                Toast.makeText(getApplicationContext(),""+count,Toast.LENGTH_SHORT).show();
            }*/

            @Override
            public void onSomeItemsSelected(int count, String ret_string) {
                return_string=ret_string;
                if(count==0) {
                    play.setTextColor(getResources().getColor(R.color.light_grey));
                    play.setBackgroundResource(R.drawable.game_selector_grey);
                    play.setClickable(false);
                    //textView.setText("Choose which lessons to practice");
                }
                else {
                    play.setTextColor(getResources().getColor(R.color.black));
                    play.setBackgroundResource(R.drawable.custom_ripple);
                    play.setClickable(true);
                }
                //Toast.makeText(getApplicationContext(),""+count,Toast.LENGTH_SHORT).show();
            }
        };

        final RussianGameSelectionRecyclerAdapter adapter = new RussianGameSelectionRecyclerAdapter(this, categories,adapterCallBack);
        recyclerView.setAdapter(adapter);


        /*DividerItemDecoration itemDecor = new DividerItemDecoration(getApplicationContext());
        recyclerView.addItemDecoration(itemDecor);*/

    }

    /*@Override
    public void onSomeItemsSelected(int count,Map<String,Boolean>Selected) {
        return;
    }*/

    @Override
    public void onSomeItemsSelected(int count,String return_string) {
        return;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.russian_lang_menu, menu);
        return true;
    }
}
