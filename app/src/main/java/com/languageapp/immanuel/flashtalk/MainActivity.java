package com.languageapp.immanuel.flashtalk;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RecyclerView recyclerView = findViewById(R.id.horizontal_recycler_view);
        //LinearLayoutManager mLayoutManager=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        /*mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);*/
        //recyclerView.setLayoutManager(mLayoutManager);

        final Animation anim_wobble = AnimationUtils.loadAnimation(this, R.anim.wobble);
        final Animation anim_wobble_test = AnimationUtils.loadAnimation(this, R.anim.scale_test);

        CircularImageViewTest settings=findViewById(R.id.settings);
        settings.startAnimation(anim_wobble);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),RussianSoundEffectsActivity.class));
            }
        });

        final TextView myTextView1 = findViewById(R.id.russian_text);
        final TextView myTextView2 = findViewById(R.id.arabic_text);
        final TextView myTextView3 = findViewById(R.id.turkish_text);
        final TextView myTextView4 = findViewById(R.id.persian_text);

        final CircularImageViewTest CircularImageView1=findViewById(R.id.russian_button);
        final CircularImageViewTest CircularImageView2=findViewById(R.id.arabic_button);
        final CircularImageViewTest CircularImageView3=findViewById(R.id.turkish_button);
        final CircularImageViewTest CircularImageView4=findViewById(R.id.persian_button);

        CircularImageView1.startAnimation(anim_wobble_test);
        CircularImageView2.startAnimation(anim_wobble_test);
        CircularImageView3.startAnimation(anim_wobble_test);
        CircularImageView4.startAnimation(anim_wobble_test);

            /*ViewGroup.LayoutParams params=(ViewGroup.LayoutParams)CircularImageView1.getLayoutParams();

            params.height=itemView.getContext().getResources().getDimensionPixelSize(R.dimen.circular_image_dim);
            params.width=itemView.getContext().getResources().getDimensionPixelSize(R.dimen.circular_image_dim);
            CircularImageView1.setLayoutParams(params);
            CircularImageView2.setLayoutParams(params);
            CircularImageView3.setLayoutParams(params);*/


        final Animation anim_scale = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
        //final Animation anim_test = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.scale_test);

        final Uri uri_swoosh=Uri.parse("android.resource://"+this.getPackageName()+"/raw/swoosh");

        CircularImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name1=myTextView1.getText().toString();
                view.startAnimation(anim_scale);
                CircularImageView1.setClickable(false);
                CircularImageView2.setClickable(false);
                CircularImageView3.setClickable(false);
                CircularImageView4.setClickable(false);
                doit(view,uri_swoosh);
                myTextView1.startAnimation(anim_scale);
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        //CircularImageView1.setClickable(true);
                        //CircularImageView2.setClickable(true);
                        //CircularImageView3.setClickable(true);
                        doit(name1);

                    }
                },500);
                CircularImageView1.setClickable(true);
                CircularImageView2.setClickable(true);
                CircularImageView3.setClickable(true);
                CircularImageView4.setClickable(true);

            }
        });

        CircularImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name2=myTextView2.getText().toString();
                view.startAnimation(anim_scale);
                CircularImageView1.setClickable(false);
                CircularImageView2.setClickable(false);
                CircularImageView3.setClickable(false);
                CircularImageView4.setClickable(false);
                doit(view,uri_swoosh);
                myTextView2.startAnimation(anim_scale);
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        //CircularImageView1.setClickable(true);
                        //CircularImageView2.setClickable(true);
                        //CircularImageView3.setClickable(true);
                        doit(name2);
                    }
                },500);
                CircularImageView1.setClickable(true);
                CircularImageView2.setClickable(true);
                CircularImageView3.setClickable(true);
                CircularImageView4.setClickable(true);
            }
        });

        CircularImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name3=myTextView3.getText().toString();
                doit(name3);
            }
        });

        CircularImageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name4=myTextView4.getText().toString();
                doit(name4);
            }
        });


        /*ArrayList<String> lang1=new ArrayList<String>();
        for(int i=0;i<1;i++){
            lang1.add("");
        }
        ArrayList<String>lang2=new ArrayList<String>();
        ArrayList<String>lang3=new ArrayList<String>();

        lang1.set(0,"Russian");
        lang2.add("Arabic");
        lang3.add("Turkish");
        //lang1.set(1,"French");
        //lang2.add("German");
        //lang3.add("Portugese");

        ArrayList<Drawable> flags1=new ArrayList<Drawable>();
        ArrayList<Drawable> flags2=new ArrayList<Drawable>();
        ArrayList<Drawable> flags3=new ArrayList<Drawable>();

        flags1.add(getResources().getDrawable(R.drawable.russia_flag_tiny));
        flags2.add(getResources().getDrawable(R.drawable.lebanese_flag2));
        flags3.add(getResources().getDrawable(R.drawable.turkish_flag_tiny));
        //flags1.add(getResources().getDrawable(R.drawable.frenchflag));
        //flags2.add(getResources().getDrawable(R.drawable.germanflag));
        //flags3.add(getResources().getDrawable(R.drawable.portugalflag));

        //int x=this.getResources().getInteger(R.integer.circular_image_view_width);

        //Toast.makeText(this,""+R.integer.circular_image_view_width,Toast.LENGTH_LONG).show();


        RecyclerViewHorizontalAdapter adapter = new RecyclerViewHorizontalAdapter(this, lang1,lang2,lang3,flags1,flags2,flags3);
        recyclerView.setAdapter(adapter);*/

        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        float dpHeight = displayMetrics.heightPixels / displayMetrics.density;
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;

        //Toast.makeText(this, "Hello",Toast.LENGTH_LONG).show();

        Toast.makeText(this," "+dpWidth, Toast.LENGTH_LONG).show();

        /*CircularImageView cimageView1=(CircularImageView)findViewById(R.id.russia_button);
        cimageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),RussianSplash.class);
                startActivity(intent);
            }
        });

        CircularImageView cimageView2=(CircularImageView)findViewById(R.id.portugal_button);
        CircularImageView cimageView3=(CircularImageView)findViewById(R.id.german_button);

        //Picasso.with(this).load(R.drawable.portugalflag).into(cimageView2);
        //Picasso.with(this).load(R.drawable.germanflag).into(cimageView3);

        /*ImageView imgView1 = (ImageView)findViewById(R.id.imageView1);
        imgView1.setScaleType(ImageView.ScaleType.CENTER_CROP);

        ImageView imgView2 = (ImageView)findViewById(R.id.imageView2);
        imgView2.setScaleType(ImageView.ScaleType.CENTER_CROP);

        ImageView imgView3 = (ImageView)findViewById(R.id.imageView3);
        imgView3.setScaleType(ImageView.ScaleType.CENTER_CROP);

        ImageView imgView4 = (ImageView)findViewById(R.id.imageView4);
        imgView4.setScaleType(ImageView.ScaleType.CENTER_CROP);

        ImageView imgView5 = (ImageView)findViewById(R.id.imageView5);
        imgView5.setScaleType(ImageView.ScaleType.CENTER_CROP);

        ImageView imgView6 = (ImageView)findViewById(R.id.imageView6);
        imgView6.setScaleType(ImageView.ScaleType.CENTER_CROP);*/

    }

    @Override
    public void onBackPressed() {

    }

    void doit(String langstr){
        switch (langstr){
            case "Russian":
                this.startActivity(new Intent(getApplicationContext(),RussianSplash.class));
                return;

            case "Arabic":
                this.startActivity(new Intent(getApplicationContext(),ArabicSplashActivity.class));
                return;

            default:
                Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
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
