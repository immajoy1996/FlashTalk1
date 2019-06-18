package com.languageapp.immanuel.flashtalk;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.ArrayList;


public class AlphabetFragment1 extends Fragment {

    //MediaPlayer mediaPlayer=null;

    //MediaPlayer mediaPlayer_alphabet;
    int STEP_TIME=100;
    RecyclerViewAdapterRussAlphabet adapter;
    //Map<String,String> letter_files=new HashMap<String,String>();
    //ImageView volume;
    //ImageView pause;
    HintDialogClass hint_box1;
    HintDialogClass hint_box2;
    String state_hint_swipe;
    String state_hint_pronunciation;

    public AlphabetFragment1() {
        // Required empty public constructor
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        // Make sure that we are currently visible
        if (this.isVisible()) {
            // If we are becoming invisible, then...
            if (!isVisibleToUser) {
                final Uri uri_flip=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/pageflipmod");
                doit(getView(),uri_flip);

                //endit();
                //volume.setVisibility(View.VISIBLE);
                //pause.setVisibility(View.GONE);
            }
            else {

            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_alphabet_fragment1, container, false);
        //Toolbar toolbar = (Toolbar)rootView.findViewById(R.id.toolbar_fragment1);
        //toolbar.setTitle("Alphabets");

        ImageView back_button=(ImageView)rootView.findViewById(R.id.back_button);
        ImageView forward_button=(ImageView)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.alphabet_view_pager);

        SharedPreferences mPrefs=getContext().getSharedPreferences("Hints",0);
        String str0=mPrefs.getString("var_Alphabet","not shown");
        SharedPreferences.Editor mEditor=mPrefs.edit();

        if(str0.equals("not shown")) {

            SpannableString msg1 = new SpannableString("Click for audio. Swipe right to practice.");
            //SpannableString msg2=new SpannableString("Click the buttons for audio.");
            (new MyApplication(getContext())).show_hints(getFragmentManager(), msg1, "var_Alphabet");
            mEditor.putString("var_Alphabet","shown");
            mEditor.commit();
        }

        final Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.wobble);

        back_button.startAnimation(anim);
        forward_button.startAnimation(anim);

        //Toast.makeText(getContext(),state_hint_pronunciation,Toast.LENGTH_SHORT).show();
        //SharedPreferences mPrefs = getActivity().getSharedPreferences("Hints", 0);
        //state_hint_pronunciation = mPrefs.getString("HINT_PRONUNCIATION", "not found");
        //state_hint_swipe = mPrefs.getString("HINT_SWIPE", "not found");

        /*if(isVisible()) {
            String msg1 = "See the arrows in the toolbar? This means you can click them or swipe the page to see more.";
            SpannableString spannableString_swipe = new SpannableString(msg1);
            String msg2 = "Click the letters to hear the pronounciation.";
            SpannableString spannableString_pronunciation = new SpannableString(msg2);

            HintDialogDoubleClass hints = HintDialogDoubleClass.newInstance(spannableString_pronunciation, spannableString_swipe);
            FragmentManager fm = getFragmentManager();
            hints.show(fm, "Dialog Double Tag");
        }*/

        //SharedPreferences.Editor mEditor = mPrefs.edit();

        /*if(state_hint_swipe.equals("not found")) {
            String msg1 = "See the arrows in the toolbar? This means you can click them or swipe the page to see more.";
            SpannableString spannableString_swipe=new SpannableString(msg1);
            hint_box1 = HintDialogClass.newInstance(spannableString_swipe);
            FragmentManager fm=getFragmentManager();
            hint_box1.show(fm,"Dialog Tag");
            mEditor.putString("HINT_SWIPE", "found").commit();
        }*/

        /*if(true) {
            String msg2 = "Click the letters to hear the pronounciation.";
            SpannableString spannableString_pronunciation=new SpannableString(msg2);
            hint_box2 = HintDialogClass.newInstance(spannableString_pronunciation);
            FragmentManager fm=getFragmentManager();
            hint_box2.show(fm,"Dialog Tag");
            mEditor.putString("HINT_PRONUNCIATION", "found").commit();
        }*/



