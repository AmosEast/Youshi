package com.example.amos.youshi;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TableLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 此界面为加餐界面
 */

public class XuancanActivity extends BaseActivity {

    private List<XItem> xItemList = new ArrayList<>();
    private List<XOpt> xOptList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuancan);

        //初始化选项列表
        initXOpts();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        final XuancanTypeAdapter xuancanTypeAdapter = new XuancanTypeAdapter(xOptList);
        recyclerView.setAdapter(xuancanTypeAdapter);

        //初始化选餐链表
        initXItems("");
        final XuanchanAdapter adapter = new XuanchanAdapter(XuancanActivity.this, R.layout.xuancan_item, xItemList);
        ListView listView = (ListView) findViewById(R.id.view_list);
        listView.setAdapter(adapter);
        //监听点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                XItem xItem = xItemList.get(position);
                customView();
            }
        });

        //recyclerView的点击事件

        xuancanTypeAdapter.setOnItemClickListener(new XuancanTypeAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String data) {
                adapter.clear();
                initXItems(data);
                adapter.notifyDataSetChanged();
            }
        });

        //设置返回点击监听事件
        super.ret_clicked(this);

    }

    /**
     * 初始化选项链表
     */
    private void initXOpts() {
        for(int i = 0; i < 5; i++) {
            XOpt xOpt = new XOpt("水果", R.drawable.apple_pic);
            xOptList.add(xOpt);
        }
    }

    /**
     * 初始化选项链表数据
     */
    private void initXItems(String item) {
//        xItemList.clear();
        for(int i = 0; i < 20; i++) {
            XItem xItem = new XItem(item + "itme_" , item + "item_8" );
            xItemList.add(xItem);
        }
    }

    /**
     * numberPicker
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void customView() {
        new NumberPickerDialog(this,
                new NumberPicker.OnValueChangeListener() {
                    @Override
                    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
//                        Log.e("ard", "所选值：" + picker.getValue() + "，原值：" + oldVal + "，新值：" + newVal); // 新值即所选值
                    }
                },
                3000, // 最大值
                20, // 最小值
                40) // 默认值
                .setCurrentValue(55) // 更新默认值
                .show();
    }
}
