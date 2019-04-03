package com.grafixartist.gallery;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by myles on 15/02/2019.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private Context mContext;
    private List<Apprentice> mData;

    public RecyclerViewAdapter(Context mContext, List<Apprentice> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_items,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tv_apprentice_name.setText(mData.get(position).getName());
        holder.img_apprentice_headshot.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,ApprenticeProfile.class);
                intent.putExtra("Name",mData.get(position).getName());
                intent.putExtra("Company",mData.get(position).getCompany());
                intent.putExtra("Role",mData.get(position).getDescription());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_apprentice_name;
        ImageView img_apprentice_headshot;
        CardView cardView;


        public MyViewHolder(View itemView) {
            super(itemView);
            tv_apprentice_name = (TextView) itemView.findViewById(R.id.apprentice_name);
            img_apprentice_headshot = (ImageView) itemView.findViewById(R.id.apprentice_pic);
            cardView = (CardView) itemView.findViewById((R.id.cardview_id));
        }
    }




}
