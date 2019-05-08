package com.example.immanuel.flashtalk;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HintDialogClass extends DialogFragment implements
        android.view.View.OnClickListener {

    //public Activity c;
    public Dialog d;
    public LinearLayout check;
    public TextView textView_msg;
    public SpannableString msg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.hint_dialog, container, false);
        //getDialog().setTitle("Simple Dialog");
        check = (LinearLayout) rootView.findViewById(R.id.check);

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

        return rootView;
    }

    public static HintDialogClass newInstance(SpannableString str) {
        HintDialogClass f = new HintDialogClass();

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
