package com.languageapp.immanuel.flashtalk;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Immanuel on 2/8/19.
 */


public class RecyclerViewAdapterArabicLang extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> categories;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_VOCAB = 2;
    private static final int TYPE_DIALOG = 3;

    MediaPlayer mediaPlayer;

    // data is passed into the constructor
    RecyclerViewAdapterArabicLang(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.categories = data;

    }

    // inflates the row layout from xml when needed
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView;
        if(viewType==TYPE_HEADER){
            layoutView = mInflater.inflate(R.layout.recycler_view_arabic_header_layout, parent, false);
            return new ArabicHeaderViewHolder(layoutView);
        }
        else if(viewType==TYPE_ITEM){
            layoutView = mInflater.inflate(R.layout.recycler_view_arabic_layout, parent, false);
            return new ArabicItemViewHolder(layoutView);
        }
        else if(viewType==TYPE_VOCAB){
            layoutView = mInflater.inflate(R.layout.recycler_view_vocab_layout, parent, false);
            return new ArabicVocabViewHolder(layoutView);
        }
        else{ //TYPE_DIALOG
            layoutView=mInflater.inflate(R.layout.recycler_view_dialog_language_activity_layout,parent,false);
            return new ArabicDialogViewHolder(layoutView);
        }
        //TextView textView=view.findViewById(R.id.recycler_view_text_view);
        /*String str=textView.getText().toString();
        if(str.equals("Verbs")){
            textView.setTextSize(30);
        }*/
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final String subject = categories.get(position);
        if(holder instanceof ArabicHeaderViewHolder){

            SpannableString spannableString = new SpannableString(subject);
            //spannableString.setSpan(new UnderlineSpan(),0,subject.length(),0);
            //spannableString.setSpan(new UnderlineSpan(), 0, subject.length(), 0);
            ((ArabicHeaderViewHolder)holder).header_textview.setText(spannableString);
            ((ArabicHeaderViewHolder)holder).header_textview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //final Uri uri_click=Uri.parse("android.resource://"+view.getContext().getPackageName()+"/raw/click_sound");
                    //doit(view,uri_click);

                    int pos=holder.getAdapterPosition();
                    switch (subject){
                        case "~ Part One ~":
                            if(categories.get(pos+1).equals("~ Part Two ~")==false) {
                                int count = 0;
                                while (categories.get(pos + 1).equals("~ Part Two ~") == false) {
                                    //holder.myTextView.setTextColor(view.getResources().getColor(R.color.black));
                                    categories.remove(pos + 1);
                                    count++;
                                    //categories.remove(pos+1);
                                    //categories.remove(pos+1);
                                }
                                notifyItemRangeRemoved(pos+1, count);
                            }
                            else{
                                categories.add(pos+1,"Overview");
                                categories.add(pos+2,"~ Alphabet ~");
                                categories.add(pos+3,"~ Essentials 1 ~");

                                notifyItemRangeInserted(pos+1, 3);
                            }
                            return;

                        case "~ Part Two ~":
                            return;

                        case "~ Extras ~":
                            return;

                    }


                }
            });

        }
        else if(holder instanceof ArabicItemViewHolder){
            ((ArabicItemViewHolder)holder).myTextView.setText(subject);
            ((ArabicItemViewHolder)holder).llayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //((ItemViewHolder)holder).myTextView.setBackgroundColor(view.getResources().getColor(R.color.white_smoke));
                    //final Uri uri_click=Uri.parse("android.resource://"+view.getContext().getPackageName()+"/raw/click_sound");
                    //doit(view,uri_click);
                    int pos=holder.getAdapterPosition();

                    //Toast.makeText(view.getContext(),str+" "+subject, Toast.LENGTH_LONG).show();
                    switch (subject) {
                        case "Overview":
                            view.getContext().startActivity(new Intent(view.getContext(), ArabicDiglossiaActivity.class));
                            return;
                        case "~ Alphabet ~":
                            if (categories.get(pos+1).equals("Basics")) {
                                //holder.myTextView.setTextColor(view.getResources().getColor(R.color.black));
                                categories.remove(pos+1);
                                categories.remove(pos+1);
                                //categories.remove(pos+1);
                                notifyItemRangeRemoved(pos+1, 2);
                            } else {
                                //holder.myTextView.setBackgroundResource(R.drawable.rect);
                                //txtView.setBackgroundResource(R.drawable.rect);
                                //holder.myTextView.setTextColor(view.getResources().getColor(R.color.sea_green));
                                categories.add(pos+1, "Basics");
                                categories.add(pos+2, "The Letters");
                                notifyItemRangeInserted(pos+1,2);
                            /*for(int i=0;i<categories.size();i++){
                                Toast.makeText(view.getContext(),categories.get(i),Toast.LENGTH_SHORT).show();
                            }*/
                            }
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5),Toast.LENGTH_SHORT).show();
                            return;

                        case "Basics":
                            view.getContext().startActivity(new Intent(view.getContext(), ArabicPreliminaryActivity.class));
                            return;

                        case "The Letters":
                            view.getContext().startActivity(new Intent(view.getContext(), ArabicAlphabetActivity.class));
                            return;
                        case "~ Essentials 1 ~":
                            if (categories.get(pos+1).equals("I, You")) {
                                //holder.myTextView.setTextColor(view.getResources().getColor(R.color.black));
                                categories.remove(pos+1);
                                categories.remove(pos+1);
                                categories.remove(pos+1);
                                //categories.remove(pos+1);
                                notifyItemRangeRemoved(pos+1, 3);
                            } else {
                                //holder.myTextView.setBackgroundResource(R.drawable.rect);
                                //txtView.setBackgroundResource(R.drawable.rect);
                                //holder.myTextView.setTextColor(view.getResources().getColor(R.color.sea_green));
                                categories.add(pos+1, "I, You");
                                categories.add(pos+2, "How Are You?");
                                categories.add(pos+3, "Basic Verbs");
                                notifyItemRangeInserted(pos+1,3);
                            /*for(int i=0;i<categories.size();i++){
                                Toast.makeText(view.getContext(),categories.get(i),Toast.LENGTH_SHORT).show();
                            }*/
                            }
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5),Toast.LENGTH_SHORT).show();
                            return;

                        case "I, You":
                            view.getContext().startActivity(new Intent(view.getContext(), ArabicBasicPronounsActivity.class));
                            return;


                    }

                /*if(subject.equals("Essentials")){
                    holder.llayout.setBackgroundColor(view.getResources().getColor(R.color.yellow));
                }*/
                }
            });
        }
        else if(holder instanceof VocabViewHolder){
            ((VocabViewHolder)holder).vocab_textview.setText(subject);
            ((VocabViewHolder)holder).vocab_llayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (subject){
                        case "Vocab 1 - People":
                            Intent intent1=new Intent(view.getContext(),RussianVocabSplash.class);
                            intent1.putExtra("PAGE_POSITION",0);
                            intent1.putExtra("VOCAB_TITLE","Vocab 1 - People");
                            intent1.putExtra("IMAGE_SRC","people");
                            view.getContext().startActivity(intent1);
                            return;
                        case "Vocab 2 - General":
                            Intent intent2=new Intent(view.getContext(),RussianVocabSplash.class);
                            intent2.putExtra("PAGE_POSITION",1);
                            intent2.putExtra("VOCAB_TITLE","Vocab 2 - General");
                            intent2.putExtra("IMAGE_SRC","car1");
                            view.getContext().startActivity(intent2);
                            return;
                        case "Vocab 3 - Places":
                            Intent intent3=new Intent(view.getContext(),RussianVocabSplash.class);
                            intent3.putExtra("PAGE_POSITION",2);
                            intent3.putExtra("VOCAB_TITLE","Vocab 3 - Places");
                            intent3.putExtra("IMAGE_SRC","park");
                            view.getContext().startActivity(intent3);
                            return;
                        case "Vocab 4 - Food/Beverages":
                            Intent intent4=new Intent(view.getContext(),RussianVocabSplash.class);
                            intent4.putExtra("PAGE_POSITION",3);
                            intent4.putExtra("VOCAB_TITLE","Vocab 4 - Food/Beverages");
                            intent4.putExtra("IMAGE_SRC","ice_cream1");
                            view.getContext().startActivity(intent4);
                            return;
                        case "Vocab 5 - Numbers":
                            Intent intent5=new Intent(view.getContext(),RussianVocabSplash.class);
                            intent5.putExtra("PAGE_POSITION",4);
                            intent5.putExtra("VOCAB_TITLE","Vocab 5 - Numbers");
                            intent5.putExtra("IMAGE_SRC","snake1");
                            view.getContext().startActivity(intent5);
                            return;
                    }
                }
            });
        }
        else {
            ((ArabicDialogViewHolder)holder).dialog_textview.setText(subject);
            ((ArabicDialogViewHolder)holder).dialog_llayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Uri uri_click=Uri.parse("android.resource://"+view.getContext().getPackageName()+"/raw/click_sound");
                    doit(view,uri_click);
                    switch (subject){
                        case "Dialogue 1 - A Testy Exchange":
                            Intent intent1=new Intent(view.getContext(),RussianDialogueSplashActivity.class);
                            intent1.putExtra("DIALOG_TITLE",subject);
                            intent1.putExtra("IMAGE_SRC","bad_grade2");
                            view.getContext().startActivity(intent1);
                            return;
                        case "Dialogue 2 - A Naive Tourist":
                            Intent intent2=new Intent(view.getContext(),RussianDialogueSplashActivity.class);
                            intent2.putExtra("DIALOG_TITLE",subject);
                            intent2.putExtra("IMAGE_SRC","pyramid2");
                            view.getContext().startActivity(intent2);
                            return;
                        case "Dialogue 3 - The United Nations":
                            Intent intent6=new Intent(view.getContext(),RussianDialogueSplashActivity.class);
                            intent6.putExtra("DIALOG_TITLE",subject);
                            intent6.putExtra("IMAGE_SRC","snake1");
                            view.getContext().startActivity(intent6);
                            return;
                        case "Dialogue 4 - A Charming Accent":
                            Intent intent3=new Intent(view.getContext(),RussianDialogueSplashActivity.class);
                            intent3.putExtra("DIALOG_TITLE",subject);
                            intent3.putExtra("IMAGE_SRC","charming1");
                            view.getContext().startActivity(intent3);
                            return;
                        case "Dialogue 5 - A Rebel":
                            Intent intent4=new Intent(view.getContext(),RussianDialogueSplashActivity.class);
                            intent4.putExtra("DIALOG_TITLE",subject);
                            intent4.putExtra("IMAGE_SRC","weight1");
                            view.getContext().startActivity(intent4);
                            return;
                        case "Dialogue 6 - An Impatient Waitress":
                            Intent intent5=new Intent(view.getContext(),RussianDialogueSplashActivity.class);
                            intent5.putExtra("DIALOG_TITLE",subject);
                            intent5.putExtra("IMAGE_SRC","coffee1");
                            view.getContext().startActivity(intent5);
                            return;
                        case "Dialogue 9 - A Very Boring Man":
                            Intent intent8=new Intent(view.getContext(),RussianDialogueSplashActivity.class);
                            intent8.putExtra("DIALOG_TITLE",subject);
                            intent8.putExtra("IMAGE_SRC","lazy1");
                            view.getContext().startActivity(intent8);
                            return;
                    }
                }
            });
        }
        //int pos=holder.getAdapterPosition();
        //holder.myTextView.setText(subject);
        /*if(subject.equals("Vocab 1 - People")){
            holder.myTextView.setTextColor(holder.myTextView.getResources().getColor(R.color.red));
        }
        if(subject.equals("Vocab 2 - Things")){
            holder.myTextView.setTextColor(holder.myTextView.getResources().getColor(R.color.red));
        }*/

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return categories.size();
    }


    // stores and recycles views as they are scrolled off screen
    /*public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        LinearLayout llayout;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.recycler_view_text_view);
            llayout=itemView.findViewById(R.id.recycler_view_categories_layout);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }*/

    // convenience method for getting data at click position
    String getItem(int id) {
        return categories.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    @Override
    public int getItemViewType(int position) {
        String str=categories.get(position);
        if (str.equals("~ Part One ~") || str.equals("~ Part Two ~") || str.equals("~ Extras ~")) {
            return TYPE_HEADER;
        }
        else if(str.equals("Vocab 1 - People") || str.equals("Vocab 2 - General") || str.equals("Vocab 3 - Places") || str.equals("Vocab 4 - Food/Beverages") || str.equals("Vocab 5 - Numbers") || str.equals("Vocab 6 - Time")){
            return TYPE_VOCAB;
        }
        else if(str.equals("Dialogue 1 - A Testy Exchange") || str.equals("Dialogue 2 - A Naive Tourist") || str.equals("Dialogue 3 - The United Nations") || str.equals("Dialogue 4 - A Charming Accent") || str.equals("Dialogue 5 - A Rebel") || str.equals("Dialogue 6 - An Impatient Waitress") || str.equals("Dialogue 7 - Stereotypes") || str.equals("Dialogue 8 - An Ordinary Conversation") || str.equals("Dialogue 8 - A Very Boring Man")){
            return TYPE_DIALOG;
        }
        return TYPE_ITEM;

    }

    void endit(){
        if(mediaPlayer!=null) {
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer=null;
            //Uri uri=Uri.parse("android.resource://"+getContext().getPackageName()+"/raw/wrong_answer");
            //adapter.mediaPlayer_alphabet= MediaPlayer.create(getContext(),uri);
        }
    }

    void doit(View view, Uri uri){
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(view.getContext(), uri);
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    //mediaPlayer_alphabet.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer=null;
                    //mediaPlayer_alphabet = MediaPlayer.create(vw.getContext(), uri);
                };
            });
            //mediaPlayer_alphabet.release();
        } else if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = MediaPlayer.create(view.getContext(), uri);
            mediaPlayer.start();


            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    //mediaPlayer_alphabet.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer=null;

                };
            });
        }
        else {
            mediaPlayer = MediaPlayer.create(view.getContext(), uri);
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    //mediaPlayer_alphabet.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer=null;
                };
            });

        }
    }
    /*private boolean isPositionHeader(int position) {
        String str=categories.get(position);
        return (str.equals("Beginner") || str.equals("Functional"));
    }*/
}

