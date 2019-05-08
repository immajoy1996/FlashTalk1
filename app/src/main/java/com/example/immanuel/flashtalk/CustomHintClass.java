package com.example.immanuel.flashtalk;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomHintClass extends Dialog implements
        android.view.View.OnClickListener {

    public Activity c;
    public Dialog d;
    public LinearLayout check;
    public TextView textView_msg;
    public SpannableString msg;

    public CustomHintClass(Activity a, SpannableString str) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
        msg=str;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.hint_dialog);
        check = (LinearLayout) findViewById(R.id.check);
        textView_msg = (TextView) findViewById(R.id.msg);
        textView_msg.setText(msg);
        check.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        /*switch (v.getId()) {
            case R.id.check:
                c.finish();
                break;
            default:
                break;
        }*/
        dismiss();
    }
}