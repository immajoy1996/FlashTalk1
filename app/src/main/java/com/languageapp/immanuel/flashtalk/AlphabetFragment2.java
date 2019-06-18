package com.languageapp.immanuel.flashtalk;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.ArrayList;


public class AlphabetFragment2 extends Fragment {

    //MediaPlayer mediaPlayer
    int STEP_TIME=100;
    RecyclerViewAdapterRussAlphPractice adapter;
    HintDialogClass hint_box1;
    HintDialogClass hint_box2;
    String state_hint_accent;
    String state_hint_cognate;
    //ImageView volume;
    //ImageView pause;

    public AlphabetFragment2() {
        // Required empty public constructor
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        // Make sure that we are currently visible
        if(isVisibleToUser){
            String msg1 = "All these words sound similar to their English counterparts. Have fun!";
            SpannableString spannableString1 = new SpannableString(msg1);

            String msg2 = "An unstressed о in Russian sounds like а. A stressed ó sounds like the normal о.";
            SpannableString spannableString2= new SpannableString(msg2);
            spannableString2.setSpan(new StyleSpan(Typeface.BOLD), msg2.indexOf("о in"), msg2.indexOf("о in") + 1, 0);
            spannableString2.setSpan(new StyleSpan(Typeface.BOLD), msg2.indexOf("а."), msg2.indexOf("а.") + 1, 0);
            spannableString2.setSpan(new StyleSpan(Typeface.BOLD), msg2.indexOf("ó"), msg2.indexOf("ó") + 1, 0);
            spannableString2.setSpan(new StyleSpan(Typeface.BOLD), msg2.indexOf("о."), msg2.indexOf("о.") + 1, 0);
            //SpannableString spannableString_pronunciation=new SpannableString(msg2);

            //(new MyApplication()).show_hints(getFragmentManager(),spannableString1,spannableString2,"HINT_COGNATE","HINT_ACCENTS");
            //HintDialogDoubleClass hints = HintDialogDoubleClass.newInstance(spannableString1, spannableString2,"HINT_COGNATE","HINT_ACCENTS");
            //FragmentManager fm = getFragmentManager();
            //hints.show(fm, "Dialog Double Tag");
            //hints.launch();
            //FragmentManager fm=getFragmentManager();
            //hint_box2.show(fm,"Dialog Tag");
            //hint_box1.show(fm,"Dialog Tag");
        }
        if (this.isVisible()) {
            // If we are becoming invisible, then...
            if (!isVisibleToUser) {
                /*if(adapter.mediaPlayer_words!=null) {
                    adapter.mediaPlayer_words.stop();
                    adapter.mediaPlayer_words.reset();
                    adapter.mediaPlayer_words.release();
                    adapter.mediaPlayer_words=null;
                    //Uri uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/raw/basic_pronouns_fragment3");
                    //adapter.mediaPlayer_words = MediaPlayer.create(getContext(), uri);
                }*/
                final Uri uri_flip=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/pageflipmod");
                doit(getView(),uri_flip);
                //endit();
                //volume.setVisibility(View.VISIBLE);
                //pause.setVisibility(View.GONE);
            }
            else {
                // do what you like
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_alphabet_fragment2, container, false);
        //Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar_fragment2);
        //toolbar.setTitle("Practice");

        ImageView back_button=(ImageView)rootView.findViewById(R.id.back_button);
        //ImageView forward_button=(ImageView)rootView.findViewById(R.id.forward_button);
        final ViewPager viewPager=getActivity().findViewById(R.id.alphabet_view_pager);

        CircularImageViewTest home=rootView.findViewById(R.id.home);
        CircularImageViewTest question=rootView.findViewById(R.id.question);
        final Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.wobble);

        back_button.startAnimation(anim);
        home.startAnimation(anim);
        question.startAnimation(anim);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endit();
                getActivity().finish();
            }
        });

        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpannableString msg0 = new SpannableString("Russian words aren't always pronounced exactly how they're spelled. We'll tell you about that next. Just keep reading for now.");
                JustHintClass hint = JustHintClass.newInstance(msg0);
                hint.show(getFragmentManager(), "Dialog");
            }
        });


        /*forward_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page+1);
            }
        });*/

        /*if(isAdded() && isVisible() && getUserVisibleHint()) {
            String msg1 = "All these words sound similar to their English counterparts. Have fun!";
            SpannableString spannableString_cognate = new SpannableString(msg1);

            String msg2 = "An unstressed о in Russian sounds like а. A stressed ó sounds like the normal о.";
            SpannableString spannableString_accent = new SpannableString(msg2);
            spannableString_accent.setSpan(new StyleSpan(Typeface.BOLD), msg2.indexOf("о in"), msg2.indexOf("о in") + 1, 0);
            spannableString_accent.setSpan(new StyleSpan(Typeface.BOLD), msg2.indexOf("а."), msg2.indexOf("а.") + 1, 0);
            spannableString_accent.setSpan(new StyleSpan(Typeface.BOLD), msg2.indexOf("ó"), msg2.indexOf("ó") + 1, 0);
            spannableString_accent.setSpan(new StyleSpan(Typeface.BOLD), msg2.indexOf("о."), msg2.indexOf("о.") + 1, 0);
            //SpannableString spannableString_pronunciation=new SpannableString(msg2);

            HintDialogDoubleClass hints = HintDialogDoubleClass.newInstance(spannableString_cognate, spannableString_accent);
            FragmentManager fm = getFragmentManager();
            hints.show(fm, "Dialog Double Tag");
        }*/

        /*SharedPreferences mPrefs = getActivity().getSharedPreferences("Hints", 0);
        state_hint_accent = mPrefs.getString("HINT_ACCENT", "not found");
        state_hint_cognate = mPrefs.getString("HINT_COGNATE", "not found");

        SharedPreferences.Editor mEditor = mPrefs.edit();*/

        /*if(state_hint_accent.equals("not found")) {
            String msg2 = "An unstressed о in Russian sounds like а. A stressed ó sounds like the normal о.";
            SpannableString spannableString_accent=new SpannableString(msg2);
            spannableString_accent.setSpan(new StyleSpan(Typeface.BOLD),msg2.indexOf("о in"),msg2.indexOf("о in")+1,0);
            spannableString_accent.setSpan(new StyleSpan(Typeface.BOLD),msg2.indexOf("а."),msg2.indexOf("а.")+1,0);
            spannableString_accent.setSpan(new StyleSpan(Typeface.BOLD),msg2.indexOf("ó"),msg2.indexOf("ó")+1,0);
            spannableString_accent.setSpan(new StyleSpan(Typeface.BOLD),msg2.indexOf("о."),msg2.indexOf("о.")+1,0);
            hint_box2 = HintDialogClass.newInstance(spannableString_accent);
            mEditor.putString("HINT_ACCENT", "found").commit();
        }*/


        /*if(state_hint_cognate.equals("not found")) {
            String msg1 = "All these words sound similar to their English counterparts. Have fun!";
            SpannableString spannableString_cognate=new SpannableString(msg1);
            hint_box1 = HintDialogClass.newInstance(spannableString_cognate);
            FragmentManager fm=getFragmentManager();
            //hint_box1.show(fm,"Dialog Tag");
            mEditor.putString("HINT_COGNATE", "found").commit();
        }*/


        ArrayList<String> lett=new ArrayList<String>();
        ArrayList<SpannableString> traslit=new ArrayList<SpannableString>();

        SpannableString str1 = new SpannableString("tom");
        SpannableString str2 = new SpannableString("atam");
        SpannableString str3 = new SpannableString("mator");
        SpannableString str4 = new SpannableString("port");
        SpannableString str5 = new SpannableString("sport");
        SpannableString str6 = new SpannableString("stop");
        SpannableString str7 = new SpannableString("paspart");
        SpannableString str8 = new SpannableString("myetr");
        SpannableString str9 = new SpannableString("era");
        SpannableString str10 = new SpannableString("ekspart");
        SpannableString str11 = new SpannableString("arkyestr");
        SpannableString str12 = new SpannableString("ristaran");
        SpannableString str13 = new SpannableString("eempart");

        /*SpannableString str14 = new SpannableString("lam-pa");
        SpannableString str15 = new SpannableString("kilo-metr");
        SpannableString str16 = new SpannableString("bal-et");
        SpannableString str17 = new SpannableString("dok-tor");
        SpannableString str18 = new SpannableString("toor-ist");
        SpannableString str19 = new SpannableString("stud-ent");
        SpannableString str20 = new SpannableString("fut-bol");
        SpannableString str21 = new SpannableString("fru-kt");
        SpannableString str22 = new SpannableString("prog-ramma");
        SpannableString str23 = new SpannableString("ki-lo-gram-ma");
        SpannableString str24 = new SpannableString("komm-oon-eez-m");
        SpannableString str25 = new SpannableString("moo-zei");
        SpannableString str26 = new SpannableString("trol-ley-bus");

        SpannableString str27 = new SpannableString("zhoor-nal");
        SpannableString str28 = new SpannableString("vol-ey-bol");
        SpannableString str29 = new SpannableString("tsen-ter");
        SpannableString str30 = new SpannableString("kon-tsert");
        SpannableString str31 = new SpannableString("yu-mor");
        SpannableString str32 = new SpannableString("shok");
        SpannableString str33 = new SpannableString("ekh-o");*/




        lett.add("том");lett.add("атом");lett.add("мотор");lett.add("порт");lett.add("спорт");lett.add("стоп");
        lett.add("паспорт");lett.add("метр");lett.add("эра");lett.add("экспорт");lett.add("оркестр");lett.add("ресторан");lett.add("импорт");
        /*lett.add("лампа");lett.add("километр");lett.add("балет");lett.add("доктор");lett.add("турист");lett.add("студент");
        lett.add("футбол");lett.add("фрукт");lett.add("программа");lett.add("килограмма");lett.add("коммунизм");lett.add("музей");lett.add("троллейбус");
        lett.add("журнал");lett.add("волейбол ");lett.add("центр");lett.add("концерт");lett.add("юмор");lett.add("шок");
        lett.add("эхо");lett.add("як");lett.add("музыка");lett.add("чемпион");lett.add("чай");lett.add("стиль");lett.add("фильм");
        lett.add("эхо");*/

        traslit.add(str1);traslit.add(str2);traslit.add(str3);traslit.add(str4);traslit.add(str5);traslit.add(str6);
        traslit.add(str7);traslit.add(str8);traslit.add(str9);traslit.add(str10);
        traslit.add(str11);traslit.add(str12);traslit.add(str13);

        // set up the RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view_alphabet);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecyclerViewAdapterRussAlphPractice(getContext(), lett,traslit);
        recyclerView.setAdapter(adapter);

        final Uri uri_default=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/test");

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(getContext(),uri);
                volume.setVisibility(View.VISIBLE);
                pause.setVisibility(View.GONE);*/
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page-1);
            }
        });

        /*forward_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(adapter.mediaPlayer_alphabet!=null && adapter.mediaPlayer_alphabet.isPlaying()){
                    adapter.mediaPlayer_alphabet.stop();
                }
                int page=viewPager.getCurrentItem();
                viewPager.setCurrentItem(page+1);
            }
        });*/

        return rootView;
    }

    void endit(){
        if(adapter.mediaPlayer_words!=null) {
            adapter.mediaPlayer_words.stop();
            adapter.mediaPlayer_words.reset();
            adapter.mediaPlayer_words.release();
            adapter.mediaPlayer_words=null;
            //Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/wrong_answer");
            //adapter.mediaPlayer_alphabet= MediaPlayer.create(getContext(),uri);
        }
    }

    void doit(View view,Uri uri) {
        if (adapter.mediaPlayer_words == null) {
            adapter.mediaPlayer_words = MediaPlayer.create(view.getContext(), uri);
            adapter.mediaPlayer_words.start();

            adapter.mediaPlayer_words.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    //mediaPlayer_alphabet.stop();
                    adapter.mediaPlayer_words.reset();
                    adapter.mediaPlayer_words.release();
                    adapter.mediaPlayer_words = null;
                    //mediaPlayer_alphabet = MediaPlayer.create(vw.getContext(), uri);
                }

                ;
            });
            //mediaPlayer_alphabet.release();
        } else if (adapter.mediaPlayer_words.isPlaying()) {
            adapter.mediaPlayer_words.stop();
            adapter.mediaPlayer_words.reset();
            adapter.mediaPlayer_words.release();
            adapter.mediaPlayer_words = MediaPlayer.create(view.getContext(), uri);
            adapter.mediaPlayer_words.start();


            adapter.mediaPlayer_words.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    //mediaPlayer_alphabet.stop();
                    adapter.mediaPlayer_words.reset();
                    adapter.mediaPlayer_words.release();
                    adapter.mediaPlayer_words = null;

                }

                ;
            });
        } else {
            adapter.mediaPlayer_words = MediaPlayer.create(view.getContext(), uri);
            adapter.mediaPlayer_words.start();

            adapter.mediaPlayer_words.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    //mediaPlayer_alphabet.stop();
                    adapter.mediaPlayer_words.reset();
                    adapter.mediaPlayer_words.release();
                    adapter.mediaPlayer_words = null;
                }

                ;
            });

        }
    }
}