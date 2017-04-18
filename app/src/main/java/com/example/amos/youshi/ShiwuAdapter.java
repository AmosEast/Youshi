package com.example.amos.youshi;

/**
 * Created by amos on 17-4-11.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by DELL on 2017/4/10.
 */

public class ShiwuAdapter extends ArrayAdapter<Shiwu>{
    private int resourceId;
    RemoteImageHelper lazyImageHelper = new RemoteImageHelper();

    public ShiwuAdapter(Context context, int textViewResourceId, List<Shiwu>objects){
        super(context, textViewResourceId, objects);
        resourceId=textViewResourceId;
    }
    @Override
    public View getView(int position, View converView, ViewGroup parent){
        Shiwu shiwu = getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId, parent,false);
        TextView shiwuName=(TextView)view.findViewById(R.id.name);
        ImageView shiwuImage=(ImageView)view.findViewById(R.id.imageView);
        TextView shiwuyingyang=(TextView)view.findViewById(R.id.yingyang);
//        shiwuImage.setImageResource();
        lazyImageHelper.loadImage(shiwuImage, shiwu.getImageURL(), false);
        shiwuName.setText(shiwu.getName());
        shiwuyingyang.setText(shiwu.getYingyang());
        return view;
    }


}