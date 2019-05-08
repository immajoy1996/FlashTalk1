package com.example.immanuel.flashtalk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class RussianCleanupActivity extends FragmentActivity {

    private static final int NUM_PAGES = 4;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_cleanup);

        mPager = (ViewPager) findViewById(R.id.cleanup_pager);
        mPagerAdapter = new CleanupPagerAdapter(getSupportFragmentManager());
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

    private class CleanupPagerAdapter extends FragmentStatePagerAdapter {
        public CleanupPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new RussianCleanupFragment1();
            }
            else if(position==1) {
                return new RussianCleanupFragment2();
            }
            else if(position==2){
                return new RussianCleanupFragment3();
            }
            else {
                return new RussianCleanupFragment4();
            }

        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
