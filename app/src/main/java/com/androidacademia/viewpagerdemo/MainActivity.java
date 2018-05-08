package com.androidacademia.viewpagerdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private String[] quoteList;
    private PagerAdapter mPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.pager);
        quoteList = getResources().getStringArray(R.array.quoteList);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);

    }

    private class ScreenSlidePagerAdapter extends FragmentPagerAdapter{

        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            QuoteFragment quoteFragment = new QuoteFragment();
            Bundle bundle = new Bundle();
            bundle.putString("quote",quoteList[position]);
            quoteFragment.setArguments(bundle);
            return quoteFragment;
        }

        @Override
        public int getCount() {
            return quoteList.length;
        }
    }
}
