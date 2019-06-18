package com.languageapp.immanuel.flashtalk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.languageapp.immanuel.flashtalk.R;


public class RussianMyFriendsHouseActivity extends FragmentActivity {

    private static final int NUM_PAGES = 3;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_my_friends_house);

        mPager = (ViewPager) findViewById(R.id.myfriendshouse_pager);
        mPagerAdapter = new RussianMyFriendsHousePagerAdapter(getSupportFragmentManager());
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

    private class RussianMyFriendsHousePagerAdapter extends FragmentStatePagerAdapter {
        public RussianMyFriendsHousePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new RussianMyFriendsHouseFragment1();
            }
            else if (position==1){
                return new RussianMyFriendsHouseFragment2();
            }
            else{
                return new RussianMyFriendsHouseFragment3();
            }

        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
