package com.ashwin.viewpagersandbox;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

public class OneFragment extends BaseFragment {
    private FragmentViewModel mFragmentViewModel;

    public OneFragment() {
        Log.d(Constant.TAG, CONTEXT + ": constructor");
    }

    public static OneFragment newInstance() {
        OneFragment fragment = new OneFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentViewModel = new ViewModelProvider(this).get(FragmentViewModel.class);

        mFragmentViewModel.getCountLiveData().observe(getViewLifecycleOwner(), n -> {
            Log.d(Constant.TAG, CONTEXT + ": count: " + n);
        });

        Button testButton = view.findViewById(R.id.test_button);
        testButton.setOnClickListener(v -> {
            mFragmentViewModel.updateCount();
        });
    }
}
