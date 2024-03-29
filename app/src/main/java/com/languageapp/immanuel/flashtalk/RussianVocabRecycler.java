package com.languageapp.immanuel.flashtalk;

/**
 * Created by Immanuel on 2/8/19.
 */

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
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


public class RussianVocabRecycler extends RecyclerView.Adapter<RussianVocabRecycler.ViewHolder> {

    private List<String> russian_words;
    private List<String> transliterations;
    private List<String> english_words;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    MediaPlayer mediaPlayer_vocab=null;
    Map<String,String> vocab_files=new HashMap<String,String>();


    // data is passed into the constructor
    RussianVocabRecycler(Context context, List<String> data1 ,List<String> data2,List<String>data3) {
        this.mInflater = LayoutInflater.from(context);
        this.russian_words = data1;
        this.transliterations=data2;
        this.english_words=data3;
        vocab_files.put("default","android.resource://"+context.getPackageName()+"/raw/wrong_answer");
        vocab_files.put("man","android.resource://"+context.getPackageName()+"/raw/prq1");
        vocab_files.put("woman","android.resource://"+context.getPackageName()+"/raw/prq2");
        vocab_files.put("friend","android.resource://"+context.getPackageName()+"/raw/prq3");
        vocab_files.put("mom","android.resource://"+context.getPackageName()+"/raw/prq4");
        vocab_files.put("dad","android.resource://"+context.getPackageName()+"/raw/prq5");
        vocab_files.put("brother","android.resource://"+context.getPackageName()+"/raw/prq6");
        vocab_files.put("sister","android.resource://"+context.getPackageName()+"/raw/prq8");

        vocab_files.put("store","android.resource://"+context.getPackageName()+"/raw/bdd1");
        vocab_files.put("cafe","android.resource://"+context.getPackageName()+"/raw/bdd2");
        vocab_files.put("hotel","android.resource://"+context.getPackageName()+"/raw/bdd3");
        vocab_files.put("highschool","android.resource://"+context.getPackageName()+"/raw/bdd4");
        vocab_files.put("restaurant","android.resource://"+context.getPackageName()+"/raw/bdd5");
        vocab_files.put("airport","android.resource://"+context.getPackageName()+"/raw/bdd6");
        vocab_files.put("park","android.resource://"+context.getPackageName()+"/raw/bdd7");

        vocab_files.put("food","android.resource://"+context.getPackageName()+"/raw/fdd1");
        vocab_files.put("drink","android.resource://"+context.getPackageName()+"/raw/fdd2");
        vocab_files.put("coffee","android.resource://"+context.getPackageName()+"/raw/fdd3");
        vocab_files.put("tea","android.resource://"+context.getPackageName()+"/raw/fdd4");
        vocab_files.put("juice","android.resource://"+context.getPackageName()+"/raw/fdd5");
        vocab_files.put("ice-cream","android.resource://"+context.getPackageName()+"/raw/fdd6");
        vocab_files.put("banana","android.resource://"+context.getPackageName()+"/raw/fdd7");
        vocab_files.put("apple","android.resource://"+context.getPackageName()+"/raw/fdd8");
        vocab_files.put("cake","android.resource://"+context.getPackageName()+"/raw/fdd9");
        vocab_files.put("water","android.resource://"+context.getPackageName()+"/raw/fdd10");
        vocab_files.put("vodka","android.resource://"+context.getPackageName()+"/raw/fdd11");

        vocab_files.put("Today","android.resource://"+context.getPackageName()+"/raw/tod1");
        vocab_files.put("day","android.resource://"+context.getPackageName()+"/raw/tod2");
        vocab_files.put("weather","android.resource://"+context.getPackageName()+"/raw/tod3");
        vocab_files.put("book","android.resource://"+context.getPackageName()+"/raw/tod4");
        vocab_files.put("building","android.resource://"+context.getPackageName()+"/raw/tod5");
        vocab_files.put("place","android.resource://"+context.getPackageName()+"/raw/tod6");
        vocab_files.put("house","android.resource://"+context.getPackageName()+"/raw/tod7");
        vocab_files.put("car","android.resource://"+context.getPackageName()+"/raw/tod8");


    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.russian_vocab_recycler, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String a = english_words.get(position);
        String b = transliterations.get(position);
        String c = russian_words.get(position);
        holder.myTextView1.setText(a);
        holder.myTextView2.setText(b);
        holder.myTextView3.setText(c);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return russian_words.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView1;
        TextView myTextView2;
        TextView myTextView3;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView1 = itemView.findViewById(R.id.english);
            myTextView2 = itemView.findViewById(R.id.transliterations);
            myTextView3 = itemView.findViewById(R.id.russian);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String letter=myTextView1.getText().toString();
                    String file_string=vocab_files.get("default");
                    Uri uri=Uri.parse(file_string);
                    if(vocab_files.containsKey(letter)) {
                        file_string = vocab_files.get(letter);
                        uri = Uri.parse(file_string);
                    }
                    //Toast.makeText(view.getContext(),file_string,Toast.LENGTH_SHORT).show();
                    if (mediaPlayer_vocab == null) {
                        mediaPlayer_vocab = MediaPlayer.create(view.getContext(), uri);
                        mediaPlayer_vocab.start();

                        mediaPlayer_vocab.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            public void onCompletion(MediaPlayer mp) {
                                //mediaPlayer_alphabet.stop();
                                mediaPlayer_vocab.reset();
                                mediaPlayer_vocab.release();
                                mediaPlayer_vocab=null;
                                //mediaPlayer_alphabet = MediaPlayer.create(vw.getContext(), uri);
                            };
                        });
                        //mediaPlayer_alphabet.release();
                    } else if (mediaPlayer_vocab.isPlaying()) {
                        mediaPlayer_vocab.stop();
                        mediaPlayer_vocab.reset();
                        mediaPlayer_vocab.release();
                        mediaPlayer_vocab=null;
                        mediaPlayer_vocab = MediaPlayer.create(view.getContext(), uri);
                        mediaPlayer_vocab.start();


                        mediaPlayer_vocab.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            public void onCompletion(MediaPlayer mp) {
                                //mediaPlayer_alphabet.stop();
                                mediaPlayer_vocab.reset();
                                mediaPlayer_vocab.release();
                                mediaPlayer_vocab=null;

                            };
                        });
                        //mediaPlayer_alphabet.stop();
                        //mediaPlayer_alphabet.reset();
                            /*try {
                                mediaPlayer_alphabet.setDataSource(itemView.getContext(), uri);
                                mediaPlayer_alphabet.prepare();
                                mediaPlayer_alphabet.start();
                            }catch (IOException e){
                                Log.d("IOException","MediaPlayer exception1");
                            }*/
                        //mediaPlayer_alphabet.release();
                    }
                    else {
                        mediaPlayer_vocab = MediaPlayer.create(view.getContext(), uri);
                        mediaPlayer_vocab.start();

                        mediaPlayer_vocab.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            public void onCompletion(MediaPlayer mp) {
                                //mediaPlayer_alphabet.stop();
                                mediaPlayer_vocab.reset();
                                mediaPlayer_vocab.release();
                                mediaPlayer_vocab=null;
                            };
                        });

                        //mediaPlayer_alphabet.release();
                            /*try {
                                mediaPlayer_alphabet.setDataSource(itemView.getContext(), uri);
                                mediaPlayer_alphabet.prepare();
                                mediaPlayer_alphabet.start();
                            }catch (IOException e){
                                Log.d("IOException","MediaPlayer exception2");
                            }*/
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
        return russian_words.get(id);
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
