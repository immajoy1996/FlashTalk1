package com.example.immanuel.flashtalk;

import java.util.ArrayList;

public class Game_Beginner extends Game_Generic{
    public Game_Beginner(){
        TOTAL=13;
        Types=new ArrayList<Integer>(TOTAL);
        Instructions=new ArrayList<String>(TOTAL);
        Questions=new ArrayList<String>(TOTAL);
        Answer1=new ArrayList<String>(TOTAL);
        Answer2=new ArrayList<String>(TOTAL);
        Answer3=new ArrayList<String>(TOTAL);
        Answer4=new ArrayList<String>(TOTAL);
        CorrectAnswer=new ArrayList<Integer>(TOTAL);
        position=0;

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("Что ты делаешь?");
        Answer1.add("What is she doing?");
        Answer2.add("What is the dog doing");
        Answer3.add("What are you doing");
        Answer4.add("N/A");
        CorrectAnswer.add(3);

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("магазин");
        Answer1.add("Person");
        Answer2.add("Store");
        Answer3.add("Table");
        Answer4.add("N/A");
        CorrectAnswer.add(2);

        Types.add(0);
        Instructions.add("Choose the correct translation");
        Questions.add("Привет. Как ты?");
        Answer1.add("Hello. How are you?");
        Answer2.add("Bye Bye");
        Answer3.add("See you later");
        Answer4.add("Hello. How is she?");
        CorrectAnswer.add(1);

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("Что ты делаешь?");
        Answer1.add("Hello. How are you?");
        Answer2.add("Bye Bye");
        Answer3.add("See you later");
        Answer4.add("N/A");
        CorrectAnswer.add(1);

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("Что ты делаешь?");
        Answer1.add("Blah Blah Blah");
        Answer2.add("Donald Trump");
        Answer3.add("What are you doing?");
        Answer4.add("N/A");
        CorrectAnswer.add(3);

        Types.add(1);
        Instructions.add("What is this?");
        Questions.add("park");
        Answer1.add("Dog?");
        Answer2.add("Car");
        Answer3.add("Park");
        Answer4.add("Dog");
        CorrectAnswer.add(3);

        Types.add(1);
        Instructions.add("What is this?");
        Questions.add("book5");
        Answer1.add("Dog?");
        Answer2.add("Book");
        Answer3.add("Park");
        Answer4.add("Dog");
        CorrectAnswer.add(2);

        Types.add(0);
        Instructions.add("Choose the correct translation");
        Questions.add("Что ты делаешь?");
        Answer1.add("What is she doing?");
        Answer2.add("What are you doing");
        Answer3.add("What is that thing doing?");
        Answer4.add("Hello. How is she?");
        CorrectAnswer.add(2);

        Types.add(0);
        Instructions.add("Choose the correct translation");
        Questions.add("Что ты делаешь?");
        Answer1.add("What is she doing?");
        Answer2.add("What is she doing");
        Answer3.add("What are you doing?");
        Answer4.add("Hello. How is she?");
        CorrectAnswer.add(3);

        Types.add(1);
        Instructions.add("What is this?");
        Questions.add("indianflag");
        Answer1.add("Dog?");
        Answer2.add("Russia");
        Answer3.add("Park");
        Answer4.add("India");
        CorrectAnswer.add(4);

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("Пака Пака! Что ты делаешь?");
        Answer1.add("FlashTalk");
        Answer2.add("This is a terrible sentence");
        Answer3.add("What are you doing?");
        Answer4.add("N/A");
        CorrectAnswer.add(2);

        Types.add(0);
        Instructions.add("Choose the correct translation");
        Questions.add("Пака Пака! Что ты делаешь? Что ты делаешь? Пака Пака! Что ты делаешь? Что ты делаешь?");
        Answer1.add("Good Evening!");
        Answer2.add("Hello");
        Answer3.add("Good Morning");
        Answer4.add("Goodbye!");
        CorrectAnswer.add(4);

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("Что ты делаешь?");
        Answer1.add("What is she doing?");
        Answer2.add("What is the dog doing");
        Answer3.add("What are you doing");
        Answer4.add("N/A");
        CorrectAnswer.add(3);
    }
}
