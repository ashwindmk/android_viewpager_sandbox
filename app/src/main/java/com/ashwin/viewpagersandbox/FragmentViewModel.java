package com.ashwin.viewpagersandbox;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FragmentViewModel extends ViewModel {
    private MutableLiveData<Integer> countLiveData = new MutableLiveData<>(0);

    public LiveData<Integer> getCountLiveData() {
        return countLiveData;
    }

    public void updateCount() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Integer x = countLiveData.getValue();
                if (x == 3) {
                    countLiveData.postValue(null);
                } else {
                    countLiveData.postValue(x + 1);
                }
            }
        }, 5000);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(Constant.TAG, "FragmentViewModel: onCleared: " + this);
    }
}
