package com.languageapp.immanuel.flashtalk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class ArabicBasicPronounsActivity extends FragmentActivity {

    private static final int NUM_PAGES = 3;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private int mPrevPage=-1;

    //MediaPlayer mediaPlayer;
    //int STEP_TIME=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arabic_basic_pronouns);

        mPager = findViewById(R.id.basic_pronouns_pager);
        mPagerAdapter = new BasicPronounsPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (mPrevPage){
                    case -1:
                        return;
                    case 0:
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //final Uri uri=Uri.parse("android.resource://"+this.getPackageName()+"/raw/test");
        //mediaPlayer=MediaPlayer.create(getApplicationContext(),uri);


    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    private class BasicPronounsPagerAdapter extends FragmentStatePagerAdapter {
        public BasicPronounsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position==0) {
                return new ArabicBasicPronounsFragment1();
            }
            else if(position==1){
                return new ArabicBasicPronounsFragment2();
            }
            else {
                return new ArabicBasicPronounsFragment3();
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    public void setActionBarTitle(String title) {
        getActionBar().setTitle(title);
    }
}