        //letter_files.put("default","android.resource://"+getActivity().getPackageName()+"/raw/wrong_answer");
        //letter_files.put("т","android.resource://"+getActivity().getPackageName()+"/raw/correct_answer");

        final ArrayList<String> lett=new ArrayList<String>();
        ArrayList<SpannableString> traslit=new ArrayList<SpannableString>();

        SpannableString str1 = new SpannableString("tom");
        str1.setSpan(new UnderlineSpan(), 0, 1, 0);

        SpannableString str2 = new SpannableString("orange");
        str2.setSpan(new UnderlineSpan(), 0, 1, 0);

        SpannableString str3 = new SpannableString("ant");
        str3.setSpan(new UnderlineSpan(), 0, 1, 0);

        SpannableString str4 = new SpannableString("mother");
        str4.setSpan(new UnderlineSpan(), 0, 1, 0);

        SpannableString str5 = new SpannableString("apple");
        str5.setSpan(new UnderlineSpan(), 0, 1, 0);

        SpannableString str6 = new SpannableString("rotten");
        str6.setSpan(new UnderlineSpan(), 0, 1, 0);

        SpannableString str7 = new SpannableString("person");
        str7.setSpan(new UnderlineSpan(), 0, 1, 0);

        SpannableString str8 = new SpannableString("salad"); //c
        str8.setSpan(new UnderlineSpan(), 0, 1, 0);

        SpannableString str9 = new SpannableString("yes"); //е
        str9.setSpan(new UnderlineSpan(), 0, 2, 0);

        SpannableString str10 = new SpannableString("elephant"); //э
        str10.setSpan(new UnderlineSpan(), 0, 1, 0);

        SpannableString str11 = new SpannableString("karma"); //к
        str11.setSpan(new UnderlineSpan(), 0, 1, 0);

        SpannableString str12 = new SpannableString("nothing"); //н
        str12.setSpan(new UnderlineSpan(), 0, 1, 0);

        SpannableString str13 = new SpannableString("feet"); //и
        str13.setSpan(new UnderlineSpan(), 1, 3, 0);

        SpannableString str14 = new SpannableString("ladder"); //л
        str14.setSpan(new UnderlineSpan(), 0, 1, 0);

        SpannableString str15 = new SpannableString("baby"); //б
        str15.setSpan(new UnderlineSpan(), 0, 1, 0);

        //сеэкни лбдуфгз йжвцюш щехяычь

        SpannableString str16 = new SpannableString("dad"); //д
        str16.setSpan(new UnderlineSpan(), 0, 1, 0);

        SpannableString str17 = new SpannableString("shoot"); //у
        str17.setSpan(new UnderlineSpan(), 2, 4, 0);

        SpannableString str18 = new SpannableString("fairy"); //ф
        str18.setSpan(new UnderlineSpan(), 0, 1, 0);

        SpannableString str19 = new SpannableString("game"); //г
        str19.setSpan(new UnderlineSpan(), 0, 1, 0);

        SpannableString str20 = new SpannableString("zebra"); //з
        str20.setSpan(new UnderlineSpan(), 0, 1, 0);

        SpannableString str21 = new SpannableString("idiot"); //й
        str21.setSpan(new UnderlineSpan(), 0, 1, 0);

        SpannableString str22 = new SpannableString("treasure"); //ж
        str22.setSpan(new UnderlineSpan(), 4, 5, 0);

        SpannableString str23 = new SpannableString("valentine"); //в
        str23.setSpan(new UnderlineSpan(), 0, 1, 0);

        SpannableString str24 = new SpannableString("tsar"); //ц
        str24.setSpan(new UnderlineSpan(), 0, 2, 0);

        SpannableString str25 = new SpannableString("yucca"); //ю
        str25.setSpan(new UnderlineSpan(), 0, 2, 0);

