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


public class RecyclerViewAdapterRussAlphabet extends RecyclerView.Adapter<RecyclerViewAdapterRussAlphabet.ViewHolder> {

    private List<String> letters;
    private List<SpannableString> transliterations;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    MediaPlayer mediaPlayer_alphabet;
    Map<String,String> letter_files=new HashMap<String,String>();
    //SoundPool soundPool;

    // data is passed into the constructor
    RecyclerViewAdapterRussAlphabet(Context context, List<String> data1 ,List<SpannableString> data2) {
        this.mInflater = LayoutInflater.from(context);
        this.letters = data1;
        this.transliterations=data2;
        //mediaPlayer_alphabet=new MediaPlayer();
        //soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        //mediaPlayer_alphabet.setAudioStreamType(AudioManager.STREAM_MUSIC);
        letter_files.put("default","android.resource://"+context.getPackageName()+"/raw/wrong_answer");
        letter_files.put("т","android.resource://"+context.getPackageName()+"/raw/letter1");
        letter_files.put("о","android.resource://"+context.getPackageName()+"/raw/letter2");
        letter_files.put("м","android.resource://"+context.getPackageName()+"/raw/letter3");
        letter_files.put("а","android.resource://"+context.getPackageName()+"/raw/letter4");
        letter_files.put("р","android.resource://"+context.getPackageName()+"/raw/letter5");
        letter_files.put("п","android.resource://"+context.getPackageName()+"/raw/letter6");
        letter_files.put("с","android.resource://"+context.getPackageName()+"/raw/letter7");
        letter_files.put("е","android.resource://"+context.getPackageName()+"/raw/letter8");
        letter_files.put("э","android.resource://"+context.getPackageName()+"/raw/letter9");
        letter_files.put("к","android.resource://"+context.getPackageName()+"/raw/letter10");
        letter_files.put("н","android.resource://"+context.getPackageName()+"/raw/letter11");
        letter_files.put("и","android.resource://"+context.getPackageName()+"/raw/letter12");
        letter_files.put("л","android.resource://"+context.getPackageName()+"/raw/letter14");
        letter_files.put("б","android.resource://"+context.getPackageName()+"/raw/letter14");
        letter_files.put("д","android.resource://"+context.getPackageName()+"/raw/letter15");
        letter_files.put("у","android.resource://"+context.getPackageName()+"/raw/letter16");
        letter_files.put("ф","android.resource://"+context.getPackageName()+"/raw/letter17");
        letter_files.put("г","android.resource://"+context.getPackageName()+"/raw/letter18");
        letter_files.put("з","android.resource://"+context.getPackageName()+"/raw/letter19");
        letter_files.put("й","android.resource://"+context.getPackageName()+"/raw/letter20");
        letter_files.put("ж","android.resource://"+context.getPackageName()+"/raw/letter21");
        letter_files.put("в","android.resource://"+context.getPackageName()+"/raw/letter21");
        letter_files.put("ц","android.resource://"+context.getPackageName()+"/raw/letter22");
        letter_files.put("ю","android.resource://"+context.getPackageName()+"/raw/letter23");
        letter_files.put("ш","android.resource://"+context.getPackageName()+"/raw/letter24");
        letter_files.put("щ","android.resource://"+context.getPackageName()+"/raw/letter25");
        letter_files.put("ё","android.resource://"+context.getPackageName()+"/raw/letter26");
        letter_files.put("х","android.resource://"+context.getPackageName()+"/raw/letter27");
        letter_files.put("я","android.resource://"+context.getPackageName()+"/raw/letter28");
        letter_files.put("ы","android.resource://"+context.getPackageName()+"/raw/letter29");
        letter_files.put("ч","android.resource://"+context.getPackageName()+"/raw/letter30");
        letter_files.put("ь","android.resource://"+context.getPackageName()+"/raw/wrong_answer");

    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.alphabet_rowview, parent, false);
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

        ViewHolder(final View itemView) {
            super(itemView);
            myTextView1 = itemView.findViewById(R.id.textview_letters);
            myTextView2 = itemView.findViewById(R.id.textview_transliterations);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String letter=myTextView1.getText().toString();
                    if(letter.equals("ь")==false) {
                        /*soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
                        final int soundId = soundPool.load(view.getContext(), R.raw.nothoarse8, 1);
                        soundPool.play(soundId, 1, 1, 0, 0, 1);
                        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
                            @Override
                            public void onLoadComplete(SoundPool soundPool, int i, int i1) {
                                soundPool.play(soundId, 1, 1, 0, 0, 1);
                                //soundPool.release();
                                //soundPool = null;
                            }
                        });*/

                        //soundPool.release();
                        //soundPool = null;
                        String file_string = letter_files.get("default");
                        Uri uri = Uri.parse(file_string);
                        if (letter_files.containsKey(letter)) {
                            file_string = letter_files.get(letter);
                            uri = Uri.parse(file_string);
                        }
                        //mediaPlayer_alphabet=MediaPlayer.create(view.getContext(),uri);
                        //Toast.makeText(view.getContext(),file_string,Toast.LENGTH_SHORT).show();
                        //final View vw=view;
                        if (mediaPlayer_alphabet == null) {
                            mediaPlayer_alphabet = MediaPlayer.create(view.getContext(), uri);
                            mediaPlayer_alphabet.start();

                            mediaPlayer_alphabet.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                public void onCompletion(MediaPlayer mp) {
                                    //mediaPlayer_alphabet.stop();
                                    mediaPlayer_alphabet.reset();
                                    mediaPlayer_alphabet.release();
                                    mediaPlayer_alphabet=null;
                                    //mediaPlayer_alphabet = MediaPlayer.create(vw.getContext(), uri);
                                };
                            });
                            //mediaPlayer_alphabet.release();
                        } else if (mediaPlayer_alphabet.isPlaying()) {
                            mediaPlayer_alphabet.stop();
                            mediaPlayer_alphabet.reset();
                            mediaPlayer_alphabet.release();
                            mediaPlayer_alphabet = MediaPlayer.create(view.getContext(), uri);
                            mediaPlayer_alphabet.start();


                            mediaPlayer_alphabet.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                public void onCompletion(MediaPlayer mp) {
                                    //mediaPlayer_alphabet.stop();
                                    mediaPlayer_alphabet.reset();
                                    mediaPlayer_alphabet.release();
                                    mediaPlayer_alphabet=null;

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
                            mediaPlayer_alphabet = MediaPlayer.create(view.getContext(), uri);
                            mediaPlayer_alphabet.start();

                            mediaPlayer_alphabet.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                public void onCompletion(MediaPlayer mp) {
                                    //mediaPlayer_alphabet.stop();
                                    mediaPlayer_alphabet.reset();
                                    mediaPlayer_alphabet.release();
                                    mediaPlayer_alphabet=null;
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