class ArabicHeaderViewHolder extends RecyclerView.ViewHolder {
    TextView header_textview;

    public ArabicHeaderViewHolder(View itemView) {
        super(itemView);
        header_textview = itemView.findViewById(R.id.header_text_view);

    }
}

class ArabicItemViewHolder extends RecyclerView.ViewHolder {
    TextView myTextView;
    LinearLayout llayout;

    public ArabicItemViewHolder(View itemView) {
        super(itemView);
        myTextView = itemView.findViewById(R.id.recycler_view_text_view);
        llayout=itemView.findViewById(R.id.recycler_view_arabic_layout);
    }
}

class ArabicVocabViewHolder extends RecyclerView.ViewHolder {
    TextView vocab_textview;
    LinearLayout vocab_llayout;

    public ArabicVocabViewHolder(View itemView) {
        super(itemView);
        vocab_textview = itemView.findViewById(R.id.vocab_text_view);
        vocab_llayout = itemView.findViewById(R.id.recycler_view_vocab_layout);
    }
}

class ArabicDialogViewHolder extends RecyclerView.ViewHolder {
    TextView dialog_textview;
    LinearLayout dialog_llayout;

    public ArabicDialogViewHolder(View itemView) {
        super(itemView);
        dialog_textview = itemView.findViewById(R.id.dialog_lang_text_view);
        dialog_llayout = itemView.findViewById(R.id.recycler_view_dialog_language_layout);
    }
}

