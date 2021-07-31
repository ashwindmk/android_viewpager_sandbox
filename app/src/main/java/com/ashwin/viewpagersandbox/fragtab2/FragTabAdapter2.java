package com.ashwin.viewpagersandbox.fragtab2;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ashwin.viewpagersandbox.Constant;
import com.ashwin.viewpagersandbox.OneFragment;
import com.ashwin.viewpagersandbox.ThreeFragment;
import com.ashwin.viewpagersandbox.TwoFragment;

public class FragTabAdapter2 extends FragmentStateAdapter {
    public FragTabAdapter2(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // This is called only once for each fragment position.
        // Might be called even before the user actually selects the page/tab.
        // Fragments might be in onStart or onStop state, even if they are not visible to the user.
        // Only 1 fragment will be in onResume state, rest of them can be in either onPause, onStart, or onStop state.
        Log.d(Constant.TAG, "FragTabAdapter2: createFragment( " + position + " )");
        switch (position) {
            case 1:
                return TwoFragment.newInstance();
            case 2:
                return ThreeFragment.newInstance();
            default:
                return OneFragment.newInstance();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
