package com.ashwin.viewpagersandbox.frag1;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.ashwin.viewpagersandbox.Constant;
import com.ashwin.viewpagersandbox.OneFragment;
import com.ashwin.viewpagersandbox.ThreeFragment;
import com.ashwin.viewpagersandbox.TwoFragment;

public class FragAdapter1 extends FragmentStatePagerAdapter {
    public FragAdapter1(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // This will be called multiple times for each fragment position, since previous to previous fragment gets destroyed.
        // To prevent fragments from destroying, use mViewPager.setOffscreenPageLimit(num);
        // Might be called even before the user actually selects the page/tab.
        // Multiple fragments might be in onResume state even if not visible to the user.
        Log.d(Constant.TAG, "FragTabAdapter1: getItem( " + position + " )");
        switch (position) {
            case 1:
                return TwoFragment.newInstance();
            case 2:
                return ThreeFragment.newInstance();
        }
        return OneFragment.newInstance();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
