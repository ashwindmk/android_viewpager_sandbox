package com.ashwin.viewpagersandbox.fragtab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.ashwin.viewpagersandbox.Constant;
import com.ashwin.viewpagersandbox.R;
import com.ashwin.viewpagersandbox.next.NextActivity;
import com.google.android.material.tabs.TabLayout;

// This is deprecated, since ViewPager and FragmentStatePagerAdapter are deprecated
// Use FragTab2Activity with ViewPager2 and FragmentStateAdapter
public class FragTab1Activity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private FragTabAdapter1 mFragTabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_tab1);

        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);

        mFragTabAdapter = new FragTabAdapter1(getSupportFragmentManager());
        mViewPager.setAdapter(mFragTabAdapter);
        //mViewPager.setOffscreenPageLimit(2);

        setUpTabViewPager1();

        Button nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(view -> {
            startActivity(new Intent(FragTab1Activity.this, NextActivity.class));
        });
    }

    private void setUpTabViewPager1() {
        mTabLayout.addTab(mTabLayout.newTab().setText("ONE"));
        mTabLayout.addTab(mTabLayout.newTab().setText("TWO"));
        mTabLayout.addTab(mTabLayout.newTab().setText("THREE"));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Current tab
                Log.d(Constant.TAG, "FragTab1Activity: onTabSelected: " + tab.getPosition());
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Previous tab
                Log.d(Constant.TAG, "FragTab1Activity: onTabUnselected: " + tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.d(Constant.TAG, "FragTab1Activity: onTabReselected: " + tab.getPosition());
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d(Constant.TAG, "FragTab1Activity: onPageScrolled: " + position);
            }

            @Override
            public void onPageSelected(int position) {
                // Current page
                Log.d(Constant.TAG, "FragTab1Activity: onPageSelected: " + position);
                mTabLayout.selectTab(mTabLayout.getTabAt(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d(Constant.TAG, "FragTab1Activity: onPageScrollStateChanged: " + state);
            }
        });
    }
}
