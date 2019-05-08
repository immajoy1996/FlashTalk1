package com.example.immanuel.flashtalk;

import java.util.ArrayList;
import java.util.Collections;

public class Game_Generic{

    public int TOTAL=5;
    public ArrayList<Integer>Types;
    public ArrayList<String>Instructions;
    public ArrayList<String>Questions;
    public ArrayList<String>Answer1;
    public ArrayList<String>Answer2;
    public ArrayList<String>Answer3;
    public ArrayList<String>Answer4;
    public ArrayList<Integer>CorrectAnswer;

    public int num_answered=0;
    public int num_right=0;
    public boolean clicked_wrong=false;

    public int position=0;

    public Game_Generic(ArrayList<Integer>Temp_Types,ArrayList<String>Temp_Instructions,ArrayList<String>Temp_Questions,ArrayList<String>Temp_Answer1,ArrayList<String>Temp_Answer2,ArrayList<String>Temp_Answer3,ArrayList<String>TempAnswer4,ArrayList<Integer>Temp_CorrectAnswer){
        Types=Temp_Types;
        Instructions=Temp_Instructions;
        Questions=Temp_Questions;
        Answer1=Temp_Answer1;
        Answer2=Temp_Answer2;
        Answer3=Temp_Answer3;
        Answer4=TempAnswer4;
        CorrectAnswer=Temp_CorrectAnswer;
        position=0;

        num_answered=0;
        num_right=0;
        clicked_wrong=false;
    }

    public Game_Generic(){
        Types=new ArrayList<Integer>(TOTAL);
        Instructions=new ArrayList<String>(TOTAL);
        Questions=new ArrayList<String>(TOTAL);
        Answer1=new ArrayList<String>(TOTAL);
        Answer2=new ArrayList<String>(TOTAL);
        Answer3=new ArrayList<String>(TOTAL);
        Answer4=new ArrayList<String>(TOTAL);
        CorrectAnswer=new ArrayList<Integer>(TOTAL);
        position=0;
    }

    public int getType(int pos){return Types.get(pos);}
    public String getInstruction(int pos){return Instructions.get(pos);}
    public String getQuestion(int pos){return Questions.get(pos);}
    public String getAnswer1(int pos){return Answer1.get(pos);}
    public String getAnswer2(int pos){return Answer2.get(pos);}
    public String getAnswer3(int pos){return Answer3.get(pos);}
    public String getAnswer4(int pos){return Answer4.get(pos);}
    public int getCorrectAnswer(int pos){return CorrectAnswer.get(pos);}

    public void shuffle(){
        ArrayList<Integer>nums=new ArrayList<>();
        for(int i=0;i<TOTAL;i++){
            nums.add(i);
        }
        Collections.shuffle(nums);

        ArrayList<Integer>Temp_Types=new ArrayList<>();
        ArrayList<String>Temp_Instructions=new ArrayList<>();
        ArrayList<String>Temp_Questions=new ArrayList<>();
        ArrayList<String>Temp_Answer1=new ArrayList<>();
        ArrayList<String>Temp_Answer2=new ArrayList<>();
        ArrayList<String>Temp_Answer3=new ArrayList<>();
        ArrayList<String>Temp_Answer4=new ArrayList<>();
        ArrayList<Integer>Temp_CorrectAnswer=new ArrayList<>();

        for(int i=0;i<TOTAL;i++){
            Temp_Types.add(Types.get(nums.get(i)));
            Temp_Instructions.add(Instructions.get(nums.get(i)));
            Temp_Questions.add(Questions.get(nums.get(i)));
            Temp_Answer1.add(Answer1.get(nums.get(i)));
            Temp_Answer2.add(Answer2.get(nums.get(i)));
            Temp_Answer3.add(Answer3.get(nums.get(i)));
            Temp_Answer4.add(Answer4.get(nums.get(i)));
            Temp_CorrectAnswer.add(CorrectAnswer.get(nums.get(i)));
        }

        for(int i=0;i<TOTAL;i++){
            Types.set(i,Temp_Types.get(i));
            Instructions.set(i,Temp_Instructions.get(i));
            Questions.set(i,Temp_Questions.get(i));
            Answer1.set(i,Temp_Answer1.get(i));
            Answer2.set(i,Temp_Answer2.get(i));
            Answer3.set(i,Temp_Answer3.get(i));
            Answer4.set(i,Temp_Answer4.get(i));
            CorrectAnswer.set(i,Temp_CorrectAnswer.get(i));
        }

    }

}
