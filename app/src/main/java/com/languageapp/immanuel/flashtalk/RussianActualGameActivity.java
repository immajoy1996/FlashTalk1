package com.languageapp.immanuel.flashtalk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RussianActualGameActivity extends AppCompatActivity {

    private int TYPE_SENTENCE=0;
    private int TYPE_IMAGE=1;
    private int TYPE_LONG_SENTENCE=2;

    MediaPlayer mediaPlayer;
    //int STEP_TIME=100;
    //ImageView volume;
    //ImageView pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_actual_game);

        final TextView instructions_textview=findViewById(R.id.instructions);
        final TextView question_textview=findViewById(R.id.question);

        final TextView answer1_textview=findViewById(R.id.answer1);
        final TextView answer2_textview=findViewById(R.id.answer2);
        final TextView answer3_textview=findViewById(R.id.answer3);
        final TextView answer4_textview=findViewById(R.id.answer4);

        final TextView answerlong1_textview=findViewById(R.id.answerlong1_textview);
        final TextView answerlong2_textview=findViewById(R.id.answerlong2_textview);
        final TextView answerlong3_textview=findViewById(R.id.answerlong3_textview);

        final TextView answerlong1_check=findViewById(R.id.answerlong1_check);
        final TextView answerlong2_check=findViewById(R.id.answerlong2_check);
        final TextView answerlong3_check=findViewById(R.id.answerlong3_check);

        final TextView check1=findViewById(R.id.check1);
        final TextView check2=findViewById(R.id.check2);
        final TextView check3=findViewById(R.id.check3);
        final TextView check4=findViewById(R.id.check4);

        final ImageView imageView=findViewById(R.id.game_image);

        final LinearLayout firstrow_layout=findViewById(R.id.firstrow);
        final LinearLayout secondrow_layout=findViewById(R.id.secondrow);

        final LinearLayout answer1_layout=findViewById(R.id.answer1_layout);
        final LinearLayout answer2_layout=findViewById(R.id.answer2_layout);
        final LinearLayout answer3_layout=findViewById(R.id.answer3_layout);
        final LinearLayout answer4_layout=findViewById(R.id.answer4_layout);

        final LinearLayout answerlong1_layout=findViewById(R.id.answerlong1_layout);
        final LinearLayout answerlong2_layout=findViewById(R.id.answerlong2_layout);
        final LinearLayout answerlong3_layout=findViewById(R.id.answerlong3_layout);

        Intent intent=getIntent();
        //ArrayList<String>Keys=intent.getStringArrayListExtra("Keys");
        //ArrayList<Integer>Bits=intent.getIntegerArrayListExtra("Bits");

        String return_string=intent.getStringExtra("RETURN_STRING");

        ArrayList<Integer> Types=new ArrayList<Integer>();
        ArrayList<String> Instructions=new ArrayList<String>();
        ArrayList<String> Questions=new ArrayList<String>();
        ArrayList<String> Answer1=new ArrayList<String>();
        ArrayList<String> Answer2=new ArrayList<String>();
        ArrayList<String> Answer3=new ArrayList<String>();
        ArrayList<String> Answer4=new ArrayList<String>();
        ArrayList<Integer> CorrectAnswer=new ArrayList<Integer>();

        //int flag=Bits.get(0);

        int total=0;

        //Toast.makeText(this,return_string,Toast.LENGTH_SHORT).show();
        for(int i=0;i<return_string.length();i++){
            if(return_string.charAt(i)=='1'){
                switch (i){
                    /*case 0: //Beginner
                        Game_Beginner game_beginner=new Game_Beginner();
                        total+=game_beginner.TOTAL;
                        for(int j=0;j<game_beginner.TOTAL;j++){
                            Types.add(game_beginner.getType(j));
                            Instructions.add(game_beginner.getInstruction(j));
                            Questions.add(game_beginner.getQuestion(j));
                            Answer1.add(game_beginner.getAnswer1(j));
                            Answer2.add(game_beginner.getAnswer2(j));
                            Answer3.add(game_beginner.getAnswer3(j));
                            Answer4.add(game_beginner.getAnswer4(j));
                            CorrectAnswer.add(game_beginner.getCorrectAnswer(j));
                        }
                        break;

                    case 1:
                        Game_Intermediate game_intermediate=new Game_Intermediate();
                        total+=game_intermediate.TOTAL;
                        for(int j=0;j<game_intermediate.TOTAL;j++){
                            Types.add(game_intermediate.getType(j));
                            Instructions.add(game_intermediate.getInstruction(j));
                            Questions.add(game_intermediate.getQuestion(j));
                            Answer1.add(game_intermediate.getAnswer1(j));
                            Answer2.add(game_intermediate.getAnswer2(j));
                            Answer3.add(game_intermediate.getAnswer3(j));
                            Answer4.add(game_intermediate.getAnswer4(j));
                            CorrectAnswer.add(game_intermediate.getCorrectAnswer(j));
                        }
                        break;

                    case 2:
                        Game_Functional game_functional=new Game_Functional();
                        total+=game_functional.TOTAL;
                        for(int j=0;j<game_functional.TOTAL;j++){
                            Types.add(game_functional.getType(j));
                            Instructions.add(game_functional.getInstruction(j));
                            Questions.add(game_functional.getQuestion(j));
                            Answer1.add(game_functional.getAnswer1(j));
                            Answer2.add(game_functional.getAnswer2(j));
                            Answer3.add(game_functional.getAnswer3(j));
                            Answer4.add(game_functional.getAnswer4(j));
                            CorrectAnswer.add(game_functional.getCorrectAnswer(j));
                        }
                        break;*/

                    default:
                        Game_Sample game_sample=new Game_Sample();
                        game_sample.shuffle();
                        total+=game_sample.TOTAL;
                        for(int j=0;j<game_sample.TOTAL;j++){
                            Types.add(game_sample.getType(j));
                            Instructions.add(game_sample.getInstruction(j));
                            Questions.add(game_sample.getQuestion(j));
                            Answer1.add(game_sample.getAnswer1(j));
                            Answer2.add(game_sample.getAnswer2(j));
                            Answer3.add(game_sample.getAnswer3(j));
                            Answer4.add(game_sample.getAnswer4(j));
                            CorrectAnswer.add(game_sample.getCorrectAnswer(j));
                        }
                        break;

                }
            }
        }

        /*for(int i=1;i<Keys.size();i++){
            String str=Keys.get(i);;
            if(Bits.get(i)==1 || flag==1){
                switch (str){
                    case "Basic Pronouns":
                        Game_BasicPronouns game_basicPronouns=new Game_BasicPronouns();
                        total+=game_basicPronouns.TOTAL;
                        for(int j=0;j<game_basicPronouns.TOTAL;j++){
                            Types.add(game_basicPronouns.getType(j));
                            Instructions.add(game_basicPronouns.getInstruction(j));
                            Questions.add(game_basicPronouns.getQuestion(j));
                            Answer1.add(game_basicPronouns.getAnswer1(j));
                            Answer2.add(game_basicPronouns.getAnswer2(j));
                            Answer3.add(game_basicPronouns.getAnswer3(j));
                            Answer4.add(game_basicPronouns.getAnswer4(j));
                            CorrectAnswer.add(game_basicPronouns.getCorrectAnswer(j));
                        }
                        break;

                   case "Question Words":
                        Game_QuestionWords gameQuestionWords=new Game_QuestionWords();
                        total+=gameQuestionWords.TOTAL;
                        for(int j=0;j<gameQuestionWords.TOTAL;j++){
                            Types.add(gameQuestionWords.getType(j));
                            Instructions.add(gameQuestionWords.getInstruction(j));
                            Questions.add(gameQuestionWords.getQuestion(j));
                            Answer1.add(gameQuestionWords.getAnswer1(j));
                            Answer2.add(gameQuestionWords.getAnswer2(j));
                            Answer3.add(gameQuestionWords.getAnswer3(j));
                            Answer4.add(gameQuestionWords.getAnswer4(j));
                            CorrectAnswer.add(gameQuestionWords.getCorrectAnswer(j));
                        }
                        break;

                    case "Basic Verbs":
                        Game_BasicVerbs game_basicVerbs=new Game_BasicVerbs();
                        total+=game_basicVerbs.TOTAL;
                        for(int j=0;j<game_basicVerbs.TOTAL;j++){
                            Types.add(game_basicVerbs.getType(j));
                            Instructions.add(game_basicVerbs.getInstruction(j));
                            Questions.add(game_basicVerbs.getQuestion(j));
                            Answer1.add(game_basicVerbs.getAnswer1(j));
                            Answer2.add(game_basicVerbs.getAnswer2(j));
                            Answer3.add(game_basicVerbs.getAnswer3(j));
                            Answer4.add(game_basicVerbs.getAnswer4(j));
                            CorrectAnswer.add(game_basicVerbs.getCorrectAnswer(j));
                        }
                        break;

                }
            }
        }*/

        final int pos=0;

        final Game_Generic game_generic=new Game_Generic(Types,Instructions,Questions,Answer1,Answer2,Answer3,Answer4,CorrectAnswer);
        game_generic.TOTAL=total;

        instructions_textview.setText(game_generic.getInstruction(pos));

        final int type=game_generic.getType(pos);

        if(type==TYPE_SENTENCE){
            question_textview.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.GONE);
            question_textview.setText(game_generic.getQuestion(pos));

            //Toast.makeText(this,"Hello "+type,Toast.LENGTH_SHORT).show();

            /*answer1_layout.setVisibility(View.VISIBLE);
            answer2_layout.setVisibility(View.VISIBLE);
            answer3_layout.setVisibility(View.VISIBLE);
            answer4_layout.setVisibility(View.VISIBLE);*/

            firstrow_layout.setVisibility(View.VISIBLE);
            secondrow_layout.setVisibility(View.VISIBLE);

            check1.setVisibility(View.INVISIBLE);
            check2.setVisibility(View.INVISIBLE);
            check3.setVisibility(View.INVISIBLE);
            check4.setVisibility(View.INVISIBLE);

            answer1_textview.setText(game_generic.getAnswer1(pos));
            answer2_textview.setText(game_generic.getAnswer2(pos));
            answer3_textview.setText(game_generic.getAnswer3(pos));
            answer4_textview.setText(game_generic.getAnswer4(pos));

            answerlong1_layout.setVisibility(View.GONE);
            answerlong2_layout.setVisibility(View.GONE);
            answerlong3_layout.setVisibility(View.GONE);

        }
        else if(type==TYPE_IMAGE){

            question_textview.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);

            firstrow_layout.setVisibility(View.VISIBLE);
            secondrow_layout.setVisibility(View.VISIBLE);

            answerlong1_layout.setVisibility(View.GONE);
            answerlong2_layout.setVisibility(View.GONE);
            answerlong3_layout.setVisibility(View.GONE);

            check1.setVisibility(View.INVISIBLE);
            check2.setVisibility(View.INVISIBLE);
            check3.setVisibility(View.INVISIBLE);
            check4.setVisibility(View.INVISIBLE);

            answer1_textview.setText(game_generic.getAnswer1(pos));
            answer2_textview.setText(game_generic.getAnswer2(pos));
            answer3_textview.setText(game_generic.getAnswer3(pos));
            answer4_textview.setText(game_generic.getAnswer4(pos));

            String name = game_generic.getQuestion(pos);
            int id = getResources().getIdentifier(name, "drawable", getPackageName());
            Drawable drawable = getResources().getDrawable(id);
            imageView.setImageDrawable(drawable);
        }

        else{ //TYPE_LONG_SENTENCE
            question_textview.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.GONE);
            question_textview.setText(game_generic.getQuestion(pos));

            firstrow_layout.setVisibility(View.GONE);
            secondrow_layout.setVisibility(View.GONE);

            /*check1.setVisibility(View.INVISIBLE);
            check2.setVisibility(View.INVISIBLE);
            check3.setVisibility(View.INVISIBLE);
            check4.setVisibility(View.INVISIBLE);*/

            /*answer1_textview.setText(game_generic.getAnswer1(pos));
            answer2_textview.setText(game_generic.getAnswer2(pos));
            answer3_textview.setText(game_generic.getAnswer3(pos));
            answer4_textview.setText(game_generic.getAnswer4(pos));*/

            answerlong1_layout.setVisibility(View.VISIBLE);
            answerlong2_layout.setVisibility(View.VISIBLE);
            answerlong3_layout.setVisibility(View.VISIBLE);

            answerlong1_check.setVisibility(View.INVISIBLE);
            answerlong2_check.setVisibility(View.INVISIBLE);
            answerlong3_check.setVisibility(View.INVISIBLE);

            answerlong1_textview.setText(game_generic.getAnswer1(pos));
            answerlong2_textview.setText(game_generic.getAnswer2(pos));
            answerlong3_textview.setText(game_generic.getAnswer3(pos));
        }

        /*answer1_textview.setText(game_generic.getAnswer1(pos));
        answer2_textview.setText(game_generic.getAnswer2(pos));
        answer3_textview.setText(game_generic.getAnswer3(pos));
        answer4_textview.setText(game_generic.getAnswer4(pos));*/

        final TextView score_textview=findViewById(R.id.score);

        //final Uri uri=Uri.parse("android.resource://"+this.getPackageName()+"/raw/question_words_fragment1");
        //mediaPlayer=MediaPlayer.create(getApplicationContext(),uri);
        ImageButton back_button=findViewById(R.id.back_button);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getApplicationContext(),uri);*/
                endit();
                //volume.setVisibility(View.VISIBLE);
                //pause.setVisibility(View.GONE);
                finish();
            }
        });

        SharedPreferences mPrefs=this.getSharedPreferences("Settings",0);
        final SharedPreferences.Editor mEditor=mPrefs.edit();
        final String tutorial_off=mPrefs.getString("SOUND_EFFECTS_OFF","false");

        final Uri uri_correct=Uri.parse("android.resource://"+this.getPackageName()+"/raw/correct_answer");
        final Uri uri_wrong=Uri.parse("android.resource://"+this.getPackageName()+"/raw/wrong_answer");

        //if(type==TYPE_LONG_SENTENCE){
            answerlong1_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int correct = game_generic.getCorrectAnswer(game_generic.position);
                    if (correct == 1) {

                        /*mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer=MediaPlayer.create(getApplicationContext(),uri_correct);
                        mediaPlayer.start();*/
                        if(tutorial_off.equals("false")) {
                            doit(view, uri_correct);
                        }

                        if(game_generic.clicked_wrong==false){ //clicked right answer first
                            game_generic.num_right++;
                            game_generic.num_answered++;
                        }
                        else{ //clicked right answer eventually
                            game_generic.clicked_wrong=false; //reset for next problem
                        }

                        int score=100*game_generic.num_right/game_generic.num_answered;
                        String score_str="Score : "+((Integer)score).toString()+"%";
                        score_textview.setText(score_str);

                        answerlong1_layout.setClickable(false);
                        answerlong2_layout.setClickable(false);
                        answerlong3_layout.setClickable(false);
                        //answer4_layout.setClickable(false);

                        answerlong1_check.setVisibility(View.VISIBLE);
                        answerlong1_check.setBackgroundResource(R.drawable.checkmark1);
                        game_generic.position = game_generic.position + 1;

                        if (game_generic.position >= game_generic.TOTAL) {
                            game_generic.position = 0;
                        }

                        final int position = game_generic.position;

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                int type_next=game_generic.getType(position);

                                if(type_next==TYPE_LONG_SENTENCE){
                                    instructions_textview.setText(game_generic.getInstruction(position));
                                    question_textview.setVisibility(View.VISIBLE);
                                    question_textview.setText(game_generic.getQuestion(position));
                                    imageView.setVisibility(View.GONE);

                                    firstrow_layout.setVisibility(View.GONE);
                                    secondrow_layout.setVisibility(View.GONE);

                                    answerlong1_layout.setVisibility(View.VISIBLE);
                                    answerlong2_layout.setVisibility(View.VISIBLE);
                                    answerlong3_layout.setVisibility(View.VISIBLE);

                                    answerlong1_textview.setText(game_generic.getAnswer1(position));
                                    answerlong2_textview.setText(game_generic.getAnswer2(position));
                                    answerlong3_textview.setText(game_generic.getAnswer3(position));

                                    answerlong1_check.setVisibility(View.INVISIBLE);
                                    answerlong2_check.setVisibility(View.INVISIBLE);
                                    answerlong3_check.setVisibility(View.INVISIBLE);

                                    answerlong1_layout.setClickable(true);
                                    answerlong2_layout.setClickable(true);
                                    answerlong3_layout.setClickable(true);
                                }

                                if(type_next==TYPE_SENTENCE || type_next==TYPE_IMAGE) {
                                    instructions_textview.setText(game_generic.getInstruction(position));
                                    //question_textview.setText(game_alphabet.getQuestion(position));

                                    firstrow_layout.setVisibility(View.VISIBLE);
                                    secondrow_layout.setVisibility(View.VISIBLE);

                                    answerlong1_layout.setVisibility(View.GONE);
                                    answerlong2_layout.setVisibility(View.GONE);
                                    answerlong3_layout.setVisibility(View.GONE);

                                    answer1_textview.setText(game_generic.getAnswer1(position));
                                    answer2_textview.setText(game_generic.getAnswer2(position));
                                    answer3_textview.setText(game_generic.getAnswer3(position));
                                    answer4_textview.setText(game_generic.getAnswer4(position));

                                    check1.setVisibility(View.INVISIBLE);
                                    check2.setVisibility(View.INVISIBLE);
                                    check3.setVisibility(View.INVISIBLE);
                                    check4.setVisibility(View.INVISIBLE);

                                    answer1_layout.setClickable(true);
                                    answer2_layout.setClickable(true);
                                    answer3_layout.setClickable(true);
                                    answer4_layout.setClickable(true);

                                    if (type_next == TYPE_SENTENCE) {
                                        question_textview.setVisibility(View.VISIBLE);
                                        imageView.setVisibility(View.GONE);
                                        question_textview.setText(game_generic.getQuestion(position));
                                    } else {
                                        question_textview.setVisibility(View.GONE);
                                        imageView.setVisibility(View.VISIBLE);

                                        String name = game_generic.getQuestion(position);
                                        int id = getResources().getIdentifier(name, "drawable", getPackageName());
                                        Drawable drawable = getResources().getDrawable(id);
                                        imageView.setImageDrawable(drawable);
                                    }
                                }
                            }
                        }, 500);
                    } else {
                        /*mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer=MediaPlayer.create(getApplicationContext(),uri_wrong);
                        mediaPlayer.start();*/
                        if(tutorial_off.equals("false")) {
                            doit(view, uri_wrong);
                        }

                        answerlong1_check.setVisibility(View.VISIBLE);
                        answerlong1_check.setBackgroundResource(R.drawable.xmark2);

                        if(game_generic.clicked_wrong==false){ //first time getting it wrong
                            game_generic.num_answered++;
                            game_generic.clicked_wrong=true;
                            int score=100*game_generic.num_right/game_generic.num_answered;
                            String score_str="Score : "+((Integer)score).toString()+"%";
                            score_textview.setText(score_str);

                        }
                        else{ //got it wrong before
                            //do nothing
                        }
                    }
                }
            });
        //}

        answerlong2_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int correct = game_generic.getCorrectAnswer(game_generic.position);
                if (correct == 2) {

                    /*mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer=MediaPlayer.create(getApplicationContext(),uri_correct);
                    mediaPlayer.start();*/
                    if(tutorial_off.equals("false")) {
                        doit(view, uri_correct);
                    }

                    if(game_generic.clicked_wrong==false){ //clicked right answer first
                        game_generic.num_right++;
                        game_generic.num_answered++;
                    }
                    else{ //clicked right answer eventually
                        game_generic.clicked_wrong=false; //reset for next problem
                    }

                    int score=100*game_generic.num_right/game_generic.num_answered;
                    String score_str="Score : "+((Integer)score).toString()+"%";
                    score_textview.setText(score_str);

                    answerlong1_layout.setClickable(false);
                    answerlong2_layout.setClickable(false);
                    answerlong3_layout.setClickable(false);
                    //answer4_layout.setClickable(false);

                    answerlong2_check.setVisibility(View.VISIBLE);
                    answerlong2_check.setBackgroundResource(R.drawable.checkmark1);
                    game_generic.position = game_generic.position + 1;

                    if (game_generic.position >= game_generic.TOTAL) {
                        game_generic.position = 0;
                    }

                    final int position = game_generic.position;

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            int type_next=game_generic.getType(position);

                            if(type_next==TYPE_LONG_SENTENCE){
                                instructions_textview.setText(game_generic.getInstruction(position));
                                question_textview.setVisibility(View.VISIBLE);
                                question_textview.setText(game_generic.getQuestion(position));
                                imageView.setVisibility(View.GONE);

                                firstrow_layout.setVisibility(View.GONE);
                                secondrow_layout.setVisibility(View.GONE);

                                answerlong1_layout.setVisibility(View.VISIBLE);
                                answerlong2_layout.setVisibility(View.VISIBLE);
                                answerlong3_layout.setVisibility(View.VISIBLE);

                                answerlong1_textview.setText(game_generic.getAnswer1(position));
                                answerlong2_textview.setText(game_generic.getAnswer2(position));
                                answerlong3_textview.setText(game_generic.getAnswer3(position));

                                answerlong1_check.setVisibility(View.INVISIBLE);
                                answerlong2_check.setVisibility(View.INVISIBLE);
                                answerlong3_check.setVisibility(View.INVISIBLE);

                                answerlong1_layout.setClickable(true);
                                answerlong2_layout.setClickable(true);
                                answerlong3_layout.setClickable(true);
                            }

                            else if(type_next==TYPE_SENTENCE || type_next==TYPE_IMAGE) {
                                instructions_textview.setText(game_generic.getInstruction(position));
                                //question_textview.setText(game_alphabet.getQuestion(position));

                                firstrow_layout.setVisibility(View.VISIBLE);
                                secondrow_layout.setVisibility(View.VISIBLE);

                                answerlong1_layout.setVisibility(View.GONE);
                                answerlong2_layout.setVisibility(View.GONE);
                                answerlong3_layout.setVisibility(View.GONE);

                                answer1_textview.setText(game_generic.getAnswer1(position));
                                answer2_textview.setText(game_generic.getAnswer2(position));
                                answer3_textview.setText(game_generic.getAnswer3(position));
                                answer4_textview.setText(game_generic.getAnswer4(position));

                                check1.setVisibility(View.INVISIBLE);
                                check2.setVisibility(View.INVISIBLE);
                                check3.setVisibility(View.INVISIBLE);
                                check4.setVisibility(View.INVISIBLE);

                                answer1_layout.setClickable(true);
                                answer2_layout.setClickable(true);
                                answer3_layout.setClickable(true);
                                answer4_layout.setClickable(true);

                                if (type_next == TYPE_SENTENCE) {
                                    question_textview.setVisibility(View.VISIBLE);
                                    imageView.setVisibility(View.GONE);
                                    question_textview.setText(game_generic.getQuestion(position));
                                } else {
                                    question_textview.setVisibility(View.GONE);
                                    imageView.setVisibility(View.VISIBLE);

                                    String name = game_generic.getQuestion(position);
                                    int id = getResources().getIdentifier(name, "drawable", getPackageName());
                                    Drawable drawable = getResources().getDrawable(id);
                                    imageView.setImageDrawable(drawable);
                                }
                            }
                        }
                    }, 500);
                } else {

                    /*mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer=MediaPlayer.create(getApplicationContext(),uri_wrong);
                    mediaPlayer.start();*/
                    if(tutorial_off.equals("false")) {
                        doit(view, uri_wrong);
                    }


                    answerlong2_check.setVisibility(View.VISIBLE);
                    answerlong2_check.setBackgroundResource(R.drawable.xmark2);

                    if(game_generic.clicked_wrong==false){ //first time getting it wrong
                        game_generic.num_answered++;
                        game_generic.clicked_wrong=true;
                        int score=100*game_generic.num_right/game_generic.num_answered;
                        String score_str="Score : "+((Integer)score).toString()+"%";
                        score_textview.setText(score_str);

                    }
                    else{ //got it wrong before
                        //do nothing
                    }
                }
            }
        });

        answerlong3_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int correct = game_generic.getCorrectAnswer(game_generic.position);
                if (correct == 3) {

                    /*mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer=MediaPlayer.create(getApplicationContext(),uri_correct);
                    mediaPlayer.start();*/
                    if(tutorial_off.equals("false")) {
                        doit(view, uri_correct);
                    }

                    if(game_generic.clicked_wrong==false){ //clicked right answer first
                        game_generic.num_right++;
                        game_generic.num_answered++;
                    }
                    else{ //clicked right answer eventually
                        game_generic.clicked_wrong=false; //reset for next problem
                    }

                    int score=100*game_generic.num_right/game_generic.num_answered;
                    String score_str="Score : "+((Integer)score).toString()+"%";
                    score_textview.setText(score_str);

                    answerlong1_layout.setClickable(false);
                    answerlong2_layout.setClickable(false);
                    answerlong3_layout.setClickable(false);
                    //answer4_layout.setClickable(false);

                    answerlong3_check.setVisibility(View.VISIBLE);
                    answerlong3_check.setBackgroundResource(R.drawable.checkmark1);
                    game_generic.position = game_generic.position + 1;

                    if (game_generic.position >= game_generic.TOTAL) {
                        game_generic.position = 0;
                    }

                    final int position = game_generic.position;

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            int type_next=game_generic.getType(position);

                            if(type_next==TYPE_LONG_SENTENCE){
                                instructions_textview.setText(game_generic.getInstruction(position));
                                question_textview.setVisibility(View.VISIBLE);
                                question_textview.setText(game_generic.getQuestion(position));
                                imageView.setVisibility(View.GONE);

                                firstrow_layout.setVisibility(View.GONE);
                                secondrow_layout.setVisibility(View.GONE);

                                answerlong1_layout.setVisibility(View.VISIBLE);
                                answerlong2_layout.setVisibility(View.VISIBLE);
                                answerlong3_layout.setVisibility(View.VISIBLE);

                                answerlong1_textview.setText(game_generic.getAnswer1(position));
                                answerlong2_textview.setText(game_generic.getAnswer2(position));
                                answerlong3_textview.setText(game_generic.getAnswer3(position));

                                answerlong1_check.setVisibility(View.INVISIBLE);
                                answerlong2_check.setVisibility(View.INVISIBLE);
                                answerlong3_check.setVisibility(View.INVISIBLE);

                                answerlong1_layout.setClickable(true);
                                answerlong2_layout.setClickable(true);
                                answerlong3_layout.setClickable(true);
                            }

                            else if(type_next==TYPE_SENTENCE || type_next==TYPE_IMAGE) {
                                instructions_textview.setText(game_generic.getInstruction(position));
                                //question_textview.setText(game_alphabet.getQuestion(position));

                                firstrow_layout.setVisibility(View.VISIBLE);
                                secondrow_layout.setVisibility(View.VISIBLE);

                                answerlong1_layout.setVisibility(View.GONE);
                                answerlong2_layout.setVisibility(View.GONE);
                                answerlong3_layout.setVisibility(View.GONE);

                                answer1_textview.setText(game_generic.getAnswer1(position));
                                answer2_textview.setText(game_generic.getAnswer2(position));
                                answer3_textview.setText(game_generic.getAnswer3(position));
                                answer4_textview.setText(game_generic.getAnswer4(position));

                                check1.setVisibility(View.INVISIBLE);
                                check2.setVisibility(View.INVISIBLE);
                                check3.setVisibility(View.INVISIBLE);
                                check4.setVisibility(View.INVISIBLE);

                                answer1_layout.setClickable(true);
                                answer2_layout.setClickable(true);
                                answer3_layout.setClickable(true);
                                answer4_layout.setClickable(true);

                                if (type_next == TYPE_SENTENCE) {
                                    question_textview.setVisibility(View.VISIBLE);
                                    imageView.setVisibility(View.GONE);
                                    question_textview.setText(game_generic.getQuestion(position));
                                } else {
                                    question_textview.setVisibility(View.GONE);
                                    imageView.setVisibility(View.VISIBLE);

                                    String name = game_generic.getQuestion(position);
                                    int id = getResources().getIdentifier(name, "drawable", getPackageName());
                                    Drawable drawable = getResources().getDrawable(id);
                                    imageView.setImageDrawable(drawable);
                                }
                            }
                        }
                    }, 500);
                } else {

                    /*mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer=MediaPlayer.create(getApplicationContext(),uri_wrong);
                    mediaPlayer.start();*/
                    if(tutorial_off.equals("false")) {
                        doit(view, uri_wrong);
                    }


                    answerlong3_check.setVisibility(View.VISIBLE);
                    answerlong3_check.setBackgroundResource(R.drawable.xmark2);

                    if(game_generic.clicked_wrong==false){ //first time getting it wrong
                        game_generic.num_answered++;
                        game_generic.clicked_wrong=true;
                        int score=100*game_generic.num_right/game_generic.num_answered;
                        String score_str="Score : "+((Integer)score).toString()+"%";
                        score_textview.setText(score_str);

                    }
                    else{ //got it wrong before
                        //do nothing
                    }
                }
            }
        });

        //if(type==TYPE_SENTENCE || type==TYPE_IMAGE) {

            answer1_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int correct = game_generic.getCorrectAnswer(game_generic.position);
                    if (correct == 1) {

                        /*mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer=MediaPlayer.create(getApplicationContext(),uri_correct);
                        mediaPlayer.start();*/
                        if(tutorial_off.equals("false")) {
                            doit(view, uri_correct);
                        }

                        if(game_generic.clicked_wrong==false){ //clicked right answer first
                            game_generic.num_right++;
                            game_generic.num_answered++;
                        }
                        else{ //clicked right answer eventually
                            game_generic.clicked_wrong=false; //reset for next problem
                        }

                        int score=100*game_generic.num_right/game_generic.num_answered;
                        String score_str="Score : "+((Integer)score).toString()+"%";
                        score_textview.setText(score_str);

                        answer1_layout.setClickable(false);
                        answer2_layout.setClickable(false);
                        answer3_layout.setClickable(false);
                        answer4_layout.setClickable(false);

                        check1.setVisibility(View.VISIBLE);
                        check1.setBackgroundResource(R.drawable.checkmark1);
                        game_generic.position = game_generic.position + 1;

                        if (game_generic.position >= game_generic.TOTAL) {
                            game_generic.position = 0;
                        }

                        final int position = game_generic.position;

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                int type_next=game_generic.getType(position);

                                if(type_next==TYPE_LONG_SENTENCE){
                                    instructions_textview.setText(game_generic.getInstruction(position));
                                    question_textview.setVisibility(View.VISIBLE);
                                    question_textview.setText(game_generic.getQuestion(position));
                                    imageView.setVisibility(View.GONE);

                                    firstrow_layout.setVisibility(View.GONE);
                                    secondrow_layout.setVisibility(View.GONE);

                                    answerlong1_layout.setVisibility(View.VISIBLE);
                                    answerlong2_layout.setVisibility(View.VISIBLE);
                                    answerlong3_layout.setVisibility(View.VISIBLE);

                                    answerlong1_textview.setText(game_generic.getAnswer1(position));
                                    answerlong2_textview.setText(game_generic.getAnswer2(position));
                                    answerlong3_textview.setText(game_generic.getAnswer3(position));

                                    answerlong1_check.setVisibility(View.INVISIBLE);
                                    answerlong2_check.setVisibility(View.INVISIBLE);
                                    answerlong3_check.setVisibility(View.INVISIBLE);

                                    answerlong1_layout.setClickable(true);
                                    answerlong2_layout.setClickable(true);
                                    answerlong3_layout.setClickable(true);
                                }

                                if(type_next==TYPE_SENTENCE || type_next==TYPE_IMAGE) {
                                    instructions_textview.setText(game_generic.getInstruction(position));
                                    //question_textview.setText(game_alphabet.getQuestion(position));
                                    answer1_textview.setText(game_generic.getAnswer1(position));
                                    answer2_textview.setText(game_generic.getAnswer2(position));
                                    answer3_textview.setText(game_generic.getAnswer3(position));
                                    answer4_textview.setText(game_generic.getAnswer4(position));

                                    check1.setVisibility(View.INVISIBLE);
                                    check2.setVisibility(View.INVISIBLE);
                                    check3.setVisibility(View.INVISIBLE);
                                    check4.setVisibility(View.INVISIBLE);

                                    answer1_layout.setClickable(true);
                                    answer2_layout.setClickable(true);
                                    answer3_layout.setClickable(true);
                                    answer4_layout.setClickable(true);

                                    if (type_next == TYPE_SENTENCE) {
                                        question_textview.setVisibility(View.VISIBLE);
                                        imageView.setVisibility(View.GONE);
                                        question_textview.setText(game_generic.getQuestion(position));
                                    } else {
                                        question_textview.setVisibility(View.GONE);
                                        imageView.setVisibility(View.VISIBLE);

                                        String name = game_generic.getQuestion(position);
                                        int id = getResources().getIdentifier(name, "drawable", getPackageName());
                                        Drawable drawable = getResources().getDrawable(id);
                                        imageView.setImageDrawable(drawable);
                                    }
                                }
                            }
                        }, 500);
                    } else {

                        /*mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer=MediaPlayer.create(getApplicationContext(),uri_wrong);
                        mediaPlayer.start();*/
                        if(tutorial_off.equals("false")) {
                            doit(view, uri_wrong);
                        }

                        check1.setVisibility(View.VISIBLE);
                        check1.setBackgroundResource(R.drawable.xmark2);

                        if(game_generic.clicked_wrong==false){ //first time getting it wrong
                            game_generic.num_answered++;
                            game_generic.clicked_wrong=true;
                            int score=100*game_generic.num_right/game_generic.num_answered;
                            String score_str="Score : "+((Integer)score).toString()+"%";
                            score_textview.setText(score_str);

                        }
                        else{ //got it wrong before
                            //do nothing
                        }
                    }
                }
            });

            answer2_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int correct = game_generic.getCorrectAnswer(game_generic.position);
                    if (correct == 2) {

                        /*mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer=MediaPlayer.create(getApplicationContext(),uri_correct);
                        mediaPlayer.start();*/
                        if(tutorial_off.equals("false")) {
                            doit(view, uri_correct);
                        }

                        if(game_generic.clicked_wrong==false){ //clicked right answer first
                            game_generic.num_right++;
                            game_generic.num_answered++;
                        }
                        else{ //clicked right answer eventually
                            game_generic.clicked_wrong=false; //reset for next problem
                        }

                        int score=100*game_generic.num_right/game_generic.num_answered;
                        String score_str="Score : "+((Integer)score).toString()+"%";
                        score_textview.setText(score_str);

                        answer1_layout.setClickable(false);
                        answer2_layout.setClickable(false);
                        answer3_layout.setClickable(false);
                        answer4_layout.setClickable(false);

                        check2.setVisibility(View.VISIBLE);
                        check2.setBackgroundResource(R.drawable.checkmark1);

                        game_generic.position = game_generic.position + 1;

                        if (game_generic.position >= game_generic.TOTAL) {
                            game_generic.position = 0;
                        }

                        final int position = game_generic.position;

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                int type_next = game_generic.getType(position);

                                if (type_next == TYPE_LONG_SENTENCE) {

                                    instructions_textview.setText(game_generic.getInstruction(position));
                                    question_textview.setVisibility(View.VISIBLE);
                                    question_textview.setText(game_generic.getQuestion(position));
                                    imageView.setVisibility(View.GONE);

                                    firstrow_layout.setVisibility(View.GONE);
                                    secondrow_layout.setVisibility(View.GONE);

                                    answerlong1_layout.setVisibility(View.VISIBLE);
                                    answerlong2_layout.setVisibility(View.VISIBLE);
                                    answerlong3_layout.setVisibility(View.VISIBLE);

                                    answerlong1_textview.setText(game_generic.getAnswer1(position));
                                    answerlong2_textview.setText(game_generic.getAnswer2(position));
                                    answerlong3_textview.setText(game_generic.getAnswer3(position));

                                    answerlong1_check.setVisibility(View.INVISIBLE);
                                    answerlong2_check.setVisibility(View.INVISIBLE);
                                    answerlong3_check.setVisibility(View.INVISIBLE);

                                    answerlong1_layout.setClickable(true);
                                    answerlong2_layout.setClickable(true);
                                    answerlong3_layout.setClickable(true);
                                } else {

                                    instructions_textview.setText(game_generic.getInstruction(position));
                                    //question_textview.setText(game_alphabet.getQuestion(position));
                                    answer1_textview.setText(game_generic.getAnswer1(position));
                                    answer2_textview.setText(game_generic.getAnswer2(position));
                                    answer3_textview.setText(game_generic.getAnswer3(position));
                                    answer4_textview.setText(game_generic.getAnswer4(position));

                                    check1.setVisibility(View.INVISIBLE);
                                    check2.setVisibility(View.INVISIBLE);
                                    check3.setVisibility(View.INVISIBLE);
                                    check4.setVisibility(View.INVISIBLE);

                                    answer1_layout.setClickable(true);
                                    answer2_layout.setClickable(true);
                                    answer3_layout.setClickable(true);
                                    answer4_layout.setClickable(true);

                                    if (type_next == TYPE_SENTENCE) {
                                        question_textview.setVisibility(View.VISIBLE);
                                        imageView.setVisibility(View.GONE);
                                        question_textview.setText(game_generic.getQuestion(position));
                                    } else {
                                        question_textview.setVisibility(View.GONE);
                                        imageView.setVisibility(View.VISIBLE);

                                        String name = game_generic.getQuestion(position);
                                        int id = getResources().getIdentifier(name, "drawable", getPackageName());
                                        Drawable drawable = getResources().getDrawable(id);
                                        imageView.setImageDrawable(drawable);
                                    }
                                }
                            }
                        }, 500);
                    } else {

                        /*mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer=MediaPlayer.create(getApplicationContext(),uri_wrong);
                        mediaPlayer.start();*/
                        if(tutorial_off.equals("false")) {
                            doit(view, uri_wrong);
                        }

                        check2.setVisibility(View.VISIBLE);
                        check2.setBackgroundResource(R.drawable.xmark2);

                        if(game_generic.clicked_wrong==false){ //first time getting it wrong
                            game_generic.num_answered++;
                            game_generic.clicked_wrong=true;
                            int score=100*game_generic.num_right/game_generic.num_answered;
                            String score_str="Score : "+((Integer)score).toString()+"%";
                            score_textview.setText(score_str);

                        }
                        else{ //got it wrong before
                            //do nothing
                        }
                    }
                }
            });

            answer3_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int correct = game_generic.getCorrectAnswer(game_generic.position);
                    if (correct == 3) {

                        /*mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer=MediaPlayer.create(getApplicationContext(),uri_correct);
                        mediaPlayer.start();*/
                        if(tutorial_off.equals("false")) {
                            doit(view, uri_correct);
                        }

                        if(game_generic.clicked_wrong==false){ //clicked right answer first
                            game_generic.num_right++;
                            game_generic.num_answered++;
                        }
                        else{ //clicked right answer eventually
                            game_generic.clicked_wrong=false; //reset for next problem
                        }

                        int score=100*game_generic.num_right/game_generic.num_answered;
                        String score_str="Score : "+((Integer)score).toString()+"%";
                        score_textview.setText(score_str);

                        answer1_layout.setClickable(false);
                        answer2_layout.setClickable(false);
                        answer3_layout.setClickable(false);
                        answer4_layout.setClickable(false);

                        check3.setVisibility(View.VISIBLE);
                        check3.setBackgroundResource(R.drawable.checkmark1);

                        game_generic.position = game_generic.position + 1;

                        if (game_generic.position >= game_generic.TOTAL) {
                            game_generic.position = 0;
                        }

                        final int position = game_generic.position;

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                int type_next = game_generic.getType(position);

                                if (type_next == TYPE_LONG_SENTENCE) {
                                    instructions_textview.setText(game_generic.getInstruction(position));
                                    question_textview.setVisibility(View.VISIBLE);
                                    question_textview.setText(game_generic.getQuestion(position));
                                    imageView.setVisibility(View.GONE);

                                    firstrow_layout.setVisibility(View.GONE);
                                    secondrow_layout.setVisibility(View.GONE);

                                    answerlong1_layout.setVisibility(View.VISIBLE);
                                    answerlong2_layout.setVisibility(View.VISIBLE);
                                    answerlong3_layout.setVisibility(View.VISIBLE);

                                    answerlong1_textview.setText(game_generic.getAnswer1(position));
                                    answerlong2_textview.setText(game_generic.getAnswer2(position));
                                    answerlong3_textview.setText(game_generic.getAnswer3(position));

                                    answerlong1_check.setVisibility(View.INVISIBLE);
                                    answerlong2_check.setVisibility(View.INVISIBLE);
                                    answerlong3_check.setVisibility(View.INVISIBLE);

                                    answerlong1_layout.setClickable(true);
                                    answerlong2_layout.setClickable(true);
                                    answerlong3_layout.setClickable(true);
                                } else {
                                    instructions_textview.setText(game_generic.getInstruction(position));
                                    //question_textview.setText(game_alphabet.getQuestion(position));
                                    answer1_textview.setText(game_generic.getAnswer1(position));
                                    answer2_textview.setText(game_generic.getAnswer2(position));
                                    answer3_textview.setText(game_generic.getAnswer3(position));
                                    answer4_textview.setText(game_generic.getAnswer4(position));

                                    check1.setVisibility(View.INVISIBLE);
                                    check2.setVisibility(View.INVISIBLE);
                                    check3.setVisibility(View.INVISIBLE);
                                    check4.setVisibility(View.INVISIBLE);

                                    answer1_layout.setClickable(true);
                                    answer2_layout.setClickable(true);
                                    answer3_layout.setClickable(true);
                                    answer4_layout.setClickable(true);

                                    if (game_generic.getType(position) == TYPE_SENTENCE) {
                                        question_textview.setVisibility(View.VISIBLE);
                                        imageView.setVisibility(View.GONE);
                                        question_textview.setText(game_generic.getQuestion(position));
                                    } else {
                                        question_textview.setVisibility(View.GONE);
                                        imageView.setVisibility(View.VISIBLE);

                                        String name = game_generic.getQuestion(position);
                                        int id = getResources().getIdentifier(name, "drawable", getPackageName());
                                        Drawable drawable = getResources().getDrawable(id);
                                        imageView.setImageDrawable(drawable);
                                    }
                                }
                            }
                        }, 500);
                    } else {

                        /*mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer=MediaPlayer.create(getApplicationContext(),uri_wrong);
                        mediaPlayer.start();*/
                        if(tutorial_off.equals("false")) {
                            doit(view, uri_wrong);
                        }

                        check3.setVisibility(View.VISIBLE);
                        check3.setBackgroundResource(R.drawable.xmark2);

                        if(game_generic.clicked_wrong==false){ //first time getting it wrong
                            game_generic.num_answered++;
                            game_generic.clicked_wrong=true;
                            int score=100*game_generic.num_right/game_generic.num_answered;
                            String score_str="Score : "+((Integer)score).toString()+"%";
                            score_textview.setText(score_str);

                        }
                        else{ //got it wrong before
                            //do nothing
                        }
                    }
                }
            });

            answer4_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int correct = game_generic.getCorrectAnswer(game_generic.position);
                    if (correct == 4) {

                        /*mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer=MediaPlayer.create(getApplicationContext(),uri_correct);
                        mediaPlayer.start();*/
                        if(tutorial_off.equals("false")) {
                            doit(view, uri_correct);
                        }

                        if(game_generic.clicked_wrong==false){ //clicked right answer first
                            game_generic.num_right++;
                            game_generic.num_answered++;
                        }
                        else{ //clicked right answer eventually
                            game_generic.clicked_wrong=false; //reset for next problem
                        }

                        int score=100*game_generic.num_right/game_generic.num_answered;
                        String score_str="Score : "+((Integer)score).toString()+"%";
                        score_textview.setText(score_str);

                        answer1_layout.setClickable(false);
                        answer2_layout.setClickable(false);
                        answer3_layout.setClickable(false);
                        answer4_layout.setClickable(false);

                        check4.setVisibility(View.VISIBLE);
                        check4.setBackgroundResource(R.drawable.checkmark1);


                        game_generic.position = game_generic.position + 1;

                        if (game_generic.position >= game_generic.TOTAL) {
                            game_generic.position = 0;
                        }

                        final int position = game_generic.position;

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                int type_next = game_generic.getType(position);

                                if (type_next == TYPE_LONG_SENTENCE) {
                                    instructions_textview.setText(game_generic.getInstruction(position));
                                    question_textview.setVisibility(View.VISIBLE);
                                    question_textview.setText(game_generic.getQuestion(position));
                                    imageView.setVisibility(View.GONE);

                                    firstrow_layout.setVisibility(View.GONE);
                                    secondrow_layout.setVisibility(View.GONE);

                                    answerlong1_layout.setVisibility(View.VISIBLE);
                                    answerlong2_layout.setVisibility(View.VISIBLE);
                                    answerlong3_layout.setVisibility(View.VISIBLE);

                                    answerlong1_textview.setText(game_generic.getAnswer1(position));
                                    answerlong2_textview.setText(game_generic.getAnswer2(position));
                                    answerlong3_textview.setText(game_generic.getAnswer3(position));

                                    answerlong1_check.setVisibility(View.INVISIBLE);
                                    answerlong2_check.setVisibility(View.INVISIBLE);
                                    answerlong3_check.setVisibility(View.INVISIBLE);

                                    answerlong1_layout.setClickable(true);
                                    answerlong2_layout.setClickable(true);
                                    answerlong3_layout.setClickable(true);
                                } else {
                                    instructions_textview.setText(game_generic.getInstruction(position));
                                    //question_textview.setText(game_alphabet.getQuestion(position));
                                    answer1_textview.setText(game_generic.getAnswer1(position));
                                    answer2_textview.setText(game_generic.getAnswer2(position));
                                    answer3_textview.setText(game_generic.getAnswer3(position));
                                    answer4_textview.setText(game_generic.getAnswer4(position));

                                    check1.setVisibility(View.INVISIBLE);
                                    check2.setVisibility(View.INVISIBLE);
                                    check3.setVisibility(View.INVISIBLE);
                                    check4.setVisibility(View.INVISIBLE);

                                    answer1_layout.setClickable(true);
                                    answer2_layout.setClickable(true);
                                    answer3_layout.setClickable(true);
                                    answer4_layout.setClickable(true);

                                    if (game_generic.getType(position) == TYPE_SENTENCE) {
                                        question_textview.setVisibility(View.VISIBLE);
                                        imageView.setVisibility(View.GONE);
                                        question_textview.setText(game_generic.getQuestion(position));
                                    } else {
                                        question_textview.setVisibility(View.GONE);
                                        imageView.setVisibility(View.VISIBLE);

                                        String name = game_generic.getQuestion(position);
                                        int id = getResources().getIdentifier(name, "drawable", getPackageName());
                                        Drawable drawable = getResources().getDrawable(id);
                                        imageView.setImageDrawable(drawable);
                                    }
                                }
                            }
                        }, 500);
                    } else {

                        /*mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer=MediaPlayer.create(getApplicationContext(),uri_wrong);
                        mediaPlayer.start();*/
                        if(tutorial_off.equals("false")) {
                            doit(view, uri_wrong);
                        }

                        check4.setVisibility(View.VISIBLE);
                        check4.setBackgroundResource(R.drawable.xmark2);

                        if(game_generic.clicked_wrong==false){ //first time getting it wrong
                            game_generic.num_answered++;
                            game_generic.clicked_wrong=true;
                            int score=100*game_generic.num_right/game_generic.num_answered;
                            String score_str="Score : "+((Integer)score).toString()+"%";
                            score_textview.setText(score_str);

                        }
                        else{ //got it wrong before
                            //do nothing
                        }
                    }
                }
            });
        //}

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        endit();
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

}
