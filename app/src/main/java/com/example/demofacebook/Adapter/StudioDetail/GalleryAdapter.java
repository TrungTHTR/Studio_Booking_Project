package com.example.demofacebook.Adapter.StudioDetail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demofacebook.Adapter.StudioDetail.Interface.IClickItemGalleryListener;
import com.example.demofacebook.Model.Gallery;
import com.example.demofacebook.R;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MyArrayAdapterHolder> {
    private final List<Gallery> mListGallery;
    private final IClickItemGalleryListener iClickItemGalleryListenerListener;


    public GalleryAdapter(List<Gallery> mListGallery, IClickItemGalleryListener iClickItemGalleryListenerListener) {
        this.mListGallery = mListGallery;
        this.iClickItemGalleryListenerListener = iClickItemGalleryListenerListener;
    }

    @NonNull
    @Override
    public MyArrayAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_gallery_item, parent, false);
        return new MyArrayAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyArrayAdapterHolder holder, int position) {
        Gallery gallery = mListGallery.get(position);
        if (gallery == null) {
            return;
        }
        holder.imageGallery.setImageResource(gallery.getImageGallery());
        holder.galleryName.setText(gallery.getGalleryName());
        holder.dateCreate.setText("Create at" + gallery.getCreateDate().toString());
        String totalImage = String.valueOf(gallery.getTotalImage());
        holder.totalItem.setText("Items" + totalImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickItemGalleryListenerListener.onClickItemGallery(gallery);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mListGallery != null) {
            return mListGallery.size();
        }
        return 0;
    }


    public class MyArrayAdapterHolder extends RecyclerView.ViewHolder {
        ImageView imageGallery;
        TextView galleryName;
        TextView dateCreate;
        TextView totalItem;

        public MyArrayAdapterHolder(@NonNull View itemView) {
            super(itemView);
            imageGallery = itemView.findViewById(R.id.GalleryMainImage);
            galleryName = itemView.findViewById(R.id.NameGalleryItem);
            dateCreate = itemView.findViewById(R.id.DateCreateGalleryItem);
            totalItem = itemView.findViewById(R.id.TotalImageGallery);

        }
    }


}
