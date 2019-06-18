package com.languageapp.immanuel.flashtalk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.languageapp.immanuel.flashtalk.R;

public class RussianBasicVerbsActivity extends FragmentActivity {

    private static final int NUM_PAGES = 4;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_basic_verbs);

        mPager = (ViewPager) findViewById(R.id.basic_verbs_pager);
        mPagerAdapter = new BasicVerbsPagerAdapter(getSupportFragmentManager());
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

    private class BasicVerbsPagerAdapter extends FragmentStatePagerAdapter {
        public BasicVerbsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new RussianBasicVerbsFragment1();
            }
            else if(position==1) {
                return new RussianBasicVerbsFragment2();
            }
            else if(position==2){
                return new RussianBasicVerbsFragment3();
            }
            else {
                return new RussianBasicVerbsFragment4();
            }

        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
