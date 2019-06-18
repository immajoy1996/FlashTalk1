package com.languageapp.immanuel.flashtalk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class RussianDialog11Activity extends FragmentActivity {

    private static final int NUM_PAGES = 1;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_dialog11);

        mPager = (ViewPager) findViewById(R.id.dialog11_pager);
        mPagerAdapter = new RussianDialog11PagerAdapter(getSupportFragmentManager());
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

    private class RussianDialog11PagerAdapter extends FragmentStatePagerAdapter {
        public RussianDialog11PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new RussianDialog11Fragment1();
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
