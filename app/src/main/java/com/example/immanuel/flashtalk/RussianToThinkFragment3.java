package com.example.immanuel.flashtalk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RussianToThinkFragment3 extends Fragment {

    public RussianToThinkFragment3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_russian_to_think_fragment3, container, false);
        //Toolbar toolbar = (Toolbar)rootView.findViewById(R.id.toolbar);
        //toolbar.setTitle("Examples");
        return rootView;
    }
}
