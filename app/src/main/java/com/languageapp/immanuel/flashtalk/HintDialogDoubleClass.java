package com.languageapp.immanuel.flashtalk;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HintDialogDoubleClass extends DialogFragment implements
        android.view.View.OnClickListener {

    //public Activity c;
    public Dialog d;
    public LinearLayout check;
    public TextView textView_msg;
    public SpannableString msg1=null;
    public SpannableString msg2=null;
    public CheckBox check_annoying;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.hint_dialog, container, false);
        //getDialog().setTitle("Simple Dialog");
        check = (LinearLayout) rootView.findViewById(R.id.check);
        check_annoying=(CheckBox)rootView.findViewById(R.id.check_annoying);

        Bundle args = getArguments();
        msg1 = (SpannableString) args.getCharSequence("SPANNABLE_MSG1", "-1");
        msg2 = (SpannableString) args.getCharSequence("SPANNABLE_MSG2", "-1");
        //variable_name1 = args.getString("VARIABLE_NAME1", "-1");
        //variable_name2 = args.getString("VARIABLE_NAME2", "-1");

        textView_msg = (TextView) rootView.findViewById(R.id.msg);
        textView_msg.setText(msg1);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                //HintDialogClass next_hint=HintDialogClass.newInstance(msg2,"BlahBlah");
                //FragmentManager fm=getFragmentManager();
                //next_hint.show(fm,"Dialog Tag 2");
            }
        });

        HintDialogDoubleClass.this.getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);


        return rootView;
    }

    public static HintDialogDoubleClass newInstance(SpannableString str1,SpannableString str2) {
        HintDialogDoubleClass f = new HintDialogDoubleClass();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putCharSequence("SPANNABLE_MSG1", str1);
        args.putCharSequence("SPANNABLE_MSG2", str2);
        //args.putString("VARIABLE_NAME1", var_name1);
        //args.putString("VARIABLE_NAME2", var_name2);
        f.setArguments(args);

        return f;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);

        SharedPreferences mPrefs=getContext().getSharedPreferences("Hints",0);
        SharedPreferences.Editor mEditor=mPrefs.edit();

        if(check_annoying.isChecked()){
            mEditor.putString("TUTORIAL_OFF","true");
            mEditor.commit();
        }
        String tutorial_off=mPrefs.getString("TUTORIAL_OFF","false");
        //Toast.makeText(getContext(),tutorial_off, Toast.LENGTH_SHORT).show();
        if(tutorial_off.equals("false")) {
            HintDialogClass next_hint = HintDialogClass.newInstance(msg2);
            next_hint.show(getFragmentManager(), "Dialog");
        }
        //state_hint_swipe = mPrefs.getString("HINT_SWIPE", "not found");
    }


    @Override
    public void onClick(View v) {
        //dismiss();
    }

}
