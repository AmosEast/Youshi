package com.example.amos.youshi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

/**
 * Created by amos on 17-4-9.
 */

public class XuanchanAdapter extends ArrayAdapter<XItem> {
    private int resourceId;

    public XuanchanAdapter(Context context, int textViewResourceId, List<XItem> objests) {
        super(context, textViewResourceId, objests);
        resourceId = textViewResourceId;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        XItem xItem = getItem(position); //截取当前项的XItem实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView fir_item = (TextView) view.findViewById(R.id.fir_item);
        TextView sec_item = (TextView) view.findViewById(R.id.sec_item);
        fir_item.setText(xItem.getFir_item());
        sec_item.setText(xItem.getSec_item());
        return view;
    }
}
