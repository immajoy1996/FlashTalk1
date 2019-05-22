package com.example.immanuel.flashtalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;


public class RussianVocabActivity extends FragmentActivity {

    private static final int NUM_PAGES = 6;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_vocab);

        mPager = (ViewPager) findViewById(R.id.vocab_view_pager);

        Intent intent=getIntent();
        int page=intent.getIntExtra("PAGE_POSITION",0);
        //Toast.makeText(this,"Hello "+page,Toast.LENGTH_SHORT).show();

        mPagerAdapter = new RussianVocabPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setCurrentItem(page);




        /*DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        float dpHeight = displayMetrics.heightPixels / displayMetrics.density;
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        Toast.makeText(this,""+dpWidth,Toast.LENGTH_SHORT);*/

        //CustomAdapterAlphabet caa=new CustomAdapterAlphabet(this,letterArray,transliterationArray);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    private class RussianVocabPagerAdapter extends FragmentStatePagerAdapter {
        public RussianVocabPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new RussianVocabFragment1();
            }
            else if(position==1){
                return new RussianVocabFragment2();
            }
            else if(position==2){
                return new RussianVocabFragment3();
            }
            else if(position==3){
                return new RussianVocabFragment4();
            }
            else if(position==4){
                return new RussianVocabFragment5();
            }
            else{
                return new RussianVocabFragment6();
            }

        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
