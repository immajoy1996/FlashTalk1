package com.languageapp.immanuel.flashtalk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.languageapp.immanuel.flashtalk.R;


public class RussianTheBestActivity extends FragmentActivity {

    private static final int NUM_PAGES = 2;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_the_best);

        mPager = (ViewPager) findViewById(R.id.thebest_pager);
        mPagerAdapter = new TheBestPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

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

    private class TheBestPagerAdapter extends FragmentStatePagerAdapter {
        public TheBestPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new RussianTheBestFragment1();
            }
            else {
                return new RussianTheBestFragment2();
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
