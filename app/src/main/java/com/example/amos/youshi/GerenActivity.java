package com.example.amos.youshi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

/**
 * 此界面为个人信息界面
 */

public class GerenActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geren);

        final Intent intent = new Intent();

        Button enter = (Button) findViewById(R.id.enter_geren);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(GerenActivity.this, ZhuyeActivity.class);
                startActivity(intent);
            }
        });

        //设置返回点击监听事件
//        super.ret_clicked(this);
    }

}
