package com.ashwin.viewpagersandbox.frag2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;

import com.ashwin.viewpagersandbox.Constant;
import com.ashwin.viewpagersandbox.R;

public class Frag2Activity extends AppCompatActivity {
    private ViewPager2 mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag2);

        mViewPager = findViewById(R.id.view_pager);

        setUpViewPagerAdapter();

        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Log.d(Constant.TAG, "FragActivity: onPageSelected: " + position);
            }
        });
    }

    private void setUpViewPagerAdapter() {
        FragAdapter2 adapter = new FragAdapter2(getSupportFragmentManager(), getLifecycle());
        mViewPager.setAdapter(adapter);
    }
}
