package com.example.immanuel.flashtalk;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.text.SpannableString;

public class MyApplication {

    private static Context context;

    MyApplication(Context cont){
        context=cont;
    }

    void show_hints(FragmentManager fm, SpannableString spannableString1, SpannableString spannableString2, String var_name1, String var_name2){
        SharedPreferences mPrefs=context.getSharedPreferences("Hints",0);

        String tutorial_off=mPrefs.getString("TUTORIAL_OFF","false");

        String str1=mPrefs.getString(var_name1,"not found");
        String str2=mPrefs.getString(var_name2,"not found");
        HintDialogDoubleClass hints1 = HintDialogDoubleClass.newInstance(spannableString1, spannableString2);
        HintDialogClass hints2=HintDialogClass.newInstance(spannableString1);
        HintDialogClass hints3=HintDialogClass.newInstance(spannableString2);

        SharedPreferences.Editor mEditor=mPrefs.edit();

        if(tutorial_off.equals("true")){return;}
        hints1.show(fm,"Dialog Double");

        /*if(str1.equals("not found") && str2.equals("not found")){
            hints1.show(fm,"Dialog Double");
            mEditor.putString(var_name1,"found");
            mEditor.putString(var_name2,"found");
            mEditor.commit();

        }
        else if(str1.equals("not found") && str2.equals("found")){
            hints2.show(fm,"Dialog");
            mEditor.putString(var_name1,"found");
            //mEditor.putString(var_name2,"found");
            mEditor.commit();
        }
        else if(str1.equals("found") && str2.equals("not found")){
            hints3.show(fm,"Dialog");
            //mEditor.putString(var_name1,"found");
            mEditor.putString(var_name2,"found");
            mEditor.commit();
        }
        else{}*/
    }

    void show_hints(FragmentManager fm, SpannableString spannableString1, String var_name1){
        SharedPreferences mPrefs=context.getSharedPreferences("Hints",0);
        String str1=mPrefs.getString(var_name1,"not found");
        //String str2=mPrefs.getString(var_name2,"not found");
        //HintDialogDoubleClass hints1 = HintDialogDoubleClass.newInstance(spannableString1, spannableString2);
        HintDialogClass hints1=HintDialogClass.newInstance(spannableString1);
        //HintDialogClass hints3=HintDialogClass.newInstance(spannableString2);

        SharedPreferences.Editor mEditor=mPrefs.edit();

        String tutorial_off=mPrefs.getString("TUTORIAL_OFF","false");
        if(tutorial_off.equals("true")){return;}


        //if(str1.equals("not found")){
            hints1.show(fm,"Dialog");
            mEditor.putString(var_name1,"found");
            //mEditor.putString(var_name2,"found");
            mEditor.commit();

        //}
    }
}