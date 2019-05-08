package com.example.immanuel.flashtalk;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.text.SpannableString;

public class MyApplication extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }

    void show_hints(FragmentManager fm, SpannableString spannableString1, SpannableString spannableString2, String var_name1, String var_name2){
        SharedPreferences mPrefs=MyApplication.getAppContext().getSharedPreferences("Hints",0);
        String str1=mPrefs.getString(var_name1,"not found");
        String str2=mPrefs.getString(var_name2,"not found");
        HintDialogDoubleClass hints1 = HintDialogDoubleClass.newInstance(spannableString1, spannableString2);
        HintDialogClass hints2=HintDialogClass.newInstance(spannableString1);
        HintDialogClass hints3=HintDialogClass.newInstance(spannableString2);

        SharedPreferences.Editor mEditor=mPrefs.edit();

        if(str1.equals("not found") && str2.equals("not found")){
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
        else{}
    }

    void show_hints(FragmentManager fm, SpannableString spannableString1, String var_name1){
        SharedPreferences mPrefs=MyApplication.getAppContext().getSharedPreferences("Hints",0);
        String str1=mPrefs.getString(var_name1,"not found");
        //String str2=mPrefs.getString(var_name2,"not found");
        //HintDialogDoubleClass hints1 = HintDialogDoubleClass.newInstance(spannableString1, spannableString2);
        HintDialogClass hints1=HintDialogClass.newInstance(spannableString1);
        //HintDialogClass hints3=HintDialogClass.newInstance(spannableString2);

        SharedPreferences.Editor mEditor=mPrefs.edit();

        if(str1.equals("not found")){
            hints1.show(fm,"Dialog");
            mEditor.putString(var_name1,"found");
            //mEditor.putString(var_name2,"found");
            mEditor.commit();

        }
    }
}