package com.example.amos.youshi;

/**
 * 该activity作为APP的主页面
 */
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.R.id.list;
import static android.R.id.text1;
import static com.example.amos.youshi.R.styleable.View;

public class ZhuyeActivity extends BaseActivity {
    private String[]names=new String[]{
            "早餐","中餐","晚餐"
    };
    private int[] imageIds=new int []{R.drawable.breakfast,R.drawable.lunch,R.drawable.dinner

    } ;
    private int[] addIds=new int []{R.drawable.add1,R.drawable.add2,R.drawable.add3

    } ;
    private String[]descs=new String[]{
            "建议摄入350卡路里","建议摄入350卡路里","建议摄入350卡路里"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuye);
        List<Map<String,Object>> listItems=new ArrayList<Map<String,Object>>();
        for(int i=0;i<names.length;i++)
        {
            Map<String,Object>listItem=new HashMap<String,Object>();
            listItem.put("header",imageIds[i]);
            listItem.put("personName",names[i]);
            listItem.put("desc",descs[i]);
            listItem.put("adds",addIds[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,
                R.layout.simple_item,
                new String []{"header","personName","desc","adds"},
                new int[]{R.id.header,R.id.name,R.id.desc,R.id.add});
        ListView list=(ListView)findViewById(R.id.mylist) ;
        list.setAdapter(simpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position,long id){

                        Intent intent1=new Intent(ZhuyeActivity.this,XuancanActivity.class);
                        startActivity(intent1);

            }

        });
        TextView textView2=(TextView)findViewById(R.id.text3);
        textView2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent=new Intent(ZhuyeActivity.this,TuijianActivity.class);
                startActivity(intent);
            }
        });

        //监听设置按钮
        ImageButton set_btn = (ImageButton) findViewById(R.id.set_btn);
        set_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent();
                intent.setClass(ZhuyeActivity.this, ShezhiActivity.class);
                startActivity(intent);
            }
        });

        //监听个人按钮
        ImageButton geren_btn = (ImageButton) findViewById(R.id.geren_btn);
        geren_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent();
                intent.setClass(ZhuyeActivity.this, GerenActivity.class);
                startActivity(intent);
            }
        });

    }

}
