package com.example.amos.youshi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 此界面为饮食推荐界面
 */

public class TuijianActivity extends BaseActivity {

    private List<Shiwu> shiwuList=new ArrayList<>();

    private String[] data = {"apple", "banana", "orange"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuijian);

        initShiwus();
        ShiwuAdapter adapter=new ShiwuAdapter(TuijianActivity.this,R.layout.shiwu,shiwuList);

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
                TuijianActivity.this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.shiwu);
        listView.setAdapter(adapter);






//        Button button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Intent是一种运行时绑定（run-time binding）机制，它能在程序运行过程中连接两个不同的组件。
//
//                //page1为先前已添加的类，并已在AndroidManifest.xml内添加活动事件(<activity android:name="page1"></activity>),在存放资源代码的文件夹下下，
//                //Intent i = new Intent(tuijian.this , set.class);
//                // startActivity(i);
//            }
//        });
//        Button set = (Button) findViewById(R.id.set);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Intent是一种运行时绑定（run-time binding）机制，它能在程序运行过程中连接两个不同的组件。
//
//                //page1为先前已添加的类，并已在AndroidManifest.xml内添加活动事件(<activity android:name="page1"></activity>),在存放资源代码的文件夹下下，
//                //Intent i = new Intent(tuijian.this , set.class);
//                // startActivity(i);
//
//            }
//        });
    }
    private void initShiwus(){
        for(int i=0;i<3;i++){
            Shiwu apple=new Shiwu("Apple", R.drawable.apple,"water");
            shiwuList.add(apple);
            Shiwu banana=new Shiwu("Banana",R.drawable.apple_pic,"water");
            shiwuList.add(banana);
            Shiwu orange=new Shiwu("Orange",R.drawable.logo,"water");
            shiwuList.add(orange);
        }
    }

}
