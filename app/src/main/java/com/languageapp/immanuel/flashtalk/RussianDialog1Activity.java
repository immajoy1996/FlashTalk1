package com.languageapp.immanuel.flashtalk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class RussianDialog1Activity extends FragmentActivity {

    private static final int NUM_PAGES = 2;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_dialog1);

        mPager = (ViewPager) findViewById(R.id.dialog1_pager);
        mPagerAdapter = new RussianDialog1PagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);


    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    private class RussianDialog1PagerAdapter extends FragmentStatePagerAdapter {
        public RussianDialog1PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new RussianDialog1Fragment1();
            }
            else {
                return new RussianDialog1Fragment2();
            }

        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

    }

    /*public String getCallingPage(){
        Intent intent=getIntent();
        String calling_page=intent.getStringExtra("FROM_PAGE");
        return calling_page;
    }*/
}
