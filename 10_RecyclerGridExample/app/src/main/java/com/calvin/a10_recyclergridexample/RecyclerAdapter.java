package com.calvin.a10_recyclergridexample;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder> {

    int[] images;

    private Context context;

    public RecyclerAdapter(int[] images, Context context) {
        this.images = images;
        this.context = context;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_layout, viewGroup, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view, context, images);

        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder viewHolder, int i) {
        int imageId = images[i];

        viewHolder.imgAlbum.setImageResource(imageId);
        viewHolder.txtAlbumTitle.setText("Image " + i);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imgAlbum;
        private TextView txtAlbumTitle;

        private Context context;
        private int[] images;


        public ImageViewHolder(@NonNull View itemView, Context context, int[] images) {
            super(itemView);

            imgAlbum = itemView.findViewById(R.id.img_album);
            txtAlbumTitle = itemView.findViewById(R.id.txt_album_title);

            this.context = context;
            this.images = images;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d("Display", "Starting intent...");
            Intent intent = new Intent(context, DisplayActivity.class);
            intent.putExtra("image_id", images[getAdapterPosition()]);

            context.startActivity(intent);
        }
    }
}
