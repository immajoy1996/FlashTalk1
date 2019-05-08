package com.example.immanuel.flashtalk;

import java.util.ArrayList;

public class Game_BasicPronouns extends Game_Generic{
    public Game_BasicPronouns(){
        TOTAL=10;
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
        Questions.add("Ты не Саша. Она Саша.");
        Answer1.add("You're not Sasha. She's Sasha.");
        Answer2.add("She's Sasha.");
        Answer3.add("You're Sammy.");
        Answer4.add("N/A");
        CorrectAnswer.add(1);

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("Привет. Я Наташа.");
        Answer1.add("Bye");
        Answer2.add("Hi. I'm Natasha.");
        Answer3.add("See you later");
        Answer4.add("N/A");
        CorrectAnswer.add(2);

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("Он Сергей?");
        Answer1.add("Is he Richard?");
        Answer2.add("Is she Sergei?");
        Answer3.add("Is he Sergei?");
        Answer4.add("N/A");
        CorrectAnswer.add(3);

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("Да, он Сергей.");
        Answer1.add("Yes, she's Natasha.");
        Answer2.add("Yes, he's Sergei.");
        Answer3.add("No, he's not Sergei.");
        Answer4.add("N/A");
        CorrectAnswer.add(2);

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("Я Мэнни. Ты Лена. Он Александр.");
        Answer1.add("I'm Manny. You're Lena. She's Alex.");
        Answer2.add("I'm Alexander. You're Lena.");
        Answer3.add("I'm Manny. You're Lena. He's Alexander.");
        Answer4.add("N/A");
        CorrectAnswer.add(3);

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("Привет. Ты Джон?");
        Answer1.add("Hi. Are you John?");
        Answer2.add("Hi. I'm John.");
        Answer3.add("Bye. I'm John.");
        Answer4.add("N/A");
        CorrectAnswer.add(1);

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("Нет. Я не Джон. Я Александр.");
        Answer1.add("Yes. I'm John.");
        Answer2.add("No. I'm not John. I'm Alexander.");
        Answer3.add("No. I'm not John. I'm Alan.");
        Answer4.add("N/A");
        CorrectAnswer.add(2);

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("Ты не Ричард. Я Ричард.");
        Answer1.add("He's not Sergei.");
        Answer2.add("I'm Richard. You're not Richard.");
        Answer3.add("You're not Richard. I'm Richard.");
        Answer4.add("N/A");
        CorrectAnswer.add(3);

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("Нет. Я не Наташа.");
        Answer1.add("No. I'm not Natasha.");
        Answer2.add("Yes. I'm Natasha.");
        Answer3.add("No. I'm Natasha.");
        Answer4.add("N/A");
        CorrectAnswer.add(1);

        Types.add(2);
        Instructions.add("Choose the correct translation");
        Questions.add("Я Мэнни. Ты Ричард. Он Дмитрий. Она Лена. ");
        Answer1.add("I'm Manny. He's Dimitri.");
        Answer2.add("I'm Manny. You're Richard. She's Lena.");
        Answer3.add("I'm Manny. You're Richard. He's Dimitri. She's Lena.");
        Answer4.add("N/A");
        CorrectAnswer.add(3);
    }
}
