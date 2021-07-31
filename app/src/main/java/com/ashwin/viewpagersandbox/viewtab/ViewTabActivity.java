package com.ashwin.viewpagersandbox.viewtab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import com.ashwin.viewpagersandbox.R;
import com.ashwin.viewpagersandbox.view.ViewAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class ViewTabActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tab);

        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);

        setUpViewPager();

        new TabLayoutMediator(mTabLayout, mViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 1:
                        tab.setText("TWO");
                        //tab.setIcon(R.drawable.ic_launcher_foreground);
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

    private void setUpViewPager() {
        List<String> list = new ArrayList<>();
        list.add("one view");
        list.add("two view");
        list.add("three view");
        ViewAdapter adapter = new ViewAdapter(list);
        mViewPager.setAdapter(adapter);
    }
}
