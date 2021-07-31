package com.ashwin.viewpagersandbox;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {
    protected final String CONTEXT = this.getClass().getSimpleName();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(Constant.TAG, CONTEXT + ": onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Constant.TAG, CONTEXT + ": onCreate");
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(Constant.TAG, CONTEXT + ": onViewCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(Constant.TAG, CONTEXT + ": onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(Constant.TAG, CONTEXT + ": onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(Constant.TAG, CONTEXT + ": onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(Constant.TAG, CONTEXT + ": onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(Constant.TAG, CONTEXT + ": onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(Constant.TAG, CONTEXT + ": onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(Constant.TAG, CONTEXT + ": onDetach");
    }
}