        SpannableString str26 = new SpannableString("sheet"); //ш
        str26.setSpan(new UnderlineSpan(), 0, 2, 0);

        SpannableString str27 = new SpannableString("appreciate"); //щ
        str27.setSpan(new UnderlineSpan(), 5, 6, 0);

        SpannableString str28 = new SpannableString("yogurt"); //ё
        str28.setSpan(new UnderlineSpan(), 0, 2, 0);

        SpannableString str29 = new SpannableString("khan"); //х
        str29.setSpan(new UnderlineSpan(), 0, 2, 0);

        SpannableString str30 = new SpannableString("yard"); //ya
        str30.setSpan(new UnderlineSpan(), 0, 2, 0);

        SpannableString str31 = new SpannableString("marry"); //ы
        str31.setSpan(new UnderlineSpan(), 4, 5, 0);

        SpannableString str32 = new SpannableString("chimp"); //ы
        str32.setSpan(new UnderlineSpan(), 0, 2, 0);

        SpannableString str33 = new SpannableString("soft sign!"); //ы
        //str33.setSpan(new UnderlineSpan(), 4, 5, 0);

        //SpannableString stressed_o=new SpannableString("ó");



        lett.add("т");lett.add("о");lett.add("м");lett.add("а");lett.add("р");lett.add("п");
        lett.add("с");lett.add("е");lett.add("э");lett.add("к");lett.add("н");lett.add("и");
        lett.add("л");lett.add("б");lett.add("д");lett.add("у");lett.add("ф");lett.add("г");
        lett.add("з");
        lett.add("й");lett.add("ж");lett.add("в");lett.add("ц");lett.add("ю");lett.add("ш");
        lett.add("щ");lett.add("ё");lett.add("х");lett.add("я");lett.add("ы");lett.add("ч");
        lett.add("ь");

        traslit.add(str1);traslit.add(str2);traslit.add(str4);traslit.add(str5);traslit.add(str6);
        traslit.add(str7);traslit.add(str8);traslit.add(str9);traslit.add(str10);traslit.add(str11);traslit.add(str12);
        traslit.add(str13);traslit.add(str14);traslit.add(str15);traslit.add(str16);traslit.add(str17);traslit.add(str18);
        traslit.add(str19);traslit.add(str20);traslit.add(str21);traslit.add(str22);traslit.add(str23);traslit.add(str24);
        traslit.add(str25);traslit.add(str26);traslit.add(str27);traslit.add(str28);traslit.add(str29);traslit.add(str30);
        traslit.add(str31);traslit.add(str32);traslit.add(str33);

        // set up the RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view_alphabet);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecyclerViewAdapterRussAlphabet(getContext(), lett,traslit);
        recyclerView.setAdapter(adapter);

        /*adapter.setClickListener(new RecyclerViewAdapterRussAlphabet.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                TextView textView_letter=view.findViewById(R.id.textview_letters);
                String letter=textView_letter.getText().toString();
                String file_string=letter_files.get("default");
                Uri uri=Uri.parse(file_string);
                if(letter_files.containsKey(letter)) {
                    file_string = letter_files.get(letter);
                    uri = Uri.parse(file_string);
                }
                //Toast.makeText(view.getContext(),file_string,Toast.LENGTH_SHORT).show();
                if(mediaPlayer_alphabet==null){
                    mediaPlayer_alphabet=MediaPlayer.create(view.getContext(),uri);
                    mediaPlayer_alphabet.start();
                    //mediaPlayer_alphabet.release();
                }
                else if(mediaPlayer_alphabet.isPlaying()){
                    mediaPlayer_alphabet.stop();
                    mediaPlayer_alphabet.release();
                    mediaPlayer_alphabet=MediaPlayer.create(view.getContext(),uri);
                    mediaPlayer_alphabet.start();
                    //mediaPlayer_alphabet.release();
                }
                else {
                    mediaPlayer_alphabet = MediaPlayer.create(view.getContext(), uri);
                    mediaPlayer_alphabet.start();
                    //mediaPlayer_alphabet.release();
                }
            }
        });*/

