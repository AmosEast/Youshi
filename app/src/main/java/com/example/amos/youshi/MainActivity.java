package com.example.amos.youshi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

/**
 * 该activity作为加载页的activity
 */

public class MainActivity extends BaseActivity {

    private SharedPreferences editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Handler handler = new Handler(); //当计时结束时，跳转至主界面
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                boolean is_denglu = false;'
                editor = getSharedPreferences("data", MODE_PRIVATE);
                boolean is_denglu = editor.getBoolean("denglu",false);
                Intent intent = new Intent();
                if(is_denglu) {
                    intent.setClass(MainActivity.this, ZhuyeActivity.class);
                }else {
                    intent.setClass(MainActivity.this, DengluActivity.class);
                }
//                boolean is_logined = false;
//                //通过sharedPreferences判断是否登录
//                Intent intent = new Intent();
//                if(is_logined) {
//                    intent.setClass(MainActivity.this, ZhuyeActivity.class);
////                    intent.setClass(MainActivity.this, XuancanActivity.class);
////                    intent.setClass(MainActivity.this, ZhuceActivity.class);
////                    intent.setClass(MainActivity.this, GerenActivity.class);
////                    intent.setClass(MainActivity.this, DengluActivity.class);
////                    intent.setClass(MainActivity.this, TuijianActivity.class);
////                    intent.setClass(MainActivity.this, ZhuyeActivity.class);
//                } else {
//                    intent.setClass(MainActivity.this, DengluActivity.class);
//                }
                startActivity(intent);

                MainActivity.this.finish();
            }
        }, 3000); //持续时间为3秒

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
