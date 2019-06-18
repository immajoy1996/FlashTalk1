package com.languageapp.immanuel.flashtalk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.languageapp.immanuel.flashtalk.R;

public class RussianPluralPronounsActivity extends FragmentActivity {

    private static final int NUM_PAGES = 3;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_plural_pronouns);

        mPager = (ViewPager) findViewById(R.id.plural_pronouns_pager);
        mPagerAdapter = new PluralPronounsPagerAdapter(getSupportFragmentManager());
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

    private class PluralPronounsPagerAdapter extends FragmentStatePagerAdapter {
        public PluralPronounsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position==0) {
                return new RussianPluralPronounsFragment1();
            }
            else if(position==1){
                return new RussianPluralPronounsFragment2();
            }
            else {
                return new RussianPluralPronounsFragment3();
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