        //final Uri uri_default=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/test");

        //final Uri uri=Uri.parse("android.resource://"+rootView.getContext().getPackageName()+"/raw/question_words_fragment1");
        //adapter.mediaPlayer_alphabet=MediaPlayer.create(rootView.getContext(),uri);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if(adapter.mediaPlayer_alphabet!=null) {
                    adapter.mediaPlayer_alphabet.stop();
                    adapter.mediaPlayer_alphabet.reset();
                    adapter.mediaPlayer_alphabet.release();
                    adapter.mediaPlayer_alphabet=null;
                }*/
                endit();
                    //adapter.mediaPlayer_alphabet=MediaPlayer.create(getContext(),uri);
                //volume.setVisibility(View.VISIBLE);
                //pause.setVisibility(View.GONE);
                getActivity().finish();
            }
        });

        forward_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mediaPlayer.stop();
                //mediaPlayer.release();
                //mediaPlayer=MediaPlayer.create(getContext(),uri);
                //volume.setVisibility(View.VISIBLE);
                //pause.setVisibility(View.GONE);
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page+1);
            }
        });


        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        endit();
        /*if(adapter.mediaPlayer_alphabet!=null) {
            adapter.mediaPlayer_alphabet.stop();
            adapter.mediaPlayer_alphabet.reset();
            adapter.mediaPlayer_alphabet.release();
            adapter.mediaPlayer_alphabet=null;
            //Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/wrong_answer");
            //adapter.mediaPlayer_alphabet= MediaPlayer.create(getContext(),uri);
        }*/
    }

    void endit(){
        if(adapter.mediaPlayer_alphabet!=null) {
            adapter.mediaPlayer_alphabet.stop();
            adapter.mediaPlayer_alphabet.reset();
            adapter.mediaPlayer_alphabet.release();
            adapter.mediaPlayer_alphabet=null;
            //Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/wrong_answer");
            //adapter.mediaPlayer_alphabet= MediaPlayer.create(getContext(),uri);
        }
    }

    void doit(View view,Uri uri) {
        if (adapter.mediaPlayer_alphabet == null) {
            adapter.mediaPlayer_alphabet = MediaPlayer.create(view.getContext(), uri);
            adapter.mediaPlayer_alphabet.start();

            adapter.mediaPlayer_alphabet.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    //mediaPlayer_alphabet.stop();
                    adapter.mediaPlayer_alphabet.reset();
                    adapter.mediaPlayer_alphabet.release();
                    adapter.mediaPlayer_alphabet = null;
                    //mediaPlayer_alphabet = MediaPlayer.create(vw.getContext(), uri);
                }

                ;
            });
            //mediaPlayer_alphabet.release();
        } else if (adapter.mediaPlayer_alphabet.isPlaying()) {
            adapter.mediaPlayer_alphabet.stop();
            adapter.mediaPlayer_alphabet.reset();
            adapter.mediaPlayer_alphabet.release();
            adapter.mediaPlayer_alphabet = MediaPlayer.create(view.getContext(), uri);
            adapter.mediaPlayer_alphabet.start();


            adapter.mediaPlayer_alphabet.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    //mediaPlayer_alphabet.stop();
                    adapter.mediaPlayer_alphabet.reset();
                    adapter.mediaPlayer_alphabet.release();
                    adapter.mediaPlayer_alphabet = null;

                }

                ;
            });
        } else {
            adapter.mediaPlayer_alphabet = MediaPlayer.create(view.getContext(), uri);
            adapter.mediaPlayer_alphabet.start();

            adapter.mediaPlayer_alphabet.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    //mediaPlayer_alphabet.stop();
                    adapter.mediaPlayer_alphabet.reset();
                    adapter.mediaPlayer_alphabet.release();
                    adapter.mediaPlayer_alphabet = null;
                }

                ;
            });

        }
    }

    /*void show_hints(FragmentManager fm, SpannableString spannableString1,SpannableString spannableString2,String var_name1,String var_name2){
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
    }*/


}
