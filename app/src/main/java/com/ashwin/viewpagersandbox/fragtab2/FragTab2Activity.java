package com.ashwin.viewpagersandbox.fragtab2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.ashwin.viewpagersandbox.Constant;
import com.ashwin.viewpagersandbox.R;
import com.ashwin.viewpagersandbox.next.NextActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class FragTab2Activity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager;
    private FragTabAdapter2 mFragTabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_tab2);

        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);

        mFragTabAdapter = new FragTabAdapter2(getSupportFragmentManager(), this.getLifecycle());
        mViewPager.setAdapter(mFragTabAdapter);

        setUpTabViewPager2();

        Button nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(view -> {
            startActivity(new Intent(FragTab2Activity.this, NextActivity.class));
        });
    }

    // Recommended
    private void setUpTabViewPager2() {
        new TabLayoutMediator(mTabLayout, mViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 1:
                        tab.setText("TWO");
                        break;
                    case 2:
                        tab.setText("THREE");
                        break;
                    default:
                        tab.setText("ONE");
                        break;
                }
            }
        }).attach();
    }

    // Not recommended
    private void setUpTabViewPager1() {
        mTabLayout.addTab(mTabLayout.newTab().setText("ONE"));
        mTabLayout.addTab(mTabLayout.newTab().setText("TWO"));
        mTabLayout.addTab(mTabLayout.newTab().setText("THREE"));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Current tab
                Log.d(Constant.TAG, "FragTabActivity: onTabSelected: " + tab.getPosition());
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Previous tab
                Log.d(Constant.TAG, "FragTabActivity: onTabUnselected: " + tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.d(Constant.TAG, "FragTabActivity: onTabReselected: " + tab.getPosition());
            }
        });

        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                Log.d(Constant.TAG, "FragTabActivity: onPageScrolled: " + position);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                // Current page
                Log.d(Constant.TAG, "FragTabActivity: onPageSelected: " + position);
                mTabLayout.selectTab(mTabLayout.getTabAt(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                Log.d(Constant.TAG, "FragTabActivity: onPageScrollStateChanged: " + state);
            }
        });
    }
}
