package com.languageapp.immanuel.flashtalk;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;

public class RussianSoundEffectsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_sound_effects);

        ImageButton back_button=(ImageButton)findViewById(R.id.back_button);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        SharedPreferences mPrefs=this.getSharedPreferences("Settings",0);
        final SharedPreferences.Editor mEditor=mPrefs.edit();
        final CheckBox checkBox=findViewById(R.id.checkbox);

        String state=mPrefs.getString("SOUND_EFFECTS_OFF","false");
        if(state.equals("true")){
            checkBox.setChecked(true);
        }
        else{
            checkBox.setChecked(false);
        }

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox.isChecked()){
                    mEditor.putString("SOUND_EFFECTS_OFF","true");
                    mEditor.commit();
                }
                else{
                    mEditor.putString("SOUND_EFFECTS_OFF","false");
                    mEditor.commit();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
