package com.languageapp.immanuel.flashtalk;

/**
 * Created by Immanuel on 2/8/19.
 */

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Immanuel on 2/8/19.
 */


public class RecyclerViewAdapterArabicPractice extends RecyclerView.Adapter<RecyclerViewAdapterArabicPractice.ViewHolder> {

    private List<String> letters;
    private List<SpannableString> transliterations;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    MediaPlayer mediaPlayer_words=null;
    Map<String,String> word_files=new HashMap<String,String>();

    // data is passed into the constructor
    RecyclerViewAdapterArabicPractice(Context context, List<String> data1 ,List<SpannableString> data2) {
        this.mInflater = LayoutInflater.from(context);
        this.letters = data1;
        this.transliterations=data2;
        word_files.put("default","android.resource://"+context.getPackageName()+"/raw/wrong_answer");
        word_files.put("том","android.resource://"+context.getPackageName()+"/raw/alphabet_fragment2_tom");
        word_files.put("атом","android.resource://"+context.getPackageName()+"/raw/alphabet_fragment2_atom");
        word_files.put("мотор","android.resource://"+context.getPackageName()+"/raw/alphabet_fragment2_motor");
        word_files.put("порт","android.resource://"+context.getPackageName()+"/raw/alphabet_fragment2_port");
        word_files.put("спорт","android.resource://"+context.getPackageName()+"/raw/alphabet_fragment2_sport");
        word_files.put("стоп","android.resource://"+context.getPackageName()+"/raw/alphabet_fragment2_stop");
        word_files.put("паспорт","android.resource://"+context.getPackageName()+"/raw/alphabet_fragment2_passport");
        word_files.put("метр","android.resource://"+context.getPackageName()+"/raw/alphabet_fragment2_meter");
        word_files.put("эра","android.resource://"+context.getPackageName()+"/raw/alphabet_fragment2_era");
        word_files.put("экспорт","android.resource://"+context.getPackageName()+"/raw/alphabet_fragment2_export");
        word_files.put("оркестр","android.resource://"+context.getPackageName()+"/raw/alphabet_fragment2_orchestra");
        word_files.put("ресторан","android.resource://"+context.getPackageName()+"/raw/alphabet_fragment2_restorant");
        word_files.put("импорт","android.resource://"+context.getPackageName()+"/raw/alphabet_fragment2_import");
        //word_files.put("атом","android.resource://"+context.getPackageName()+"/raw/alphabet_fragment2_atom");
        //word_files.put("мотор","android.resource://"+context.getPackageName()+"/raw/alphabet_fragment2_motor");
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.arabic_alphabet_practice_rowview, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String a = letters.get(position);
        SpannableString b = transliterations.get(position);
        holder.myTextView1.setText(a);
        holder.myTextView2.setText(b);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return letters.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView1;
        TextView myTextView2;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView1 = itemView.findViewById(R.id.textview_letters);
            myTextView2 = itemView.findViewById(R.id.textview_transliterations);
            itemView.setOnClickListener(this);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String letter=myTextView1.getText().toString();
                    String file_string=word_files.get("default");
                    Uri uri=Uri.parse(file_string);
                    if(word_files.containsKey(letter)) {
                        file_string = word_files.get(letter);
                        uri = Uri.parse(file_string);
                    }
                    if(mediaPlayer_words==null){
                        mediaPlayer_words=MediaPlayer.create(view.getContext(),uri);
                        mediaPlayer_words.start();
                        mediaPlayer_words.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer_words.reset();
                                mediaPlayer_words.release();
                                mediaPlayer_words=null;
                            }
                        });
                    }
                    else if(mediaPlayer_words.isPlaying()){
                        mediaPlayer_words.stop();
                        mediaPlayer_words.reset();
                        mediaPlayer_words.release();
                        mediaPlayer_words=MediaPlayer.create(view.getContext(),uri);
                        mediaPlayer_words.start();
                        mediaPlayer_words.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer_words.reset();
                                mediaPlayer_words.release();
                                mediaPlayer_words=null;
                            }
                        });
                    }
                    else {
                        mediaPlayer_words = MediaPlayer.create(view.getContext(), uri);
                        mediaPlayer_words.start();
                        mediaPlayer_words.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer_words.reset();
                                mediaPlayer_words.release();
                                mediaPlayer_words=null;
                            }
                        });
                    }
                }
            });
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return letters.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
