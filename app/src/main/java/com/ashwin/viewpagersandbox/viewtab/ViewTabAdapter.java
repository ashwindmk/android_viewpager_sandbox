package com.ashwin.viewpagersandbox.viewtab;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ashwin.viewpagersandbox.Constant;
import com.ashwin.viewpagersandbox.R;

import java.util.List;

public class ViewTabAdapter extends RecyclerView.Adapter<ViewTabAdapter.ItemViewHolder> {
    class ItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(String s) {
            TextView tv = itemView.findViewById(R.id.my_text_view);
            tv.setText(s);
        }
    }

    private List<String> mList;

    public ViewTabAdapter(List<String> list) {
        mList = list;
    }

    @NonNull
    @Override
    public ViewTabAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Only called the first time the view is selected
        Log.d(Constant.TAG, "ViewPagerAdapter: onCreateViewHolder");
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_pager, parent, false);
        return new ViewTabAdapter.ItemViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewTabAdapter.ItemViewHolder holder, int position) {
        Log.d(Constant.TAG, "ViewPagerAdapter: onBindViewHolder( " + position + " )");
        String s = mList.get(position);
        holder.bind(s);
    }

    @Override
    public int getItemCount() {
        Log.d(Constant.TAG, "ViewPagerAdapter: getItemCount");
        return mList.size();
    }
}
