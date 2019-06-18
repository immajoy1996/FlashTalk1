package com.languageapp.immanuel.flashtalk;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

public class JustHintClass extends DialogFragment implements
        android.view.View.OnClickListener {

    //public Activity c;
    public Dialog d;
    public LinearLayout check;
    //public CheckBox check_annoying;
    public TextView textView_msg;
    public SpannableString msg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.justtutorial, container, false);
        //getDialog().setTitle("Simple Dialog");
        check = (LinearLayout) rootView.findViewById(R.id.check);
        //check_annoying=(CheckBox)rootView.findViewById(R.id.check_annoying);


        Bundle args = getArguments();
        msg = (SpannableString) args.getCharSequence("SPANNABLE_MSG", "-1");
        textView_msg = (TextView) rootView.findViewById(R.id.msg);
        textView_msg.setText(msg);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        JustHintClass.this.getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        return rootView;
    }

    public static JustHintClass newInstance(SpannableString str) {
        JustHintClass f = new JustHintClass();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putCharSequence("SPANNABLE_MSG", str);
        f.setArguments(args);

        return f;
    }


    @Override
    public void onClick(View v) {
        //dismiss();
    }




}
