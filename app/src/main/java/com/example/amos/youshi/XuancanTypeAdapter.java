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

public class XuancanTypeAdapter extends RecyclerView.Adapter<XuancanTypeAdapter.ViewHolder> implements RecyclerView.OnClickListener{

    private List<XOpt> xOptList;

//    public String[] datas;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    static class ViewHolder extends RecyclerView.ViewHolder {
//        View opt_view;
        ImageView opt_image;
        TextView opt_name;

        public ViewHolder(View view) {
            super(view);
//            opt_view = view;
            opt_image = (ImageView) view.findViewById(R.id.opt_image);
            opt_name = (TextView) view.findViewById(R.id.opt_name);
        }
    }

    public XuancanTypeAdapter(List<XOpt> xOptList) {
        this.xOptList = xOptList;
//        this.datas = datas;
    }

    //define interface
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , String data);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        //将创建的View注册点击事件
        view.setOnClickListener(this);
        return holder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        XOpt xOpt = xOptList.get(position);
        holder.opt_image.setImageResource(xOpt.getOpt_image());
        holder.opt_name.setText(xOpt.getOpt_name());

        //将位置数据保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(xOpt.getOpt_name());
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v,(String)v.getTag());
        }
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }



    public int getItemCount() {

        return xOptList.size();
    }




}
