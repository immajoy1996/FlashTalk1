package com.languageapp.immanuel.flashtalk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.languageapp.immanuel.flashtalk.R;


public class RussianIDontUnderstandActivity extends FragmentActivity {

    private static final int NUM_PAGES = 3;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idont_understand);

        mPager = (ViewPager) findViewById(R.id.idontunderstandyou_pager);
        mPagerAdapter = new IDontUnderstandPagerAdapter(getSupportFragmentManager());
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

    private class IDontUnderstandPagerAdapter extends FragmentStatePagerAdapter {
        public IDontUnderstandPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new IDontUnderstandFragment1();
            }
            else if(position==1){
                return new IDontUnderstandFragment3(); //too lazy to write a new file ...
            }
            else{
                return new IDontUnderstandFragment4();
            }

        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
