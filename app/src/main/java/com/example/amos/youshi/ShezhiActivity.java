package com.example.amos.youshi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 该界面为设置界面
 */

public class ShezhiActivity extends BaseActivity {
    private String [] data={"每日通知","字体","语言","主题","登录/切换用户","关于"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shezhi);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(
                ShezhiActivity.this,android.R.layout.simple_list_item_1,data
        );
        ListView listView=(ListView)findViewById(R.id.list1);
        listView.setAdapter(adapter);

        //设置返回点击监听事件
        super.ret_clicked(this);
    }



}

