package com.ashwin.viewpagersandbox.frag1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.ashwin.viewpagersandbox.Constant;
import com.ashwin.viewpagersandbox.R;

public class Frag1Activity extends AppCompatActivity {
    private ViewPager mViewPager;
    private FragAdapter1 mFragAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag1);

        mViewPager = findViewById(R.id.view_pager);
        mFragAdapter = new FragAdapter1(getSupportFragmentManager());
        mViewPager.setAdapter(mFragAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                Log.d(Constant.TAG, "Frag1Activity: onPageSelected: " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
