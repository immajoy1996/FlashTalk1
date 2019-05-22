package com.example.immanuel.flashtalk;

/**
 * Created by Immanuel on 2/8/19.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Immanuel on 2/8/19.
 */


public class RecyclerViewHorizontalAdapter extends RecyclerView.Adapter<RecyclerViewHorizontalAdapter.ViewHolder> {

    private final int TOTAL_PAGES=1;
    private List<String> lang1;
    private List<String> lang2;
    private List<String> lang3;
    private List<Drawable> flags1;
    private List<Drawable> flags2;
    private List<Drawable> flags3;
    private LayoutInflater mInflater;
    private Context cont;
    private ItemClickListener mClickListener;

    MediaPlayer mediaPlayer;

    // data is passed into the constructor
    RecyclerViewHorizontalAdapter(Context context, List<String> data1,List<String> data2,List<String> data3,List<Drawable> data4,List<Drawable> data5,List<Drawable> data6) {
        this.mInflater = LayoutInflater.from(context);
        this.lang1= data1;
        this.lang2= data2;
        this.lang3= data3;
        this.flags1=data4;
        this.flags2=data5;
        this.flags3=data6;
        this.cont=context;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycler_view_horizontal_rowview, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        position=position%TOTAL_PAGES;
        String l1 = lang1.get(position);
        String l2 = lang2.get(position);
        String l3 = lang3.get(position);
        Drawable d1=(Drawable)flags1.get(position);
        Drawable d2=(Drawable)flags2.get(position);
        Drawable d3=(Drawable)flags3.get(position);
        holder.myTextView1.setText(l1);
        holder.myTextView2.setText(l2);
        holder.myTextView3.setText(l3);
        holder.CircularImageView1.setImageDrawable(d1);
        holder.CircularImageView2.setImageDrawable(d2);
        holder.CircularImageView3.setImageDrawable(d3);
        /*Picasso.with(holder.myTextView1.getContext()).load(R.drawable.frenchflag).into(holder.CircularImageView1);
        Picasso.with(holder.myTextView1.getContext()).load(R.drawable.frenchflag).into(holder.CircularImageView2);
        Picasso.with(holder.myTextView1.getContext()).load(R.drawable.frenchflag).into(holder.CircularImageView3);*/

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return lang1.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView1;
        TextView myTextView2;
        TextView myTextView3;
        CircularImageViewTest2 CircularImageView1;
        CircularImageViewTest2 CircularImageView2;
        CircularImageViewTest2 CircularImageView3;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView1 = itemView.findViewById(R.id.language_name1);
            myTextView2 = itemView.findViewById(R.id.language_name2);
            myTextView3 = itemView.findViewById(R.id.language_name3);
            CircularImageView1=itemView.findViewById(R.id.circular_image_view1);
            CircularImageView2=itemView.findViewById(R.id.circular_image_view2);
            CircularImageView3=itemView.findViewById(R.id.circular_image_view3);

            final Animation anim_wobble = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.wobble);
            anim_wobble.setRepeatCount(Animation.INFINITE);

            CircularImageView1.startAnimation(anim_wobble);
            CircularImageView2.startAnimation(anim_wobble);
            CircularImageView3.startAnimation(anim_wobble);

            /*ViewGroup.LayoutParams params=(ViewGroup.LayoutParams)CircularImageView1.getLayoutParams();

            params.height=itemView.getContext().getResources().getDimensionPixelSize(R.dimen.circular_image_dim);
            params.width=itemView.getContext().getResources().getDimensionPixelSize(R.dimen.circular_image_dim);
            CircularImageView1.setLayoutParams(params);
            CircularImageView2.setLayoutParams(params);
            CircularImageView3.setLayoutParams(params);*/


            final Animation anim = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.scale);
            //final Animation anim_test = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.scale_test);

            final Uri uri_swoosh=Uri.parse("android.resource://"+itemView.getContext().getPackageName()+"/raw/swoosh");

            CircularImageView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final String name1=myTextView1.getText().toString();
                    view.startAnimation(anim);
                    //CircularImageView1.setClickable(false);
                    //CircularImageView2.setClickable(false);
                    //CircularImageView3.setClickable(false);
                    doit(view,uri_swoosh);
                    myTextView1.startAnimation(anim);
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                             //CircularImageView1.setClickable(true);
                            //CircularImageView2.setClickable(true);
                            //CircularImageView3.setClickable(true);
                            doit(name1);
                        }
                    },500);

                }
            });
            CircularImageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name2=myTextView2.getText().toString();
                    doit(name2);
                }
            });
            CircularImageView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name3=myTextView3.getText().toString();
                    doit(name3);
                }
            });

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return lang1.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    void doit(String langstr){
        switch (langstr){
            case "Russian":
                cont.startActivity(new Intent(cont,RussianSplash.class));
                return;

                default:
                    Toast.makeText(cont,"Coming Soon",Toast.LENGTH_SHORT).show();
                    return;

        }
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
}
