package com.example.amos.youshi;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 该activity作为加载页的activity
 */

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler(); //当计时结束时，跳转至主界面
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean is_logined = true;
                //通过sharedPreferences判断是否登录
                Intent intent = new Intent();
                if(is_logined) {
                    intent.setClass(MainActivity.this, ZhuyeActivity.class);
                } else {
                    intent.setClass(MainActivity.this, DengluActivity.class);
                }
                startActivity(intent);

                MainActivity.this.finish();
            }
        }, 3000); //持续时间为3秒


//        new Thread(new Runnable() { //开启子线程，后台处理耗时任务
//             public void run() {
//                 /* 这里运行耗时任务，比如加载网络数据 */
//                 runOnUiThread(new Runnable() { //返回主线程（UI线程）
//                      public void run() {
//                          Intent intent = new Intent(MainActivity.this, MainActivity.class);
//                          startActivity(intent); //跳转至 MainActivity
//                          MainActivity.this.finish(); //结束当前的 Activity
//                      }
//                 });
//             }
//        }).start();

    }
}
