package com.ashwin.viewpagersandbox.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.ashwin.viewpagersandbox.R;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {
    private ViewPager2 mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        mViewPager = findViewById(R.id.view_pager);

        setUpViewPager();
    }

    private void setUpViewPager() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        ViewAdapter adapter = new ViewAdapter(list);

        mViewPager.setAdapter(adapter);

        // For vertical swiping
//        mViewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);

        // For fake swipe
//        mViewPager.beginFakeDrag();
//        mViewPager.fakeDragBy(-10f);
//        mViewPager.endFakeDrag();
    }
}
