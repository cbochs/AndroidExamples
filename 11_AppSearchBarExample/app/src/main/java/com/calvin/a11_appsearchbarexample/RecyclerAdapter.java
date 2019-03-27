package com.calvin.a11_appsearchbarexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<String> names;

    public RecyclerAdapter(List<String> names) {
        this.names = names;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        TextView textView = (TextView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_view, viewGroup, false);

        MyViewHolder myViewHolder = new MyViewHolder(textView);

        return myViewHolder;
    }

    public void updateList(List<String> newList) {
        names = new ArrayList<>();
        names.addAll(newList);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.txtCountryName.setText(names.get(i));
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtCountryName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCountryName = (TextView) itemView;
        }
    }
}
