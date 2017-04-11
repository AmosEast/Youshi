package com.example.amos.youshi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by amos on 17-4-9.
 */

public class XuancanTypeAdapter extends RecyclerView.Adapter<XuancanTypeAdapter.ViewHolder> {

    private List<XOpt> xOptList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View opt_view;
        ImageView opt_image;
        TextView opt_name;

        public ViewHolder(View view) {
            super(view);
            opt_view = view;
            opt_image = (ImageView) view.findViewById(R.id.opt_image);
            opt_name = (TextView) view.findViewById(R.id.opt_name);
        }
    }

    public XuancanTypeAdapter(List<XOpt> xOptList) {
        this.xOptList = xOptList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.opt_view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                XOpt xOpt = xOptList.get(position);
                Toast.makeText(v.getContext(), "You clicked view" + xOpt.getOpt_name(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.opt_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int postion = holder.getAdapterPosition();
                XOpt xOpt = xOptList.get(postion);
                Toast.makeText(v.getContext(), "You clicked view" + xOpt.getOpt_name(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        XOpt xOpt = xOptList.get(position);
        holder.opt_image.setImageResource(xOpt.getOpt_image());
        holder.opt_name.setText(xOpt.getOpt_name());
    }

    public int getItemCount() {

        return xOptList.size();
    }


}
