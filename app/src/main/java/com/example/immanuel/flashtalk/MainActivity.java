package com.example.immanuel.flashtalk;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_horizontal);

        RecyclerView recyclerView = findViewById(R.id.horizontal_recycler_view);
        LinearLayoutManager mLayoutManager=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        /*mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);*/
        recyclerView.setLayoutManager(mLayoutManager);

        ArrayList<String> lang1=new ArrayList<String>();
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
        recyclerView.setAdapter(adapter);

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
}
