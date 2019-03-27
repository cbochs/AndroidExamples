package com.calvin.a09_recyclerviewexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<String> list;

    public RecyclerAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewHolder, int i) {
        TextView textView = (TextView) LayoutInflater.from(viewHolder.getContext())
                .inflate(R.layout.text_view_layout, viewHolder, false);

        MyViewHolder myViewHolder = new MyViewHolder(textView);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        viewHolder.txtVersionName.setText(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtVersionName;

        public MyViewHolder(TextView itemView) {
            super(itemView);
            txtVersionName = itemView;
        }
    }
}
