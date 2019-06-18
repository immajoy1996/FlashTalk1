package com.languageapp.immanuel.flashtalk;

import java.util.ArrayList;

public class Game_Sample extends Game_Generic{

    public Game_Sample(){
        TOTAL=30;
        Types=new ArrayList<Integer>(TOTAL);
        Instructions=new ArrayList<String>(TOTAL);
        Questions=new ArrayList<String>(TOTAL);
        Answer1=new ArrayList<String>(TOTAL);
        Answer2=new ArrayList<String>(TOTAL);
        Answer3=new ArrayList<String>(TOTAL);
        Answer4=new ArrayList<String>(TOTAL);
        CorrectAnswer=new ArrayList<Integer>(TOTAL);
        position=0;

        Types.add(0);
        Instructions.add("Choose the correct translation");
        Questions.add("да");
        Answer1.add("he");
        Answer2.add("no");
        Answer3.add("yes");
        Answer4.add("she");
        CorrectAnswer.add(3);

        Types.add(0);
        Instructions.add("Choose the correct translation");
        Questions.add("нет");
        Answer1.add("yes");
        Answer2.add("no");
        Answer3.add("true");
        Answer4.add("false");
        CorrectAnswer.add(2);

        Types.add(0);
        Instructions.add("Choose the correct translation");
        Questions.add("важно");
        Answer1.add("excellent");
        Answer2.add("important");
        Answer3.add("boring");
        Answer4.add("very");
        CorrectAnswer.add(2);

        Types.add(0);
        Instructions.add("Choose the correct translation");
        Questions.add("красиво");
        Answer1.add("beautiful");
        Answer2.add("interesting");
        Answer3.add("which");
        Answer4.add("important");
        CorrectAnswer.add(1);

        Types.add(0);
        Instructions.add("Choose the correct translation");
        Questions.add("интересно");
        Answer1.add("important");
        Answer2.add("handsome");
        Answer3.add("interesting");
        Answer4.add("nice");
        CorrectAnswer.add(3);

        Types.add(0);
        Instructions.add("Choose the correct translation");
        Questions.add("может быть");
        Answer1.add("maybe");
        Answer2.add("never");
        Answer3.add("sometimes");
        Answer4.add("i love");
        CorrectAnswer.add(1);

        Types.add(0);
        Instructions.add("Choose the correct translation");
        Questions.add("извени");
        Answer1.add("to want");
        Answer2.add("excuses");
        Answer3.add("item");
        Answer4.add("excuse me");
        CorrectAnswer.add(4);

        Types.add(0);
        Instructions.add("Choose the correct translation");
        Questions.add("пожалуйста");
        Answer1.add("maybe");
        Answer2.add("please");
        Answer3.add("excuse me");
        Answer4.add("to understand");
        CorrectAnswer.add(2);

        Types.add(0);
        Instructions.add("Choose the correct translation");
        Questions.add("потому что");
        Answer1.add("how");
        Answer2.add("because");
        Answer3.add("why");
        Answer4.add("where");
        CorrectAnswer.add(2);

        Types.add(0);
        Instructions.add("Choose the correct translation");
        Questions.add("когда");
        Answer1.add("when");
        Answer2.add("where");
        Answer3.add("how");
        Answer4.add("it");
        CorrectAnswer.add(1);

        Types.add(1);
        Instructions.add("What's this?");
        Questions.add("sample_apple1");
        Answer1.add("яблоко");
        Answer2.add("сок");
        Answer3.add("машина");
        Answer4.add("девушка");
        CorrectAnswer.add(1);

        Types.add(1);
        Instructions.add("What's this?");
        Questions.add("sample_banana1");
        Answer1.add("человек");
        Answer2.add("машина");
        Answer3.add("банан");
        Answer4.add("яблоко");
        CorrectAnswer.add(3);

        Types.add(1);
        Instructions.add("What's this?");
        Questions.add("sample_book1");
        Answer1.add("водка");
        Answer2.add("президент");
        Answer3.add("книга");
        Answer4.add("яблоко");
        CorrectAnswer.add(3);

        Types.add(1);
        Instructions.add("What's this?");
        Questions.add("sample_building1");
        Answer1.add("здание");
        Answer2.add("книга");
        Answer3.add("президент");
        Answer4.add("аэропорт");
        CorrectAnswer.add(1);

        Types.add(1);
        Instructions.add("What's this?");
        Questions.add("sample_cake1");
        Answer1.add("здание");
        Answer2.add("торт");
        Answer3.add("аэропорт");
        Answer4.add("девушка");
        CorrectAnswer.add(2);

        Types.add(1);
        Instructions.add("What's this?");
        Questions.add("sample_car1");
        Answer1.add("книга");
        Answer2.add("здание");
        Answer3.add("девушка");
        Answer4.add("машина");
        CorrectAnswer.add(4);

        Types.add(1);
        Instructions.add("What's this?");
        Questions.add("sample_house1");
        Answer1.add("парк");
        Answer2.add("дом");
        Answer3.add("президент");
        Answer4.add("человек");
        CorrectAnswer.add(2);

        Types.add(1);
        Instructions.add("What's this?");
        Questions.add("sample_icecream");
        Answer1.add("дом");
        Answer2.add("торт");
        Answer3.add("банан");
        Answer4.add("мороженое");
        CorrectAnswer.add(4);

        Types.add(1);
        Instructions.add("What's this?");
        Questions.add("sample_weather1");
        Answer1.add("погода");
        Answer2.add("здание");
        Answer3.add("мороженое");
        Answer4.add("машина");
        CorrectAnswer.add(1);

        Types.add(1);
        Instructions.add("What's this?");
        Questions.add("sample_vodka1");
        Answer1.add("погода");
        Answer2.add("водка");
        Answer3.add("девушка");
        Answer4.add("машина");
        CorrectAnswer.add(2);


        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("Привет. Что ты делаешь сейчас?");
        Answer1.add("Hi. What are you doing now?");
        Answer2.add("Hi. I'm not doing anything.");
        Answer3.add("Hi. What are they doing now?");
        Answer4.add("N/A");
        CorrectAnswer.add(1);

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("Я не знаю русский, только английский.");
        Answer1.add("I don't know Russian nor French.");
        Answer2.add("I know English and Russian.");
        Answer3.add("I don't know Russian, only English.");
        Answer4.add("N/A");
        CorrectAnswer.add(3);

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("Почему ты хочешь изучать русский язык?");
        Answer1.add("Why do you want to study Russian.");
        Answer2.add("I want to study Russian.");
        Answer3.add("Because I want to study Russian.");
        Answer4.add("N/A");
        CorrectAnswer.add(1);

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("Я не понимаю о чём ты говоришь.");
        Answer1.add("I understand you.");
        Answer2.add("I don't understand what you're talking about.");
        Answer3.add("I don't understand what he's saying.");
        Answer4.add("N/A");
        CorrectAnswer.add(2);

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("Извени, где метро? Направо или прямо?");
        Answer1.add("Excuse me, where's the metro? Right or straight?");
        Answer2.add("Excuse me, where's the metro? Left or right?");
        Answer3.add("Excuse me, where's the metro? Left or straight?");
        Answer4.add("N/A");
        CorrectAnswer.add(1);

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("Как я еду в метро?");
        Answer1.add("How are you going there?");
        Answer2.add("I'm eating in the metro.");
        Answer3.add("How do I go to the metro?");
        Answer4.add("N/A");
        CorrectAnswer.add(3);

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("Может быть, я буду есть и потом, буду идти в университет.");
        Answer1.add("I will eat and go to the university.");
        Answer2.add("Maybe, I will eat and after, I will go to the university.");
        Answer3.add("Maybe, I will eat and go to the park.");
        Answer4.add("N/A");
        CorrectAnswer.add(2);

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("У меня есть папа, мама и одна собака.");
        Answer1.add("I have a dad, mom and one dog.");
        Answer2.add("He has a dad, mom and one cat.");
        Answer3.add("I have a dad, mom and one cat.");
        Answer4.add("N/A");
        CorrectAnswer.add(1);

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("Я думаю что Америка лучшая страна в мире.");
        Answer1.add("I think that America is the strongest country in the world.");
        Answer2.add("I think that America is the worst.");
        Answer3.add("I think that America is the best country in the world.");
        Answer4.add("N/A");
        CorrectAnswer.add(3);

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("Что ты думаешь о руской политике сейчас?");
        Answer1.add("I'm thinking about Russian politics now.");
        Answer2.add("What do you think about Russian politics now?");
        Answer3.add("What do you think about it?");
        Answer4.add("N/A");
        CorrectAnswer.add(2);

    }
}
