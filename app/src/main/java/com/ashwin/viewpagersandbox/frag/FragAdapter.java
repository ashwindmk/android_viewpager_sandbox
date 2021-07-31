package com.ashwin.viewpagersandbox.frag;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ashwin.viewpagersandbox.OneFragment;
import com.ashwin.viewpagersandbox.ThreeFragment;
import com.ashwin.viewpagersandbox.TwoFragment;

public class FragAdapter extends FragmentStateAdapter {
    public FragAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new TwoFragment();
            case 2:
                return new ThreeFragment();
        }
        return new OneFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
